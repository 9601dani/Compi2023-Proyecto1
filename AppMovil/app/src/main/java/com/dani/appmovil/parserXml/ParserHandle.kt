package com.dani.appmovil.parserXml

import com.dani.appmovil.objectsWorld.World
import java.io.StringReader

class ParserHandle {
    public  fun compilerXml(input: String) {
        println("SI SI SI ")
        val lexer =  LexXml(StringReader(input))
        val pa= ParserXml(lexer);
        val parser = pa.parse().value as ArrayList<World>
        parser.forEach{
            println("word ${it.getInfo()}")
        }

    }
}