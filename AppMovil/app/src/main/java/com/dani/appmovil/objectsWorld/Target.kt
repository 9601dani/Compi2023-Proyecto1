package com.dani.appmovil.objectsWorld

data class Target (var posX:Integer, var posY:Integer){
    constructor():this(Integer(0), Integer(0))
    override fun toString(): String {
        return "Target(posX='$posX', posY='$posY')"
    }
}