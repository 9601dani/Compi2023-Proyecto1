package com.dani.appmovil.models

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dani.appmovil.R
import com.dani.appmovil.models.ConstruccionMatriz.reportOperaciones
import java.util.ArrayList

class ReportOperacionesMov : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_operaciones_mox)
        val arrayOPeraciones= reportOperaciones
        if(!arrayOPeraciones.isEmpty()){
            setTable(arrayOPeraciones)
            println("------->"+arrayOPeraciones.size)
        }
    }
    private fun setTable(listOpe: ArrayList<OperacionesMovReport>){
        val tablerOpera= findViewById<TableLayout>(R.id.table_report_mov_1)
        tablerOpera.removeAllViews()
        val encabezado= LayoutInflater.from(this).inflate(R.layout.report_opera_row,null,false)
        val txt_operador= encabezado.findViewById<TextView>(R.id.text_operacion)
        val txt_line= encabezado.findViewById<TextView>(R.id.txt_linea)
        val txt_columna= encabezado.findViewById<TextView>(R.id.txt_column_mov)

        txt_operador.text="Operador"
        txt_operador.setTextColor(Color.BLUE)
        txt_line.text="Linea"
        txt_line.setTextColor(Color.BLUE)
        txt_columna.text="Columna"
        txt_columna.setTextColor(Color.BLUE)
        tablerOpera.addView(encabezado)

        listOpe.forEach{
            println("ando entrando aqui")
            val row= LayoutInflater.from(this).inflate(R.layout.report_opera_row,null,false)
            val txt_operado= row.findViewById<TextView>(R.id.text_operacion)
            val txt_lin= row.findViewById<TextView>(R.id.txt_linea)
            val txt_column= row.findViewById<TextView>(R.id.txt_column_mov)

            txt_operado.text = it.operador
            txt_lin.text = it.line.toString()
            txt_column.text = it.column.toString()

            tablerOpera.addView(row)
        }



    }
}