package me.efraimgentil.toyrobot.domain;

import me.efraimgentil.toyrobot.exception.RobotException;
import org.junit.Test;

public class ToyRobotTest  {


    @Test(expected = RobotException.class)
    public void shouldThrowErrorIfCoordinateIsOutOfTable(){
        ToyRobot toyRobot = new ToyRobot();

        toyRobot.putOnTable(new Table(5), 5 ,5  , Direction.NORTH);;
    }


    @Test(expected = RobotException.class)
    public void shouldThrowErrorIfRobotIsAlreadyOnATable(){
        ToyRobot toyRobot = new ToyRobot();
        toyRobot.putOnTable(new Table(5), 4 ,4  , Direction.NORTH);

        //Try to put on the table two times
        toyRobot.putOnTable(new Table(5), 4 ,4  , Direction.NORTH);
    }

    @Test
    public void shouldPutRobotInTheTable(){
        ToyRobot toyRobot = new ToyRobot();

        toyRobot.putOnTable(new Table(5), 3 ,3  , Direction.SOUTH);
    }

}
