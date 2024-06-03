package objects.Sprites;

import Debugger.DebugWindow;
import Statics.GameData;

import java.awt.image.BufferedImage;

public class Sprites {
    private int MaxAnimationStates = 0;
    private int MaxSpriteStates = 0;
    //Animation state || Sprite State
    BufferedImage Spritesheet;
    private BufferedImage[][] Sprites;
    public Sprites(BufferedImage Spritesheet) {
        this.Spritesheet = Spritesheet;
        MaxAnimationStates = Spritesheet.getHeight() / GameData.SpriteSize;
        MaxSpriteStates = Spritesheet.getWidth() / GameData.SpriteSize;

        //Set size of sprites Just in case the user will forget it
        Sprites = new BufferedImage[MaxAnimationStates][MaxSpriteStates];

        DebugWindow.log("Player Sprite Data:  \n Max Sprites States : " + MaxSpriteStates + " \n Max Animation State : " + MaxAnimationStates);
    }
    // Animations Are being pulled from the give spritesheet
    // this wil have the effect that i need the row and the amount of sprites
    // this because not animation wil have the same amount of sprites in the animation
    public void SetAnimationState(int Row, int SpriteAmount){
        Sprites[Row] = new BufferedImage[SpriteAmount];
        for(int i = 0; i < SpriteAmount; i++){
            Sprites[Row][i] = Spritesheet.getSubimage(i * GameData.SpriteSize, Row * GameData.SpriteSize, GameData.SpriteSize, GameData.SpriteSize);
        }
    }
    public int GetAnimationStateAmount(){
        return Sprites.length;
    }

    public int GetSpriteStateAmount(int AnimationState){
        return Sprites[AnimationState].length;
    }

    public BufferedImage GiveSprite(int AnimationState, int SpriteState){
        return Sprites[AnimationState][SpriteState];
    }
}
