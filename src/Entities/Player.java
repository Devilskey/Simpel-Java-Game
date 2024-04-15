package Entities;

import Debuger.DebugWindow;
import Graphical_And_Rendering.WindowHandler;
import Handlers.KeyboardHandler;
import Scenes.MainScene.MainWorldTiles;
import Statics.DebugSettings;
import Statics.GameData;
import abstractions.Entity;
import enums.MoveTo;
import objects.SizeObjects.Scale;
import objects.SizeObjects.Vector2;
import objects.Tiles.AnimatedTiles;
import objects.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    public int FramesPassed = 0;
    public int StateCounter = 0;
    private final float MovementSpeed = 100;
    private MoveTo moveDirection = MoveTo.none;
    public int AnimationState = 0;
    public Vector2 MoveToPosition;
    public Player() {
        super("src/assets/test/WorstSpriteSheetEver.png");
        //World Position not screen position
        Position = new Vector2(0, 0);
        Size = new Scale(GameData.PixelSize, GameData.PixelSize);
        SpriteHandler.SetAnimationState(0, 2);
        SpriteHandler.SetAnimationState(1, 2);
        MoveToPosition = new Vector2(0, 0);
        CanMove = true;
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
        if(moveDirection == MoveTo.none) {
            if (KeyboardHandler.Key_A && !ObstacleLeft) {
                MoveToPosition.addX(-GameData.PixelSize);
                moveDirection = MoveTo.Left;
                return;
            }
            if (KeyboardHandler.Key_D  && !ObstacleRight) {
                MoveToPosition.addX(GameData.PixelSize);
                moveDirection = MoveTo.Right;
                return;
            }
            if (KeyboardHandler.Key_S  && !ObstacleDown) {
                MoveToPosition.addY(GameData.PixelSize);
                moveDirection = MoveTo.Down;
                return;
            }
            if (KeyboardHandler.Key_W && !ObstacleUp) {
                MoveToPosition.addY(-GameData.PixelSize);
                moveDirection = MoveTo.Up;

            }
        }else{
            MoveToNextPosition();
        }
    }
    public void MoveToNextPosition(){
       if(CheckIftheSamePosition(Position, MoveToPosition)) {
            moveDirection = MoveTo.none;
            return;
        }
        //D
        if(moveDirection == MoveTo.Right ){
            Position.addX((MovementSpeed / GameData.fps));
        }
        //A
        if(moveDirection == MoveTo.Left){
            Position.addX(-(MovementSpeed / GameData.fps));
        }
        //S
        if(moveDirection == MoveTo.Down){
            Position.addY((MovementSpeed / GameData.fps));
        }
        //W
        if(moveDirection == MoveTo.Up){
            Position.addY(-(MovementSpeed / GameData.fps));
        }
    }
    public boolean CheckIftheSamePosition(Vector2 PlayerPosition, Vector2 MoveToPosition){
        if((int)PlayerPosition.GetX() == (int)MoveToPosition.GetX())
            if((int)PlayerPosition.GetY() == (int)MoveToPosition.GetY())
                return true;
        return false;
    }

    @Override
    public void Update() {
        MovePlayer();
    }
}
