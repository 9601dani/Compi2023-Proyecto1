package com.dani;

import com.dani.objects.World;
import com.dani.objects.WorldModel;
import com.dani.objects.WorldsModel;
import com.dani.parserJson.Lexer;
import com.dani.parserJson.ParserJson;
import com.dani.parserXml.LexXml;
import com.dani.parserXml.ParserXml;

import java.io.StringReader;
import java.util.ArrayList;

;
import static com.dani.server.Server.compileJson;

public class Main {
    public static Double VERSION=  0.0;
    public static void main(String[] args) {
/*        conec();*/
        String testString="<?xml version=\"1.0\" encoding=\"UTF-1555\"?>" +
                "<worlds>\n" +
                "\t<WorldModel>\n" +
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
                "\t</WorldModel>\n" +
                "</worlds>\n";
        String testString2="<worlds>\n" +
                "\t<WorldModel>\n" +
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
                "\t</WorldModel>\n" +
                "\t<WorldModel>\n" +
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
                "\t</WorldModel>\n" +
                "</worlds>";
        String testString3="<worlds>\n" +
                "\t<WorldModel>\n" +
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
                "\t</WorldModel>\n" +
                 "</worlds>";
        //System.out.println(testString2);
       String testString4=" {\n \"name\": \"nombrePrueba\",\n" +
               "  \"cols\": 4,\n" +
               "  \"rows\": 0,\n" +
                "  \"config\": {\n" +
                "    \"box_color\": \"#ffff00\",\n" +
                "    \"box_on_target_color\": \"#fe0002\",\n" +
                "    \"target_color\": \"#d6fe0a\",\n" +
                "    \"brick_color\": \"#bdbebf\",\n" +
                "    \"hall_color\": \"#0001ff\",\n" +
                "    \"undefined_color\": \"#303030\",\n" +
                "    \"player_color\": \"#ff00f7\"\n" +
                "  },\n" +
                "  \"board\": [\n" +
                "    {\n" +
                "      \"posX\": 0,\n" +
                "      \"posY\": \"2 * 1\",\n" +
                "      \"type\": \"BRICK\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": 0,\n" +
                "      \"posY\": \"9 / 3 * 1\",\n" +
                "      \"type\": \"BRICK\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": 0,\n" +
                "      \"posY\": \"10 / 2 - 1\",\n" +
                "      \"type\": \"BRICK\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": \"2 / 2\",\n" +
                "      \"posY\": 0,\n" +
                "      \"type\": \"BRICK\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": \"10 - 3 * 3\",\n" +
                "      \"posY\": \"3 * 2 - 5\",\n" +
                "      \"type\": \"HALL\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": 1,\n" +
                "      \"posY\": \"2 * 1\",\n" +
                "      \"type\": \"HALL\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"boxes\": [\n" +
                "    {\n" +
                "      \"posX\": 2,\n" +
                "      \"posY\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": 2,\n" +
                "      \"posY\": \"1 + 1\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"targets\": [\n" +
                "    {\n" +
                "      \"posX\": \"4 / 2 + 1\",\n" +
                "      \"posY\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": \"4 / 2 + 1\",\n" +
                "      \"posY\": \"1 * 1 + 1\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"player\": {\n" +
                "    \"posX\": 1,\n" +
                "    \"posY\": \"(5 + 2) / (3 + 4)\"\n" +
                "  }\n" +
                "}";
        String testString5=" {\n \"name\": \"nombrePrueba2\",\n" +
                "  \"cols\": 4,\n" +
                "  \"rows\": 10,\n" +
                "  \"config\": {\n" +
                "    \"box_color\": \"#ffff00\",\n" +
                "    \"box_on_target_color\": \"#fe0002\",\n" +
                "    \"target_color\": \"#d6fe0a\",\n" +
                "    \"brick_color\": \"#bdbebf\",\n" +
                "    \"hall_color\": \"#0001ff\",\n" +
                "    \"undefined_color\": \"#303030\",\n" +
                "    \"player_color\": \"#ff00f7\"\n" +
                "  },\n" +
                "  \"board\": [\n" +
                "    {\n" +
                "      \"posX\": 0,\n" +
                "      \"posY\": \"2 * 1\",\n" +
                "      \"type\": \"BRICK\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": 0,\n" +
                "      \"posY\": \"9 / 3 * 1\",\n" +
                "      \"type\": \"BRICK\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": 0,\n" +
                "      \"posY\": \"10 / 2 - 1\",\n" +
                "      \"type\": \"BRICK\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": \"2 / 2\",\n" +
                "      \"posY\": 0,\n" +
                "      \"type\": \"BRICK\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": \"10 - 3 * 3\",\n" +
                "      \"posY\": \"3 * 2 - 5\",\n" +
                "      \"type\": \"HALL\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": 1,\n" +
                "      \"posY\": \"2 * 1\",\n" +
                "      \"type\": \"HALL\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"boxes\": [\n" +
                "    {\n" +
                "      \"posX\": 2,\n" +
                "      \"posY\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": 2,\n" +
                "      \"posY\": \"1 + 1\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"targets\": [\n" +
                "    {\n" +
                "      \"posX\": \"4 / 2 + 1\",\n" +
                "      \"posY\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": \"4 / 2 + 1\",\n" +
                "      \"posY\": \"1 * 1 + 1\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"player\": {\n" +
                "    \"posX\": 1,\n" +
                "    \"posY\": \"(5 + 2) / (3 + 4)\"\n" +
                "  }\n" +
                "}";

       compileJson(testString4+","+testString5);
        compileJson(testString4);
        //compileXml(testString);
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





}