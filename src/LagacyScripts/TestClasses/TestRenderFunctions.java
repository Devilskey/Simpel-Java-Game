package LagacyScripts.TestClasses;

import Statics.GameData;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class TestRenderFunctions {
    public static void GiveMeCOLOR(BufferedImage SceneImg, int[][] PixelArray) {
        Graphics scenegraphics = SceneImg.getGraphics();
        Random rand = new Random();
        for (int i = 0; i < PixelArray.length; i++) {
            for (int j = 0; j < PixelArray.length; j++) {
                scenegraphics.setColor(new Color( rand.nextInt(255), rand.nextInt(255),  rand.nextInt(255)));
                scenegraphics.fillRect(i * GameData.PixelSize, j * GameData.PixelSize, GameData.PixelSize, GameData.PixelSize);
            }
        }
    }
    public static void RandomTileUse(BufferedImage SceneImg, int[][] PixelArray, BufferedImage[] TileMap) {
        Graphics scenegraphics = SceneImg.getGraphics();
        Random rand = new Random();
        for (int i = 0; i < PixelArray.length; i++) {
            for (int j = 0; j < PixelArray.length; j++) {
                scenegraphics.drawImage(TileMap[rand.nextInt(TileMap.length)], i * GameData.PixelSize, j * GameData.PixelSize, GameData.PixelSize, GameData.PixelSize, null);
            }
        }
    }

   public void TileLine(BufferedImage SceneImg, int[][] PixelArray, BufferedImage[] TileMap) {
        Graphics scenegraphics = SceneImg.getGraphics();
        Random rand = new Random();
        for (int i = 0; i < PixelArray.length; i++) {
            int randomTile = rand.nextInt(TileMap.length);
            for (int j = 0; j < PixelArray.length; j++) {
                scenegraphics.drawImage(TileMap[randomTile], j * GameData.PixelSize, i * GameData.PixelSize, GameData.PixelSize, GameData.PixelSize, null);
            }
        }
    }
}
