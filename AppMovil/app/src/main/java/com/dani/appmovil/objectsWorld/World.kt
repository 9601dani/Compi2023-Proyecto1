package com.dani.appmovil.objectsWorld

class World (
    var name:String, var rows:Integer, var cols:Integer, var config:ConfigWorld, var arrayBoard:ArrayList<Board>, var arrayBoxes: ArrayList<Box>,
    var arrayTarget: ArrayList<Target>, var player:Player, var errorArray:ArrayList<AError>?){

    constructor():this("",Integer(0),Integer(0), ConfigWorld(),
         ArrayList<Board>(), ArrayList<Box>(),ArrayList<Target>(),Player(),ArrayList<AError>())
     fun getInfo(): String {
        return "World(name='$name')"
    }

    fun getNames(): String {
        return name;
    }
}