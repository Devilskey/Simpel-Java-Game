package Handlers;

import Debuger.DebugWindow;
import Statics.GameData;
import objects.SizeObjects.Vector2;

public class GameLogicHandler {
    private static Vector2 PositionStartRender = new Vector2(0,0);
    public static void SetPositionStartRender(Vector2 NewPositionRender){
        PositionStartRender = NewPositionRender;
    }
    public static Vector2 WorldPositionToScreen(Vector2 PositionScreen){
        return MinPositions(PositionScreen, PositionStartRender);
    }

    public static boolean VisibleOnScreen(Vector2 Position){

        return true;
    }

    private static Vector2 MinPositions(Vector2 Position1, Vector2 Position2){
        return new Vector2(
                Position1.GetX() - Position2.GetX(),
                Position1.GetY() - Position2.GetY()
        );
    }
}
