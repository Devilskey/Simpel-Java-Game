package Statics;

import Handlers.KeyboardHandler;
import objects.Vector2;

public class GameData {
    public static Vector2 WindowSize = new Vector2(0,0);
    public static int PixelSize = 64;
    public static int TileSize = 32;
    public static int SpriteSize = 16;
    public static float fps = 0;
    public static float DeltaTime = 0.0001f;
    public static KeyboardHandler key;
}
