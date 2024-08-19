package Statics;

import Handlers.Peripherals.KeyboardHandler;
import objects.SizeObjects.Scale;

public class GameData {
    public static Scale WindowSize = new Scale(500, 500);
    public static int PixelSize = 64;
    public static int SpriteSize = 16;
    public static int fps = 0;
    public static KeyboardHandler key;
    public static final int TICKS_PER_SEC = 30;
    public static final int MS_PER_TICK =  TICKS_PER_SEC / 1000;

}