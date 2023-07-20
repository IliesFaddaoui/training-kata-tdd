package com.ilies.trainingkatatdd.tennis;

import lombok.Getter;

@Getter
public class TennisGame {

    private static final int FORTY_POINT_SCORE = 3;
    private static final int ADVANTAGE_POINT_SCORE = 4;
    private static final String LOVE = "Love " ;
    private static final String FIFTEEN = "Fifteen " ;
    private static final String THIRTY = "Thirty " ;
    private static final String FORTY = "Forty " ;
    private static final String ADVANTAGE = "Advantage " ;
    private static final String ALL = "all" ;
    public static final String WIN_THE_GAME = " win the game !" ;

    private String score;
    private int player1Score;
    private int player2Score;
    private boolean isGameOver;

    private final GameInformation gameInformation;


    public TennisGame(String firstPlayerName, String secondPlayerName) {
        gameInformation = new GameInformation(firstPlayerName, secondPlayerName);
        this.score = "Love all" ;
        this.player1Score = 0;
        this.player2Score = 0;
        this.isGameOver = false;
    }

    public void scorePoint(String playerName) {
        if (gameInformation.isFirstPlayer(playerName)) {
            scorePointForPlayer1();
        } else {
            scorePointForPlayer2();
        }
        updateScoreValue();
    }

    private void scorePointForPlayer1() {
        if (player1Score < FORTY_POINT_SCORE) {
            player1Score++;
        } else if (player1Score == FORTY_POINT_SCORE) {
            handlePlayer1FortyPointScore();
        } else if (player1Score == ADVANTAGE_POINT_SCORE) {
            isGameOver = true;
        }
    }

    private void scorePointForPlayer2() {
        if (player2Score < FORTY_POINT_SCORE) {
            player2Score++;
        } else if (player2Score == FORTY_POINT_SCORE) {
            handlePlayer2FortyPointScore();
        } else if (player2Score == ADVANTAGE_POINT_SCORE) {
            isGameOver = true;
        }
    }

    private void handlePlayer1FortyPointScore() {
        if (player2Score < FORTY_POINT_SCORE) {
            isGameOver = true;
        } else if (player2Score == FORTY_POINT_SCORE) {
            player1Score++;
        } else if (player2Score == ADVANTAGE_POINT_SCORE) {
            player2Score--;
        }
    }

    private void handlePlayer2FortyPointScore() {
        if (player1Score < FORTY_POINT_SCORE) {
            isGameOver = true;
        } else if (player1Score == FORTY_POINT_SCORE) {
            player2Score++;
        } else if (player1Score == ADVANTAGE_POINT_SCORE) {
            player1Score--;
        }
    }


    private void updateScoreValue() {
        if (!isGameOver) {
            score = textualScoreRegardingPlayerOnePoints() +
                    textualScoreToAddRegardingPlayerTwoPoints();
        } else if (player1Score > player2Score) {
            score = gameInformation.firstPlayerName + WIN_THE_GAME;
        } else {
            score = gameInformation.secondPlayerName + WIN_THE_GAME;
        }
    }

    private String textualScoreToAddRegardingPlayerTwoPoints() {
        if (player1Score != ADVANTAGE_POINT_SCORE) {
            if (player1Score == player2Score) {
                return ALL;
            } else {
                switch (player2Score) {
                    case 0 -> {
                        return LOVE.toLowerCase().trim();
                    }
                    case 1 -> {
                        return FIFTEEN.toLowerCase().trim();
                    }
                    case 2 -> {
                        return THIRTY.toLowerCase().trim();
                    }
                    case 3 -> {
                        return FORTY.toLowerCase().trim();
                    }
                    case 4 -> {
                        return ADVANTAGE + gameInformation.secondPlayerName;
                    }
                }
            }
        }
        return "" ;
    }

    private String textualScoreRegardingPlayerOnePoints() {
        if (player2Score != ADVANTAGE_POINT_SCORE) {
            switch (player1Score) {
                case 0 -> {
                    return LOVE;
                }
                case 1 -> {
                    return FIFTEEN;
                }
                case 2 -> {
                    return THIRTY;
                }
                case 3 -> {
                    return FORTY;
                }
                case 4 -> {
                    return ADVANTAGE + gameInformation.firstPlayerName;
                }
            }
        }
        return "" ;
    }

    private record GameInformation(String firstPlayerName, String secondPlayerName) {
        private boolean isFirstPlayer(String playerName) {
            return firstPlayerName.equals(playerName);
        }
    }
}
