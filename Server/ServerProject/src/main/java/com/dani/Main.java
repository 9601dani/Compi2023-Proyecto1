package com.dani;

import com.dani.objectXml.World;
import com.dani.server.Server;
import java_cup.runtime.Symbol;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import static com.dani.server.Server.conec;

public class Main {
    public static void main(String[] args) {
/*        conec();*/
        String testString="<?xml version=\"1.0\" encoding=\"UTF-1555\"?>" +
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
                "</worlds>\n";
        String testString2="<worlds>\n" +
                "\t<world>\n" +
                "\t\t<name>nombre1</name>\n" +
                "\t\t<rows>4</rows>\n" +
                "\t\t<cols>2</cols>\n" +
                "\t\t<config>\n" +
                "\t\t\t<box_color>#ffffff</box_color>\n" +
                "\t\t\t<box_on_target_color>#f1f2f3</box_on_target_color>\n" +
                "\t\t\t<target_color>#f1f2f3</target_color>\n" +
                "\t\t\t<brick_color>#f1f2b3</brick_color>\n" +
                "\t\t\t<hall_color>#f1f2f7</hall_color>\n" +
                "\t\t\t<undefined_color>#f1f223</undefined_color>\n" +
                "\t\t\t<player_color>#f1f2f9</player_color>\n" +
                "\t\t</config>\n" +
                "\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>49</posX>\n" +
                "\t\t\t<posY>25</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>6</posX>\n" +
                "\t\t\t<posY>7</posY>\n" +
                "\t\t\t<type>HALL</type>\n" +
                "\t\t</board>\n" +
                "\n" +
                "\t\t<boxes>\n" +
                "\t\t\t<posX>54</posX>\n" +
                "\t\t\t<posY>9</posY>\n" +
                "\t\t</boxes>\n" +
                "\t\t<boxes>\n" +
                "\t\t\t<posX>14</posX>\n" +
                "\t\t\t<posY>10</posY>\n" +
                "\t\t</boxes>\n" +
                "\n" +
                "\t\t<targets>\n" +
                "\t\t\t<posX>26</posX>\n" +
                "\t\t\t<posY>9</posY>\n" +
                "\t\t</targets>\n" +
                "\t\t<targets>\n" +
                "\t\t\t<posX>18</posX>\n" +
                "\t\t\t<posY>11</posY>\n" +
                "\t\t</targets>\n" +
                "\n" +
                "\t\t<player>\n" +
                "\t\t\t<posX>2</posX>\n" +
                "\t\t\t<posY>60</posY>\n" +
                "\t\t</player>\n" +
                "\t</world>\n" +
                "\t<world>\n" +
                "\t\t<name>nombre2</name>\n" +
                "\t\t<rows>4</rows>\n" +
                "\t\t<cols>5</cols>\n" +
                "\t\t<config>\n" +
                "\t\t\t<box_color>#f56fff</box_color>\n" +
                "\t\t\t<box_on_target_color>#f1f2f3</box_on_target_color>\n" +
                "\t\t\t<target_color>#f1f223</target_color>\n" +
                "\t\t\t<brick_color>#f1a2b3</brick_color>\n" +
                "\t\t\t<hall_color>#f1e2f7</hall_color>\n" +
                "\t\t\t<undefined_color>#f4f223</undefined_color>\n" +
                "\t\t\t<player_color>#b1f2f9</player_color>\n" +
                "\t\t</config>\n" +
                "\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>49</posX>\n" +
                "\t\t\t<posY>25</posY>\n" +
                "\t\t\t<type>HALL</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>6</posX>\n" +
                "\t\t\t<posY>7</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\n" +
                "\t\t<boxes>\n" +
                "\t\t\t<posX>14</posX>\n" +
                "\t\t\t<posY>9</posY>\n" +
                "\t\t</boxes>\n" +
                "\t\t<boxes>\n" +
                "\t\t\t<posX>134</posX>\n" +
                "\t\t\t<posY>810</posY>\n" +
                "\t\t</boxes>\n" +
                "\n" +
                "\t\t<targets>\n" +
                "\t\t\t<posX>24</posX>\n" +
                "\t\t\t<posY>9</posY>\n" +
                "\t\t</targets>\n" +
                "\t\t<targets>\n" +
                "\t\t\t<posX>134</posX>\n" +
                "\t\t\t<posY>120</posY>\n" +
                "\t\t</targets>\n" +
                "\n" +
                "\t\t<player>\n" +
                "\t\t\t<posX>24</posX>\n" +
                "\t\t\t<posY>69</posY>\n" +
                "\t\t</player>\n" +
                "\t</world>\n" +
                "</worlds>";
        String testString3="<worlds>\n" +
                "\t<world>\n" +
                "\t\t<name>nombre1</name>\n" +
                "\t\t<rows>4</rows>\n" +
                "\t\t<cols>2</cols>\n" +
                "\t\t<config>\n" +
                "\t\t\t<box_color>#ffffff</box_color>\n" +
                "\t\t\t<box_on_target_color>#f1f2f3</box_on_target_color>\n" +
                "\t\t\t<target_color>#f1f2f3</target_color>\n" +
                "\t\t\t<brick_color>#f1f2b3</brick_color>\n" +
                "\t\t\t<hall_color>#f1f2f7</hall_color>\n" +
                "\t\t\t<undefined_color>#f1f223</undefined_color>\n" +
                "\t\t\t<player_color>#f1f2f9</player_color>\n" +
                "\t\t</config>\n" +
                "\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>49</posX>\n" +
                "\t\t\t<posY>25</posY>\n" +
                "\t\t\t<type>BRICK</type>\n" +
                "\t\t</board>\n" +
                "\t\t<board>\n" +
                "\t\t\t<posX>6</posX>\n" +
                "\t\t\t<posY>7</posY>\n" +
                "\t\t\t<type>HALL</type>\n" +
                "\t\t</board>\n" +
                "\n" +
                "\t\t<boxes>\n" +
                "\t\t\t<posX>54</posX>\n" +
                "\t\t\t<posY>9</posY>\n" +
                "\t\t</boxes>\n" +
                "\t\t<boxes>\n" +
                "\t\t\t<posX>14</posX>\n" +
                "\t\t\t<posY>10</posY>\n" +
                "\t\t</boxes>\n" +
                "\n" +
                "\t\t<targets>\n" +
                "\t\t\t<posX>26</posX>\n" +
                "\t\t\t<posY>9</posY>\n" +
                "\t\t</targets>\n" +
                "\t\t<targets>\n" +
                "\t\t\t<posX>18</posX>\n" +
                "\t\t\t<posY>11</posY>\n" +
                "\t\t</targets>\n" +
                "\n" +
                "\t\t<player>\n" +
                "\t\t\t<posX>2</posX>\n" +
                "\t\t\t<posY>60</posY>\n" +
                "\t\t</player>\n" +
                "\t</world>\n" +
                 "</worlds>";
        //System.out.println(testString2);
        compile(testString);
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

    public static void compile(String testString){
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

}