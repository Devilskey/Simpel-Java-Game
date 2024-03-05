package objects.Tiles;

import Statics.GameData;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Dictionary;
import java.util.Enumeration;

public class AnimatedTile {

    public AnimatedTile(int SetArray) {
        AnimationTiles = new BufferedImage[SetArray];
    }

    public int AnimatedCoolDown = 10;
    public BufferedImage[] AnimationTiles;
    int State = 0;
    int FramesPassed;
    public Color MapColor;

    public BufferedImage SwitchState() {
        FramesPassed++;
        if(FramesPassed > GameData.fps / AnimationTiles.length * AnimatedCoolDown) {
            if (State < AnimationTiles.length) {
                State++;
            }
            if (State == AnimationTiles.length) {
                State = 0;
            }
            FramesPassed = 0;
        }
        return AnimationTiles[State];

    }
}
