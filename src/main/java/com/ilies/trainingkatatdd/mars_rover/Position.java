package com.ilies.trainingkatatdd.mars_rover;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void increaseXPosition() {
        x += 1;
    }
    public void decreaseXPosition() {
        x -= 1;
    }
    public void increaseYPosition() {
        y += 1;
    }
    public void decreaseYPosition() {
        y -= 1;
    }
}
