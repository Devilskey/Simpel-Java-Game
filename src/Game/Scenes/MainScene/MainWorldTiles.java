package Game.Scenes.MainScene;

import engine.Graphical_And_Rendering.ImageHandler;
import engine.abstractions.SceneMapLoader;
import engine.Objects.Tiles.AnimatedTiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MainWorldTiles extends SceneMapLoader {

    public MainWorldTiles(){
        super("src/Game.Scenes/MainScene/World/Map.png", "src/Game.Assets/test/NewDemoSpriteSheat.png");
    }

    public void LoadTiles(BufferedImage TileMap){
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 0, 0, "Grass",  new Color(0, 255, 0), false)); //#008000
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 0, 16, "Grass Water",  new Color(0, 220, 0),true)); //#008000
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 16, 16, "Grass Water Corner Top",  new Color(0, 200, 0), true)); //#008000
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 16, 48, "Grass Water Corner Side Left",  new Color(0, 180, 0), true)); //#008000
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 32, 48, "Grass Water Corner Side Right",  new Color(0, 164, 0), true)); //#008000
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 32, 16, "Grass Water Corner Side Right",  new Color(79, 183, 79), true)); //#008000

        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 48, 48, "Grass water corner 4", new Color(0, 160, 0), true));
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 0, 64, "Grass water corner 5", new Color(0, 150, 0), true));
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 0, 96, "Grass water corner 6", new Color(140, 0, 255), true)); //#0000FF
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 48, 80, "Grass water corner 7", new Color(121, 0, 220), true)); //#0000FF
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 32, 80, "Grass top water corner 2", new Color(102, 0, 189), true)); //#0000FF
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 16, 96, "Grass water corner 9", new Color(80, 29, 122), true)); //#0000FF
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 32, 96, "Grass water corner 9", new Color(98, 57, 131), true)); //#0000FF
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 0, 112, "Grass water corner 10", new Color(68, 35, 89), true)); //#0000FF

        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 0, 48, "GrassTop", new Color(255, 200, 0), true)); //#FFA500
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 48, 32, "DirtTop", new Color(240, 200, 0), true)); //#FFA500
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 16, 64, "DirtLong", new Color(240, 180, 0),true)); //#FFA500
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 48, 64, "Dirt Water", new Color(188, 240, 0), true)); //#FFA500

        Pallet.VoidTile = ImageHandler.GetTile(TileMap, 32, 0, "Flower", Color.BLUE, false); //#0000FF
        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 16, 0, "Flower Red", new Color(200, 0, 0),false)); //#0000FF

        Pallet.tiles.add(ImageHandler.GetTile(TileMap, 16, 80, "Still water", new Color(0, 174, 255), true)); //#0000FF
    }

    @Override
    public void LoadAnimatedTiles(BufferedImage TileMap){
        AnimatedTiles Water = new AnimatedTiles(3, "Water", new Color(0,0, 255));
        Water.States[0] = ImageHandler.GetAnimatedTile(TileMap, 0, 32);
        Water.States[1] = ImageHandler.GetAnimatedTile(TileMap, 16, 32);
        Water.States[2] = ImageHandler.GetAnimatedTile(TileMap, 32, 32 );

        Pallet.animatedTiles.add(Water);
    }
}