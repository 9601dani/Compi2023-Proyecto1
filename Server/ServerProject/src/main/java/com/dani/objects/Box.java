package com.dani.objects;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "boxes")
public class Box {
    private Integer posX;
    private Integer posY;

    public Box() {
    }

    public Box(Integer posX, Integer posY) {
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
        return "{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }
    public void clean(){
        this.posX=null;
        this.posY=null;

    }
}
