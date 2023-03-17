package com.dani.appmovil.models;

import com.dani.appmovil.objectsWorld.Board;
import com.dani.appmovil.objectsWorld.World;

public class ConstruccionMatriz {
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
