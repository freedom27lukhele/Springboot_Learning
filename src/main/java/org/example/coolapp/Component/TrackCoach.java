package org.example.coolapp.Component;

import org.example.coolapp.Interface.Coach;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Run a 5k hard";
    }
}
