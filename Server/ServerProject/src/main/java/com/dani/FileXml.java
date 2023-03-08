package com.dani;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileXml {
    private static final String PATH="src/main/resources/com/dani/server/xml/sokoban.xml";
    private static FileXml fileXml;

    public FileXml(){}


    public static FileXml getInstance(){
        if(fileXml== null){
            fileXml= new FileXml();
        }
        return fileXml;
    }

    public void generateFileXml(String content){
        File file = new File(PATH);
        FileWriter writer = null;
        try {
            BufferedWriter bw;
            writer = new FileWriter(file);
            bw = new BufferedWriter(new FileWriter(String.valueOf(writer)));
            bw.close(); //
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
