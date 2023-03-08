package com.dani;

import java.io.*;

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
    public void generateFileXml(String content) throws IOException{
       FileWriter writer = new FileWriter(getFileXml());
       writer.write(content);
       writer.close();

    }
    private File getFileXml(){return new File(PATH);}

}
