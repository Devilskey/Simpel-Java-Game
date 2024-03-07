package Scenes.MainScene;

import Graphical_And_Rendering.ImageHandler;
import Statics.DebugSettings;
import Statics.GameData;
import objects.SizeObjects.Scale;
import objects.Tiles.AnimatedTiles;
import objects.Tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainWorldTiles {
    public Tile Grass;
    public Tile Dirt;
    public AnimatedTiles Water;
    public Tile Flower;
    private String TileMapLocation = "src/assets/test/WorstSpriteSheetEver.png";
    private String MapLocation = "src/Scenes/MainScene/World/Map.png";
    BufferedImage WorldMap;

    public MainWorldTiles(){
        try {
            BufferedImage TileMap = ImageIO.read(new File(TileMapLocation));
            Water = new AnimatedTiles(3, "Water", new Color(0,0, 255));

            WorldMap = ImageIO.read(new File(MapLocation));

            Grass = ImageHandler.GetTile(TileMap, 0, 0, "Grass",  new Color(0, 255, 0)); //#008000
            Dirt = ImageHandler.GetTile(TileMap, 0, 16, "Dirt", new Color(255, 200, 0)); //#FFA500

            Water.States[0] = ImageHandler.GetAnimatedTile(TileMap, 16, 16); //#0000FF
            Water.States[1] = ImageHandler.GetAnimatedTile(TileMap, 0, 32); //#0000FF
            Water.States[2] = ImageHandler.GetAnimatedTile(TileMap, 16, 32 ); //#0000FF

            GameData.Saved = TileMap;

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

        int WindowWidth = ((int)GameData.WindowSize.GetWidth() / GameData.PixelSize) + 4;
        int WindowHeight = ((int)GameData.WindowSize.GetHeight() / GameData.PixelSize) + 4;

        BufferedImage MapPiece = WorldMap.getSubimage(posX, posY, WindowWidth, WindowHeight);

        Tile[][] map = new Tile[WindowHeight][WindowWidth];
        for (int x = 0; x < MapPiece.getWidth(); x++) {
            for (int y = 0; y < MapPiece.getHeight(); y++) {
                map[y][x] = PixelEqualsSprite(x, y, MapPiece);
            }
        }
        Water.NextState();
        return map;
    }

    public Scale GetSizeMapPixels(){
        return new Scale(WorldMap.getWidth(),WorldMap.getHeight());
    }
    public Tile PixelEqualsSprite(int x, int y, BufferedImage PieceMap){
        int pixelData  = PieceMap.getRGB(x, y);

        if(DebugSettings.DebugPixelEqualsTile) {
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
            return Water.GetState();
        }
        return Flower;
    }

}
