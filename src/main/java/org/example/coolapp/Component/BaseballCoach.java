package org.example.coolapp.Component;

import org.example.coolapp.Interface.Coach;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    public BaseballCoach() {
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30mins in batting practise";
    }
}
