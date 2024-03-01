package Graphical_And_Rendering.Tiles;

import Statics.GameData;
import objects.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageHandler {

    public static BufferedImage GetImage(BufferedImage tileMap, int x, int y) {
        return tileMap.getSubimage(x, y, GameData.SpriteSize, GameData.SpriteSize);
    }

    public static Tile GetTile(BufferedImage tileMap, int x, int y, String Name, Color TileColor){
        Tile newTile = new Tile();
        newTile.image = tileMap.getSubimage(x, y, GameData.SpriteSize, GameData.SpriteSize);
        newTile.Name = Name;
        newTile.MapColor = TileColor;
        return newTile;
    }


    public static BufferedImage[] DivideImage(BufferedImage tileMap){
        int index = 0;
        System.out.println(index);
        int Tiles = (tileMap.getHeight() / GameData.SpriteSize) * (tileMap.getWidth() / GameData.SpriteSize);
        BufferedImage[]  Titlemap = new BufferedImage[Tiles];

        for (int i = 0; i  < tileMap.getHeight() / GameData.SpriteSize; i++ ){
            for (int j = 0; j < tileMap.getWidth() / GameData.SpriteSize; j ++ ){
                Titlemap[index] = tileMap.getSubimage(j *  GameData.SpriteSize, i *  GameData.SpriteSize ,GameData.SpriteSize,GameData.SpriteSize);
                System.out.println(index);
                index++;
            }
        }
        return Titlemap;
    }
}
