package BoredGame.Scenes.OverWorld;

import engine.abstractions.SceneMapLoader;

import java.awt.image.BufferedImage;

public class OverworldTileSet extends SceneMapLoader {


    public OverworldTileSet(String MapPath, String TileMapPath) {
        super(MapPath, TileMapPath);
    }

    @Override
    public void LoadTiles(BufferedImage TileMap) {

    }

    @Override
    public void LoadAnimatedTiles(BufferedImage TileMap) {

    }
}
