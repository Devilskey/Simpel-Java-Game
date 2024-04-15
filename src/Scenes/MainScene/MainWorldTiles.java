package Scenes.MainScene;

import Debuger.DebugWindow;
import Graphical_And_Rendering.ImageHandler;
import Handlers.GameLogicHandler;
import Statics.DebugSettings;
import Statics.GameData;
import objects.SizeObjects.Scale;
import objects.SizeObjects.Vector2;
import objects.Tiles.AnimatedTiles;
import objects.Tiles.Tile;
import objects.Tiles.TilePallet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainWorldTiles {
    public TilePallet Pallet = new TilePallet();
    private String TileMapLocation = "src/assets/test/NewDemoSpriteSheat.png";
    private String MapLocation = "src/Scenes/MainScene/World/Map.png";
    BufferedImage WorldMap;

    public MainWorldTiles(){
        try {
            BufferedImage TileMap = ImageIO.read(new File(TileMapLocation));

            WorldMap = ImageIO.read(new File(MapLocation));

            LoadTiles(TileMap);
            LoadAnimatedTiles(TileMap);

        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Tile[][] GetMapTiles(int CamX, int CamY) {
        GameLogicHandler.SetPositionStartRender(new Vector2(CamX, CamY));
        int posX = CamX / GameData.PixelSize;
        int posY = CamY / GameData.PixelSize;

        int WindowWidth = ((int)GameData.WindowSize.GetWidth() / GameData.PixelSize) + 4;
        int WindowHeight = ((int)GameData.WindowSize.GetHeight() / GameData.PixelSize) + 4;

        BufferedImage MapPiece = WorldMap.getSubimage(posX, posY, WindowWidth, WindowHeight);
        DebugSettings.Map = MapPiece;

        Tile[][] map = new Tile[WindowHeight][WindowWidth];
        for (int x = 0; x < MapPiece.getWidth(); x++) {
            for (int y = 0; y < MapPiece.getHeight(); y++) {
                map[y][x] = Pallet.PixelEqualsSprite(x, y, MapPiece);
            }
        }
        Pallet.SwitchStates();
        return map;
    }

    public Scale GetSizeMapPixels(){
        return new Scale(WorldMap.getWidth(),WorldMap.getHeight());
    }

    public static Vector2 GetCenterFromGrid (){
        int xTiles = GameData.WindowSize.GetWidth() / GameData.PixelSize;
        int yTiles = GameData.WindowSize.GetHeight() / GameData.PixelSize;
        float xMid = xTiles / 2;
        float yMid = yTiles / 2;
        int x = (int)(GameData.PixelSize * xMid);
        int y = (int)(GameData.PixelSize * yMid);

        return new Vector2(x,y);
    }

    private void LoadTiles(BufferedImage TileMap){
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

    private void LoadAnimatedTiles(BufferedImage TileMap){
        AnimatedTiles Water = new AnimatedTiles(3, "Water", new Color(0,0, 255));
        Water.States[0] = ImageHandler.GetAnimatedTile(TileMap, 0, 32);
        Water.States[1] = ImageHandler.GetAnimatedTile(TileMap, 16, 32);
        Water.States[2] = ImageHandler.GetAnimatedTile(TileMap, 32, 32 );

        Pallet.animatedTiles.add(Water);
    }
}