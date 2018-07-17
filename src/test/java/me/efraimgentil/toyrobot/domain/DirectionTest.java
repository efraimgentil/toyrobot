package me.efraimgentil.toyrobot.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {



    @Test
    public void shouldReturnWestDirectionWhenTurningToLeftIfFacingNorth(){
        Direction facing = Direction.NORTH;

        Direction newDirection = facing.turnLeft();

        assertThat(newDirection).isEqualTo(Direction.WEST);
    }

    @Test
    public void shouldReturnEastDirectionWhenTurningToRightIfFacingNorth(){
        Direction facing = Direction.NORTH;

        Direction newDirection = facing.turnRight();

        assertThat(newDirection).isEqualTo(Direction.EAST);
    }

    @Test
    public void shouldReturnSouthDirectionWhenTurningToLeftIfFacingWest(){
        Direction facing = Direction.WEST;

        Direction newDirection = facing.turnLeft();

        assertThat(newDirection).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void shouldReturnNorthDirectionWhenTurningToRightIfFacingWest(){
        Direction facing = Direction.WEST;

        Direction newDirection = facing.turnRight();

        assertThat(newDirection).isEqualTo(Direction.NORTH);
    }

    @Test
    public void shouldReturnEastDirectionWhenTurningToLeftIfFacingSouth(){
        Direction facing = Direction.SOUTH;

        Direction newDirection = facing.turnLeft();

        assertThat(newDirection).isEqualTo(Direction.EAST);
    }

    @Test
    public void shouldReturnWestDirectionWhenTurningToRightIfFacingSouth(){
        Direction facing = Direction.SOUTH;

        Direction newDirection = facing.turnRight();

        assertThat(newDirection).isEqualTo(Direction.WEST);
    }

    @Test
    public void shouldReturnNorthDirectionWhenTurningToLeftIfFacingEast(){
        Direction facing = Direction.EAST;

        Direction newDirection = facing.turnLeft();

        assertThat(newDirection).isEqualTo(Direction.NORTH);
    }

    @Test
    public void shouldReturnSouthDirectionWhenTurningToRightIfFacingEast(){
        Direction facing = Direction.EAST;

        Direction newDirection = facing.turnRight();

        assertThat(newDirection).isEqualTo(Direction.SOUTH);
    }

}
