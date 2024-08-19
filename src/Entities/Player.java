package Entities;

import Handlers.Peripherals.KeyboardHandler;
import Handlers.Physics.ColisionHandler;
import Interfaces.Entity.NPC;
import Statics.GameData;
import Statics.Input;
import abstractions.Entity;
import enums.MoveTo;
import objects.SizeObjects.Scale;
import objects.SizeObjects.Vector2;

import java.awt.image.BufferedImage;

public class Player extends Entity {
    public int FramesPassed = 0;
    public int StateCounter = 0;
    private MoveTo moveDirection = MoveTo.none;
    public int AnimationState = 0;
    public Vector2 MoveToPosition;
    public NPC NearNPC;
    private boolean TalkState;

    public Player() {
        super("src/Assets/test/WorstSpriteSheetEver.png");
        //World Position not screen position
        Position = new Vector2(0, 0);
        Size = new Scale(GameData.PixelSize, GameData.PixelSize);
        SpriteHandler.SetAnimationState(0, 2);
        SpriteHandler.SetAnimationState(1, 2);
        MoveToPosition = new Vector2(0, 0);
        CanMove = true;
        IsPlayer = true;
    }

    @Override
    public BufferedImage renderSprite(){
        SwitchSprite();
        return SpriteHandler.GiveSprite(AnimationState, StateCounter);
    }

    public void SwitchSprite (){
        int length = SpriteHandler.GetSpriteStateAmount(0);

        if(GameData.fps * length > FramesPassed) {
            FramesPassed++;
        }else {
            FramesPassed = 0;
            if (StateCounter < length - 1) {
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
            if (Input.Key_A && !ObstacleLeft) {
                MoveToPosition.addX(-GameData.PixelSize);
                moveDirection = MoveTo.Left;
                return;
            }
            if (Input.Key_D  && !ObstacleRight) {
                MoveToPosition.addX(GameData.PixelSize);
                moveDirection = MoveTo.Right;
                return;
            }
            if (Input.Key_S  && !ObstacleDown) {
                MoveToPosition.addY(GameData.PixelSize);
                moveDirection = MoveTo.Down;
                return;
            }
            if (Input.Key_W && !ObstacleUp) {
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
        float movementSpeed = 90;
        if(moveDirection == MoveTo.Right ){
            Position.addX((movementSpeed / GameData.fps));
        }
        //A
        if(moveDirection == MoveTo.Left){
            Position.addX(-(movementSpeed / GameData.fps));
        }
        //S
        if(moveDirection == MoveTo.Down){
            Position.addY((movementSpeed / GameData.fps));
        }
        //W
        if(moveDirection == MoveTo.Up){
            Position.addY(-(movementSpeed / GameData.fps));
        }
    }
    public boolean CheckIftheSamePosition(Vector2 PlayerPosition, Vector2 MoveToPosition){
        if((int)PlayerPosition.GetX() == (int)MoveToPosition.GetX())
            if((int)PlayerPosition.GetY() == (int)MoveToPosition.GetY()) {
                Position.SetX((int)MoveToPosition.GetX());
                Position.SetY((int)MoveToPosition.GetY());
                return true;
            }
        return false;
    }

    public void TalkToNPC(){
        // Using talk state we can force the Speak Methode to be a boolean that returns true when the chat is done
        // Using this we can have multiple text piece after each other and we need to press a button like the space bar to get
        // Through all the diffrent text bubbles.
         NearNPC = ColisionHandler.GetNearestNPC();

        if(NearNPC != null && (Input.Button_Spacebar || TalkState)) {
            TalkState = NearNPC.Speak();
        }else if(Input.Button_Spacebar ){
                System.out.println("No NPC");
        }
    }

    @Override
    public void Update() {
        TalkToNPC();
        MovePlayer();
    }
}
