package com.dani.appmovil.objectsWorld

import java.io.Serializable

data class Box(var posX:Integer?, var posY:Integer?):
    Serializable {
    constructor():this(Integer(0), Integer(0))
    override fun toString(): String {
        return "Box(posX=$posX, posY=$posY)"
    }
    fun clean(){
        this.posX=null
        this.posY=null
    }
}