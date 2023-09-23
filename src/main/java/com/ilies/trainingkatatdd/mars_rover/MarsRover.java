package com.ilies.trainingkatatdd.mars_rover;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class MarsRover {
    private Position position;
    private Direction direction;

    private final Map<String, Runnable> movementMap = Map.of(
            Movement.F.toString(), this::moveForward,
            Movement.R.toString(), () -> direction = turnRightDirection(),
            Movement.L.toString(), () -> direction = turnLeftDirection(),
            Movement.B.toString(), this::moveBackward
    );

    private void moveBackward() {
        if(Direction.E.equals(direction)){
            position.decreaseXPosition();
        }
        else if(Direction.N.equals(direction)) {
            position.decreaseYPosition();
        }
        else if(Direction.S.equals(direction)) {
            position.increaseYPosition();
        }
        else if(Direction.W.equals(direction)) {
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
            List<String> orderedCommands = new ArrayList<>(List.of(commands.split("")));
            orderedCommands.forEach(c -> {
                movementMap.get(c).run();
            });
        }
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
        if(Direction.N.equals(direction)) {
            this.position.increaseYPosition();
        }
        else if(Direction.E.equals(direction)) {
            position.increaseXPosition();
        }
        else if(Direction.S.equals(direction)) {
            position.decreaseYPosition();
        }
        else if(Direction.W.equals(direction)) {
            position.decreaseXPosition();
        }
    }

}
