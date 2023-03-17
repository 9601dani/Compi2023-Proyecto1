package com.dani.appmovil.models

data class OperacionesMovReport(var operador:String,var line:Int, var column:Int) {
    override fun toString(): String {
        return "OperacionesMovReport(operador='$operador', line=$line, column=$column)"
    }
}