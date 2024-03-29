package com.dani.appmovil.objectsWorld

import java.io.Serializable

data class ConfigWorld(var box_color: String?,var box_on_target_color:String?,var target_color:String?,
                        var brick_color:String?, var hall_color:String?, var undefined_color:String?,var player_color:String?):
    Serializable {
    constructor():this("","","","","","","")
    override fun toString(): String {
        return "ConfigWorld(box_color='$box_color', box_on_target_color='$box_on_target_color', target_color='$target_color', brick_color='$brick_color', hall_color='$hall_color', undefined_color='$undefined_color', player_color='$player_color')"
    }
    fun clean() {
        box_color = null
        box_on_target_color = null
        target_color = null
        brick_color = null
        hall_color = null
        undefined_color = null
        player_color = null
    }
}