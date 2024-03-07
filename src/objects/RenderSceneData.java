package objects;

import Statics.GameData;
import objects.SizeObjects.Vector2;
import objects.Tiles.Tile;

import java.awt.*;

public class RenderSceneData {
    //Tile X, Y Pixels
    public Tile[][] Pixels;
    public Vector2 pos;

    public void RenderImg (Graphics graphics){
        int TilesPassedX = (int)(pos.GetX() / GameData.PixelSize);
        int TilesPassedY = (int)(pos.GetY() / GameData.PixelSize);
        float CamX = pos.GetX() - TilesPassedX * GameData.PixelSize;
        float CamY = pos.GetY() -  TilesPassedY *  GameData.PixelSize;


        int x = -1;
        int y = -1;
        for (Tile[] pixel : Pixels){
            for (Tile tile : pixel){
                graphics.drawImage(tile.image, (x * GameData.PixelSize) - (int) CamX, (y * GameData.PixelSize) - (int) CamY, GameData.PixelSize, GameData.PixelSize, null);
                x++;
            }
            x = -1;
            y++;
        }
    }
}
