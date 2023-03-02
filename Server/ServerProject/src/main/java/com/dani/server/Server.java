package com.dani.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

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
}
