package com.dani.appmovil.objects

import android.util.Log

class Token(val lexeme: String?, val tokenType: Int, val column: Int, val line:Int ) {
    private val TAG: String = "Token.class"

    fun printInfo() {
        Log.println(Log.INFO, TAG, "value: ${this.lexeme}, type: ${this.tokenType}, line: ${this.line}, column: ${this.column}")
    }

    fun getInfo(): String {
        return "value: ${this.lexeme}, type: ${this.tokenType}, line: ${this.line}, column: ${this.column}\n"
    }
}