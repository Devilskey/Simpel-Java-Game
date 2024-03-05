package objects;

import Graphical_And_Rendering.MainDisplay;
import Handlers.KeyboardHandler;
import Statics.GameData;

public class Camera {
    public Vector2 pos;
    private final float MovementSpeed;
    private final int MaxX;
    private final int MaxY;

    public Camera (Vector2 pos, float MovementSpeed, int MaxX, int MaxY){
        this.pos = pos;
        this.MovementSpeed = MovementSpeed;
        this.MaxX = MaxX;
        this.MaxY = MaxY;
    }

    public void BordersCam(){
        if (pos.GetY() >= 0)
            pos.SetY(0);
        if (pos.GetX() >= 0)
            pos.SetX(0);
        if (pos.GetY() <= -(MaxY - GameData.WindowSize.GetY()))
            pos.SetY(-(MaxY - GameData.WindowSize.GetY()));
        if (pos.GetX() <= -(MaxX - GameData.WindowSize.GetX()))
            pos.SetX(-(MaxX - GameData.WindowSize.GetX()));
    }

    public void MoveCamera () {
        if (KeyboardHandler.Key_A)
            pos.addX(MovementSpeed * GameData.DeltaTime);
        if (KeyboardHandler.Key_D)
            pos.addX(-(MovementSpeed * GameData.fps));
        if (KeyboardHandler.Key_S)
            pos.addY(-MovementSpeed * GameData.fps);
        if (KeyboardHandler.Key_W)
            pos.addY(MovementSpeed * GameData.fps);
        BordersCam();
        System.out.println(MovementSpeed);
    }
}