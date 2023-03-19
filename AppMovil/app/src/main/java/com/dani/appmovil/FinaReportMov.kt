package com.dani.appmovil

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TableLayout
import android.widget.TextView
import com.dani.appmovil.models.ConstruccionMatriz.listMovimientosFinales
import com.dani.appmovil.objects.MotionArr
import com.dani.appmovil.parserMov.ParserMovSym

class FinaReportMov : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fina_report_mov)
        val movimientosFinales= listMovimientosFinales
        setTable(movimientosFinales)
    }

    private  fun setTable(listMov: ArrayList<MotionArr>){
        val tablaErrores= findViewById<TableLayout>(R.id.mov_table)
        tablaErrores.removeAllViews()
        val encabezados= LayoutInflater.from(this).inflate(R.layout.report_only_mov_final_row,null,false)
        val txt_type= encabezados.findViewById<TextView>(R.id.txt_mov_final)
        val txt_cantidad= encabezados.findViewById<TextView>(R.id.txt_cantidad_final)
        val txt_line= encabezados.findViewById<TextView>(R.id.text_line_report_final)
        val txt_column= encabezados.findViewById<TextView>(R.id.txt_column_report_final)

        txt_type.text= "Instruccion"
        txt_type.setTextColor(Color.BLUE)
        txt_cantidad.text="Valor Mov."
        txt_cantidad.setTextColor(Color.BLUE)
        txt_line.text="Linea"
        txt_line.setTextColor(Color.BLUE)
        txt_column.text="Columna"
        txt_cantidad.setTextColor(Color.BLUE)
        tablaErrores.addView(encabezados)

        listMov.forEach {
            val row = LayoutInflater.from(this).inflate(R.layout.report_only_mov_final_row, null, false)
            val txt_type= row.findViewById<TextView>(R.id.txt_mov_final)
            val txt_cantidad= row.findViewById<TextView>(R.id.txt_cantidad_final)
            val txt_line= row.findViewById<TextView>(R.id.text_line_report_final)
            val txt_column= row.findViewById<TextView>(R.id.txt_column_report_final)

            txt_type.text= verType((it.directMov))
            txt_cantidad.text= it.valor.toString()
            txt_line.text= it.linea.toString()
            txt_column.text=it.columna.toString()

            tablaErrores.addView(row)
        }
    }

    fun verType(input:Int):String{
        if(input== ParserMovSym.DOWN){
            return "down"
        }else if(input== ParserMovSym.UP){
            return "up"
        }else if(input== ParserMovSym.LEFT){
            return "left"
        }else {
            return  "right"
        }

    }
}