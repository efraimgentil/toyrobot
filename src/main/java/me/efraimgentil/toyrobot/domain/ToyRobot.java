package me.efraimgentil.toyrobot.domain;

import me.efraimgentil.toyrobot.exception.RobotException;
import org.springframework.stereotype.Service;

@Service
public class ToyRobot {

    private int x;
    private int y;
    private Direction direction;
    private Table tableThatImOn;

    public ToyRobot(){}

    public ToyRobot turnTo(TurnDirection turnDirection){
        direction = direction.turn(turnDirection);
        return this;
    }

    public ToyRobot move(){
        if(tableThatImOn == null) throw new RobotException("Robot is not on a table");
        Move move = direction.getMove(x, y);
        if(tableThatImOn.willFall(move.getX() , move.getY())){
            throw new RobotException("Robot refuses to fall to death");
        }
        this.x = move.getX();
        this.y = move.getY();
        return this;
    }

    public ToyRobot putOnTable(Table table , PlacePosition placePosition){
        if (table.willFall(placePosition.getX(), placePosition.getY())) {
            throw new RobotException(String.format("The position (%d,%d) will result int the Robot falling.", x, y));
        }
        this.tableThatImOn = table;
        this.x = placePosition.getX();
        this.y = placePosition.getY();
        this.direction = placePosition.getDirection();
        return this;
    }

    public Report generateReport(){
        if(tableThatImOn == null) throw new RobotException("Robot missing");
        return new Report(x, y, direction);
    }

}
