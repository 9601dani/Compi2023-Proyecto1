package com.dani.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
@JacksonXmlRootElement(namespace = "", localName = "worlds")
public class WorldsModel {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "world")
    ArrayList<WorldModel> arrayWorld;


    public WorldsModel() {

    }



    public WorldsModel(ArrayList<WorldModel> arrayWorld) {
        this.arrayWorld = arrayWorld;
    }

    public ArrayList<WorldModel> getArrayWorld() {
        return arrayWorld;
    }

    public void setArrayWorld(ArrayList<WorldModel> arrayWorld) {
        this.arrayWorld = arrayWorld;
    }
}
