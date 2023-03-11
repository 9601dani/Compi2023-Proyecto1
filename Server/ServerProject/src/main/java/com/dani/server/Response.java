package com.dani.server;

import com.dani.objects.World;

import java.util.ArrayList;

public class Response {
        private Response_E typeRes;
        private ArrayList<World> world;
        private String name;
    public Response(Response_E typeRes) {
        this.typeRes = typeRes;
        this.world= new ArrayList<>();
        this.name=null;
    }

    public Response(Response_E typeRes, ArrayList<World> world) {
        this.typeRes = typeRes;
        this.world = world;
        this.name=null;
    }

    public Response(Response_E typeRes, String name) {
        this.typeRes = typeRes;
        this.world =  new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Response() {
        world= new ArrayList<World>();
    }
    public Response_E getTypeRes() {
        return typeRes;
    }

    public void setTypeRes(Response_E typeRes) {
        this.typeRes = typeRes;
    }

    public ArrayList<World> getWorld() {
        return world;
    }

    public void setWorld(ArrayList<World> world) {
        this.world = world;
    }
}
