package abstractions;

import Debuger.DebugWindow;
import objects.SizeObjects.Scale;
import objects.SizeObjects.Vector2;
import objects.Sprites.Sprites;

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
}
