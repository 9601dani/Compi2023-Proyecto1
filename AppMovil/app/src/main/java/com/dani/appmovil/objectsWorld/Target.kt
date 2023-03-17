package com.dani.appmovil.objectsWorld

import java.io.Serializable

data class Target (var posX:Integer?, var posY:Integer?):
    Serializable {
    constructor():this(Integer(0), Integer(0))
    override fun toString(): String {
        return "Target(posX='$posX', posY='$posY')"
    }
    fun clean() {
        posX = null
        posY = null
    }
}