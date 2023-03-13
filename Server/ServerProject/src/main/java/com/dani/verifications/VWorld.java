package com.dani.verifications;

import com.dani.objects.*;

import java.util.ArrayList;

public class VWorld {

    public boolean verificarWorldNo(World arrayWorld){
        boolean ts=false;
        ts=verificarNoNull(arrayWorld);
        if(ts==true){
            System.out.println("ts1");
            return true;
        }else{
            ts=verificarPosBox(arrayWorld.getArrayBoard(),arrayWorld.getArrayBoxes());
            if(ts==true){
                System.out.println("ts2");
                return ts;
            }else{
                ts=verificarPosTarget(arrayWorld.getArrayBoard(),arrayWorld.getArrayTarget());
                if(ts==true){
                    System.out.println("ts3");
                    return ts;
                }
            }
        }
        System.out.println("ts4"+ts);
        return ts;
    }
    public boolean verificarNoNull(World arrayWorld){
        if(arrayWorld.getName()=="" || arrayWorld.getName()==null){
            System.out.println("error null name");
            return true;
        }else if(arrayWorld.getCols()==null || arrayWorld.getRows()==null){
            System.out.println("error null cols | rows");
            return true;
        }
        return false;
    }
    public boolean verificarPosBox(ArrayList<Board> arrayBoard,ArrayList<Box> arrayBox){
        System.out.println("psoBox");
        boolean tt=false;
        for(int i=0;i<arrayBox.size();i++){
            for(int j=0;j<arrayBoard.size();j++){
                if(arrayBoard.get(j).getPosX()==arrayBox.get(i).getPosX() && arrayBoard.get(j).getPosY()==arrayBox.get(i).getPosY() ){
                    System.out.println("error "+  i + " box "+j);
                    tt=true;
                }
            }
        }
        tt=verificarNoRepetido(arrayBoard);
        if(tt==true){
            return true;
        }else{
            return false;
        }
    }
    public boolean verificarPosTarget(ArrayList<Board> arrayBoard,ArrayList<Target> arrayTarget){
        System.out.println("posTarget");
        boolean tt=false;
        for(int i=0;i<arrayTarget.size();i++){
            for(int j=0;j<arrayBoard.size();j++){
                if(arrayBoard.get(j).getPosX()==arrayTarget.get(i).getPosX() && arrayBoard.get(j).getPosY()==arrayTarget.get(i).getPosY() ){
                    System.out.println("error "+  i + " target "+j);
                    tt=true;
                }
            }
        }
        /*tt=verificarNoRepetido(arrayBoard);*/
        if(tt==true){
            return true;
        }else{
            return false;
        }
    }

    public boolean verificarNoRepetido(ArrayList<Board> arrayboard){
        System.out.println("noRpetido");
            for(int i=0; i<arrayboard.size();i++){
                for (int j=0;j<arrayboard.size();j++){
                    if(i==j){
                        System.out.println("son iguales");
                    }else{
                        if(arrayboard.get(i).getPosX()== arrayboard.get(j).getPosX() && arrayboard.get(i).getPosY()== arrayboard.get(j).getPosY()){
                            System.out.println("error "+  i + " board "+j);
                            return true;
                        }
                    }
                }
            }
            return false;
    }
}
