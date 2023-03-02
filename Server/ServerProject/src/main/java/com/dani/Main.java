package com.dani;

import com.dani.server.Server;

import java.io.IOException;
import java.io.StringReader;

import static com.dani.server.Server.conec;

public class Main {
    public static void main(String[] args) {
        conec();
        /*String testString="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<worlds>\n" +
                "\t<world>\n" +
                "\t\t<name>tatoine</name>\n" +
                "\t\t<rows>5</rows>\n" +
                "\t\t<cols>4</cols>\n" +
                "\t\t<config>\n" +
                "\t\t\t<box_color>#ffff00</box_color>\n" +
                "\t\t\t<box_on_target_color>#fe0002</box_on_target_color>\n" +
                "\t\t\t<target_color>#d6fe0a</target_color>\n" +
                "\t\t\t<brick_color>#bdbebf</brick_color>\n" +
                "\t\t\t<hall_color>#0001ff</hall_color>\n" +
                "\t\t\t<undefined_color>#303030</undefined_color>\n" +
                "\t\t\t<player_color>#ff00f7</player_color>\n" +
                "\t\t</config>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>0</posX>\n" +
                "\t\t\t<posY>0</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>0</posX>\n" +
                "\t\t\t<posY>1</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>0</posX>\n" +
                "\t\t\t<posY>2</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>0</posX>\n" +
                "\t\t\t<posY>3</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>0</posX>\n" +
                "\t\t\t<posY>4</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>1</posX>\n" +
                "\t\t\t<posY>0</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>1</posX>\n" +
                "\t\t\t<posY>1</posY>\n" +
                "\t\t\t<type>HALL</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>1</posX>\n" +
                "\t\t\t<posY>2</posY>\n" +
                "\t\t\t<type>HALL</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>1</posX>\n" +
                "\t\t\t<posY>3</posY>\n" +
                "\t\t\t<type>HALL</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>1</posX>\n" +
                "\t\t\t<posY>4</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>2</posX>\n" +
                "\t\t\t<posY>0</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>2</posX>\n" +
                "\t\t\t<posY>1</posY>\n" +
                "\t\t\t<type>HALL</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>2</posX>\n" +
                "\t\t\t<posY>2</posY>\n" +
                "\t\t\t<type>HALL</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>2</posX>\n" +
                "\t\t\t<posY>3</posY>\n" +
                "\t\t\t<type>HALL</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>2</posX>\n" +
                "\t\t\t<posY>4</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>3</posX>\n" +
                "\t\t\t<posY>0</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>3</posX>\n" +
                "\t\t\t<posY>1</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>3</posX>\n" +
                "\t\t\t<posY>2</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>3</posX>\n" +
                "\t\t\t<posY>4</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>3</posX>\n" +
                "\t\t\t<posY>5</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\t\t<boxes>\n" +
                "\t\t\t<posX>2</posX>\n" +
                "\t\t\t<posY>1</posY>\n" +
                "\t\t</boxes>\n" +
                "\t\t<boxes>\n" +
                "\t\t\t<posX>2</posX>\n" +
                "\t\t\t<posY>2</posY>\n" +
                "\t\t</boxes>\n" +
                "\t\t<targets>\n" +
                "\t\t\t<posX>3</posX>\n" +
                "\t\t\t<posY>1</posY>\n" +
                "\t\t</targets>\n" +
                "\t\t<targets>\n" +
                "\t\t\t<posX>3</posX>\n" +
                "\t\t\t<posY>2</posY>\n" +
                "\t\t</targets>\n" +
                "\t\t<player>\n" +
                "\t\t\t<posX>1</posX>\n" +
                "\t\t\t<posY>1</posY>\n" +
                "\t\t</player>\n" +
                "\t</world>\n" +
                "</worlds>";
        System.out.println(testString);
        compile(testString);*/
       /* LexXml lexer = new LexXml(new StringReader(testString));
        try{
            Token token= lexer.yylex();
            while(token.getTokenType() != TokenType.EOF){
                token=lexer.yylex();
            }
        }catch (IOException e){
            e.getMessage();

        }*/

    }

   /* public static void compile(String testString){
        ParserXml p = new ParserXml(new LexXml(new StringReader(testString)));
        try {
            p.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}