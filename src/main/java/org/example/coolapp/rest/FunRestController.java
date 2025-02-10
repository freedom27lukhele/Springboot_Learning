package org.example.coolapp.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //injecting properties from the application.properties

    @Value("${coach.name}")
    private String name;

    @Value("${team.name}")
    private String teamName;

    //endpoint to use these information
    @GetMapping("/teaminfo")
    public String teamInfo() {
        return name + " " + teamName;
    }


//    @GetMapping("/")
//    public String sayHello() {
//        return "Hello World";
//    }
//
//    //expose a new endpoint for workout
//    @GetMapping("/workout")
//    public String getDailyWorkout() {
//        return " run hard 5 km";
//    }
//
//    //fortune endpoint
//    @GetMapping("/fortune")
//    public String getFortune() {
//        return "i won the lotto";
//    }


}
