package com.dani.appmovil

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dani.appmovil.Objects.LexerMov
import com.dani.appmovil.Objects.Motion
import com.dani.appmovil.Objects.ParserMov
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.StringReader
import java.net.Socket
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val compileButton: Button = findViewById(R.id.compi_buttom)
        val textResponse: TextView= findViewById(R.id.textResponse)
        compileButton.setOnClickListener(View.OnClickListener {
           /* Log.println(Log.INFO, TAG, "Compiling")*/

            /*val output = this.compiler(input);*/
            createSocket()

        })

        /*backspaceButton.setOnClickListener(View.OnClickListener {
           *//* Log.println(Log.INFO, TAG, "Cleaning editor")*//*
            *//*editor.setText("")*//*

        })*/

    }
    /*val cadenaN3="+"
        this.compile(cadenaN3)*/
    private fun compiler(input: String) {
        val lexer =  LexerMov(StringReader(input))
        val pa= ParserMov(lexer);
        val parser = pa.parse().value as ArrayList<Motion>
        parser.forEach{
            println("Mov--> ${it.getInfo()}")
        }
    }
    private fun createSocket()  {
        findViewById<Button>(R.id.compi_buttom).setOnClickListener{
            Log.d("Mensaje", "Conectandose al sevidor")
            Executors.newSingleThreadExecutor().execute{
                val editor: EditText = findViewById(R.id.compileInputTxt)
                val socket = Socket("192.168.0.33",5000)
                val dataInput= DataInputStream(socket.getInputStream())
                val dataOutputStream= DataOutputStream(socket.getOutputStream())
                val input = editor.text.toString()
                dataOutputStream.writeUTF(input)
                val mensaje=dataInput.readUTF()
                val txtResponse:TextView = findViewById(R.id.textResponse)
                txtResponse.text=(mensaje)
            }
        }
    }
}