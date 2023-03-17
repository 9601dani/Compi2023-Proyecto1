package com.dani.appmovil

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import com.dani.appmovil.models.ConstruccionMatriz
import com.dani.appmovil.objectsWorld.World
import com.dani.appmovil.parserXml.ParserXmlSym

class PaintPanel(context: Context?, val world:World): View(context) {
    private val posX = 100.0f
    private val posY = 100.0f
    private val increment = 150.0f
    private var canvas: Canvas?=null
/*    private val imgResIds = setOf(R.drawable.player, R.drawable.box)
    private val bitmaps = mutableMapOf<Int, Bitmap>()*/

    private val paint = Paint()
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.style = Paint.Style.FILL_AND_STROKE

        var boardMatrix = ConstruccionMatriz().hacerMatriz(world)

        for(i in 0 until world.rows!!.toInt()){
            for(j in 0 until world.cols!!.toInt()){
                if(boardMatrix[i][j] == null){
                    paintUndefined(paint, canvas, i, j)
                    continue
                }

                if(boardMatrix[i][j].esBox && boardMatrix[i][j].esTarget){
                    paintBoxOnTarget(paint, canvas, i, j)
                    continue
                }

                if(boardMatrix[i][j].esBox){
                    paintBox(paint, canvas, i, j)
                    continue
                }

                if(boardMatrix[i][j].esTarget){
                    paintTarget(paint, canvas, i, j)
                    continue
                }

                if(boardMatrix[i][j].esPlayer){
                    paintPlayer(paint, canvas, i, j)
                    continue
                }

                if(boardMatrix[i][j].type == Integer(ParserXmlSym.BRICK)){
                    paintBrick(paint, canvas, i, j)
                    continue
                } else {
                    paintHall(paint, canvas, i, j)
                }

            }
        }

    }



    /*   private fun loadBitmaps(){
           imgResIds.forEach {
               bitmaps[it] = BitmapFactory.decodeResource(resources, it)
           }
       }*/

    private fun paintUndefined(paint: Paint, canvas: Canvas?, i: Int, j: Int){
        paint.color = Color.parseColor(world.config!!.undefined_color)
        canvas?.drawRect(posX+ increment*j,posY+increment*i,posX+increment*(j+1),posY+increment*(i+1),paint)
    }

    private fun paintBox(paint: Paint, canvas: Canvas?, i: Int, j: Int){
        paint.color = Color.parseColor(world.config!!.box_color)
        canvas?.drawRect(posX+ increment*j,posY+increment*i,posX+increment*(j+1),posY+increment*(i+1),paint)
    }

    private fun paintBoxOnTarget(paint: Paint, canvas: Canvas?, i: Int, j: Int){
        paint.color = Color.parseColor(world.config!!.box_on_target_color)
        canvas?.drawRect(posX+ increment*j,posY+increment*i,posX+increment*(j+1),posY+increment*(i+1),paint)
    }

    private fun paintTarget(paint: Paint, canvas: Canvas?, i: Int, j: Int){
        paint.color = Color.parseColor(world.config!!.target_color)
        canvas?.drawRect(posX+ increment*j,posY+increment*i,posX+increment*(j+1),posY+increment*(i+1),paint)
    }

    private fun paintPlayer(paint: Paint, canvas: Canvas?, i: Int, j: Int){
        paint.color = Color.parseColor((world.config!!.player_color))
        canvas?.drawRect(posX+ increment*j,posY+increment*i,posX+increment*(j+1),posY+increment*(i+1),paint)
//        canvas?.drawBitmap(bitmaps[R.drawable.player]!!, null, RectF(posX+ increment*j,posY+increment*i,posX+increment*(j+1),posY+increment*(i+1)), paint)
    }

    private fun paintBrick(paint: Paint, canvas: Canvas?, i: Int, j: Int){
        paint.color = Color.parseColor(world.config!!.brick_color)
        canvas?.drawRect(posX+ increment*j,posY+increment*i,posX+increment*(j+1),posY+increment*(i+1),paint)
    }

    private fun paintHall(paint: Paint, canvas: Canvas?, i: Int, j: Int){
        paint.color = Color.parseColor(world.config!!.hall_color)
        canvas?.drawRect(posX+ increment*j,posY+increment*i,posX+increment*(j+1),posY+increment*(i+1),paint)
    }
}