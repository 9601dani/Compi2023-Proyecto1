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
import com.dani.appmovil.objectsWorld.ArrayWorld
import org.w3c.dom.Text

class NamesA : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_names)
        val response = intent.getSerializableExtra("response", ArrayWorld:: class.java)
        if (response != null) {
            setTable(response)
        }
    }

private fun setTable(listW: ArrayWorld){
 val tablaNames= findViewById<TableLayout>(R.id.tableNames)
    tablaNames.removeAllViews()
    val encabezados = LayoutInflater.from(this).inflate(R.layout.name_row,null,false)
    val txt_world= encabezados.findViewById<TextView>(R.id.txt_name_worlds)

    txt_world.text="Nombres Mundos"
    txt_world.setTextColor(Color.BLACK)
    tablaNames.addView(encabezados)

    listW.aWorld.forEach{
        val row = LayoutInflater.from(this).inflate(R.layout.name_row,null,false)
        val txt_world= row.findViewById<TextView>(R.id.txt_name_worlds)
        txt_world.text= it.name
        tablaNames.addView(row)
    }
}
}