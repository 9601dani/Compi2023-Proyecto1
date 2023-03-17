package com.dani.appmovil

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import com.dani.appmovil.objectsWorld.ArrayWorld
import com.dani.appmovil.objectsWorld.Response
import com.dani.appmovil.objectsWorld.World

class TableroJuego : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablero_juego)

        val responde= intent.getSerializableExtra("response",ArrayWorld::class.java)
        val world= responde!!.aWorld.get(0)
        var frameLayout = findViewById<FrameLayout>(R.id.frameLayout)
        var paintPanel= PaintPanel(this,world!!)
        frameLayout?.addView(paintPanel);
        ArrayWorld().clean()

    }
}