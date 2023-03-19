package com.dani.appmovil

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.dani.appmovil.models.ConstruccionMatriz.*
import com.dani.appmovil.models.ReportMovLayout
import com.dani.appmovil.models.ReportOperacionesMov
import com.dani.appmovil.objects.Motion
import com.dani.appmovil.objectsWorld.ArrayWorld
import com.dani.appmovil.parserMov.LexerMov
import com.dani.appmovil.parserMov.ParserMov
import com.dani.appmovil.parserMov.ParserMovSym
import java.io.StringReader

class TableroJuego : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablero_juego)
        val string_name_world: TextView= this.findViewById(R.id.txt_world_name)

        var motionsObe= ArrayList<Motion>()
        val responde= intent.getSerializableExtra("response",ArrayWorld::class.java)
        val world= responde!!.aWorld.get(0)
        string_name_world.text= "Bienvenido al mundo: "+world.name
        var frameLayout = findViewById<FrameLayout>(R.id.frameLayout)
        var paintPanel= PaintPanel(this,world!!)
        frameLayout?.addView(paintPanel);
        ArrayWorld().clean()
        val botonReportMov:Button= findViewById(R.id.button_report_ope)
        val botonCompileMov:Button= findViewById(R.id.button_compile_mov)
        val botonReportMovOn: Button= findViewById(R.id.button_report_mov)
        val botonReporteMovFInal:Button= findViewById(R.id.button_jugar)
        val txt_mov:EditText= findViewById(R.id.text_mov)

        botonCompileMov.setOnClickListener(View.OnClickListener {
            reportOperaciones=ArrayList()
            erroForClient= ArrayList()
            CANTIDAD_LEFT=0
            CANTIDAD_DOWN=0
            CANTIDAD_UP=0
            CANTIDAD_RIGHT=0
            motionsObe= (compiler(txt_mov.text.toString()))

            if(motionsObe.isNotEmpty()){
                Toast.makeText(this,"Se analizo correctamente",Toast.LENGTH_LONG).show()
                botonReportMov.setOnClickListener(View.OnClickListener {
                    val intent= Intent(this,ReportOperacionesMov::class.java)
                    startActivity(intent)
                })
                botonReportMovOn.setOnClickListener(View.OnClickListener {
                    val intent1= Intent(this, ReportMovLayout::class.java)
                    startActivity(intent1)
                })
                botonReporteMovFInal.setOnClickListener(View.OnClickListener {
                    val intent2= Intent(this,FinaReportMov::class.java)
                    startActivity(intent2)
                })

            }else{
                if(erroForClient.isEmpty()){
                    Toast.makeText(this,"errores del movimiento",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Ups, hemos encontrado errores",Toast.LENGTH_SHORT).show()
                    /*crear el intent de errores*/
                    val intent2= Intent(this, LayoutErrMov::class.java)
                    startActivity(intent2)
                }

            }

        })



    }
    private fun compiler(input: String): ArrayList<Motion> {
        erroForClient= ArrayList()
        listMovimientosFinales= ArrayList()
        println("entre al compiler")
        val lexer = LexerMov(StringReader(input))
        val pa= ParserMov(lexer);
        val sym = pa.parse();
        if(sym!= null && sym.value is ArrayList<*>){

            val motionPa= sym.value as ArrayList<Motion>
            /*motionPa.forEach{
                println("Mov--> ${it.getInfo()}")
            }*/
            this.cambiarNegativos(motionPa)
            for(i in 0..listMovimientosFinales.size-1) {
                listMovimientosFinales.get(i).valor = motionPa.get(i).value
                listMovimientosFinales.get(i).directMov= motionPa.get(i).directMov
            }
            return motionPa
        }
        /*if(sym!= null && sym.value is ArrayList<*>){
            val motionPa= sym.value as ArrayList<Motion>
            *//*for(i in 0..motionPa.size){
                listMovimientosFinales.get(i).valor=motionPa.get(i).value
            }*//*
            return motionPa
        }*/
        return ArrayList()
    }

    private fun cambiarNegativos(inputArr: ArrayList<Motion>){
        inputArr.forEach{
            if(it.value < 0){
                it.directMov= cambiarTyoe(it.directMov)
                it.value= kotlin.math.abs(it.value)
            }
        }
    }
    private fun cambiarTyoe(input: Int): Int{
        if(input== ParserMovSym.LEFT){
            return ParserMovSym.RIGHT
        }else if(input== ParserMovSym.RIGHT){
            return ParserMovSym.LEFT
        }else if( input == ParserMovSym.DOWN){
            return ParserMovSym.UP
        }else if(input== ParserMovSym.UP){
            return ParserMovSym.DOWN
        }
        return input
    }
}