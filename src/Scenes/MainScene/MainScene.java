package Scenes.MainScene;

import Entities.NPC.Villager;
import Handlers.Physics.ColisionHandler;
import abstractions.Scene;
import abstractions.Entity;
import enums.MoveTo;
import objects.Camera;
import Entities.Player;
import objects.SizeObjects.Scale;
import objects.Tiles.Tile;
import objects.SizeObjects.Vector2;

import javax.swing.text.Position;

public class MainScene extends Scene {

    private final MainWorldTiles WorldTile;

    private Camera cam ;

    public MainScene(){
        super();
        WorldTile = new MainWorldTiles();

        Scale MapSize = WorldTile.GetSizeMapPixels();
        cam = new Camera(new Vector2 (0,0),
                200,
                (int)MapSize.GetWidth() ,
                (int)MapSize.GetHeight());

        Entities.add(new Player());
        Entities.add(new Villager(new Vector2(64, 64),
                "src/assets/Scripts/VillagerHenk.txt"));
    }

    @Override
    public void RenderScene(){
        PixelArray = WorldTile.GetMapTiles(cam.pos.GetX(),cam.pos.GetY());
    }

    @Override
    public void Update(){
        PositionInScene = cam.pos;
        cam.MoveWithEntitie(Entities.getFirst().Position);

    }
}
