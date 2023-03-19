package com.dani.appmovil.objects

data class Motion (var directMov:Int, var value:Int, var movePush: Boolean){

    fun getInfo(): String {
        return "type: ${this.directMov}, value: ${this.value}, is push?: ${this.movePush}\n"
    }
}