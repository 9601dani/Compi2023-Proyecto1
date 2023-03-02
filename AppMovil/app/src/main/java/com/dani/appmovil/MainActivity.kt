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
import com.dani.appmovil.server.ConexServer
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.StringReader
import java.net.Socket
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editor: EditText = findViewById(R.id.etInput)
        val textView: TextView = findViewById(R.id.tvResult)
        val compileButton: Button = findViewById(R.id.btnCompile)

        compileButton.setOnClickListener(View.OnClickListener {
           /* Log.println(Log.INFO, TAG, "Compiling")*/
            val input = editor.text.toString()
            val output = this.compiler(input);

            if (output != null) {
                textView.text = output.toString()
            } else {
                textView.text = "Something went wrong"
            }
        })
        createSocket()
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
    private fun createSocket(){
        findViewById<Button>(R.id.btnClear).setOnClickListener{
            Log.d("Mensaje", "Conectandise al sevidor")
            Executors.newSingleThreadExecutor().execute{
                val socket = Socket("192.168.0.33",5000)
                val dataInput= DataInputStream(socket.getInputStream())
                val dataOutputStream= DataOutputStream(socket.getOutputStream())
                dataOutputStream.writeUTF("Enviando mensaje desde el cliente")
                val mensaje=dataInput.readUTF()
                println(mensaje)
            }
        }

    }


}