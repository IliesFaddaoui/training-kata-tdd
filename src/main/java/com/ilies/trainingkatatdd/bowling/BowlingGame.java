package com.ilies.trainingkatatdd.bowling;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class BowlingGame {

    private static final int MAX_SCORE = 10;
    private static final int MAX_ROUNDS = 10;
    private boolean isOver = false;
    private final List<RollPair> rollHistory = new ArrayList<>();

    public void rollABall(int firstRoll, int secondRoll) {
        checkIfGameIsOver();
        checkIfRoundScoreIsLegit(firstRoll, secondRoll);
        updatePreviousStrike(firstRoll, secondRoll);
        updatePreviousSpare(firstRoll);

        rollHistory.add(new RollPair(firstRoll + secondRoll, firstRoll, secondRoll));
    }

    private void updatePreviousStrike(int firstRoll, int secondRoll) {
        if (!rollHistory.isEmpty()) {
            if (rollHistory.size() >= 2) {
                RollPair penultimateRollPair = rollHistory.get(rollHistory.size() - 2);
                RollPair lastRollPair = rollHistory.get(rollHistory.size() - 1);
                int lastLastupdatedScore = penultimateRollPair.score();
                if (penultimateRollPair.isStrike()) {
                    if (rollHistory.get(rollHistory.size() - 1).firstRoll == 10) {
                        lastLastupdatedScore += firstRoll + MAX_SCORE;
                    } else {
                        lastLastupdatedScore += firstRoll + secondRoll + lastRollPair.score;
                    }
                    rollHistory.set(rollHistory.size() - 2, new RollPair(lastLastupdatedScore, penultimateRollPair.firstRoll(), penultimateRollPair.secondRoll()));
                }
            }
        }
    }

    private void updatePreviousSpare(int firstRoll) {
        if (!rollHistory.isEmpty()) {
            RollPair lastRollPair = rollHistory.get(rollHistory.size() - 1);
            int lastupdatedScore = lastRollPair.score();
            if (lastRollPair.isSpare()) {
                lastupdatedScore += firstRoll;
                rollHistory.set(rollHistory.size() - 1, new RollPair(lastupdatedScore, lastRollPair.firstRoll(), lastRollPair.secondRoll()));

            }
        }
    }

    private void checkIfGameIsOver() {
        if (rollHistory.size() >= MAX_ROUNDS) {
            RollPair lastRollPair = rollHistory.get(rollHistory.size() - 1);
            if (!lastRollPair.isStrike() && lastRollPair.score() < MAX_SCORE) {
                throw new IllegalStateException("La partie est déjà terminée. Vous ne pouvez pas enregistrer de nouveau résultat.");
            }
            if (rollHistory.size() == MAX_ROUNDS + 2 || (rollHistory.size() == MAX_ROUNDS + 1 && !rollHistory.get(MAX_ROUNDS).isStrike())) {
                throw new IllegalStateException("La partie est déjà terminée. Vous ne pouvez pas enregistrer de nouveau résultat.");
            }
        }
    }

    private void checkIfRoundScoreIsLegit(int firstRoll, int secondRoll) {
        if (firstRoll + secondRoll > 10) {
            throw new IllegalStateException("Impossible de marquer plus de 10 points sur un tour.");
        }
    }

    public int getScore() {
        return rollHistory.stream().limit(10).mapToInt(RollPair::score).sum();
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
