package objects;

import Debuger.DebugWindow;
import Handlers.GameLogicHandler;
import Statics.GameData;
import abstractions.Entity;
import objects.SizeObjects.Vector2;
import objects.Tiles.Tile;

import java.awt.*;

public class RenderSceneData {
    //Tile X, Y Pixels
    public Tile[][] Pixels;
    public Vector2 pos;
    public Entity[] Entites;
    public void RenderEntities (Graphics graphics){
        for(Entity entity : Entites){
            Vector2 PositionScreen = GameLogicHandler.WorldPositionToScreen(entity.Position);
            if(GameLogicHandler.VisibleOnScreen(PositionScreen)) {
                graphics.drawImage(entity.renderSprite(), (int) PositionScreen.GetX(), (int) PositionScreen.GetY(), entity.Size.GetWidth(), entity.Size.GetHeight(), null);
            }

        }
    }

    public void RenderImg (Graphics graphics){
        int TilesPassedX = (int)(pos.GetX() / GameData.PixelSize);
        int TilesPassedY = (int)(pos.GetY() / GameData.PixelSize);
        float CamX = pos.GetX() - TilesPassedX * GameData.PixelSize;
        float CamY = pos.GetY() -  TilesPassedY * GameData.PixelSize;

        int x = -1;
        int y = -1;
        for (Tile[] pixel : Pixels){
            for (Tile tile : pixel){
                graphics.drawImage(tile.image, ((x * GameData.PixelSize) - (int) CamX), ((y * GameData.PixelSize) - (int) CamY), GameData.PixelSize , GameData.PixelSize, null);
                x++;
            }
            x = -1;
            y++;
        }
    }
}
