package com.dani.objects;

public class ConfigWorld {
    private String box_color;
    private String box_on_target_color;
    private String target_color;
    private String brick_color;
    private String hall_color;
    private String undefined_color;
    private String player_color;

    public ConfigWorld() {
    }

    public ConfigWorld(String box_color, String box_on_target_color, String target_color, String brick_color, String hall_color, String undefined_color, String player_color) {
        this.box_color = box_color;
        this.box_on_target_color = box_on_target_color;
        this.target_color = target_color;
        this.brick_color = brick_color;
        this.hall_color = hall_color;
        this.undefined_color = undefined_color;
        this.player_color = player_color;
    }

    public String getBox_color() {
        return box_color;
    }

    public String getBox_on_target_color() {
        return box_on_target_color;
    }

    public String getTarget_color() {
        return target_color;
    }

    public String getBrick_color() {
        return brick_color;
    }

    public String getHall_color() {
        return hall_color;
    }

    public String getUndefined_color() {
        return undefined_color;
    }

    public String getPlayer_color() {
        return player_color;
    }

    public void setBox_color(String box_color) {
        this.box_color = "#"+box_color;
    }

    public void setBox_on_target_color(String box_on_target_color) {
        this.box_on_target_color = "#"+box_on_target_color;
    }

    public void setTarget_color(String target_color) {
        this.target_color = "#"+target_color;
    }

    public void setBrick_color(String brick_color) {
        this.brick_color = "#"+brick_color;
    }

    public void setHall_color(String hall_color) {
        this.hall_color = "#"+hall_color;
    }

    public void setUndefined_color(String undefined_color) {
        this.undefined_color = "#"+undefined_color;
    }

    public void setPlayer_color(String player_color) {
        this.player_color = "#"+player_color;
    }

    @Override
    public String toString() {
        return "ConfigWorld{" +
                "box_color='" + box_color + '\'' +
                ", box_on_target_color='" + box_on_target_color + '\'' +
                ", target_color='" + target_color + '\'' +
                ", brick_color='" + brick_color + '\'' +
                ", hall_color='" + hall_color + '\'' +
                ", undefined_color='" + undefined_color + '\'' +
                ", player_color='" + player_color + '\'' +
                '}';
    }
}
