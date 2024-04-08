package objects;

import Debuger.DebugWindow;
import Handlers.KeyboardHandler;
import Statics.GameData;
import objects.SizeObjects.Vector2;

public class Camera {
    public Vector2 pos;
    private final float MovementSpeed;
    private final int MaxX;
    private final int MaxY;

    public boolean LinkedToEntitie = false;

    public Camera(Vector2 pos, float MovementSpeed, int MaxX, int MaxY) {
        this.pos = pos;
        this.MovementSpeed = MovementSpeed;
        this.MaxX = MaxX * GameData.PixelSize;
        this.MaxY = MaxY * GameData.PixelSize;
    }
    public Camera (Vector2 pos, float MovementSpeed, int MaxX, int MaxY, boolean Linked){
        this.LinkedToEntitie = Linked;
        this.pos = pos;
        this.MovementSpeed = MovementSpeed;
        this.MaxX = MaxX * GameData.PixelSize;
        this.MaxY = MaxY * GameData.PixelSize;
    }

    public void BordersCam(){
        if (pos.GetY() <= GameData.PixelSize)
            pos.SetY(GameData.PixelSize);
        if (pos.GetX() <= GameData.PixelSize)
            pos.SetX(GameData.PixelSize);
        if (pos.GetY() <= -(MaxY - GameData.WindowSize.GetHeight()))
            pos.SetY((MaxY - GameData.WindowSize.GetHeight()));
        if (pos.GetX() <= -(MaxX - GameData.WindowSize.GetWidth()))
            pos.SetX((MaxX - GameData.WindowSize.GetWidth()));
    }
    public void MoveWithEntitie () {

        // Check if the player is in the middel X OR Y of the screen so yes move Else Dont
        // Check if the player
        if (KeyboardHandler.Key_A)
            pos.addX(-(MovementSpeed / GameData.fps));
        else if (KeyboardHandler.Key_D)
            pos.addX((MovementSpeed / GameData.fps));
        else if (KeyboardHandler.Key_S)
            pos.addY(MovementSpeed / GameData.fps);
        else if (KeyboardHandler.Key_W)
            pos.addY(-(MovementSpeed / GameData.fps));
        BordersCam();
    }

    public void MoveCamera () {
        if (KeyboardHandler.Key_A)
            pos.addX(-(MovementSpeed / GameData.fps));
        else if (KeyboardHandler.Key_D)
            pos.addX((MovementSpeed / GameData.fps));
       else if (KeyboardHandler.Key_S)
            pos.addY(MovementSpeed / GameData.fps);
       else if (KeyboardHandler.Key_W)
            pos.addY(-(MovementSpeed / GameData.fps));
         BordersCam();
    }
}
