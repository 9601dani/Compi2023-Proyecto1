package com.dani.objects;

public class Board {
    private Integer posX;
    private Integer posY;
    private Integer type;

    public Board() {
    }

    public Board(Integer type, String na) {
        if (na.equals("posX")){
            this.posX=type;
        }else if(na.equals("posY")){
            this.posY=type;
        }else if(na.equals("type")){
            this.type=type;
        }
    }

    public Board(Integer posX, Integer posY, Integer type) {
        this.posX = posX;
        this.posY = posY;
        this.type = type;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPosX() {
        return posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public Integer getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Board{" +
                "posX=" + posX +
                ", posY=" + posY +
                ", type=" + type +
                '}';
    }
}
