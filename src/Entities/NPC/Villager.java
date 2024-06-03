package Entities.NPC;

import Interfaces.Entity.NPC;
import Handlers.Files.ScriptsHandler;
import Statics.GameData;
import abstractions.Entity;
import objects.SizeObjects.Scale;
import objects.SizeObjects.Vector2;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Villager extends Entity implements NPC {
    private String PathTextFile = "";
    private String[] Lines = new String[0];
    private int OutputNumber = 0;

    public Villager(Vector2 pos, String TextFilePath) {
        super("src/Assets/test/WorstSpriteSheetEver.png");
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
            String[] NewLines = ScriptsHandler.GetNPCScript("src/Assets/Scripts/VillagerHenk.txt");
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
