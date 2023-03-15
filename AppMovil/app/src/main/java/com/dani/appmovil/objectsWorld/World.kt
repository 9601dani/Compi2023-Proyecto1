package com.dani.appmovil.objectsWorld

data class World (
    var name:String?, var rows:Integer?, var cols:Integer?, var config:ConfigWorld?, var arrayBoard:ArrayList<Board>, var arrayBoxes: ArrayList<Box>,
    var arrayTarget: ArrayList<Target>, var player:Player?, var errArray:ArrayList<AError>){

    constructor():this(null,Integer(0),Integer(0), ConfigWorld(),
         ArrayList<Board>(), ArrayList<Box>(),ArrayList<Target>(),Player(),ArrayList<AError>())


    fun getInfo(): String {
        return "World(name='$name')"
    }

    fun getNames(): String {
        if(name!=null){
            return name.toString()
        }
        return ""
    }
    fun clean() {
        name = null
        rows = null
        cols = null
        config = null
        arrayBoard = ArrayList()
        arrayBoxes = ArrayList()
        arrayTarget = ArrayList()
        player = null
        errArray= ArrayList()
    }

    override fun toString(): String {
        return "(name=$name, rows=$rows, cols=$cols, config=$config, arrayBoard=$arrayBoard, arrayBoxes=$arrayBoxes, arrayTarget=$arrayTarget, player=$player, errArray=$errArray)"
    }

}