package com.dani.appmovil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dani.appmovil.Objects.LexerMov
import com.dani.appmovil.Objects.Token
import com.dani.appmovil.Objects.TokenType
import java.io.IOException
import java.io.StringReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("hi")
        this.compiler();
    }
    private fun compiler(){
        println("hola mundo")
        val stringP="\"down (2 * 5 / 10);\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"# empujando la caja hacia la derecha\\n\" +\n" +
                "                \"push right (6 - 5);\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"# hacia la izquierda una casilla\\n\" +\n" +
                "                \"left (6 / 2 - 2);\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"# hacia arriba una casilla\\n\" +\n" +
                "                \"down (-1);\""
        val lexer = LexerMov(StringReader(stringP))
        try {
            var token: Token = lexer.yylex()
            while (token.tokenType !== TokenType.EOF) {
                 token = lexer.yylex()
                println(token.getInfo())
            }
        } catch (e: IOException) {
            e.message
        }
    }
}