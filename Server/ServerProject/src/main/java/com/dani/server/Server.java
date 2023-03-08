package com.dani.server;

import com.dani.objects.World;
import com.dani.objects.WorldModel;
import com.dani.objects.WorldsModel;
import com.dani.parserJson.Lexer;
import com.dani.parserJson.ParserJson;
import com.dani.parserXml.LexXml;
import com.dani.parserXml.ParserXml;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Executors;


public class Server {
  /*  static Socket s;
    static ServerSocket ssk;
    static InputStreamReader isr;
    static BufferedReader br;*/
private final String PATH= "";

    public static void conec(){
        Executors.newFixedThreadPool(2).execute(()->{
            ServerSocket server;
            Socket sc;
            DataInputStream in;
            DataOutputStream out;
            final int PUERTO=5000;
            try{
                server = new ServerSocket(PUERTO);
                System.out.println("Inicie servidor");
                while(true){
                    sc= server.accept();
                    System.out.println("Cliente conectado");
                    in= new DataInputStream(sc.getInputStream());
                    out = new DataOutputStream(sc.getOutputStream());
                    String mensaje= in.readUTF();
                    System.out.println(mensaje);
                    out.writeUTF("Hola mundo desde servidor");
                    sc.close();
                    System.out.println("CLiente desconectado");
                }
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
    public static void compileJson(String testString){
        ParserJson p = new ParserJson(new Lexer(new StringReader(testString)));
        try {
            System.out.println("voy a parserJson");
            String datXml="";
            ArrayList<World> worldList = (ArrayList<World>) p.parse().value;
            ArrayList<WorldsModel> listXml= new ArrayList<>();
            ArrayList<WorldModel> listToXml= new ArrayList<>();
            //WorldModel.forEach(System.out::println);
            for (int i = 0; i < worldList.size(); i++) {
                String elemento = String.valueOf(worldList.get(i));
                listToXml.add(new WorldModel(worldList.get(i).getName(),worldList.get(i).getRows(),worldList.get(i).getCols(),worldList.get(i).getConfig(),
                        worldList.get(i).getArrayBoard(),worldList.get(i).getArrayBoxes(),worldList.get(i).getArrayTarget(),worldList.get(i).getPlayer()));
                /* converObjectToXml(worldList.get(i));*/
            }
            datXml+= new Converter().converObjectToXml(new WorldsModel(listToXml));
            System.out.printf(datXml);
        } catch (Exception e) {
            System.out.println("algo fallo en json");
            e.printStackTrace();
        }
    }
    public static void compileXml(String testString){
        ParserXml p = new ParserXml(new LexXml(new StringReader(testString)));
        try {
            System.out.println("voy a parser");
            ArrayList<World> world = (ArrayList<World>) p.parse().value;
            world.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("algo fallo");
            e.printStackTrace();
        }
    }

    public static void generateFileXml(String txtXml){


    }
}
