package com.ilies.trainingkatatdd.gameoflife;

import java.util.Arrays;

public record GameOfLife(Cell[][] grid) {

    public GameOfLife nextGeneration() {
        int gridSize = grid().length;
        Cell[][] nextGeneration = new Cell[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                int aliveNeighbors = countAliveNeighbors(i, j);
                if (aliveNeighbors < 2)
                    nextGeneration[i][j] = Cell.dead();
                else if (aliveNeighbors > 3)
                    nextGeneration[i][j] = Cell.dead();
                else if (aliveNeighbors == 3) {
                    nextGeneration[i][j] = Cell.alive();
                } else
                    nextGeneration[i][j] = grid[i][j];
            }
        }
        return new GameOfLife(nextGeneration);
    }

    public int countAliveNeighbors(int row, int col) {
        var size = grid.length - 1;
        var possibleNeighborsLocations = possibleNeighbors(row, col);

        return Arrays.stream(possibleNeighborsLocations)
                .reduce(0, (aliveCells, neighbor) -> {
                    var neighborRow = neighbor[0];
                    var neighborCol = neighbor[1];
                    var neighborIsInGrid = 0 <= neighborRow && neighborRow <= size && 0 <= neighborCol && neighborCol <= size;
                    return neighborIsInGrid && grid[neighborRow][neighborCol].status()
                            ? Integer.valueOf(aliveCells + 1) : aliveCells;
                }, (acc, acc2) -> acc);
    }

    private static int[][] possibleNeighbors(int row, int col) {
        int previousRow = row - 1;
        int previousCol = col - 1;
        int nextCol = col + 1;
        int nextRow = row + 1;
        return new int[][]{
                {previousRow, previousCol},
                {previousRow, col},
                {previousRow, nextCol},
                {row, previousCol},
                {row, nextCol},
                {nextRow, previousCol},
                {nextRow, col},
                {nextRow, nextCol},
        };
    }

    public Cell cellAt(int i, int j) {
        return grid[i][j];
    }

}
