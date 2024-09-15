package engine.UI;

import Game.Statics.GameData;
import engine.Objects.SizeObjects.Vector2;

public class UIElementLocation {

    public static Vector2 TopLeft() {
        return new Vector2(0, 0);
    }

    public static Vector2 TopCenter(){
        float Center = (float) GameData.WindowSize.GetWidth() / 2;
        return new Vector2(Center,0);
    }


    public static Vector2 TopRight(){
        return new Vector2(GameData.WindowSize.GetWidth(),0);

    }
    public static Vector2 MidCenter(){
        float CenterX = (float) GameData.WindowSize.GetWidth() / 2;
        float CenterY = (float) GameData.WindowSize.GetHeight() / 2;

        return new Vector2(CenterX, CenterY);

    }

    public static Vector2 MidLeft(){
        float CenterY = (float) GameData.WindowSize.GetHeight() / 2;
        return new Vector2(0,CenterY);

    }

    public static Vector2 MidRight(){
        float CenterY = (float) GameData.WindowSize.GetHeight() / 2;
        return new Vector2(GameData.WindowSize.GetWidth(),CenterY);
    }

    public static Vector2 BottomCenter(){
        float CenterX = (float) GameData.WindowSize.GetWidth() / 2;
        return new Vector2(CenterX,GameData.WindowSize.GetHeight());
    }

    public static Vector2 BottomLeft(){
        return new Vector2(0,GameData.WindowSize.GetHeight());
    }

    public static Vector2 BottomRight(){
        return new Vector2(GameData.WindowSize.GetWidth(),GameData.WindowSize.GetHeight());
    }

}
