package objects.Tiles;

import objects.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimationTile {
    public String Name;
    public AnimatedTile image;
    public Vector2 Pos;
    public AnimationTile(String Name, AnimatedTile Image, Vector2 pos){
        this.Name = Name;
        this.Pos = pos;
        this.image = Image;
    }

}
