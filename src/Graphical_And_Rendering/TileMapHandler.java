package Graphical_And_Rendering;

import Statics.GameData;
import Statics.TileSetData;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class TileMapHandler {

    public static BufferedImage[] Titlemap = new BufferedImage[0];

    public static BufferedImage GetSprite(BufferedImage tileMap) {

        return tileMap.getSubimage(376,326,102,102);
    }

    public static void LoadTileMapToTileData(BufferedImage tileMap){
        int index = 0;
        System.out.println(index);
        int Tiles = (tileMap.getHeight() / 16) * (tileMap.getWidth() / 16);
        Titlemap = new BufferedImage[Tiles];

        for (int i = 0; i  < tileMap.getHeight() / 16; i++ ){
            for (int j = 0; j < tileMap.getWidth()  / 16; j ++ ){
                Titlemap[index] = tileMap.getSubimage(j * 16, i * 16 ,16,16);
                System.out.println(index);
                index++;
            }
        }
    }
}
