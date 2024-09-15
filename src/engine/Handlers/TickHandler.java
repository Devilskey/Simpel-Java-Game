package engine.Handlers;

import engine.Debugger.DebugWindow;
import Game.Statics.GameData;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TickHandler {
    private LocalTime nextTick = LocalTime.now();

    public TickHandler(){
        DebugWindow.log("Next Tick: " + nextTick + " Tick per ms: " + GameData.MS_PER_TICK);
    }

    public boolean timeForNewTick () {
        if(nextTick.isBefore(LocalTime.now())) {
            nextTick = nextTick.plus(GameData.MS_PER_TICK, ChronoUnit.MILLIS);
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