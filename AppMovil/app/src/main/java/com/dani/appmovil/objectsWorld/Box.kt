package com.dani.appmovil.objectsWorld

data class Box(var posX:Integer?, var posY:Integer?) {
    constructor():this(Integer(0), Integer(0))
    override fun toString(): String {
        return "Box(posX=$posX, posY=$posY)"
    }
    fun clean(){
        this.posX=null
        this.posY=null
    }
}