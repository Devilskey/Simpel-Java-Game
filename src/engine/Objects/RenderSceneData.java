package engine.Objects;

import engine.Handlers.GameLogicHandler;
import Game.Statics.GameData;
import engine.UI.UIHandler;
import engine.abstractions.Entity;
import engine.abstractions.UserInterface;
import engine.Objects.SizeObjects.Vector2;
import engine.Objects.Tiles.Tile;

import java.awt.*;
import java.util.ArrayList;

public class RenderSceneData {
    //Tile X, Y Pixels
    public Tile[][] Pixels;
    public Vector2 pos;
    public ArrayList<Entity> Entites;
    public UIHandler UIhandler;

    public void RenderUI(Graphics graphics){
        if(UIhandler == null)
            return;

        for(UserInterface UIElement : UIhandler.UI){
            UIElement.RenderUIElement(graphics);
        }
    }

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
        int TilesPassedX = (int)(pos.GetX() / GameData.PixelSize);
        int TilesPassedY = (int)(pos.GetY() / GameData.PixelSize);

        int CamX = (int) (pos.GetX() - TilesPassedX * GameData.PixelSize);
        int CamY = (int) (pos.GetY() -  TilesPassedY * GameData.PixelSize);


        int x = 0;
        int y = 0;

        for (Tile[] pixel : Pixels){
            for (Tile tile : pixel){
                if(tile == null){
                    System.out.println("tile is 0 at");
                }else {
                    graphics.drawImage(tile.image, ((x * GameData.PixelSize) - CamX), ((y * GameData.PixelSize) - CamY), GameData.PixelSize, GameData.PixelSize, null);
                }
                x++;
            }
            x = 0;
            y++;
        }
    }
}
