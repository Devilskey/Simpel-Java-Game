package Game.Entities.NPC;

import Game.Entity.NPC;
import engine.Handlers.Files.ScriptsHandler;
import Game.Statics.GameData;
import engine.abstractions.Entity;
import engine.Objects.SizeObjects.Scale;
import engine.Objects.SizeObjects.Vector2;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Villager extends Entity implements NPC {
    private String PathTextFile = "";
    private String[] Lines = new String[0];
    private int OutputNumber = 0;

    public Villager(Vector2 pos, String TextFilePath) {
        super("src/Game/Assets/test/WorstSpriteSheetEver.png");
        Position = pos;
        Size = new Scale(GameData.PixelSize, GameData.PixelSize);
        SpriteHandler.SetAnimationState(0, 1);
        IsPlayer = false;
        Start();
    }

    @Override
    public BufferedImage renderSprite() {
        return SpriteHandler.GiveSprite(0, 0);
    }

    @Override
    public void Start() {
        try {
            String[] NewLines = ScriptsHandler.GetNPCScript("src/Game/Assets/Scripts/VillagerHenk.txt");
            System.out.println(NewLines[0]);
            Lines = NewLines;

        }catch (IOException ex)
        {
            System.out.println(ex.getCause());
        }
    }

    @Override
    public void Update() {
    }

    @Override
    public boolean Speak() {
        System.out.println(Lines[OutputNumber % 4] + " i count: " + OutputNumber + " State Spacebar: ");
        OutputNumber ++;
        return false;
    }
}
