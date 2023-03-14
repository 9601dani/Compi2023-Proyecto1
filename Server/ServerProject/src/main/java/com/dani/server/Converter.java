package com.dani.server;
import com.dani.FileXml;
import com.dani.models.Error;

import java.io.IOException;
import java.util.ArrayList;

import com.dani.models.NameWorld;
import com.dani.models.WorldModelName;
import com.dani.models.WorldsModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import static com.dani.Main.*;

public class Converter {
public static String MESSAGE_ERROR="";
    private FileXml file;
    public  String converObjectToXml (WorldsModel worlds,boolean escribir) throws IOException {
        String xml="";
        for(int i=0; i<worlds.getArrayWorld().size();i++){
            System.out.println(i+". "+ worlds.getArrayWorld().get(i).toString());
        }
           /* String nombreArchivo = "xmlArch.xml";
            String ubicacion = "/home/danimo/Desktop";
            File arch= new File(ubicacion+nombreArchivo);
            xmlMapper.writeValue(archivoXml ,World.class);
        FileOutputStream fos = new FileOutputStream(arch);*/
        if(escribir==true){
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            VERSION++;
             xml = "<?xml version=\""+VERSION+"\" encoding=\"UTF-8\"?>\n";
            try {
                xml += xmlMapper.writeValueAsString(worlds);
                //System.out.println();
           /* fos.write(xml.getBytes());
            fos.close();*/
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }}

        if(escribir==true){
            file= new FileXml();
            file.generateFileXml(xml);
            /*System.out.println("---------------------------------");
            System.out.println(xml);*/
        }


       // System.out.println(xml);
        return xml;
    }
    public  static String converObjectToXmlError (Error error) {
        SIHAYERROR=true;
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
           /* String nombreArchivo = "xmlArch.xml";
            String ubicacion = "/home/danimo/Desktop";
            File arch= new File(ubicacion+nombreArchivo);
            xmlMapper.writeValue(archivoXml ,World.class);
        FileOutputStream fos = new FileOutputStream(arch);*/
        VERSION++;
        String xml = "<?xml version=\""+VERSION+"\" encoding=\"UTF-8\"?>\n";
        try {
            xml += xmlMapper.writeValueAsString(error);
            //System.out.println();
           /* fos.write(xml.getBytes());
            fos.close();*/
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        MESSAGE_ERROR=xml;
         System.out.println(MESSAGE_ERROR);
        return xml;
    }
    public  String converObjectToXmlRequestWorld (NameWorld worlds) throws IOException {

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
           /* String nombreArchivo = "xmlArch.xml";
            String ubicacion = "/home/danimo/Desktop";
            File arch= new File(ubicacion+nombreArchivo);
            xmlMapper.writeValue(archivoXml ,World.class);
        FileOutputStream fos = new FileOutputStream(arch);*/
        VERSIONES++;
        String xml = "<?xml version=\""+VERSIONES+"\" encoding=\"UTF-8\"?>\n";
        try {
            xml += xmlMapper.writeValueAsString(worlds);
            //System.out.println();
           /* fos.write(xml.getBytes());
            fos.close();*/
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        // System.out.println(xml);

        return xml;
    }
}

