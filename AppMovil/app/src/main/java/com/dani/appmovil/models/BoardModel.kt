package com.dani.appmovil.models

import com.dani.appmovil.objectsWorld.Board
import com.dani.appmovil.objectsWorld.World

data class BoardModel (val buid:Point, val boar: Board)  {
            val point= buid
            val type: Integer? = boar.type
            var esBox:Boolean= false
            var esTarget:Boolean=false
            var esPlayer:Boolean=false

}