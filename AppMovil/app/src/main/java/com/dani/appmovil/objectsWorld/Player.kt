package com.dani.appmovil.objectsWorld

data class Player(var posX:Integer?, var posY:Integer?) {
    constructor():this(Integer(0), Integer(0))
    override fun toString(): String {
        return "Player(posX='$posX', posY='$posY')"
    }
    fun clean() {
        posX = null
        posY = null
    }
}