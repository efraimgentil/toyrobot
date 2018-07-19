package me.efraimgentil.toyrobot.domain;

import me.efraimgentil.toyrobot.exception.RobotException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ToyRobotTest  {


    @Test(expected = RobotException.class)
    public void shouldThrowErrorIfCoordinateIsOutOfTable(){
        ToyRobot toyRobot = new ToyRobot();

        toyRobot.putOnTable(new Table(5), new PlacePosition(5 ,5  , Direction.NORTH) );
    }

    @Test
    public void shouldPutRobotInTheTable(){
        ToyRobot toyRobot = new ToyRobot();

        toyRobot.putOnTable(new Table(5), new PlacePosition(3 ,3  , Direction.SOUTH) );
    }

    @Test(expected = RobotException.class)
    public void shouldRefuseToMoveIfNotInATable(){
        ToyRobot toyRobot = new ToyRobot();

        toyRobot.move();
    }

    @Test
    public void shouldMoveTheRobotToNorth(){
        ToyRobot toyRobot = new ToyRobot();
        toyRobot.putOnTable(new Table(5), new PlacePosition(0 ,0  , Direction.NORTH));

        toyRobot.move();

        Report report = toyRobot.generateReport();
        assertThat(report.getX()).isEqualTo(0);
        assertThat(report.getY()).isEqualTo(1);
        assertThat(report.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test(expected = RobotException.class)
    public void shouldRefuseToMoveIfGoingToFall(){
        ToyRobot toyRobot = new ToyRobot();
        toyRobot.putOnTable(new Table(5), new PlacePosition(0 ,0  , Direction.NORTH));

        toyRobot.move().move().move().move().move().move();

        Report report = toyRobot.generateReport();
        assertThat(report.getX()).isEqualTo(0);
        assertThat(report.getY()).isEqualTo(1);
        assertThat(report.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void shouldTurnDirectionToWest(){
        ToyRobot toyRobot = new ToyRobot();
        toyRobot.putOnTable(new Table(5), new PlacePosition(0 ,0  , Direction.NORTH));

        toyRobot.turnTo(TurnDirection.LEFT);

        Report report = toyRobot.generateReport();
        assertThat(report.getX()).isEqualTo(0);
        assertThat(report.getY()).isEqualTo(0);
        assertThat(report.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void shouldMoveMultipleTimes(){
        ToyRobot toyRobot = new ToyRobot();
        toyRobot.putOnTable(new Table(5), new PlacePosition(1 ,2  , Direction.EAST));

        Report report = toyRobot.move().move().turnTo(TurnDirection.LEFT).move().generateReport();

        assertThat(report.getX()).isEqualTo(3);
        assertThat(report.getY()).isEqualTo(3);
        assertThat(report.getDirection()).isEqualTo(Direction.NORTH);
    }

}
