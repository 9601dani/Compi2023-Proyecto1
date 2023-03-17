package com.dani.appmovil.objectsWorld

import java.io.Serializable

data class ArrayWorld(var aWorld: ArrayList<World>) : Serializable {
    constructor() : this(ArrayList())

    override fun toString(): String {
        return "arrayWorld(aWorld=$aWorld)"
    }

    fun clean(){
        aWorld= ArrayList()
    }

}