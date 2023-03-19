package com.dani.appmovil

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.dani.appmovil.models.ErroresA
import com.dani.appmovil.models.NamesA
import com.dani.appmovil.objectsWorld.ArrayWorld
import com.dani.appmovil.objectsWorld.World
import com.dani.appmovil.parserXml.LexXml
import com.dani.appmovil.parserXml.ParserXml
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.StringReader
import java.net.InetAddress
import java.net.Socket
import java.util.concurrent.Executors

public var opcion:String="";

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val compileButton: Button = findViewById(R.id.compi_buttom)
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
                       /* var strnS="";
                        for(i in 0..arrayWorld.size-1){
                            strnS+=arrayWorld.get(i).getNames()+" "
                        }
                        txtResponse.text=(strnS)*/
                        if(arrayWorld.get(0).arrayBoard.isEmpty()){

                            mandarA_NuevoActivity("ONLY_NAMES",arrayWorld)
                        }else{
                            mandarA_NuevoActivity("DIBUJAR_MUND0",arrayWorld)
                        }

                    }else{
                        /*var sr=""
                        for(i in 0..arrayWorld.get(0).errArray.size-1){
                            sr+=arrayWorld.get(0).errArray.get(i).toString()
                            print(i)
                        }
                        txtResponse.text=(sr)*/
                        mandarA_NuevoActivity("ERROR",arrayWorld)
                    }
                }
            }
        }catch (e: java.lang.Exception){
            println("sin conexion")}
        Toast.makeText(this,"Ups, no hay conexion",Toast.LENGTH_SHORT).show()

    }
    fun compilerXml(input: String): ArrayList<World> {
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

    private fun mandarA_NuevoActivity(op:String, arrayWorl: ArrayList<World>){
        val arr: ArrayWorld =  ArrayWorld(arrayWorl)
        when(op){
           "DIBUJAR_MUND0"-> {
               val intent= Intent(this, TableroJuego::class.java)
               intent.putExtra("response",arr)
               startActivity(intent)
            }
            "ONLY_NAMES"->{
                val intent= Intent(this, NamesA::class.java)
                intent.putExtra("response",arr)
                startActivity(intent)
            }
            "ERROR" ->{
                val intent= Intent(this, ErroresA:: class.java)
                intent.putExtra("response",arr)
                startActivity(intent)
                arrayWorl.get(0).clean();
            }
        }
    }

}