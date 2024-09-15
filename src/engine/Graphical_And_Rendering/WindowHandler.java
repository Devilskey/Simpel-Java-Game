package engine.Graphical_And_Rendering;

import Game.Statics.GameData;

public class WindowHandler {
    public static int GetCenterX (){
        int TileAmount = (GameData.WindowSize.GetWidth() / GameData.PixelSize);
        int MiddleTile =  (int) TileAmount / 2;
        return (MiddleTile + 1) * GameData.PixelSize;
    }
    public static int GetCenterY(){
        int TileAmount = (GameData.WindowSize.GetHeight() / GameData.PixelSize);
        int MiddleTile =  (int) TileAmount / 2;
        return (MiddleTile + 1) * GameData.PixelSize;
    }

}
