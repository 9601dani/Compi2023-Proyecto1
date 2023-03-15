package com.dani.server;

import com.dani.FileXml;
import com.dani.models.*;
import com.dani.models.Error;
import com.dani.objects.Response;
import com.dani.objects.Response_E;
import com.dani.objects.World;
import com.dani.parserJson.Lexer;
import com.dani.parserJson.ParserJson;
import com.dani.verifications.VWorld;
import java_cup.runtime.Scanner;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Executors;

import static com.dani.Main.erroForClient;
import static com.dani.layout.Request_response.txt_to_android;
import static com.dani.layout.Request_response.txt_to_server;
import static com.dani.parserJson.ParserHandleJson.compileJsonHandle;
import static com.dani.parserJson.ParserJson.getSingletonInstanceResponse;
import static com.dani.parserXml.HandleParserXml.compileXml;
import static com.dani.server.Converter.converObjectToXmlError;
import static com.dani.verifications.VWorld.configDefecto;


public class Server {
  /*  static Socket s;
    static ServerSocket ssk;
    static InputStreamReader isr;
    static BufferedReader br;*/

    public static void conec(){
        Executors.newFixedThreadPool(2).execute(()->{
            ServerSocket server;
            Socket sc;
            DataInputStream in;
            DataOutputStream out;
            final int PUERTO=5000;
            try{
                server = new ServerSocket(PUERTO);
               /* System.out.println("Inicie servidor");*/
                while(true){
                    sc= server.accept();
                    /*System.out.println("Cliente conectado");*/
                    in= new DataInputStream(sc.getInputStream());
                    out = new DataOutputStream(sc.getOutputStream());
                    String mensaje= in.readUTF();
                    txt_to_server.setText("Recibiendo: \n"+mensaje);
                    String response=compileJson(mensaje);
                    txt_to_android.setText("Enviando a cliente: \n "+ response);
                    if(response==""){
                        out.writeUTF("HEMOS ENCONTRADO ERRORES");
                        sc.close();
                    }else{
                        out.writeUTF(response);
                        sc.close();
                    }

                    /*System.out.println("Cliente desconectado");*/
                }
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
/*    public static void enviarMensaje(String mensaje){
        Executors.newFixedThreadPool(2).execute(()->{
            ServerSocket server;
            Socket sc = null;
            DataInputStream in;
            DataOutputStream out;
            final int PUERTO=5000;
            try{
                server = new ServerSocket(PUERTO);
                *//* System.out.println("Inicie servidor");*//*
                while(true){
                    sc.close();
                    out = new DataOutputStream(sc.getOutputStream());
                    txt_to_android.setText("Enviando a cliente: \n "+ mensaje);
                    out.writeUTF(mensaje);
                    sc.close();
                }
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }*/
    public static String compileJson(String testString){
        ParserJson p = new ParserJson((Scanner) new Lexer(new StringReader(testString)));

        String datXml="";
        try {
           Response worldList= compileJsonHandle(testString);
            if(erroForClient.isEmpty()){
                if(getSingletonInstanceResponse()==null){
                    datXml+="HAY ERRORES";
                }else if(worldList.getTypeRes()== Response_E.REQUEST_ALL_WORLDS){
                    try{
                        System.out.println(new FileXml().readFile());
                        ArrayList<World> wor=compileXml(new FileXml().readFile());
                        if(erroForClient.isEmpty()){
                            if(wor==null){
                                System.out.println("NO HAY MUNDOS");
                            }else{
                                ArrayList<String> arrayNames= new ArrayList<>();
                                for (int i = 0; i < wor.size(); i++) {
                                    /* String elemento = String.valueOf(worldList.getWorld().get(i));*/
                                    arrayNames.add(new String(wor.get(i).getName()));
                                }
                                datXml= new Converter().converObjectToXmlRequestWorld(new NameWorld(arrayNames));
                                System.out.println("esto genere :\n"+datXml);
                                return datXml;
                            }
                        }else{
                            datXml=converObjectToXmlError(new Error(erroForClient));
                            erroForClient=new ArrayList<>();
                            return datXml;
                        }

                    }catch(Exception e) {}
                }else if(worldList.getTypeRes()== Response_E.REQUEST_FOR_NAME){
                    /*AQUI REGRESO EL MUNDO PARA JUGAR*/
                    try{
                        System.out.println(new FileXml().readFile());
                        ArrayList<World> wor=compileXml(new FileXml().readFile());

                        if(wor.isEmpty()){
                            System.out.println("NO HAY MUNDOS");
                            erroForClient.add(new ErrorModel("",0,0,ErrorType.OTHER,"ACTUALMENTE NO HAY MUNDOS"));
                            datXml=converObjectToXmlError(new Error(erroForClient));
                            erroForClient=new ArrayList<>();
                            return datXml;
                        }else{
                            ArrayList<WorldModel> listToXml= new ArrayList<>();
                            for (int i = 0; i < wor.size(); i++) {
                                String elemento = String.valueOf(wor.get(i));
                                listToXml.add(new WorldModel(wor.get(i).getName(),wor.get(i).getRows(),wor.get(i).getCols(),wor.get(i).getConfig(),
                                        wor.get(i).getArrayBoard(),wor.get(i).getArrayBoxes(),wor.get(i).getArrayTarget(),wor.get(i).getPlayer()));
                                /*converObjectToXml(worldList.get(i));*/
                            }
                            ArrayList<WorldModel> listToXmlRequest= new ArrayList<>();
                            for(int i=0;i <listToXml.size();i++){
                                if(listToXml.get(i).getName().equals(worldList.getName())){
                                    listToXmlRequest.add(listToXml.get(i));
                                }
                            }
                            if(!listToXmlRequest.isEmpty()){
                                WorldsModel arrayToRequest= new WorldsModel(listToXmlRequest);
                                datXml=  new Converter().converObjectToXml(arrayToRequest,false);
                            }
                            System.out.println("esto genere :\n"+datXml);
                            if(datXml.equals("")){
                                erroForClient.add(new ErrorModel("",0,0,ErrorType.OTHER,"no existe el mudndo"));
                                datXml=converObjectToXmlError(new Error(erroForClient));
                                erroForClient=new ArrayList<>();
                                return datXml;
                            }
                            return datXml;
                        }
                    }catch(Exception e) {}
                    System.out.println("REGRESARE POR NOMBRE");
                } else if (worldList.getTypeRes()== Response_E.REQUEST_NEW_WORLD) {
                    System.out.println("sooooo\n"+ worldList.getWorld().toString());
                    System.out.println("algo aqui si");
                    String doc=new FileXml().getSingletonInstanceFile().readFile();
                    ArrayList<WorldsModel> listXml= new ArrayList<>();
                    ArrayList<WorldModel> listToXml= new ArrayList<>();
                    System.out.println(doc);
                    ArrayList<World> wor=compileXml(doc);
                    //WorldModel.forEach(System.out::println);
                    for(int i=0; i<wor.size();i++){
                        listToXml.add(new WorldModel(wor.get(i).getName(),wor.get(i).getRows(),wor.get(i).getCols(),wor.get(i).getConfig(),
                                wor.get(i).getArrayBoard(),wor.get(i).getArrayBoxes(),wor.get(i).getArrayTarget(),wor.get(i).getPlayer()));
                        System.out.println(i+". "+ wor.get(i).getArrayBoard());
                    }
                    System.out.println("WORLDLIST--> "+ worldList.getWorld().size());
                    boolean ms=false;
                    for (int i=0; i < worldList.getWorld().size(); i++) {
                        /*String elemento = String.valueOf(worldList.getWorld().get(i));*/
                        WorldModel wm=new  WorldModel(worldList.getWorld().get(i).getName(),worldList.getWorld().get(0).getRows(),worldList.getWorld().get(0).getCols(),worldList.getWorld().get(0).getConfig(),
                                worldList.getWorld().get(0).getArrayBoard(),worldList.getWorld().get(0).getArrayBoxes(),worldList.getWorld().get(0).getArrayTarget(),worldList.getWorld().get(0).getPlayer());
                        if(VerificarWorld(listToXml,wm)==false){
                            listToXml.add(wm);
                        }else{
                            ms=true;
                        }
                        /*new WorldModel(worldList.getWorld().get(i).getName(),worldList.getWorld().get(i).getRows(),worldList.getWorld().get(i).getCols(),worldList.getWorld().get(i).getConfig(),
                                    worldList.getWorld().get(i).getArrayBoard(),worldList.getWorld().get(i).getArrayBoxes(),worldList.getWorld().get(i).getArrayTarget(),worldList.getWorld().get(i).getPlayer())*/
                        /*converObjectToXml(worldList.get(i));*/
                    }
                    if(ms==false){
                        VWorld veri= new VWorld();

                        if(veri.verificarWorldNo(new World(worldList.getWorld().get(0).getName(),worldList.getWorld().get(0).getRows(),worldList.getWorld().get(0).getCols()
                                ,worldList.getWorld().get(0).getConfig(),worldList.getWorld().get(0).getArrayBoard(),worldList.getWorld().get(0).getArrayBoxes(),
                                worldList.getWorld().get(0).getArrayTarget(),worldList.getWorld().get(0).getPlayer()) )==true){
                            ms=true;
                        }

                        /*AQUI EL ERROR............................*/
                        System.out.println("--> mostrare");
                        for(int i=0; i<listToXml.size();i++){
                            System.out.println(i+". "+ listToXml.get(i).getBoard());
                        }
                        if(ms==true){
                            System.out.println("si hay error en verrificaciones");
                            return "HAY ERRORES EN VERIFICACIONES";
                        }else{
                            System.out.println("no hay error\n"+listToXml.toString());
                            configDefecto(listToXml.get(listToXml.size()-1).getConfig());
                            datXml+=new Converter().converObjectToXml(new WorldsModel(listToXml),true);
                        /*if(listXml.get(listXml.size()).getArrayWorld().size()<1){
                            datXml+= new Converter().converObjectToXml(new WorldsModel(listToXml),true);
                        }else{
                            datXml+= new Converter().converObjectToXml(new WorldsModel(listToXml),true);
                        }*/
                        }
                    }
                }
                // datXml+= new Converter().converObjectToXml(new WorldsModel(listToXml));
                //System.out.printf(datXml);
                return datXml;
            }else{
                System.out.println("el array de errores es nulo");
                /*aqui si hay errores*/
                datXml=converObjectToXmlError(new Error(erroForClient));
                erroForClient=new ArrayList<>();
                return datXml;
            }
        } catch (Exception e) {
            /*System.out.println("algo fallo en json");*/
            e.printStackTrace();
            /*enviarMensaje(datXml);*/
            return datXml;
        }

    }
   /* public static ArrayList<Board> parsearABoard(ArrayList<BoardModel> boardModel){
        ArrayList<Board> dvArray= new ArrayList<>();
        System.out.println(boardModel.size()+"size board");
        for(int i=0; i<boardModel.size();i++){
            dvArray.add(new Board(boardModel.get(i).getPosX(),boardModel.get(i).getPosY(),mandarType(boardModel.get(i).getType())));
            System.out.println("pasando boards");
        }
        return dvArray;
    }*/
    public static Integer  mandarType(String st){
        if(st.equals("HALL")){
            return 4;
        }else if(st.equals("BRICK")){
            return 3;
        }
        return 0;

    }


    public static boolean VerificarWorld(ArrayList<WorldModel> arregloExistente,WorldModel nuevoMundo){
        boolean exist=false;
        for(int i=0;i<arregloExistente.size();i++){
            if(arregloExistente.get(i).getName().equals(nuevoMundo.getName())){
                System.out.println("YA EXISTE EL MUNDO");
                exist=true;
                return exist;
            }
        }
        return exist;
    }


}
