package me.efraimgentil.toyrobot.controller;

import me.efraimgentil.toyrobot.domain.PlacePosition;
import me.efraimgentil.toyrobot.domain.Table;
import me.efraimgentil.toyrobot.domain.ToyRobot;
import me.efraimgentil.toyrobot.domain.TurnDirection;
import me.efraimgentil.toyrobot.exception.RobotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class RobotController {

    private ToyRobot toyRobot;

    @Autowired
    private RobotController(ToyRobot toyRobot){
        this.toyRobot = toyRobot;
    }

    @PostMapping("place")
    public ResponseEntity place(@RequestBody PlacePosition placePosition){
        Table table = new Table();
        toyRobot.putOnTable(table , placePosition);
        return ResponseEntity.ok().build();
    }

    @PostMapping("move")
    public ResponseEntity move(){
        toyRobot.move();
        return ResponseEntity.ok().build();
    }

    @PostMapping("left")
    public ResponseEntity turnLeft(){
        toyRobot.turnTo(TurnDirection.LEFT);
        return ResponseEntity.ok().build();
    }

    @PostMapping("right")
    public ResponseEntity turnRight(){
        toyRobot.turnTo(TurnDirection.RIGHT);
        return ResponseEntity.ok().build();
    }

    @GetMapping("report")
    public ResponseEntity report(){
        return ResponseEntity.ok(toyRobot.generateReport());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleRobotException(RobotException re){
        return new HashMap<String,String>(){{ put("message" , re.getMessage()); }};
    }

}
