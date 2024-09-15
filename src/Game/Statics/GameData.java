package Game.Statics;

import engine.Handlers.Peripherals.KeyboardHandler;
import engine.Objects.SizeObjects.Scale;

import java.awt.*;

public class GameData {
    public static Scale WindowSize;
    public static int PixelSize = 64;
    public static int SpriteSize = 16;
    public static int fps = 0;
    public static KeyboardHandler key;
    public static final int TICKS_PER_SEC = 30;
    public static final long MS_PER_TICK = 1000 / TICKS_PER_SEC ;
    public static final String FontName = "Arial";
    public static int HighestFPSCount = 0;

}