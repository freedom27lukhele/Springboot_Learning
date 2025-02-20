package org.example.coolapp.Component;

import org.example.coolapp.Interface.Coach;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {


    public TrackCoach() {
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a 5k hard";
    }
}
