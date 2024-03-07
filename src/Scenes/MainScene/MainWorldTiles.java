package Scenes.MainScene;

import Graphical_And_Rendering.Tiles.ImageHandler;
import Statics.Debug;
import Statics.GameData;
import objects.Tile;
import objects.SizeObjects.Vector2;

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

            Water = ImageHandler.GetTile(TileMap, 16, 16, "Water", new Color(0,0, 255)); //#0000FF
            Flower = ImageHandler.GetTile(TileMap, 16, 0, "Flower", Color.BLUE); //#0000FF


        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Tile[][] GetMapTiles(int CamX, int CamY) {
        int posX = CamX / GameData.PixelSize;
        int posY = CamY / GameData.PixelSize;

        if(posX <= 0)
            posX = 1;
        if(posY <= 0)
            posY = 1;

        int WindowWidth = ((int)GameData.WindowSize.GetX() / GameData.PixelSize) + 4;
        int WindowHeight = ((int)GameData.WindowSize.GetY() / GameData.PixelSize) + 4;

        BufferedImage MapPiece = WorldMap.getSubimage(posX, posY, WindowWidth, WindowHeight);

        Tile[][] map = new Tile[WindowHeight][WindowWidth];
        for (int x = 0; x < MapPiece.getWidth(); x++) {
            for (int y = 0; y < MapPiece.getHeight(); y++) {
                map[y][x] = PixelEqualsSprite(x, y, MapPiece);
            }
        }

        return map;
    }

    public Vector2 GetSizeMapPixels(){
        return new Vector2(0,0);
    }
    public Tile PixelEqualsSprite(int x, int y, BufferedImage PieceMap){
        int pixelData  = PieceMap.getRGB(x, y);

        if(Debug.DebugPixelEqualsTile) {
            System.out.println((pixelData == Grass.MapColor.hashCode()));
            System.out.println(" TC: " + pixelData + " : MC: " + Grass.MapColor);
        }

        if(pixelData == Grass.MapColor.hashCode()) {
            return Grass;
        }
        if(pixelData == Dirt.MapColor.hashCode()) {
            return Dirt;
        }
        if(pixelData == Water.MapColor.hashCode()){
            return Water;
        }
        return Flower;
    }

}
