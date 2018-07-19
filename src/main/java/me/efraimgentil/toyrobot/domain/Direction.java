package me.efraimgentil.toyrobot.domain;

import java.util.Arrays;
import java.util.List;

public enum Direction {

     NORTH {
        @Override
        public Move getMove(int currentX, int currentY) {
            return new Move(currentX , ++currentY);
        }
    },
    WEST {
        @Override
        public Move getMove(int currentX, int currentY) {
            return new Move(--currentX, currentY);
        }
    },
    EAST {
        @Override
        public Move getMove(int currentX, int currentY) {
            return new Move(++currentX, currentY);
        }
    },
    SOUTH {
        @Override
        public Move getMove(int currentX, int currentY) {
            return new Move(currentX , --currentY);
        }
    };

    public abstract Move getMove(int currentX , int currentY);

    private static List<Direction> directions = Arrays.asList(NORTH,EAST,SOUTH,WEST);
    public Direction turn(TurnDirection turnDirection){
        int idx = directions.indexOf(this);
        switch (turnDirection){
            case LEFT:
                if(idx-1 < 0)
                    return directions.get(directions.size()-1);
                return directions.get(idx-1);
            case RIGHT:
                if(idx+1 >= directions.size())
                    return directions.get(0);
                return directions.get(idx+1);
            default:
                throw new IllegalArgumentException("Invalid turn direction movement");
        }
    }


}
