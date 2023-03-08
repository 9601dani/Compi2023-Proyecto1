package com.dani.server;
import com.dani.FileXml;
import com.dani.objects.World;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.dani.objects.WorldModel;
import com.dani.objects.WorldsModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import static com.dani.Main.VERSION;

public class Converter {
    private FileXml file;
    public  String converObjectToXml (WorldsModel worlds) throws IOException {
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
            xml += xmlMapper.writeValueAsString(worlds);
            //System.out.println();
           /* fos.write(xml.getBytes());
            fos.close();*/
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        file= new FileXml();
        file.generateFileXml(xml);

       // System.out.println(xml);
        return xml;
    }
}

