package me.efraimgentil.toyrobot.domain;

public enum Direction {

    NORTH {
        @Override
        public Move gettMove(int currentX, int currentY) {
            return new Move(currentX , ++currentY);
        }

        @Override
        public Direction turnLeft() {
            return WEST;
        }

        @Override
        public Direction turnRight() {
            return EAST;
        }
    },
    WEST {
        @Override
        public Move gettMove(int currentX, int currentY) {
            return new Move(--currentX, currentY);
        }

        @Override
        public Direction turnLeft() {
            return SOUTH;
        }

        @Override
        public Direction turnRight() {
            return NORTH;
        }
    },
    EAST {
        @Override
        public Move gettMove(int currentX, int currentY) {
            return new Move(++currentX, currentY);
        }

        @Override
        public Direction turnLeft() {
            return NORTH;
        }

        @Override
        public Direction turnRight() {
            return SOUTH;
        }
    },
    SOUTH {
        @Override
        public Move gettMove(int currentX, int currentY) {
            return new Move(currentX , --currentY);
        }

        @Override
        public Direction turnLeft() {
            return EAST;
        }

        @Override
        public Direction turnRight() {
            return WEST;
        }
    };


    public abstract Move gettMove(int currentX , int currentY);
    public abstract Direction turnLeft();
    public abstract Direction turnRight();


}
