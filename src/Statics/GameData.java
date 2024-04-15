package Statics;

import Handlers.KeyboardHandler;
import objects.SizeObjects.Scale;
import objects.SizeObjects.Vector2;

import java.awt.image.BufferedImage;

public class GameData {
    public static Scale WindowSize = new Scale(0, 0);
    public static int PixelSize = 64;
    public static int SpriteSize = 16;
    public static int fps = 0;
    public static KeyboardHandler key;
}