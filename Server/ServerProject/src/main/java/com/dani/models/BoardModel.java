package com.dani.models;

import java.io.Serializable;

public class BoardModel implements Serializable {
    private Integer posX;
    private Integer posY;
    private Integer type;

    public BoardModel(Integer posX, Integer posY, Integer type) {
        this.posX = posX;
        this.posY = posY;
        this.type = type;
    }
  /*  public String getType(Integer T) {
        if(T==3){
            return "HALL";
        }else if(T==4){
            return "BRICK";
        }
        return "F";
    }*/

    public BoardModel() {
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
