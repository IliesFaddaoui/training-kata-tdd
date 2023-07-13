package com.ilies.trainingkatatdd.bowling;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class BowlingGame {

    private static final int MAX_SCORE = 10;
    private static final int MAX_ROUNDS = 10;
    private final List<RollPair> rollHistory = new ArrayList<>();

    public void rollABall(int firstRoll, int secondRoll) {
        checkIfGameIsOver();
        checkIfRoundScoreIsLegit(firstRoll, secondRoll);
        updateEventualPreviousStrike(firstRoll, secondRoll);
        updateEventualPreviousSpare(firstRoll);

        rollHistory.add(new RollPair(firstRoll + secondRoll, firstRoll, secondRoll));
    }

    public int getScore() {
        return rollHistory.stream().limit(10).mapToInt(RollPair::score).sum();
    }

    private void updateEventualPreviousStrike(int firstRoll, int secondRoll) {
        if (isEnoughThrowsToCalculateStrikeResult()) {
            //nb : penultimate means before the last in english :-)
            RollPair penultimateRollPair = rollHistory.get(rollHistory.size() - 2);
            int penultimateScoreUpdated = penultimateRollPair.score();
            if (penultimateRollPair.isStrike()) {
                if (getLastRollPair().firstRoll == 10) {
                    penultimateScoreUpdated += firstRoll + MAX_SCORE;
                } else {
                    penultimateScoreUpdated += firstRoll + secondRoll + getLastRollPair().score;
                }
                rollHistory.set(rollHistory.size() - 2, new RollPair(penultimateScoreUpdated, penultimateRollPair.firstRoll(), penultimateRollPair.secondRoll()));
            }
        }
    }

    private void updateEventualPreviousSpare(int firstRoll) {
        if (!rollHistory.isEmpty()) {
            int lastupdatedScore = getLastRollPair().score();
            if (getLastRollPair().isSpare()) {
                lastupdatedScore += firstRoll;
                int previousRound = rollHistory.size() -1;
                rollHistory.set(previousRound, new RollPair(lastupdatedScore, getLastRollPair().firstRoll(), getLastRollPair().secondRoll()));
            }
        }
    }

    private void checkIfGameIsOver() {
        if (rollHistory.size() >= MAX_ROUNDS) {
            if (!isLastRollAStrikeOrASpare() || rollHistory.size() == MAX_ROUNDS + 2 || isTenthAStrikeWhenEleventhRoll()) {
                throw new IllegalStateException("La partie est déjà terminée. Vous ne pouvez pas enregistrer de nouveau résultat.");
            }
        }
    }

    private boolean isTenthAStrikeWhenEleventhRoll() {
        return rollHistory.size() == MAX_ROUNDS + 1 && !rollHistory.get(MAX_ROUNDS).isStrike();
    }

    private boolean isEnoughThrowsToCalculateStrikeResult() {
        return !rollHistory.isEmpty() && rollHistory.size() >= 2;
    }
    private boolean isLastRollAStrikeOrASpare() {
        return getLastRollPair().isStrike() || !(getLastRollPair().score() < MAX_SCORE);
    }

    private RollPair getLastRollPair() {
        return rollHistory.get(rollHistory.size() - 1);
    }

    private void checkIfRoundScoreIsLegit(int firstRoll, int secondRoll) {
        if (firstRoll + secondRoll > 10) {
            throw new IllegalStateException("Impossible de marquer plus de 10 points sur un tour.");
        }
    }

    private record RollPair(int score, int firstRoll, int secondRoll) {

        public boolean isStrike() {
            return firstRoll == MAX_SCORE;
        }

        public boolean isSpare() {
            return !isStrike() && score == MAX_SCORE;
        }
    }
}
