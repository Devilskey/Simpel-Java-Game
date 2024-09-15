package Game.Scenes.CollisionTestScene;

import Game.Entities.NPC.Villager;
import Game.Entities.Player;
import Game.Scenes.MenuScene.MenuScene;
import Game.Statics.GameData;
import engine.Handlers.Physics.CollisionHandler;
import engine.Handlers.SceneManager;
import engine.UI.Objects.UIElementPanel;
import engine.UI.enums.UIEnum;
import engine.abstractions.Entity;
import engine.abstractions.Scene;
import engine.Enums.MoveTo;
import engine.Objects.Camera;
import engine.Objects.SizeObjects.Scale;
import engine.Objects.SizeObjects.Vector2;
import engine.UI.Objects.UIElementText;

import java.awt.*;

public class CollisionScene extends Scene {

    private final CollisionTilSet WorldTile;

    private Camera cam ;
    public float health = 100;

    private UIElementText TextPos = new UIElementText("X, Y", new Vector2(0,-65), 20, 1, UIEnum.bottomLeft, "Position");
    private UIElementPanel GreenBar = new UIElementPanel(new Vector2(5,5), new Scale((int)health * 2, 20), Color.GREEN, "Green-healthBar");


    public CollisionScene(){
        super();
        WorldTile = new CollisionTilSet();

        Scale MapSize = WorldTile.GetSizeMapPixels();
        cam = new Camera(new Vector2(0,0),
                false);

        float RandomX = 128; // new Random().nextFloat(0, WorldTile.GetSizeMap().GetX());
        float RandomY = 128; // new Random().nextFloat(0, WorldTile.GetSizeMap().GetY());

        Entities.add(new Player(RandomX, RandomY));
        Entities.add(new Villager(new Vector2(64, 64),
                "src/assets/Scripts/VillagerHenk.txt"));

        TextPos.TextContent = "X: 0, Y: 0";
        UI.add( new UIElementPanel(new Vector2(0,0), new Scale(GameData.WindowSize.GetWidth(), 30), Color.white, "InfoPanel"));
        UI.add( new UIElementPanel(new Vector2(5,5), new Scale(200, 20), Color.RED, "Red-healthBar"));
        UI.add( GreenBar);
        UI.add( new UIElementText("Level 1", new Vector2(0,0), 20, 1, UIEnum.topCenter, "Level"));
        UI.add(TextPos);

    }

    @Override
    public void UpdateRender() {
        PixelArray = WorldTile.GetMapTiles(cam.pos.GetX(),cam.pos.GetY());
    }

    @Override
    public void UpdateGameLogic() {
        Collisions();
        health -= 0.1f;
        cam.MoveWithEntitie(Entities.get(0).Position);
        PositionInScene = cam.pos;

        if(health < 0){
            SceneManager.SwitchLoadedScene(new MenuScene());
        }
    }

    @Override
    public void UIUpdate(){
        SetPlayerPositionText();
        GreenBar.setWidth((int)health * 2);

        UI.updateElementByName("Position", TextPos);
    }

    private void SetPlayerPositionText(){
        Entity entity = Entities.get(0);
        if(entity.IsPlayer){
            TextPos.TextContent = "X: " + (int)entity.Position.GetX() + ", Y: " + (int)entity.Position.GetY();
        }
    }

    private void Collisions(){
        CollisionHandler.ResetNearestNPC();
        CollisionHandler.SetMap(PixelArray);
        CollisionHandler.SetEntities(Entities);
        for (Entity entity : Entities) {
            if(entity.CanMove){
                entity.ObstacleUp = CollisionHandler.CanCollide(entity.Position, MoveTo.Up);
                entity.ObstacleDown = CollisionHandler.CanCollide(entity.Position, MoveTo.Down);
                entity.ObstacleLeft = CollisionHandler.CanCollide(entity.Position, MoveTo.Left);
                entity.ObstacleRight = CollisionHandler.CanCollide(entity.Position, MoveTo.Right);
            }
            entity.Update();
            if(entity instanceof Player)
                ((Player) entity).NearNPC = CollisionHandler.GetNearestNPC();
        }
    }
}