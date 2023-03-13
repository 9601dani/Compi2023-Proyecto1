package com.dani.appmovil.objects

data class Motion (val directMov:Int, val value:Int, val movePush: Boolean){

    fun getInfo(): String {
        return "type: ${this.directMov}, value: ${this.value}, is push?: ${this.movePush}\n"
    }
}