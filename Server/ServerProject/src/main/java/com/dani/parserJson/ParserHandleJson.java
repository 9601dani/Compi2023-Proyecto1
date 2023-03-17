package com.dani.parserJson;

import com.dani.models.ErrorModel;
import com.dani.models.ErrorType;
import com.dani.objects.Response;
import java_cup.runtime.Symbol;

import java.io.StringReader;
import java.util.ArrayList;

import static com.dani.Main.erroForClient;

public class ParserHandleJson {
    public static Response compileJsonHandle(String testString){
        Response r=new Response();
        Lexer lexer = new Lexer(new StringReader(testString));
        erroForClient= new ArrayList<>();
        ParserJson parser = new ParserJson(lexer);
        Symbol sym= null;
        try {
            sym = parser.parse();
            if(sym!=null){
                r= (Response) sym.value;
            }
        } catch (Exception e) {
            erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"Hemos_encontrado_error_no_recuperable"));
            erroForClient= new ArrayList<>();
        }

        return r;
        /*try {
            ParserJson p = new ParserJson(new Lexer(new StringReader(testString)));
            Response worldList=p.parse()==null? null:(Response) p.parse().value;
            return worldList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }
}
