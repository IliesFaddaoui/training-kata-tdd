package com.ilies.trainingkatatdd.mars_rover;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class MarsRover {
    public static final String INVALID_COMMAND_AT_STEP = "Invalid command at step ";
    public static final String DEUX_POINTS = ": ";
    public static final String EMPTY_STRING = "";
    public static final int ONE = 1;

    private final Position position;
    private Direction direction;

    private final Map<String, Runnable> movementMap = Map.of(
            Movement.F.toString(), this::moveForward,
            Movement.R.toString(), () -> direction = turnRightDirection(),
            Movement.L.toString(), () -> direction = turnLeftDirection(),
            Movement.B.toString(), this::moveBackward
    );

    private void moveBackward() {
        if (Direction.E.equals(direction)) {
            position.decreaseXPosition();
        } else if (Direction.N.equals(direction)) {
            position.decreaseYPosition();
        } else if (Direction.S.equals(direction)) {
            position.increaseYPosition();
        } else if (Direction.W.equals(direction)) {
            position.increaseXPosition();
        }
    }

    public MarsRover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public void move(String commands) {
        if (!commands.isEmpty()) {
            List<String> orderedCommands = new ArrayList<>(List.of(commands.split(EMPTY_STRING)));
            orderedCommands.forEach(c -> {
                try {
                    proceedMovement(orderedCommands, c);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private void proceedMovement(List<String> orderedCommands, String c) throws Exception {
        if (!movementMap.containsKey(c)) {
            throw new Exception(INVALID_COMMAND_AT_STEP + (orderedCommands.indexOf(c) + ONE) + DEUX_POINTS + c);
        }
        movementMap.get(c).run();
    }

    private Direction turnRightDirection() {
        return switch (direction) {
            case N -> Direction.E;
            case E -> Direction.S;
            case S -> Direction.W;
            case W -> Direction.N;
        };
    }

    private Direction turnLeftDirection() {
        return switch (direction) {
            case N -> Direction.W;
            case W -> Direction.S;
            case S -> Direction.E;
            case E -> Direction.N;
        };
    }

    private void moveForward() {
        if (Direction.N.equals(direction)) {
            this.position.increaseYPosition();
        } else if (Direction.E.equals(direction)) {
            position.increaseXPosition();
        } else if (Direction.S.equals(direction)) {
            position.decreaseYPosition();
        } else if (Direction.W.equals(direction)) {
            position.decreaseXPosition();
        }
    }

}
