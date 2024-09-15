package engine.abstractions;

import engine.Debugger.DebugWindow;
import Game.Statics.GameData;
import engine.Enums.MoveTo;
import engine.Objects.SizeObjects.Scale;
import engine.Objects.SizeObjects.Vector2;
import engine.Objects.Sprites.Sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Entity {
    public Sprites SpriteHandler;
    public Scale Size = new Scale(0,0);
    public Vector2 Position = new Vector2(0,0);
    public BufferedImage SpriteSheet;
    public BufferedImage BaseSprite;
    public abstract BufferedImage renderSprite();
    public abstract void Start();
    public abstract void Update();
    public boolean CanMove = false;
    public boolean ObstacleUp, ObstacleDown, ObstacleLeft, ObstacleRight;
    public boolean OverlappingCollisionUp,OverlappingCollisionDown, OverlappingCollisionRight, OverlappingCollisionLeft;
    public boolean canColide = true;
    public boolean IsPlayer = false;

    public Entity(String SpriteSheatPath){
        try {
            SpriteSheet = ImageIO.read(new File(SpriteSheatPath));
            BaseSprite = SpriteSheet.getSubimage(0, 0, 16, 16);
            SpriteHandler = new Sprites(SpriteSheet);
        }catch (IOException ex){
            DebugWindow.log(ex.getMessage());
        }
        Start();
    }

    public Vector2 CollisionPushBack(Vector2 EntityPos, MoveTo Direction){
        float OverTileValueX = EntityPos.GetX() % GameData.PixelSize;
        float OverTileValueY = EntityPos.GetY() % GameData.PixelSize;


        float newX = EntityPos.GetX();
        float newY = EntityPos.GetY();

       switch (Direction){
           case Up -> newY += (GameData.PixelSize - OverTileValueY) + 4;
           case Down -> newY -= OverTileValueY;
           case Left -> newX += (GameData.PixelSize - OverTileValueX) + 3;
           case Right -> newX -= OverTileValueX;
       }

        System.out.println("Old Position = " + EntityPos.GetX() + " : " + EntityPos.GetY() + " New Position = " + newX + " : " + newY  );
        return new Vector2(newX, newY);

    }
}
