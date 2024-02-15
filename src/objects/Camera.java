package objects;

import Graphical_And_Rendering.MainDisplay;
import Handlers.KeyboardHandler;
import Statics.GameData;

public class Camera {
    public Vector2 pos;
    private final float MovementSpeed;

    public Camera (Vector2 pos, float MovementSpeed){
        this.pos = pos;
        this.MovementSpeed = MovementSpeed;
    }

    public void MoveCamera (){
        if(KeyboardHandler.Key_A)
            pos.addX(MovementSpeed / GameData.fps);
        if(KeyboardHandler.Key_D)
            pos.addX(-( MovementSpeed / GameData.fps));
        if(KeyboardHandler.Key_S)
            pos.addY(-MovementSpeed / GameData.fps);
        if(KeyboardHandler.Key_W)
            pos.addY(MovementSpeed / GameData.fps);
    }

}
