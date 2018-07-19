package me.efraimgentil.toyrobot.domain;

public class Report {

    private int x;
    private int y;
    private Direction direction;

    public Report(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

}
