package com.dani.parserXml;

import com.dani.objects.World;

import java.io.StringReader;
import java.util.ArrayList;

public class HandleParserXml {
    public static ArrayList<World> compileXml(String testString){
        ParserXml p = new ParserXml(new LexXml(new StringReader(testString)));
        try {
            if(testString.equals("")){
                return new ArrayList<World>();
            }else{
                System.out.println("voy a parser");
                ArrayList<World>  world= (ArrayList<World>) p.parse().value;
                world.forEach(System.out::println);
                return world;
            }


        } catch (Exception e) {
            System.out.println("algo fallo");
            e.printStackTrace();
        }
        return null;
    }
}
