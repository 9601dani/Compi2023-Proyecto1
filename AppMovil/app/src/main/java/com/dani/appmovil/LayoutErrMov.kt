package com.dani.appmovil

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TableLayout
import android.widget.TextView
import com.dani.appmovil.models.ConstruccionMatriz.erroForClient
import com.dani.appmovil.models.ErrorMovClient
import com.dani.appmovil.objectsWorld.AError

class LayoutErrMov : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_err_mov)

        val errOnMovCliente= erroForClient

        setTable(errOnMovCliente)
    }
    private  fun setTable(listEC: ArrayList<ErrorMovClient>){
        val tablaErrores= findViewById<TableLayout>(R.id.t_err)
        tablaErrores.removeAllViews()
        val encabezados= LayoutInflater.from(this).inflate(R.layout.layout_err_row,null,false)
        val txt_lexema= encabezados.findViewById<TextView>(R.id.txt_lexema_err)
        val txt_line= encabezados.findViewById<TextView>(R.id.txt_line_err)
        val txt_column= encabezados.findViewById<TextView>(R.id.txt_column_err)
        val txt_type= encabezados.findViewById<TextView>(R.id.txt_type_err)
        val txt_descrip= encabezados.findViewById<TextView>(R.id.txt_descrip_err)

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
        println("---> size "+listEC.size)
        listEC.forEach {
            val row = LayoutInflater.from(this).inflate(R.layout.layout_err_row, null, false)
            val txt_lexema = row.findViewById<TextView>(R.id.txt_lexema_err)
            val txt_line = row.findViewById<TextView>(R.id.txt_line_err)
            val txt_column = row.findViewById<TextView>(R.id.txt_column_err)
            val txt_type = row.findViewById<TextView>(R.id.txt_type_err)
            val txt_descrip = row.findViewById<TextView>(R.id.txt_descrip_err)

            txt_lexema.text = it.lexema
            txt_line.text = it.linea.toString()
            txt_column.text = it.columna.toString()
            txt_type.text = it.typeE
            txt_descrip.text = it.descrip

            tablaErrores.addView(row)
        }
    }
}