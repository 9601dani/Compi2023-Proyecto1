package com.dani;

import java.io.IOException;
import java.io.StringReader;

public class Main {
    public static void main(String[] args) {
        String testString="{\n" +
                "   \"name\": \"tatoine\",\n" + "201.1"+
                "   \"rows\": \"5 * 5 - 20\",\n" +
                "   \"cols\": \"10 / 5 + 2\",\n" +
                "   \"config\": {\n" +
                "       \"box_color\": \"#ffff00\",\n" +
                "       \"box_on_target_color\": \"#fe0002\",\n" +
                "       \"target_color\": \"#d6fe0a\",\n" +
                "       \"brick_color\": \"#bdbebf\",\n" +
                "       \"hall_color\": \"#0001ff\",\n" +
                "       \"undefined_color\": \"#303030\",\n" +
                "       \"player_color\": \"#ff00f7\"\n" +
                "   },\n";
        Lexer lexer = new Lexer(new StringReader(testString));
        try{
            Token token= lexer.yylex();
            while(token.getTokenType() != TokenType.EOF){
                token=lexer.yylex();
            }
        }catch (IOException e){
            e.getMessage();

        }

    }
}