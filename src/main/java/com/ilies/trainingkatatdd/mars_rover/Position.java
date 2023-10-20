package com.ilies.trainingkatatdd.mars_rover;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position {
    public static final int ONE = 1;
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void increaseXPosition() {
        x += ONE;
    }
    public void decreaseXPosition() {
        x -= ONE;
    }
    public void increaseYPosition() {
        y += ONE;
    }
    public void decreaseYPosition() {
        y -= ONE;
    }
}
