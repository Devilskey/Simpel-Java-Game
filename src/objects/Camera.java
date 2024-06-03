package objects;

import Graphical_And_Rendering.WindowHandler;
import Handlers.Peripherals.KeyboardHandler;
import Statics.GameData;
import objects.SizeObjects.Vector2;

public class Camera {
    public Vector2 pos;
    private final float MovementSpeed;
    private final int MaxX;
    private final int MaxY;

    public boolean LinkedToEntitie = false;

    int trueAmount = 0;

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
        if (pos.GetY() <= 0)
            pos.SetY(0);
        if (pos.GetX() <= 0)
            pos.SetX(0);
        if (pos.GetY() <= -(MaxY - GameData.WindowSize.GetHeight()))
            pos.SetY((MaxY - GameData.WindowSize.GetHeight()));
        if (pos.GetX() <= -(MaxX - GameData.WindowSize.GetWidth()))
            pos.SetX((MaxX - GameData.WindowSize.GetWidth()));
    }
    public void MoveWithEntitie (Vector2 positionPlayer) {
        float centerXplayer = (WindowHandler.GetCenterX() - (float) GameData.PixelSize);
        float centerYplayer = (WindowHandler.GetCenterY() - (float) GameData.PixelSize);

        float x = 0;
        float y = 0;

        if (positionPlayer.GetX() > centerXplayer)
            x = positionPlayer.GetX() - centerXplayer;
        else
            x = 0;

        if (positionPlayer.GetY() > centerYplayer)
            y = positionPlayer.GetY() - centerYplayer;
        else
            y = 0;
        pos = new Vector2(x, y);
    }
}
