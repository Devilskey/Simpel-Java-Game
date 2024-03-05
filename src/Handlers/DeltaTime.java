package Handlers;

public class DeltaTime {
    protected static float DeltaTime = 0.0f;

    public static float Time() {
        return DeltaTime;
    }

    public void CalculateDeltaTime(long TimeFirst, long TimeLast){
        long Time = (TimeFirst - TimeLast);
    }
}
