package com.dani.appmovil.models

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TableLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.dani.appmovil.R
import com.dani.appmovil.objectsWorld.AError
import com.dani.appmovil.objectsWorld.ArrayWorld

class ErroresA : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_errores)
        val response = intent.getSerializableExtra("response", ArrayWorld:: class.java)
        /*for (i in 0..response!!.aWorld.size){

        }*/
        println("->"+response!!.aWorld.get(0).errArray.size)
        val errors= response!!.aWorld.get(0).errArray
    setTable(errors);
    }

   private  fun setTable(listE: ArrayList<AError>){
        val tablaErrores= findViewById<TableLayout>(R.id.tableErr)
        tablaErrores.removeAllViews()
        val encabezados= LayoutInflater.from(this).inflate(R.layout.error_row,null,false)
        val txt_lexema= encabezados.findViewById<TextView>(R.id.txt_lexema)
        val txt_line= encabezados.findViewById<TextView>(R.id.txt_line)
        val txt_column= encabezados.findViewById<TextView>(R.id.txt_column)
        val txt_type= encabezados.findViewById<TextView>(R.id.txt_type)
        val txt_descrip= encabezados.findViewById<TextView>(R.id.txt_descrip)

        txt_lexema.text= "Lexema"
        txt_lexema.setTextColor(Color.BLUE)
        txt_line.text="Linea"
        txt_line.setTextColor(Color.BLUE)
        txt_column.text="Columna"
        txt_column.setTextColor(Color.BLUE)
        txt_type.text="Tipo Error"
        txt_type.setTextColor(Color.BLUE)
        txt_descrip.text="Descripcion"
        txt_descrip.setTextColor(Color.BLUE)
        tablaErrores.addView(encabezados)
        listE.forEach {
            val row = LayoutInflater.from(this).inflate(R.layout.error_row, null, false)
            val txt_lexema = row.findViewById<TextView>(R.id.txt_lexema)
            val txt_line = row.findViewById<TextView>(R.id.txt_line)
            val txt_column = row.findViewById<TextView>(R.id.txt_column)
            val txt_type = row.findViewById<TextView>(R.id.txt_type)
            val txt_descrip = row.findViewById<TextView>(R.id.txt_descrip)

            txt_lexema.text = it.lexeme
            txt_line.text = it.line.toString()
            txt_column.text = it.column.toString()
            txt_type.text = it.type
            txt_descrip.text = it.description

            tablaErrores.addView(row)
        }
    }
}