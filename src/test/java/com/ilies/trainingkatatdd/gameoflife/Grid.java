package com.ilies.trainingkatatdd.gameoflife;

import java.util.Arrays;

public record Grid (Cell[][] cells){

    public Grid nextGeneration() {
        Cell[][] nextGeneration = new Cell[cells().length][cells().length] ;
        for(int i = 0; i < cells().length; i++) {
            for(int j = 0; j < cells().length; j++) {
                int aliveNeighbors = countAliveNeighbors(i,j);
                if( aliveNeighbors <2)
                    nextGeneration[i][j] = Cell.dead();
            }
        }
        return new Grid(nextGeneration);
    }
    
    public int countAliveNeighbors(int row, int col) {
        var size = cells.length -1;

        var possibleNeighbors = new int[][]{
                {row -1,col-1},
                {row -1,col},
                {row-1,col +1},
                {row ,col -1},
                {row,col +1},
                {row +1,col -1},
                {row +1,col},
                {row +1,col +1},
        };

        return Arrays.stream(possibleNeighbors)
                .reduce( 0, (aliveCells,neighbor) ->{
                    var neigborRow = neighbor[0];
                    var neigborCol =  neighbor[1];
                    var neighborIsInGrid = 0 <= neigborRow && neigborRow <= size && 0 <= neigborCol && neigborCol <= size;
                    return neighborIsInGrid && cells[neigborRow][neigborCol].status()
                            ? Integer.valueOf(aliveCells + 1): aliveCells;
                }, (acc,acc2) -> acc);
    }
}
