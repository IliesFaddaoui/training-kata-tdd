package com.ilies.trainingkatatdd.gameoflife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class GameOfLifeTest {
    @Test
    void grid_composed_by_only_dead_cells_should_not_change_at_next_generation() {
        Cell[][] cells = {
                {Cell.dead(), Cell.dead(), Cell.dead()},
                {Cell.dead(), Cell.dead(), Cell.dead()},
                {Cell.dead(), Cell.dead(), Cell.dead()},
        };
        var initGrid = new GameOfLife(cells);

        GameOfLife gridAtNextGeneration = initGrid.nextGeneration();

        assertThat(gridAtNextGeneration.cellAt(0, 0)).isEqualTo(Cell.dead());
    }

    @Test
    void rule_1_underpopulation_cell_with_fewer_than_two_alive_neighbors_dies() {
        Cell[][] cells = {
                {Cell.alive(), Cell.dead(), Cell.dead()},
                {Cell.dead(), Cell.dead(), Cell.dead()},
                {Cell.dead(), Cell.dead(), Cell.dead()},
        };
        var initGrid = new GameOfLife(cells);

        GameOfLife gridAtNextGeneration = initGrid.nextGeneration();

        assertThat(gridAtNextGeneration.cellAt(0, 0)).isEqualTo(Cell.dead());
    }

    @Test
    void rule_2_overcrowding_cell_with_more_than_3_alive_neighbors_dies() {
        Cell[][] cells = {
                {Cell.alive(), Cell.alive(), Cell.dead()},
                {Cell.alive(), Cell.alive(), Cell.dead()},
                {Cell.dead(), Cell.dead(), Cell.alive()},
        };
        var initGrid = new GameOfLife(cells);

        GameOfLife gridAtNextGeneration = initGrid.nextGeneration();

        assertThat(gridAtNextGeneration.cellAt(1, 1)).isEqualTo(Cell.dead());
    }

    @Test
    void rule_3_alive_cell_with_2_or_3_alive_neighbors_lives() {
        Cell[][] cells = {
                {Cell.alive(), Cell.alive(), Cell.dead()},
                {Cell.alive(), Cell.alive(), Cell.alive()},
                {Cell.dead(), Cell.dead(), Cell.dead()},
        };
        var initGrid = new GameOfLife(cells);

        GameOfLife gridAtNextGeneration = initGrid.nextGeneration();

        //alive cell with 3 alive neighbors
        assertThat(gridAtNextGeneration.cellAt(0, 0)).isEqualTo(Cell.alive());
        //alive cell with 2 alive neighbors
        assertThat(gridAtNextGeneration.cellAt(1, 2)).isEqualTo(Cell.alive());
    }

    @Test
    void rule_4_dead_cell_with__3_alive_neighbors_relives() {
        Cell[][] cells = {
                {Cell.dead(), Cell.alive(), Cell.dead()},
                {Cell.dead(), Cell.alive(), Cell.alive()},
                {Cell.dead(), Cell.dead(), Cell.dead()},
        };
        var initGrid = new GameOfLife(cells);

        GameOfLife gridAtNextGeneration = initGrid.nextGeneration();

        assertThat(gridAtNextGeneration.cellAt(0, 2)).isEqualTo(Cell.alive());
    }

    @Nested
    @DisplayName("How many alive neighbors")
    class countAliveNeighbors {
        private GameOfLife grid;

        @BeforeEach
        void setup() {
            this.grid = new GameOfLife(new Cell[][]{
                    {Cell.alive(), Cell.alive(), Cell.alive()},
                    {Cell.alive(), Cell.alive(), Cell.alive()},
                    {Cell.alive(), Cell.alive(), Cell.alive()},
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
        void forCellAtTopRight(String displayName, int row, int col, int expectedAliveNeighbors) {

            var aliveNeighbors = grid.countAliveNeighbors(row, col);

            assertThat(aliveNeighbors).isEqualTo(expectedAliveNeighbors);
        }
    }
}