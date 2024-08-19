package Interfaces;

import Debugger.Logger;
import Handlers.GameLogicHandler;
import Statics.DebugSettings;
import Statics.GameData;
import enums.LogLevel;
import objects.SizeObjects.Scale;
import objects.SizeObjects.Vector2;
import objects.Tiles.Tile;
import objects.Tiles.TilePallet;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class SceneMapLoader {

    public TilePallet Pallet = new TilePallet();
    BufferedImage WorldMap;

    public SceneMapLoader(String MapPath, String TileMapPath){
        try {
            BufferedImage TileMap = ImageIO.read(new File(TileMapPath));

            WorldMap = ImageIO.read(new File(MapPath));

            LoadTiles(TileMap);
            LoadAnimatedTiles(TileMap);

        }catch (IOException ex) {
            Logger.Log(LogLevel.Error, "Error SceneLoader" + ex.getCause());
            ex.printStackTrace();
        }
    }

    public abstract void LoadTiles(BufferedImage TileMap);
    public abstract void LoadAnimatedTiles(BufferedImage TileMap);

    public Tile[][] GetMapTiles(float CamX, float CamY) {
        GameLogicHandler.SetPositionStartRender(new Vector2(CamX, CamY));
        float posX = CamX / GameData.PixelSize;
        float posY = CamY / GameData.PixelSize;

        int WindowWidth = ((int)GameData.WindowSize.GetWidth() / GameData.PixelSize) + 4;
        int WindowHeight = ((int)GameData.WindowSize.GetHeight() / GameData.PixelSize) + 4;


        BufferedImage MapPiece = WorldMap.getSubimage((int)posX, (int)posY, WindowWidth, WindowHeight);
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

    public Scale GetSizeMapPixels() {
        return new Scale(WorldMap.getWidth(),WorldMap.getHeight());
    }
}
