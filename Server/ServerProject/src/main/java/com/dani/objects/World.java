package com.dani.objects;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(namespace = "", localName = "world")
public class World {
    private String name;
    private Integer rows;
    private Integer cols;
    private ConfigWorld config;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "board")
    private ArrayList<Board> arrayBoard;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "boxes")
    private ArrayList<Box> arrayBoxes;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "targets")
    private ArrayList<Target> arrayTarget;
    private Player player;
    /*objeto de esta clase*/

    public World() {
        arrayBoard= new ArrayList<Board>();
        arrayBoxes= new ArrayList<Box>();
        arrayTarget= new ArrayList<Target>();
    }

    public World(String name, Integer rows, Integer cols, ConfigWorld config, ArrayList<Board> arrayBoard, ArrayList<Box> arrayBoxes, ArrayList<Target> arrayTarget, Player player) {
        this.name = name;
        this.rows = rows;
        this.cols = cols;
        this.config = config;
        this.arrayBoard = arrayBoard;
        this.arrayBoxes = arrayBoxes;
        this.arrayTarget = arrayTarget;
        this.player = player;
    }

    public World(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getCols() {
        return cols;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    public ConfigWorld getConfig() {
        return config;
    }

    public void setConfig(ConfigWorld config) {
        this.config = config;
    }

    public ArrayList<Board> getArrayBoard() {
        return arrayBoard;
    }

    public void setArrayBoard(ArrayList<Board> arrayBoard) {
        this.arrayBoard = arrayBoard;
    }

    public ArrayList<Box> getArrayBoxes() {
        return arrayBoxes;
    }

    public void setArrayBoxes(ArrayList<Box> arrayBoxes) {
        this.arrayBoxes = arrayBoxes;
    }

    public ArrayList<Target> getArrayTarget() {
        return arrayTarget;
    }

    public void setArrayTarget(ArrayList<Target> arrayTarget) {
        this.arrayTarget = arrayTarget;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "World{" +
                "name='" + name + '\'' +
                ", rows=" + rows +
                ", cols=" + cols +
                ", config=" + config +
                ", arrayBoard=" + arrayBoard +
                ", arrayBoxes=" + arrayBoxes +
                ", arrayTarget=" + arrayTarget +
                ", player=" + player +
                '}';
    }
}
