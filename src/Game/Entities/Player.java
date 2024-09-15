package Game.Entities;

import engine.Handlers.Physics.CollisionHandler;
import Game.Entity.NPC;
import Game.Statics.GameData;
import Game.Statics.Input;
import engine.abstractions.Entity;
import engine.Enums.MoveTo;
import engine.Objects.SizeObjects.Scale;
import engine.Objects.SizeObjects.Vector2;

import java.awt.image.BufferedImage;

public class Player extends Entity {
    public int FramesPassed = 0;
    public int StateCounter = 0;
    private MoveTo moveDirection = MoveTo.none;
    public int AnimationState = 0;
    public Vector2 MoveToPosition;
    public NPC NearNPC;
    private boolean TalkState;

    public Player(float positionX, float positionY) {
        super("src/Game/Assets/test/WorstSpriteSheetEver.png");
        //World Position not screen position
        Position = new Vector2(positionX, positionY);
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
        float movementSpeed = 100;
            MoveTo Direction = MoveTo.none;
            if (Input.Key_A && !ObstacleLeft) {
                Position.addX(-(movementSpeed / GameData.MS_PER_TICK));
            }
            else if (OverlappingCollisionLeft)
                Position = CollisionPushBack(Position, MoveTo.Left);

            if (Input.Key_D  && !ObstacleRight) {
                Position.addX((movementSpeed / GameData.MS_PER_TICK));
            }
            else if (OverlappingCollisionRight)
               Position = CollisionPushBack(Position, MoveTo.Right);

            if (Input.Key_S  && !ObstacleDown) {
                Position.addY((movementSpeed / GameData.MS_PER_TICK));
            }
            else if(OverlappingCollisionDown)
                Position = CollisionPushBack(Position, MoveTo.Down);

            if (Input.Key_W && !ObstacleUp) {
                Position.addY(-(movementSpeed / GameData.MS_PER_TICK));
            }
            else if(OverlappingCollisionUp) {
                Position = CollisionPushBack(Position, MoveTo.Up);
            }

    }

    public void TalkToNPC(){
        // Using talk state we can force the Speak Methode to be a boolean that returns true when the chat is done
        // Using this we can have multiple text piece after each other and we need to press a button like the space bar to get
        // Through all the diffrent text bubbles.
         NearNPC = CollisionHandler.GetNearestNPC();

        if(NearNPC != null && (Input.Key_Space)) {
            TalkState = NearNPC.Speak();
        }
    }

    @Override
    public void Update() {
        TalkToNPC();
        MovePlayer();
    }
}
