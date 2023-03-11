package com.dani.models;

import com.dani.objects.World;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(namespace = "", localName = "")

public class WorldModelName {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "worlds")
    ArrayList<String> world;

    public WorldModelName(ArrayList<String> world) {
        this.world = world;
    }

    public ArrayList<String> getWorld() {
        return world;
    }

    public void setWorld(ArrayList<String> world) {
        this.world = world;
    }
}
