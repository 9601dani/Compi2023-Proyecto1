package com.dani.appmovil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dani.appmovil.Objects.LexerMov
import com.dani.appmovil.Objects.ParserMov
import java.io.StringReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cadenaN2="up(5-3*2);"
        this.compile(cadenaN2);
        val cadenaN3="up((5-3)*2);"
        this.compile(cadenaN3);
        val cadenaN4="up(7*5+6/9-5-4*5+FLOOR(10.2));"
        this.compile(cadenaN4);
        val cadenaN5="up(FLOOR(10.2)+ CEIL(12.6));"
        this.compile(cadenaN5);
    }
    private fun compile(input: String) {
        val lexer =  LexerMov(StringReader(input))
        val pa= ParserMov(lexer);
        val parser = pa.parse().value as Double?
            println("Mov--> $parser")
    }
}