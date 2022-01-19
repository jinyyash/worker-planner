# Worker Planner
## Overview
Worker Planner is a REST service, that can plan Workers Shift data. In this application workers can add their shifts. A shift is 8 hours long and a Worker never has two shifts on the same day.Shift always start from 12:00am, 08:00am, 16:00pm

### Technical Overview

This application is built upon Java Spring Framework.

##### This application also relies on the following parts:

#### Database 

- **MySQL**

#### Tools & Plugins:
- **Maven** for dependency management and building automation
- **Hibernate** for ORM
- **JUnit and Mockito** for unit and Integration test
- **Postman** for API manual testing

### Database schema

Entities: Workers, Shifts

**Entity Relationship Diagram**

![image](/docs//erd.png?raw=true)

## How to Setup
### Using Docker
- Clone this repository

We can easily run the whole with only a single command:
 ``` 
docker-compose up
```
Docker will pull the MySQL and Spring Boot images (if our machine does not have it before).

The services can be run on the background with command:

 ``` 
docker-compose up -d
```
You can check the current working containers by using 
 ``` 
docker ps
```

#### Stop the System
Stopping all the running containers is also simple with a single command:
 ``` 
docker-compose down
```
If you need to stop and remove all containers, networks, and all images used by any service in docker-compose.yml file, use the command:
 ``` 
docker-compose down --rmi all
```
### Run on local enviroment 
- Clone this repository
- Make sure you are using Java 17 and Maven 3.x
- You can build the project by running ```mvn clean package```
- Once successfully built, you can run the service by using this command
 ``` 
mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"
```
- Once the application runs you should see something like this

  ![image](/docs//run.png?raw=true)

#### Environment Property Configuration 
```
Location : /src/main/resources/application.properties

server.port=${port}
spring.datasource.username=${username}
spring.datasource.password=${password}
```

### Reference Demo 

You can find relevant Postman Collection in ```
postman collection directory```

#### Add Worker

```
POST - http://localhost:8085/api/v1/worker 
```
Request Body
```
{
    "name": "example name ",
    "email": "example@gmail.com"
} 
```
Response Body 
```
{
    "id": 4,
    "name": "example name ",
    "email": "example@gmail.com",
    "shifts": null
}
```

#### Add Shift

```
POST - http://localhost:8085/api/v1/shift 
```
Request Body
```
{
    "date":"2022-01-19",
    "startTime":"00:00",
    "worker":{
        "id":4
    }
}
```
#### Find Shifts by Worker Id and Date

```
GET - http://localhost:8085/api/v1/findShiftByWorkerAndDate?id=1&date=2022-01-19
```
Response Body
```
[
    {
        "id": 7,
        "date": "2022-01-19",
        "startTime": "00:00:00",
        "worker": {
            "id": 4,
            "name": "example name ",
            "email": "example@gmail.com"
        }
    }
]
```

#### Get all Workers

```
GET - http://localhost:8085/api/v1/workers
```
Response Body
```
[
    {
        "id": 4,
        "name": "example name ",
        "email": "example@gmail.com",
        "shifts": [
            {
                "id": 7,
                "date": "2022-01-19",
                "startTime": "00:00:00"
            }
        ]
    }
]
```
#### Update Worker Details

```
PUT - http://localhost:8085/api/v1/worker/2 
```
Request Body
```{
    "name": "Jinadi Yasiruka",
    "email": "jinyyash@gmail.com"
}
```
#### Delete Worker

```
DELETE - http://localhost:8085/api/v1/worker/2 
```

