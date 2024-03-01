package Scenes.MainScene;

import Graphical_And_Rendering.Tiles.ImageHandler;
import Statics.GameData;
import objects.Tiles.AnimatedTile;
import objects.Tiles.AnimationTile;
import objects.Tiles.Tile;
import objects.Vector2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainWorldTiles {
    public Tile Grass;
    public Tile Dirt;
    public AnimatedTile Water = new AnimatedTile(3);
    private List<AnimationTile> AnimatedTileMap = new ArrayList<AnimationTile>();
    public Tile Flower;
    private final String TileMapLocation = "src/assets/test/WorstSpriteSheetEver.png";
    private final String MapLocation = "src/Scenes/MainScene/World/Map.png";
    private BufferedImage WorldMap;


    public MainWorldTiles(){
        try {
            BufferedImage TileMap = ImageIO.read(new File(TileMapLocation));
            WorldMap = ImageIO.read(new File(MapLocation));

            Grass = ImageHandler.GetTile(TileMap, 0, 0, "Grass",  new Color(0, 255, 0)); //#008000
            Dirt = ImageHandler.GetTile(TileMap, 0, 16, "Dirt", new Color(255, 200, 0)); //#FFA500

            Water.AnimationTiles[0] = ImageHandler.GetImage(TileMap, 16, 16);
            Water.AnimationTiles[1] = ImageHandler.GetImage(TileMap, 0, 32);
            Water.AnimationTiles[2] = ImageHandler.GetImage(TileMap, 16, 32);
            Water.MapColor = new Color(0, 0, 255); //#0000FF

            Flower = ImageHandler.GetTile(TileMap, 16, 0, "Flower", Color.BLUE); //#0000FF


        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void DrawMap(BufferedImage Scene){
        Graphics scene = Scene.getGraphics();
        for (int x = 0; x < WorldMap.getHeight(); x++) {
            for (int y = 0; y < WorldMap.getHeight(); y++) {
                PixelEqualsSprite(x, y);
               scene.drawImage(PixelEqualsSprite(x, y), x * GameData.PixelSize, y * GameData.PixelSize, GameData.PixelSize, GameData.PixelSize, null);
            }
        }
    }
    //Color.Black == none
    public void DrawAnimationMap(BufferedImage Scene){
        Graphics scene = Scene.getGraphics();
        for (int x = 0; x < AnimatedTileMap.size(); x++) {
            AnimationTile tile = AnimatedTileMap.get(x);
            scene.drawImage(tile.image.SwitchState(), (int) tile.Pos.GetX() * GameData.PixelSize, (int)tile.Pos.GetY() * GameData.PixelSize, GameData.PixelSize, GameData.PixelSize, null);
        }
    }

    public BufferedImage PixelEqualsSprite(int x, int y){
        int pixelData  = WorldMap.getRGB(x, y);

        System.out.println((pixelData == Grass.MapColor.hashCode()));
        System.out.println(" TC: " + pixelData + " : MC: " + Grass.MapColor);

        if(pixelData == Grass.MapColor.hashCode()) {
            return Grass.image;
        }
        if(pixelData == Dirt.MapColor.hashCode()) {
            return Dirt.image;
        }
        if(pixelData == Water.MapColor.hashCode()){
            AnimatedTileMap.add(new AnimationTile("Water", Water, new Vector2(x, y)));
            return Water.AnimationTiles[0];
        }
        return Flower.image;
    }
}
