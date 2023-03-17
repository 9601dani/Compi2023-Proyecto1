package com.dani.appmovil.objectsWorld

import java.io.Serializable

data class AError(var lexeme:String, var line:Int,var column:Int,var type:String, var description:String):
    Serializable {
    constructor() : this("",0,0,"","")
    override fun toString(): String {
        return "AError -->'$lexeme', line=$line, column=$column, type='$type', description='${description}')"
    }
}