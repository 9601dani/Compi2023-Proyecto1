package com.dani.objects;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.dani.objects.BoardModel;

import java.io.Serializable;
import java.util.ArrayList;

/*THIS IS MODEL FOR XML*/
@JacksonXmlRootElement(namespace = "", localName = "world")
public class WorldModel implements Serializable {
    private String name;
    private Integer rows;
    private Integer cols;
    private ConfigWorld config;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "board")
    private ArrayList<BoardModel> board;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "boxes")
    private ArrayList<Box> boxes;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "targets")
    private ArrayList<Target> targets;
    private Player player;
    /*objeto de esta clase*/

    public WorldModel(String name, Integer rows, Integer cols, ConfigWorld config, ArrayList<Board> board, ArrayList<Box> boxes, ArrayList<Target> target, Player player) {
        this.name = name;
        this.rows = rows;
        this.cols = cols;
        this.config = config;
        this.board = newBoardModel(board);
        this.boxes = boxes;
        this.targets = target;
        this.player = player;
    }

    public ArrayList<BoardModel> newBoardModel(ArrayList<Board> arrayBoard) {
        ArrayList<BoardModel> modelArray= new ArrayList<>();
        for (int i = 0; i < arrayBoard.size(); i++) {
            modelArray.add(new BoardModel(arrayBoard.get(i).getPosX(),arrayBoard.get(i).getPosY(),arrayBoard.get(i).getType()));
        }
        return modelArray;
    }

    public WorldModel() {
        board= new ArrayList<BoardModel>();
        boxes= new ArrayList<Box>();
        targets= new ArrayList<Target>();
    }

    public String getName() {
        return name;
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getCols() {
        return cols;
    }

    public ConfigWorld getConfig() {
        return config;
    }

    public ArrayList<BoardModel> getBoard() {
        return board;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public ArrayList<Target> getTargets() {
        return targets;
    }

    public Player getPlayer() {
        return player;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    public void setConfig(ConfigWorld config) {
        this.config = config;
    }

    public void setBoard(ArrayList<BoardModel> board) {
        this.board = board;
    }

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }

    public void setTargets(ArrayList<Target> targets) {
        this.targets = targets;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
