package com.dani.appmovil

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import com.dani.appmovil.models.ConstruccionMatriz.reportOperaciones
import com.dani.appmovil.models.ReportMov
import com.dani.appmovil.models.ReportMovLayout
import com.dani.appmovil.models.ReportOperacionesMov
import com.dani.appmovil.objects.Motion
import com.dani.appmovil.objectsWorld.ArrayWorld
import com.dani.appmovil.parserMov.LexerMov
import com.dani.appmovil.parserMov.ParserMov
import java.io.StringReader

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
        val botonReportMov:Button= findViewById(R.id.button_report_ope)
        val botonCompileMov:Button= findViewById(R.id.button_compile_mov)
        val botonReportMovOn: Button= findViewById(R.id.button_report_mov)
        val txt_mov:EditText= findViewById(R.id.text_mov)
        botonCompileMov.setOnClickListener(View.OnClickListener {
            reportOperaciones=ArrayList()
            (compiler(txt_mov.text.toString()))
        })
        botonReportMov.setOnClickListener(View.OnClickListener {
        val intent= Intent(this,ReportOperacionesMov::class.java)
            startActivity(intent)
        })
        botonReportMovOn.setOnClickListener(View.OnClickListener {
            val intent1= Intent(this, ReportMovLayout::class.java)
            startActivity(intent1)
        })

    }
    private fun compiler(input: String) {
        val lexer = LexerMov(StringReader(input))
        val pa= ParserMov(lexer);
        val parser = pa.parse().value as ArrayList<Motion>
        parser.forEach{
            println("Mov--> ${it.getInfo()}")
        }
    }
}