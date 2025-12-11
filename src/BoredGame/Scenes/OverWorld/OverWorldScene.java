package BoredGame.Scenes.OverWorld;
import engine.abstractions.Scene;

public class OverWorldScene extends Scene {

    // private final OverworldTileSet tileSet ;
    //StartMethod
    public OverWorldScene(){
        super();
        OverworldTileSet tileSet = new OverworldTileSet("Assets/OverWorld/OverWorldSpriteSheet","Assets/OverWorld/OverWorldSpriteSheet.png");

    }

    @Override
    public void UIUpdate(){
    }

    @Override
    public void UpdateRender() {
       //  PixelArray = tileSet.GetMapTiles(cam.pos.GetX(),cam.pos.GetY());
    }

    @Override
    public void UpdateGameLogic() {

    }
}
