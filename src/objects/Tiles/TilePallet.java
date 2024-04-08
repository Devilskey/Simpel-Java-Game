package objects.Tiles;

import Statics.DebugSettings;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TilePallet {
    public Tile VoidTile;
    public ArrayList<Tile> tiles = new ArrayList<Tile>();
    public ArrayList<AnimatedTiles> animatedTiles = new ArrayList<AnimatedTiles>();

    public Tile PixelEqualsSprite(int x, int y, BufferedImage PieceMap){
        int pixelData  = PieceMap.getRGB(x, y);

        for(AnimatedTiles tile: animatedTiles){
            if(pixelData == tile.MapColor.hashCode()) {
                return tile.GetState();
            }
        }

        for(Tile tile: tiles){
            if(pixelData == tile.MapColor.hashCode()) {
                return tile;
            }
        }
        return VoidTile;
    }

    public void SwitchStates(){
        for(AnimatedTiles tile: animatedTiles){
            tile.NextState();
        }

    }
}
