package Entities;

import Debuger.DebugWindow;
import Handlers.KeyboardHandler;
import Scenes.MainScene.MainWorldTiles;
import Statics.GameData;
import abstractions.Entity;
import objects.SizeObjects.Scale;
import objects.SizeObjects.Vector2;
import objects.Tiles.AnimatedTiles;
import objects.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    public int FramesPassed = 0;
    public int StateCounter = 0;
    private final float MovementSpeed = 200;

    public int AnimationState = 0;
    public Player() {
        super("src/assets/test/WorstSpriteSheetEver.png");
        //World Position not screen position
        Position = new Vector2(128, 64);
        Size = new Scale(GameData.PixelSize, GameData.PixelSize);
        SpriteHandler.SetAnimationState(0, 2);
        SpriteHandler.SetAnimationState(1, 2);
    }
    @Override
    public BufferedImage renderSprite(){
        SwitchSprite();
        return SpriteHandler.GiveSprite(AnimationState, StateCounter);
    }

    public void SwitchSprite (){
        int lenght = SpriteHandler.GetSpriteStateAmount(0);

        if(GameData.fps * lenght > FramesPassed) {
            FramesPassed++;
        }else {
            FramesPassed = 0;
            if (StateCounter < lenght - 1) {
                StateCounter++;
            }
            else {
                StateCounter = 0;
            }
        }
    }

    @Override
    public void Start() {

    }

    public void MovePlayer(){
        if (KeyboardHandler.Key_A && Position.GetX() > 64) {
            Position.addX(-(MovementSpeed / GameData.fps));
            AnimationState = 1;
        } else if (KeyboardHandler.Key_D ) {
            Position.addX((MovementSpeed / GameData.fps));
            AnimationState = 1;
        } else if (KeyboardHandler.Key_S) {
            Position.addY(MovementSpeed / GameData.fps);
            AnimationState = 1;
        } else if (KeyboardHandler.Key_W && Position.GetY() > 64 ) {
            DebugWindow.log(Position.GetY() + "");
            Position.addY(-(MovementSpeed / GameData.fps));
            AnimationState = 1;
        }else
            AnimationState = 0;
    }

    @Override
    public void Update() {
        MovePlayer();
    }
}
