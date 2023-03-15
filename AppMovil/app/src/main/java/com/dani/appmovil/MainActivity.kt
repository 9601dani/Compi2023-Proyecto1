package com.dani.appmovil

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dani.appmovil.objects.LexerMov
import com.dani.appmovil.objects.Motion
import com.dani.appmovil.objects.ParserMov
import com.dani.appmovil.objectsWorld.World
import com.dani.appmovil.parserXml.LexXml
import com.dani.appmovil.parserXml.ParserXml
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.StringReader
import java.net.Socket
import java.util.concurrent.Executors
import java.net.InetAddress
import java.util.*
import kotlin.collections.ArrayList

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
        try{
            findViewById<Button>(R.id.compi_buttom).setOnClickListener{
                Log.d("Mensaje", "Conectandose al sevidor")
                Executors.newSingleThreadExecutor().execute{
                    val editor: EditText = findViewById(R.id.compileInputTxt)
                    println(InetAddress.getLocalHost())
                    val socket = Socket("192.168.0.33",5000)

                    val dataInput= DataInputStream(socket.getInputStream())
                    val dataOutputStream= DataOutputStream(socket.getOutputStream())
                    val input = editor.text.toString()
                    dataOutputStream.writeUTF(input)
                    val mensaje=dataInput.readUTF()
                    val txtResponse:TextView = findViewById(R.id.textResponse)

                    println("RECIBI ESTO: "+mensaje)
                    var arrayWorld= compilerXml(mensaje)
                    /*arrayWorld.forEach{
                        println("Mov--> ${it.getInfo()}")
                    }*/
                    var str=false

                    for(i in 0..arrayWorld.size-1){
                        if(!arrayWorld.get(i).errArray.isEmpty()){
                            str=true;
                        }
                    }
                    if(str==false){
                        var strnS="";
                        for(i in 0..arrayWorld.size-1){
                            strnS+=arrayWorld.get(i).getNames()+" "
                        }
                        txtResponse.text=(strnS)

                    }else{
                        println("es array de errores")
                    }
                }
            }
        }catch (e: java.lang.Exception){
            println("sin conexion")}

    }
    fun compilerXml(input: String): ArrayList<World> {
        println("SI SI SI ")
        val txtResponse:TextView = findViewById(R.id.textResponse)
        val lexer =  LexXml(StringReader(input))
        val pa= ParserXml(lexer);
        val parser = pa.parse().value as ArrayList<World>
       /* val str= ArrayList<String>()
        if(parser.get(0).arrayBoard.size<1){
            parser.forEach{
                println("word ${it.getInfo()}")
                str.add(it.getNames());
            }
            txtResponse.text=(str.toString())
        }else{
            txtResponse.text= parser.toString()
        }*/

        return parser

    }
}