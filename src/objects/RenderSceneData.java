package objects;

import Handlers.GameLogicHandler;
import Statics.GameData;
import abstractions.Entity;
import objects.SizeObjects.Vector2;
import objects.Tiles.Tile;

import java.awt.*;
import java.util.ArrayList;

public class RenderSceneData {
    //Tile X, Y Pixels
    public Tile[][] Pixels;
    public Vector2 pos;
    public ArrayList<Entity> Entites;


    public void RenderEntities (Graphics graphics){
        if(Entites == null)
            return;

        for(Entity entity : Entites){
            Vector2 PositionScreen = GameLogicHandler.WorldPositionToScreen(entity.Position);
            if(GameLogicHandler.VisibleOnScreen(PositionScreen)) {
                graphics.drawImage(entity.renderSprite(), (int) PositionScreen.GetX(), (int) PositionScreen.GetY(), entity.Size.GetWidth(), entity.Size.GetHeight(), null);
            }
        }
    }

    public void RenderImg (Graphics graphics){
        if(Pixels == null)
            return;

        int TilesPassedX = (int)(pos.GetX() / GameData.PixelSize);
        int TilesPassedY = (int)(pos.GetY() / GameData.PixelSize);

        int CamX = (int) (pos.GetX() - TilesPassedX * GameData.PixelSize);
        int CamY = (int) (pos.GetY() -  TilesPassedY * GameData.PixelSize);

        int x = 0;
        int y = 0;

        for (Tile[] pixel : Pixels){
            for (Tile tile : pixel){
                graphics.drawImage(tile.image, ((x * GameData.PixelSize)  - CamX), ((y * GameData.PixelSize) - CamY), GameData.PixelSize , GameData.PixelSize, null);
                x++;
            }
            x = 0;
            y++;
        }
    }
}
