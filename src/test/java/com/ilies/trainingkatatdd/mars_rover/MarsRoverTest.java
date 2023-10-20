package com.ilies.trainingkatatdd.mars_rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MarsRoverTest {
    private MarsRover marsRover;
    @BeforeEach
    public void init() {
        marsRover = new MarsRover(new Position(0,0), Direction.N);
    }
    @Test
    public void shouldReceiveInitialPosition() {

        assertEquals(0, marsRover.getX());
        assertEquals(0, marsRover.getY());
        assertEquals(Direction.N, marsRover.getDirection());
    }

    @Test
    public void shouldIncreaseYPositionOne_whenFacingNorthAndMoveForward() {
        marsRover.move("F");
        assertEquals(0,marsRover.getX());
        assertEquals(1,marsRover.getY());
        assertEquals(Direction.N,marsRover.getDirection());
    }

    @Test
    public void shouldDecreaseYPositionByOne_whenFacingNorthAndMoveBackward() {
        marsRover.move("B");
        assertEquals(0,marsRover.getX());
        assertEquals(-1,marsRover.getY());
        assertEquals(Direction.N,marsRover.getDirection());
    }

    @Test
    public void shouldFaceEast_whenFacingNorthAndMoveRightFourTime() {
        marsRover.move("RRRR");
        assertEquals(0,marsRover.getX());
        assertEquals(0,marsRover.getY());
        assertEquals(Direction.N,marsRover.getDirection());
    }

    @Test
    public void shouldFaceNorth_WhenFacingNorthAndMoveLeftFourTime() {
        marsRover.move("LLLL");
        assertEquals(0,marsRover.getX());
        assertEquals(0,marsRover.getY());
        assertEquals(Direction.N,marsRover.getDirection());
    }

    @Test
    public void shouldStayInPlace_WhenMovementsInstructionIsEmpty() {
        marsRover.move("");
        assertEquals(0,marsRover.getX());
        assertEquals(0,marsRover.getY());
        assertEquals(Direction.N, marsRover.getDirection());
    }

    @Test
    public void shouldIncreaseXPositionByOne_WhenFacingEastAndMoveForward() {
        marsRover.move("RF");
        assertEquals(1,marsRover.getX());
        assertEquals(0,marsRover.getY());
        assertEquals(Direction.E,marsRover.getDirection());
    }

    @Test
    public void shouldDecreaseYPositionByOne_WhenFacingSouthAndMoveForward() {
        marsRover.move("RRF");
        assertEquals(0,marsRover.getX());
        assertEquals(-1,marsRover.getY());
        assertEquals(Direction.S,marsRover.getDirection());
    }

    @Test
    public void shouldDecreaseXPositionByOne_WhenFacingWestAndMoveForward() {
        marsRover.move("LF");
        assertEquals(-1,marsRover.getX());
        assertEquals(0,marsRover.getY());
        assertEquals(Direction.W,marsRover.getDirection());
    }

    @Test
    public void shouldDecreaseYPositionByOne_WhenFacingNorthAndMoveBackward() {
        marsRover.move("B");
        assertEquals(0,marsRover.getX());
        assertEquals(-1,marsRover.getY());
        assertEquals(Direction.N, marsRover.getDirection());
    }

    @Test
    public void shouldDecreaseXPositionByOne_WhenFacingEAndMoveBackward() {
        marsRover.move("RB");
        assertEquals(-1,marsRover.getX());
        assertEquals(0,marsRover.getY());
        assertEquals(Direction.E, marsRover.getDirection());
    }

    @Test
    public void shouldIncreaseYPositionByOne_WhenFacingSouthAndMoveBackward() {
        marsRover.move("RRB");
        assertEquals(0,marsRover.getX());
        assertEquals(1,marsRover.getY());
        assertEquals(Direction.S,marsRover.getDirection());
    }

    @Test
    public void shouldIncreaseXPositionByOne_WhenFacingWestAndMoveBackward() {
        marsRover.move("LB");
        assertEquals(1,marsRover.getX());
        assertEquals(0,marsRover.getY());
        assertEquals(Direction.W,marsRover.getDirection());
    }

    @Test
    public void shouldRaiseExceptionIfInvalidCommandsIsSend() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> marsRover.move("KLP"));
        assertEquals("java.lang.Exception: Invalid command at step 1: K", exception.getMessage());
    }

}