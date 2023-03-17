package com.dani.appmovil.models

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dani.appmovil.R
import com.dani.appmovil.models.ConstruccionMatriz.*
import java.util.ArrayList


class ReportMovLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_mov)
        reporMov!!.add(ReportMov("LEFT", CANTIDAD_LEFT))
        reporMov!!.add(ReportMov("RIGHT", CANTIDAD_RIGHT))
        reporMov!!.add(ReportMov("UP", CANTIDAD_UP))
        reporMov!!.add(ReportMov("DOWN", CANTIDAD_DOWN))
        val listMov= reporMov;
        setTable(listMov)
        CANTIDAD_DOWN=0;
        CANTIDAD_LEFT=0;
        CANTIDAD_UP=0;
        CANTIDAD_RIGHT=0;
        reporMov= ArrayList()
        
    }
    private fun setTable(listOpeMov: ArrayList<ReportMov>) {
        val tableMovReport = findViewById<TableLayout>(R.id.table_repor_mov_l)
        tableMovReport.removeAllViews()
        val encabezado = LayoutInflater.from(this).inflate(R.layout.report_mov_row, null, false)
        val txt_direccion = encabezado.findViewById<TextView>(R.id.txt_mov_direccion)
        val txt_cantidad = encabezado.findViewById<TextView>(R.id.xt_mov_cantidad)

        txt_direccion.text = "DIRECCION"
        txt_direccion.setTextColor(Color.BLUE)
        txt_cantidad.text = "CANTIDAD"
        txt_cantidad.setTextColor(Color.BLUE)
        tableMovReport.addView(encabezado)

        listOpeMov.forEach {
            println("ando entrando aqui")
            val row = LayoutInflater.from(this).inflate(R.layout.report_mov_row, null, false)
            val txt_direccion = row.findViewById<TextView>(R.id.txt_mov_direccion)
            val txt_cantidad = row.findViewById<TextView>(R.id.xt_mov_cantidad)

            txt_direccion.text = it.direccion
            txt_cantidad.text = it.cantidad.toString()
            tableMovReport.addView(row)
        }
    }
}