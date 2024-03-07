package objects.Tiles;

import Statics.GameData;

import java.awt.*;

public class AnimatedTiles {
    public Tile[] States;
    public String Name = "";
    public Color MapColor;
    public int FramesPassed = 0;
    public int StateCounter = 0;

    public AnimatedTiles (int MaxStates, String Name, Color MapColor){
        States = new Tile[MaxStates];
        this.MapColor = MapColor;
        this.Name = Name;
    }
    public void NextState(){
        if(GameData.fps * States.length > FramesPassed) {
            FramesPassed++;
            return;
        }
        FramesPassed = 0;

        if (StateCounter < States.length - 1) {
            StateCounter++;
            return;
        }
        StateCounter = 0;
    }
    public Tile GetState(){
        return States[StateCounter];
    }
}
