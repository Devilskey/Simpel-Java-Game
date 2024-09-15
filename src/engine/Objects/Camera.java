package engine.Objects;

import engine.Debugger.DebugWindow;
import engine.Graphical_And_Rendering.WindowHandler;
import Game.Statics.GameData;
import engine.Objects.SizeObjects.Vector2;

public class Camera {
    public Vector2 pos;
    private boolean Static = false;

    public Camera(boolean Static) {
        this.Static =  Static;
    }

    public Camera (Vector2 pos, boolean Static){
        this.pos = pos;
        this.Static =  Static;
    }

    public void MoveWithEntitie (Vector2 positionPlayer) {
        if(Static) {
            DebugWindow.log("Error: Camera is static");
            return;
        }

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
