package com.dani.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(namespace = "", localName = "worlds")
public class NameWorld {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "world")
    private ArrayList<String>  world;

    public NameWorld(ArrayList<String> world) {
        this.world = world;
    }

    public ArrayList<String> getWorld() {
        return world;
    }

    public void setWorld(ArrayList<String> world) {
        this.world = world;
    }
}
