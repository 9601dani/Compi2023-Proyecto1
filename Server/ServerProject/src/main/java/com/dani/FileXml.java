package com.dani;

import java.io.*;
import java.util.Scanner;

public class FileXml {
    private static final String PATH="src/main/resources/com.dani.server.xml/sokoban.xml";
    private static FileXml fileXml;

    public FileXml(){}


    public static FileXml getInstance(){
        if(fileXml== null){
            fileXml= new FileXml();
        }
        return fileXml;
    }
    public String readFile()throws IOException{
        StringBuilder content= new StringBuilder();
        Scanner scan = new Scanner(getFileXml());
        while(scan.hasNextLine()){
            content.append(scan.nextLine()).append("\n");
        }
        return content.toString();
    }
    public void generateFileXml(String content) throws IOException{
       FileWriter writer = new FileWriter(getFileXml());
       writer.write(content);
       writer.close();

    }
    private File getFileXml(){return new File(PATH);}

    public static FileXml xmlFile;
    public FileXml getSingletonInstanceFile() {
        if (xmlFile == null){
            xmlFile = new FileXml();
        }
        else{
            /* System.out.println("No se puede crear el objeto  porque ya existe un objeto de la clase World");*/
        }
        return xmlFile;
    }
}
