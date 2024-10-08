package engine.Handlers.Physics;

import Game.Statics.GameData;
import engine.Enums.MoveTo;
import engine.Objects.SizeObjects.Vector2;

public class DirectionsVector {

    public static Vector2 RightOnGrid(){
        return  new Vector2(GameData.PixelSize, 0);
    }
    public static Vector2 LeftOnGrid(){
        return  new Vector2(-GameData.PixelSize, 0);
    }
    public static Vector2 UpOnGrid(){
        return  new Vector2(0, -GameData.PixelSize);
    }
    public static Vector2 BottomOnGrid(){
        return  new Vector2(0, GameData.PixelSize);
    }

    public static Vector2 MoveToVector2(MoveTo Direction){
        switch (Direction){
            default -> {
                return new Vector2(0,0);
            }
            case Up -> {
                return UpOnGrid();
            }
            case Down -> {
                return BottomOnGrid();
            }
            case Left -> {
                return LeftOnGrid();
            }
            case Right -> {
                return RightOnGrid();
            }
        }
    }
}
