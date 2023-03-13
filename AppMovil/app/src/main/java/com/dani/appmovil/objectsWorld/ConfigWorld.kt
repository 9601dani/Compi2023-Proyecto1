package com.dani.appmovil.objectsWorld

data class ConfigWorld(var box_color: String,var box_on_target_color:String,var target_color:String,
                        var brick_color:String, var hall_color:String, var undefined_color:String,var player_color:String) {
    constructor():this("","","","","","","")
    override fun toString(): String {
        return "ConfigWorld(box_color='$box_color', box_on_target_color='$box_on_target_color', target_color='$target_color', brick_color='$brick_color', hall_color='$hall_color', undefined_color='$undefined_color', player_color='$player_color')"
    }
}