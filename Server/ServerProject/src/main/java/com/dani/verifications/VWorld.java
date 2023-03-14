package com.dani.verifications;

import com.dani.objects.*;

import java.util.ArrayList;

public class VWorld {

    public boolean verificarWorldNo(World arrayWorld){
        boolean ts=false;
        ts=verificarNoNull(arrayWorld);/**/
        if(ts==true){
            return ts;
        }
        ts=verificarNoRepetidoOnBoxes(arrayWorld.getArrayBoxes());
        if(ts==true){
            return ts;
        }
        ts= verificarNoRepetidoOnTarget(arrayWorld.getArrayTarget());
        if(ts==true){
            return ts;
        }
        if(ts==true){
            System.out.println("ts1");
            return true;
        }else{
            ts=verificarPosBoxOnBoard(arrayWorld.getArrayBoard(),arrayWorld.getArrayBoxes());
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
        }else{
            for(int i =0;i<arrayWorld.getArrayBoard().size();i++){
                if(arrayWorld.getArrayBoard().get(i).getPosX()!=null){}else{
                    return true;
                }
                if(arrayWorld.getArrayBoard().get(i).getPosY()!=null){}else{
                    return true;
                }
                if(arrayWorld.getArrayBoard().get(i).getType()!=null){}else{
                    return true;
                }
            }
            for(int i =0;i<arrayWorld.getArrayBoxes().size();i++){
                if(arrayWorld.getArrayBoxes().get(i).getPosX()!=null){}else{
                    return true;
                }
                if(arrayWorld.getArrayBoxes().get(i).getPosY()!=null){}else{
                    return true;
                }
            }
            for(int i =0;i<arrayWorld.getArrayTarget().size();i++){
                if(arrayWorld.getArrayTarget().get(i).getPosX()!=null){}else{
                    return true;
                }
                if(arrayWorld.getArrayTarget().get(i).getPosY()!=null){}else{
                    return true;
                }
            }

        }
        return false;
    }
    public boolean verificarPosBoxOnBoard(ArrayList<Board> arrayBoard,ArrayList<Box> arrayBox){
        System.out.println("psoBox");
        boolean tt=true;
        for(int i=0;i<arrayBox.size();i++){
            for(int j=0;j<arrayBoard.size();j++){
                if(arrayBoard.get(j).getPosX()==arrayBox.get(i).getPosX() && arrayBoard.get(j).getPosY()==arrayBox.get(i).getPosY() ){
                    System.out.println("error "+  i + " box "+j);
                    tt=false;
                    break;
                }
            }
        }

        if(tt==false){
            tt=  verificarNoRepetidoOnBoard(arrayBoard);
            return tt;
        }else{
            return true;
        }

    }
    public boolean verificarPosTarget(ArrayList<Board> arrayBoard,ArrayList<Target> arrayTarget){
        boolean tt=false;
        for(int i=0;i<arrayTarget.size();i++){
            for(int j=0;j<arrayBoard.size();j++){
                if(arrayBoard.get(j).getPosX()==arrayTarget.get(i).getPosX() && arrayBoard.get(j).getPosY()==arrayTarget.get(i).getPosY() ){
                    System.out.println("error "+  i + " target "+j);
                    tt=true;
                    break;
                }
            }
        }
        /*tt=verificarNoRepetido(arrayBoard);*/
        if(tt==true){
            return false;
        }else{
            return true;
        }
    }
    public boolean verificarNoRepetidoOnBoxes(ArrayList<Box> arraybox){
        System.out.println("noRpetido");
        for(int i=0; i<arraybox.size();i++){
            for (int j=0;j<arraybox.size();j++){
                if(i==j){
                    System.out.println("son iguales");
                }else{
                    if(arraybox.get(i).getPosX()== arraybox.get(j).getPosX() && arraybox.get(i).getPosY()== arraybox.get(j).getPosY()){
                        System.out.println("error "+  i + " boxes "+j);
                        System.out.println(arraybox.get(i).toString()+ " -- "+arraybox.get(i).toString());
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean verificarNoRepetidoOnBoard(ArrayList<Board> arrayboard){
        System.out.println("noRpetido");
            for(int i=0; i<arrayboard.size();i++){
                for (int j=0;j<arrayboard.size();j++){
                    if(i==j){
                        System.out.println("son iguales");
                    }else{
                        if(arrayboard.get(i).getPosX()== arrayboard.get(j).getPosX() && arrayboard.get(i).getPosY()== arrayboard.get(j).getPosY()){
                            System.out.println("error "+  i + " board "+j);
                            System.out.println(arrayboard.get(i).toString()+ " -- "+arrayboard.get(i).toString());
                            return true;
                        }
                    }
                }
            }
            return false;
    }
    public boolean verificarNoRepetidoOnTarget(ArrayList<Target> arrayTarget){
        System.out.println("noRpetido");
        for(int i=0; i<arrayTarget.size();i++){
            for (int j=0;j<arrayTarget.size();j++){
                if(i==j){
                    System.out.println("son iguales");
                }else{
                    if(arrayTarget.get(i).getPosX()== arrayTarget.get(j).getPosX() && arrayTarget.get(i).getPosY()== arrayTarget.get(j).getPosY()){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void configDefecto(ConfigWorld config){
        if(config.getBox_color()!=null){}else{
            config.setBox_color("ffff00");
        }
        if(config.getBox_on_target_color()!=null){}else{
            config.setBox_on_target_color("fe0002");
        }
        if( config.getTarget_color()!=null){}else{
            config.setTarget_color("d6fe0a");
        }
        if(config.getBrick_color()!=null){}else{
            config.setBrick_color("bdbebf");
        }
        if(config.getHall_color()!=null){}else{
            config.setHall_color("0001ff");
        }
        if(config.getUndefined_color()!=null){}else{
            config.setUndefined_color("303030");
        }
        if(config.getPlayer_color()!=null){}else{
            config.setPlayer_color("ff00f7");
        }
    }

}
