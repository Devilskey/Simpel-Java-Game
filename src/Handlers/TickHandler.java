package Handlers;

import Statics.GameData;

import java.time.Duration;
import java.time.LocalTime;

public class TickHandler {
    private LocalTime nextTick = LocalTime.now();

    public boolean timeForNewTick () {
        System.out.println(GameData.MS_PER_TICK);
        if(nextTick.isBefore(LocalTime.now())) {
            nextTick = nextTick.plusSeconds(GameData.MS_PER_TICK);
            System.out.println(nextTick.getSecond());
            return true;
        }
        return false;
    }

    public void TimeForNextTick() {

        Duration duration = Duration.between(nextTick, LocalTime.now());
        long hours = duration.toHours();
        long minutes = duration.toMinutes();
        long seconds = duration.getSeconds();
        long millis = duration.toMillis();

        System.out.println("Difference in hours: " + hours);
        System.out.println("Difference in minutes: " + minutes);
        System.out.println("Difference in seconds: " + seconds);
        System.out.println("Difference in milliseconds: " + millis);
    }

}