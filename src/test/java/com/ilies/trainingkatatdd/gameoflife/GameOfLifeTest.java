package com.ilies.trainingkatatdd.gameoflife;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class GameOfLifeTest {
    @Test
    void grid_composed_by_only_dead_cells_should_not_change_at_next_generation(){
        Cell[][] cells = {
                {Cell.dead(),Cell.dead(),Cell.dead()},
                {Cell.dead(),Cell.dead(),Cell.dead()},
                {Cell.dead(),Cell.dead(),Cell.dead()},
        };
        var initGrid = new Grid(cells);

        Grid gridAtNextGeneration = initGrid.nextGeneration();

        assertThat(gridAtNextGeneration.cells()).isEqualTo(cells);
    }

    @Test
    void cell_with_less_than_two_alive_neighbors_dead(){
        Cell[][] cells = {
                {Cell.alive(),Cell.dead(),Cell.dead()},
                {Cell.dead(),Cell.dead(),Cell.dead()},
                {Cell.dead(),Cell.dead(),Cell.dead()},
        };
        var initGrid = new Grid(cells);

        Grid gridAtNextGeneration = initGrid.nextGeneration();

        assertThat(gridAtNextGeneration.cells()).isEqualTo(new Cell[][]{
                {Cell.dead(),Cell.dead(),Cell.dead()},
                {Cell.dead(),Cell.dead(),Cell.dead()},
                {Cell.dead(),Cell.dead(),Cell.dead()},
        });
    }


    /**
     *         i-1,j-1 | i-1,j |i-1,j+1
     *          i,j-1  |i,j    | i,j+1
     *         i+1,j-1 | i+1,j |i+1,j+1
     */

    @Nested
    @DisplayName("How many alive neighbors")
    class countAliveNeighbors{
        private Grid grid;

        @BeforeEach
        void setup(){
            this.grid = new Grid(new Cell[][]{
                    {Cell.alive(),Cell.alive(),Cell.alive()},
                    {Cell.alive(),Cell.alive(),Cell.alive()},
                    {Cell.alive(),Cell.alive(),Cell.alive()},
            });
        }

        @ParameterizedTest(name = "cell at {0} ({1}:{2}) there is {3} alive neighbors)")
        @CsvSource(value = {
                "top left,0,0,3",
                "top middle,0,1,5",
                "top right,0,2,3",
                "middle left,1,0,5",
                "middle middle,1,1,8",
                "middle right,1,2,5",
                "bottom left,0,2,3",
                "bottom middle,1,2,5",
                "bottom right,2,2,3",
        })
        void forCellAtTopRight(String displayName, int row, int col, int expectedAliveNeighbors){

            var aliveNeighbors = grid.countAliveNeighbors(row, col);

            assertThat(aliveNeighbors).isEqualTo(expectedAliveNeighbors);
        }
    }



}