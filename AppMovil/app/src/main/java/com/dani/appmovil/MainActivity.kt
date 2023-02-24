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
        val cadenaN3="# hacia abajo 1 posición\n" +
                "down (2 * 5 / 10);\n" +
                "\n" +
                "# empujando la caja hacia la derecha\n" +
                "push right (6 - 5);\n" +
                "\n" +
                "# hacia la izquierda una casilla\n" +
                "left (6 / 2 - 2);\n"
        this.compile(cadenaN3)
    }
    private fun compile(input: String) {
        val lexer =  LexerMov(StringReader(input))
        val pa= ParserMov(lexer);
        val parser = pa.parse().value as ArrayList<*>
        parser.forEach{
            println("Mov--> $it")
        }
    }
}