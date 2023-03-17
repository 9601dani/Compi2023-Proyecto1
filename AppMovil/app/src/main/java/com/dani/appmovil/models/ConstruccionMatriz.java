package com.dani.appmovil.models;

import com.dani.appmovil.objectsWorld.Board;
import com.dani.appmovil.objectsWorld.World;

import java.util.ArrayList;

public class ConstruccionMatriz {
    public static ArrayList<OperacionesMovReport> reportOperaciones = new ArrayList<>();
    public static ArrayList<ReportMov> reporMov= new ArrayList<>();
    public static int CANTIDAD_LEFT=0;
    public static int CANTIDAD_DOWN=0;
    public static int CANTIDAD_UP=0;
    public static int CANTIDAD_RIGHT=0;
    public static ArrayList<ErrorMovClient> erroForClient= new ArrayList<>();
    public BoardModel[][] hacerMatriz(World world){
        BoardModel [][] boards= new BoardModel[world.getRows()][world.getCols()];
        world.getArrayBoard().forEach(board -> {
            Point point= new Point(board.getPosX(),board.getPosY());
            boards[board.getPosX()][board.getPosY()]= new BoardModel(point,board);
        });
        world.getArrayBoxes().forEach(box -> {
            boards[box.getPosX()][box.getPosY()].setEsBox(true);
        });
        world.getArrayTarget().forEach(target -> {
            boards[target.getPosX()][target.getPosY()].setEsTarget(true);
        });
        boards[world.getPlayer().getPosX()][world.getPlayer().getPosY()].setEsPlayer(true);
        return boards;
    }
}
