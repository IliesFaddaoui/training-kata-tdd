package com.ilies.trainingkatatdd.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TennisGameTest {

    private static final String ROGER = "Roger";
    private static final String RAFFY = "Raffy";

    private TennisGame tennisGame;

    @BeforeEach
    void initGame() {
        tennisGame = new TennisGame(ROGER, RAFFY);
    }

    @Test
    void shouldReturnAllLoveAScore() {

        assertEquals("Love all", tennisGame.getScore());
    }

    @Test
    void shouldReturnFifteenLove_playerOneScore() {
        tennisGame.scorePoint(ROGER);
        assertEquals("Fifteen love", tennisGame.getScore());
    }

    @Test
    void shouldReturnLoveFifteen_playerTwoScore() {
        tennisGame.scorePoint(RAFFY);
        assertEquals("Love fifteen", tennisGame.getScore());
    }

    @Test
    void shouldReturnFifteenAll_bothPlayersScoreOnce() {
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(ROGER);
        assertEquals("Fifteen all", tennisGame.getScore());
    }

    @Test
    void shouldReturnThirtyLove_playerOneScoreTwice() {
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        assertEquals("Thirty love", tennisGame.getScore());
    }

    @Test
    void shouldReturnLoveThirty_playerTwoScoreTwice() {
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(RAFFY);
        assertEquals("Love thirty", tennisGame.getScore());
    }

    @Test
    void shouldReturnFortyLove_playerOneScoreThreeTime() {
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        assertEquals("Forty love", tennisGame.getScore());
    }

    @Test
    void shouldReturnThirtyFifteen() {
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(RAFFY);
        assertEquals("Thirty fifteen", tennisGame.getScore());
    }

    @Test
    void shouldReturnFifteenThirty() {
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(RAFFY);
        assertEquals("Fifteen thirty", tennisGame.getScore());
    }

    @Test
    void shouldReturnThirtyAll() {
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(RAFFY);
        assertEquals("Thirty all", tennisGame.getScore());
    }

    @Test
    void shouldReturnFortyLove() {
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        assertEquals("Forty love", tennisGame.getScore());
    }

    @Test
    void shouldReturnLoveForty() {
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(RAFFY);
        assertEquals("Love forty", tennisGame.getScore());
    }

    @Test
    void shouldReturnFortyFifteen() {
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        assertEquals("Forty fifteen", tennisGame.getScore());
    }

    @Test
    void shouldReturnAdvantageRoger() {
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        assertEquals("Advantage Roger", tennisGame.getScore());
    }

    @Test
    void shouldReturnAdvantageRaffy() {
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(RAFFY);
        assertEquals("Advantage Raffy", tennisGame.getScore());
    }

    @Test
    void shouldRogerWinTheGame() {
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        assertEquals("Roger win the game !", tennisGame.getScore());
    }

    @Test
    void shouldRaffyWinTheGame() {
        tennisGame.scorePoint(RAFFY);
        //0-15
        tennisGame.scorePoint(RAFFY);
        //0-30
        tennisGame.scorePoint(RAFFY);
        //O-40
        tennisGame.scorePoint(ROGER);
        //15-40
        tennisGame.scorePoint(ROGER);
        //30-40
        tennisGame.scorePoint(ROGER);
        //40-40
        tennisGame.scorePoint(ROGER);
        //AD-40
        tennisGame.scorePoint(RAFFY);
        //40-40
        tennisGame.scorePoint(RAFFY);
        //40-AD
        tennisGame.scorePoint(RAFFY);
        //Game raffy
        assertEquals("Raffy win the game !", tennisGame.getScore());
    }

    @Test
    void shouldRogerWinPerfectGam() {
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        tennisGame.scorePoint(ROGER);
        assertEquals("Roger win the game !", tennisGame.getScore());
    }

    @Test
    void shouldRaffyWinPerfectGam() {
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(RAFFY);
        tennisGame.scorePoint(RAFFY);
        assertEquals("Raffy win the game !", tennisGame.getScore());
    }

}