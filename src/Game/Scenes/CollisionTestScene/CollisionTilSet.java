package Game.Scenes.CollisionTestScene;

import engine.Graphical_And_Rendering.ImageHandler;
import engine.abstractions.SceneMapLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CollisionTilSet extends SceneMapLoader {
    public CollisionTilSet(){
        super("src/Game/Scenes/CollisionTestScene/Map/Map.png", "src/Game/Assets/test/NewDemoSpriteSheat.png");
    }

    public void LoadTiles(BufferedImage TileMap){
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 0, 0, "Grass",  new Color(0, 255, 0), false)); //#008000
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 0, 32, "Dirt",  new Color(255, 0, 0), true)); //#008000

    }

    @Override
    public void LoadAnimatedTiles(BufferedImage TileMap){
    }
}
