package com.dani.objects;

public class Target {
    private Integer posX;
    private Integer posY;

    public Target() {
    }

    public Target(Integer posX, Integer posY) {
        this.posX = posX;
        this.posY = posY;
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

    @Override
    public String toString() {
        return "Target{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}