package me.efraimgentil.toyrobot.domain;

import me.efraimgentil.toyrobot.exception.FallException;
import me.efraimgentil.toyrobot.exception.RobotException;

public class ToyRobot {

    private int x;
    private int y;
    private Direction direction;
    private Table tableThatImOn;


    public ToyRobot(){}

    public ToyRobot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void putOnTable(Table table , int x , int y , Direction direction){
        if(tableThatImOn == null) {
            if (table.willFall(x, y)) {
                throw new RobotException(String.format("The position (%d,%d) will result int the Robot falling.", x, y));
            }
            this.tableThatImOn = table;
            this.x = x;
            this.y = y;
            this.direction = direction;
        }else{
            throw new RobotException("Robot is already in a tablle");
        }

    }



}
