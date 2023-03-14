package com.dani.appmovil.objectsWorld

data class Board(var posX:Integer?, var posY:Integer?, var type:Integer?) {
    constructor():this(Integer(0), Integer(0),Integer(0))
    override fun toString(): String {
        return "Board(posX=$posX, posY=$posY, type=$type)"
    }
    fun clean(){
        this.posX=null
        this.posY=null
        this.type=null
    }
}