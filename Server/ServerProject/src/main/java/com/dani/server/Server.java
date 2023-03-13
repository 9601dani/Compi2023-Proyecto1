package com.dani.server;

import com.dani.FileXml;
import com.dani.models.NameWorld;
import com.dani.models.WorldModelName;
import com.dani.objects.World;
import com.dani.models.WorldModel;
import com.dani.models.WorldsModel;
import com.dani.parserJson.Lexer;
import com.dani.parserJson.ParserJson;
import com.dani.parserXml.LexXml;
import com.dani.parserXml.ParserXml;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Executors;

import static com.dani.Main.SIHAYERROR;
import static com.dani.layout.Request_response.txt_to_android;
import static com.dani.layout.Request_response.txt_to_server;
import static com.dani.parserJson.ParserJson.getSingletonInstanceResponse;
import static com.dani.server.Converter.MESSAGE_ERROR;


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
    public static void enviarMensaje(String mensaje){
        Executors.newFixedThreadPool(2).execute(()->{
            ServerSocket server;
            Socket sc = null;
            DataInputStream in;
            DataOutputStream out;
            final int PUERTO=5000;
            try{
                server = new ServerSocket(PUERTO);
                /* System.out.println("Inicie servidor");*/
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
    }
    public static String compileJson(String testString){
        ParserJson p = new ParserJson(new Lexer(new StringReader(testString)));
        String datXml="";
        try {
            System.out.println("voy a parserJson:" + testString);
            Response worldList = (Response) p.parse().value;
            if(SIHAYERROR==true){
                SIHAYERROR=false;
                datXml=MESSAGE_ERROR;
                return datXml;
            }else{
                System.out.println(getSingletonInstanceResponse().getTypeRes());
                if(getSingletonInstanceResponse()==null){
                    datXml+="HAY ERRORES";
                }else if(worldList.getTypeRes()== Response_E.REQUEST_ALL_WORLDS){
                    try{
                        System.out.println(new FileXml().readFile());
                        ArrayList<World> wor=compileXml(new FileXml().readFile());

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
                    }catch(Exception e) {}
                }else if(worldList.getTypeRes()== Response_E.REQUEST_FOR_NAME){
                    /*AQUI REGRESO EL MUNDO PARA JUGAR*/
                    try{
                        System.out.println(new FileXml().readFile());
                        ArrayList<World> wor=compileXml(new FileXml().readFile());

                        if(wor==null){
                            System.out.println("NO HAY MUNDOS");
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
                                    WorldsModel arrayToRequest= new WorldsModel(listToXmlRequest);
                                    datXml=  new Converter().converObjectToXml(arrayToRequest,false);
                                }
                            }

                            System.out.println("esto genere :\n"+datXml);
                            return datXml;
                        }
                    }catch(Exception e) {}
                    System.out.println("REGRESARE POR NOMBRE");
                } else if (worldList.getTypeRes()== Response_E.REQUEST_NEW_WORLD) {
                    System.out.println("algo aqui si");
                    System.out.println("-->");
                    String doc=new FileXml().readFile();
                    System.out.println("-->"+doc);
                    ArrayList<WorldsModel> listXml= new ArrayList<>();
                    ArrayList<WorldModel> listToXml= new ArrayList<>();
                    if(doc!=""){
                        ArrayList<World> wor=compileXml(new FileXml().readFile());

                        //WorldModel.forEach(System.out::println);
                        for(int i=0; i<wor.size();i++){
                            listToXml.add(new WorldModel(wor.get(i).getName(),wor.get(i).getRows(),wor.get(i).getCols(),wor.get(i).getConfig(),
                                    wor.get(i).getArrayBoard(),wor.get(i).getArrayBoxes(),wor.get(i).getArrayTarget(),wor.get(i).getPlayer()));
                        }
                    }
                    for (int i = 0; i < worldList.getWorld().size(); i++) {
                        String elemento = String.valueOf(worldList.getWorld().get(i));
                        if(VerificarWorld(listToXml,new WorldModel(worldList.getWorld().get(i).getName(),worldList.getWorld().get(i).getRows(),worldList.getWorld().get(i).getCols(),worldList.getWorld().get(i).getConfig(),
                                worldList.getWorld().get(i).getArrayBoard(),worldList.getWorld().get(i).getArrayBoxes(),worldList.getWorld().get(i).getArrayTarget(),worldList.getWorld().get(i).getPlayer()))==false){
                            listToXml.add(new WorldModel(worldList.getWorld().get(i).getName(),worldList.getWorld().get(i).getRows(),worldList.getWorld().get(i).getCols(),worldList.getWorld().get(i).getConfig(),
                                    worldList.getWorld().get(i).getArrayBoard(),worldList.getWorld().get(i).getArrayBoxes(),worldList.getWorld().get(i).getArrayTarget(),worldList.getWorld().get(i).getPlayer()));
                        }
                        /*converObjectToXml(worldList.get(i));*/
                    }
                    /*AQUI GUARDO EL MUNDO EN XML*/
                    if(listXml.get(listXml.size()-1).getArrayWorld().size()<1){
                        datXml+= new Converter().converObjectToXml(new WorldsModel(listToXml),true);
                    }

                }
                // datXml+= new Converter().converObjectToXml(new WorldsModel(listToXml));
                //System.out.printf(datXml);
                return datXml;
            }

        } catch (Exception e) {
            /*System.out.println("algo fallo en json");
            e.printStackTrace();*/
            /*enviarMensaje(datXml);*/
            return datXml;
        }

    }
    public static ArrayList<World> compileXml(String testString){
        ParserXml p = new ParserXml(new LexXml(new StringReader(testString)));
        try {
            System.out.println("voy a parser");
            ArrayList<World> world = (ArrayList<World>) p.parse().value;
            world.forEach(System.out::println);
            return world;

        } catch (Exception e) {
            System.out.println("algo fallo");
            e.printStackTrace();
        }
        return null;
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
