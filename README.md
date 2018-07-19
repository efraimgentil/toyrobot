# Toy Robot


### How to run the project

Running the project, you should execute the following terminal command in the root folder of the project
```cmd
$ ./mvnw spring-boot:run
```

Running the tests
```cmd
$ ./mvnw test
```

You can import the `ToyRobot.postman_collection.json` in you postman to use the project, it contains all the available commands


### Commands

The commands tha api support are REST calls 

> Where {{host}} replace for the host address (default: http://localhost:8080)

PLACE

```javascript
\\method: POST
\\URL: {{host}}/place
\\content-type: application/json
\\request payload example
{
  "x" : 0
  ,"y" : 0
  ,"direction" : "NORTH" \\Values available (NORTH,SOUTH,WEST,EAST)
}
```

MOVE - Move one position towards the current facing direction 

```javascript
\\method: POST
\\URL: {{host}}/move
\\request payload NO PAYLOAD
```

LEFT  - Turn to left direction of the actual facing direction

```javascript
\\method: POST
\\URL: {{host}}/left
\\request payload NO PAYLOAD
```

RIGHT - Turn to right direction of the actual facing direction

```javascript
\\method: POST
\\URL: {{host}}/right
\\request payload NO PAYLOAD
```

REPORT - Get the robot report (current position and facing direction)

```javascript
\\method: GET
\\URL: {{host}}/report
\\payload NO PAYLOAD
\\response payload example
{
    "x": 0,
    "y": 0,
    "direction": "WEST"
}
```

### Assumptions

- I'm assuming that the input will always be correct, so i did not wrote validation to the input, if it was required i would have wrote using BeanValidation
- I'm assuming that once placed, the robot can be placed in another place again, but not removed from the table
- I'm assuming that we have only one robot instance for the application, for that i'm using Spring scope Singleton, to handle that for me
- The postman collection is attached with the project. (Using version v2.1)


### Stack

 - Java 8
 - Spring Boot
 - Maven