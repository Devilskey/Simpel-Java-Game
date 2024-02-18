package Scenes.MainScene;

import Graphical_And_Rendering.Tiles.ImageHandler;
import Statics.GameData;
import objects.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainWorldTiles {
    public Tile Grass;
    public Tile Dirt;
    public Tile Water;
    public Tile Flower;
    private String TileMapLocation = "src/assets/test/WorstSpriteSheetEver.png";
    private String MapLocation = "src/Scenes/MainScene/World/Map.png";
    BufferedImage WorldMap;

    public MainWorldTiles(){
        try {
            BufferedImage TileMap = ImageIO.read(new File(TileMapLocation));
            WorldMap = ImageIO.read(new File(MapLocation));

            Grass = ImageHandler.GetTile(TileMap, 0, 0, "Grass",  new Color(0, 255, 0)); //#008000
            Dirt = ImageHandler.GetTile(TileMap, 0, 16, "Dirt", new Color(255, 200, 0)); //#FFA500

            Water = ImageHandler.GetTile(TileMap, 16, 16, "Grass", new Color(0,0, 255)); //#0000FF
            Flower = ImageHandler.GetTile(TileMap, 16, 0, "Flower", Color.BLUE); //#0000FF


        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void DrawMap(BufferedImage Scene){
        Graphics scene = Scene.getGraphics();
        for (int x = 0; x < WorldMap.getHeight(); x++) {
            for (int y = 0; y < WorldMap.getHeight(); y++) {
                scene.drawImage(PixelEqualsSprite(x, y), x * GameData.PixelSize, y * GameData.PixelSize, GameData.PixelSize, GameData.PixelSize, null);

            }
        }
    }
    public BufferedImage PixelEqualsSprite(int x, int y){
        int pixelData  = WorldMap.getRGB(x, y);

        System.out.println((pixelData == Grass.MapColor.hashCode()));
        System.out.println(" TC: " + pixelData + " : MC: " + Grass.MapColor);

        if(pixelData == Grass.MapColor.hashCode()) {
            System.out.println("Grass");
            return Grass.image;
        }
        if(pixelData == Dirt.MapColor.hashCode()) {
            System.out.println("Dirt");
            return Dirt.image;
        }
        if(pixelData == Water.MapColor.hashCode()){
            System.out.println("Water");
            return Water.image;
        }
        return Flower.image;

    }
}
