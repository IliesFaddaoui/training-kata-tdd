package com.ilies.trainingkatatdd.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    private BowlingGame bowlingGame;

    @BeforeEach
    void init() {
        bowlingGame = new BowlingGame();
    }

    @Test
    void shouldReturnScore0_OneRollZeroPinsFallen() {
        bowlingGame.rollABall(0,0);
        assertEquals(0, bowlingGame.getScore());
    }

    @Test
    void shouldReturnScore2_twoRollOnePinsFallen() {
        bowlingGame.rollABall(1,1);
        assertEquals(2, bowlingGame.getScore());
    }

    @Test
    void shouldReturnScore38_twoSparesAnd8PinsFallAfter() {
        assertAll("score calculation",
                () -> rollSpare(3, 7),
                () -> rollSpare(3, 7),
                () -> bowlingGame.rollABall(8, 0),
                () -> assertEquals(39, bowlingGame.getScore())
        );
    }

    @Test
    void shouldStopPlayingAfterTenRound() {
        assertAll("score calculation",
                () -> rollSpare(2, 8),
                () -> rollSpare(2, 8),
                () -> rollSpare(2, 8),
                () -> rollSpare(2, 8),
                () -> rollSpare(2, 8),
                () -> rollSpare(2, 8),
                () -> rollSpare(2, 8),
                () -> rollSpare(2, 8),
                () -> rollSpare(2, 8),
                () -> bowlingGame.rollABall(8, 0),
                () -> assertEquals(122, bowlingGame.getScore()),
                () -> assertThrows(IllegalStateException.class,
                        () -> bowlingGame.rollABall(5,0))
        );
    }

    @Test
    void shouldIgnoreIllegalRolls() {
        assertAll("score calculation",
                () -> bowlingGame.rollABall(1,1),
                () -> assertThrows(IllegalStateException.class, () -> bowlingGame.rollABall(1,10)),
                () -> bowlingGame.rollABall(1,1),
                () -> assertEquals(4,bowlingGame.getScore())
                );
    }

    @Test
    void shouldReturnScore24_oneStrikeAnd7pinsFallAfter(){
        assertAll("score calculation",
                () -> rollSpare(10, 0),
                () -> rollSpare(2, 5),
                () -> rollSpare(0, 0),
                () -> rollSpare(0, 0),
                () -> rollSpare(0, 0),
                () -> rollSpare(0, 0),
                () -> rollSpare(0, 0),
                () -> rollSpare(0, 0),
                () -> rollSpare(0, 0),
                () -> rollSpare(0, 0),
                () -> assertEquals(24, bowlingGame.getScore())
        );
    }

    @Test
    void shouldScore267AndExceptionFor12thRoll_lastRollASpare() {
        assertAll("score calculation",
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(9, 1),
                () -> rollSpare(6, 0),
                () -> assertThrows(IllegalStateException.class, () -> bowlingGame.rollABall(1,10)),
                () -> assertEquals(281, bowlingGame.getScore())
        );
    }
    @Test
    void shouldReturnScore270_AlmostPerfectGame(){
        assertAll("score calculation",
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(0, 0),
                () -> assertEquals(270, bowlingGame.getScore())
        );
    }

    @Test
    void shouldReturnScore300_PerfectGame(){
        assertAll("score calculation",
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> rollSpare(10, 0),
                () -> assertEquals(300, bowlingGame.getScore())
        );
    }

    private void rollSpare(int firstRoll, int secondRoll) {
        bowlingGame.rollABall(firstRoll, secondRoll);
    }
}