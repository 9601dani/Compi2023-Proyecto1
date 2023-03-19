package com.dani.verifications;

import com.dani.models.ErrorModel;
import com.dani.models.ErrorType;
import com.dani.objects.*;
import com.dani.parserJson.ParserJsonSym;

import java.util.ArrayList;

import static com.dani.Main.erroForClient;

public class VWorld {

    public boolean verificarWorldNo(World arrayWorld){
        boolean ts=false;
        ts=verificarNoBrick(arrayWorld.getArrayBoard(),arrayWorld.getArrayBoxes(),arrayWorld.getArrayTarget());
        if(ts){return ts;}
        ts= verificarDentroDeArray(arrayWorld);
        if(ts){return ts;}
        ts=verificarNoNull(arrayWorld);/**/
        if(ts){return ts;}
        ts=verificarNoRepetidoOnBoxes(arrayWorld.getArrayBoxes());
        if(ts){return ts;}
        ts= verificarNoRepetidoOnTarget(arrayWorld.getArrayTarget());
        if(ts){return ts;}
        if(ts){return true;}else{
            ts=verificarPosBoxOnBoard(arrayWorld.getArrayBoard(),arrayWorld.getArrayBoxes());
            if(ts){
                return ts;
            }else{
                ts=verificarPosTarget(arrayWorld.getArrayBoard(),arrayWorld.getArrayTarget());
                if(ts){
                    return ts;
                }
            }
        }
        return ts;
    }
    public boolean verificarNoBrick(ArrayList<Board> board, ArrayList<Box> arrayBox, ArrayList<Target> arratTarget){
        for(int i=0; i<arrayBox.size();i++){

            for(int j=0;j<board.size();j++){
                if(board.get(j).getPosX()== arrayBox.get(i).getPosX() && board.get(j).getPosY()== arrayBox.get(i).getPosY()){
                    if(board.get(j).getType().equals(ParserJsonSym.BRICK)){
                        erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"no_se_puede_definir_una_caja_en_ya_que_hay_ladrillo"));
                        return true;
                    }
                }
            }
        }
        for(int i=0; i<arratTarget.size();i++){

            for(int j=0;j<board.size();j++){
                if(board.get(j).getPosX()== arratTarget.get(i).getPosX() && board.get(j).getPosY()== arratTarget.get(i).getPosY()){
                    if(board.get(j).getType().equals(ParserJsonSym.BRICK)){
                        erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"no_se_puede_definir_un_target_en_ya_que_hay_ladrillo"));
                        return true;
                    }
                }
            }

        }
        return false;
    }
    public void verificarTypeNull(ArrayList<Board> type){
        for(int i=0;i<type.size();i++){
            if(type.get(i).getType().equals(null)){
                type.get(i).setType(3);
            }
        }
    }
    public boolean verificarNoNull(World arrayWorld){
        if(arrayWorld.getArrayTarget().size()!=arrayWorld.getArrayBoard().size()){
            erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"numero_de_targets_no_es_igual_a_boxes"));
            return true;
        }
        if(arrayWorld.getName()=="" || arrayWorld.getName()==null){
            erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"nombre_del_mundo_no_definido"));
            return true;
        }else if(arrayWorld.getCols()==null || arrayWorld.getRows()==null){
            erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"El_numero_de_columnas_o_filas_no_definido"));
            return true;
        }else{
            for(int i =0;i<arrayWorld.getArrayBoard().size();i++){
                if(arrayWorld.getArrayBoard().get(i).getPosX()!=null){}else{
                    erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"BOARD_NO_DEFINIDO_POS_X"));
                    return true;
                }
                if(arrayWorld.getArrayBoard().get(i).getPosY()!=null){}else{
                    erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"BOARD_NO_DEFINIDO_POS_Y"));
                    return true;
                }
                if(arrayWorld.getArrayBoard().get(i).getType()!=null){}else{
                    erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"TYPE_BOARD_NO_DEFINIDO"));
                    return true;
                }
            }
            for(int i =0;i<arrayWorld.getArrayBoxes().size();i++){
                if(arrayWorld.getArrayBoxes().get(i).getPosX()!=null){}else{
                    erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"BOXES_NO_DEFINIDO_POS_X"));
                    return true;
                }
                if(arrayWorld.getArrayBoxes().get(i).getPosY()!=null){}else{
                    erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"BOXES_NO_DEFINIDO_POS_Y"));
                    return true;
                }
            }
            for(int i =0;i<arrayWorld.getArrayTarget().size();i++){
                if(arrayWorld.getArrayTarget().get(i).getPosX()!=null){}else{
                    erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"TARGET_NO_DEFINIDO_POS_X"));
                    return true;
                }
                if(arrayWorld.getArrayTarget().get(i).getPosY()!=null){}else{
                    erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"TARGET_NO_DEFINIDO_POS_X"));
                    return true;
                }
            }

        }
        return false;
    }
    public boolean verificarPosBoxOnBoard(ArrayList<Board> arrayBoard,ArrayList<Box> arrayBox){
        boolean tt=true;
        for(int i=0;i<arrayBox.size();i++){
            for(int j=0;j<arrayBoard.size();j++){
                if(arrayBoard.get(j).getPosX()==arrayBox.get(i).getPosX() && arrayBoard.get(j).getPosY()==arrayBox.get(i).getPosY() ){
                    tt=false;
                    break;
                }
            }
        }

        if(tt==false){
            tt=  verificarNoRepetidoOnBoard(arrayBoard);
            return tt;
        }else{
            erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"El_BOX_no_esta_definida_en_BOARD"));
            return true;
        }

    }
    public boolean verificarPosTarget(ArrayList<Board> arrayBoard,ArrayList<Target> arrayTarget){
        boolean tt=false;
        for(int i=0;i<arrayTarget.size();i++){
            for(int j=0;j<arrayBoard.size();j++){
                if(arrayBoard.get(j).getPosX()==arrayTarget.get(i).getPosX() && arrayBoard.get(j).getPosY()==arrayTarget.get(i).getPosY() ){
                    tt=true;
                    break;
                }
            }
        }
        /*tt=verificarNoRepetido(arrayBoard);*/
        if(tt==true){
            return false;
        }else{
            erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"El_TARGET_no_esta_definida_en_BOARD"));
            return true;
        }
    }
    public boolean verificarNoRepetidoOnBoxes(ArrayList<Box> arraybox){
        System.out.println("noRpetido");
        for(int i=0; i<arraybox.size();i++){
            for (int j=0;j<arraybox.size();j++){
                if(i==j){
                }else{
                    if(arraybox.get(i).getPosX()== arraybox.get(j).getPosX() && arraybox.get(i).getPosY()== arraybox.get(j).getPosY()){
                        erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"La_posicion_"+arraybox.get(i).getPosY()+"_"+arraybox.get(i).getPosX()+"_de_BOXES_ya_se_definio_anteriormente"));
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
                    }else{
                        if(arrayboard.get(i).getPosX()== arrayboard.get(j).getPosX() && arrayboard.get(i).getPosY()== arrayboard.get(j).getPosY()){
                            erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"La_posicion_"+arrayboard.get(i).getPosY()+"_"+arrayboard.get(i).getPosX()+"_de_BOARD_ya_se_definio_anteriormente"));
                            return true;
                        }
                    }
                }
            }
            return false;
    }
    public boolean verificarNoRepetidoOnTarget(ArrayList<Target> arrayTarget){
        for(int i=0; i<arrayTarget.size();i++){
            for (int j=0;j<arrayTarget.size();j++){
                if(i==j){
                }else{
                    if(arrayTarget.get(i).getPosX()== arrayTarget.get(j).getPosX() && arrayTarget.get(i).getPosY()== arrayTarget.get(j).getPosY()){
                        erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"La_posicion_"+arrayTarget.get(i).getPosY()+"_"+arrayTarget.get(i).getPosX()+"_de_TARGET_ya_se_definio_anteriormente"));
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

    public static Boolean verificarDentroDeArray(World world){
        for (int i=0; i<world.getArrayBoard().size();i++){
            if(world.getArrayBoard().get(i).getPosX()>= world.getRows() || world.getArrayBoard().get(i).getPosY()>= world.getCols()){
                erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"La_posicion_"+world.getArrayBoard().get(i).getPosY()+"_"+world.getArrayBoard().get(i).getPosX()+"_en_BOARD_no_esta_definida"));
                return true;
            }
        }
        for (int i=0;i<world.getArrayBoxes().size();i++){
            if(world.getArrayBoxes().get(i).getPosX()>= world.getRows() || world.getArrayBoxes().get(i).getPosY()>= world.getCols()){
                erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"La_posicion_"+world.getArrayBoxes().get(i).getPosY()+"_"+world.getArrayBoxes().get(i).getPosX()+"_en_BOXES_no_esta_definida"));
                return true;
            }
        }
        for (int i=0;i<world.getArrayTarget().size();i++){
            if(world.getArrayTarget().get(i).getPosX()>= world.getRows() || world.getArrayTarget().get(i).getPosY()>= world.getCols()){
                erroForClient.add(new ErrorModel("WORLD",0,0, ErrorType.OTHER,"La_posicion_"+world.getArrayTarget().get(i).getPosY()+"_"+world.getArrayTarget().get(i).getPosX()+"_en_TARGET_no_esta_definida"));
                return true;
            }
        }
        return false;
    }

}
