package engine.Graphical_And_Rendering;

import Game.Statics.GameData;
import engine.Objects.Tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHandler {

    public static BufferedImage GetImage(String path){
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }

    public static Tile GetTile(BufferedImage tileMap, int x, int y, String Name, Color TileColor, boolean canCollide){
        Tile newTile = new Tile();
        newTile.image = tileMap.getSubimage(x, y, GameData.SpriteSize, GameData.SpriteSize);
        newTile.Name = Name;
        newTile.MapColor = TileColor;
        newTile.canCollide = canCollide;
        return newTile;
    }

    public static Tile GetAnimatedTile(BufferedImage tileMap, int x, int y){
        Tile newTile = new Tile();
        newTile.image = tileMap.getSubimage(x, y, GameData.SpriteSize, GameData.SpriteSize);
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
