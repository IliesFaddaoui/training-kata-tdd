package com.ilies.trainingkatatdd.gameoflife;



public record Cell(boolean status){

    public static  Cell alive(){
       return new Cell(true);
   }
    public static Cell dead(){
        return new Cell(false);
    }
}
