package Handlers.Physics;

import Debuger.DebugWindow;
import Entities.Villager;
import Handlers.GameLogicHandler;
import Interfaces.Entity.NPC;
import Statics.Directions.DirectionsVector;
import Statics.GameData;
import abstractions.Entity;
import enums.MoveTo;
import objects.SizeObjects.Vector2;
import objects.Tiles.Tile;

import java.util.Arrays;

public class ColisionHandler {
    private static Tile[][] map;
    private static Entity[] entities;
    private static NPC NearestNPCToPlayer;

    public static void SetMap(Tile[][] newMap){
        map = newMap;
    }

    public static void SetEntities(Entity[] entitieArray){
        entities = entitieArray;
    }

    public static NPC GetNearestNPC(){
        return NearestNPCToPlayer;
    }

    public static void ResetNearestNPC(){
        NearestNPCToPlayer = null;
    }

    public static boolean CanCollide(Vector2 pos, MoveTo Direction){
        Vector2 PositionCollision = new Vector2(pos.GetX(), pos.GetY());

        Vector2 screenPos = GameLogicHandler.WorldPositionToScreen(pos);
        int x = (int) (screenPos.GetX() / GameData.PixelSize);
        int y = (int) (screenPos.GetY() / GameData.PixelSize);

        if (Direction == MoveTo.Right)
            x += 1;
        if(Direction == MoveTo.Left && x == 0) {
            return true;
        }
        else if (Direction == MoveTo.Left ) {
            x -= 1;
        }
        if(Direction == MoveTo.Up && y == 0) {
            return true;
        }
        if (Direction == MoveTo.Up)
            y -= 1;
        if (Direction == MoveTo.Down)
            y += 1;

        boolean TileCollision = map[y][x].canCollide;

        PositionCollision.AddVector(DirectionsVector.MoveToVector2(Direction));

        boolean EntityCollision = Arrays.stream(entities)
                .anyMatch(entity -> {
                    if(entity.IsPlayer)
                        return false;

                    if(entity.Position.GetX() == PositionCollision.GetX() && entity.Position.GetY() == PositionCollision.GetY()) {
                        if(entity instanceof NPC && NearestNPCToPlayer == null)
                            NearestNPCToPlayer = (NPC) entity;

                        return true;
                    }
                    return false;
                });
        return (TileCollision || EntityCollision);
    }
}