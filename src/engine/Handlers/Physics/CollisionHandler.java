package engine.Handlers.Physics;

import engine.Handlers.GameLogicHandler;
import Game.Entity.NPC;
import Game.Statics.GameData;
import engine.abstractions.Entity;
import engine.Enums.MoveTo;
import engine.Objects.SizeObjects.Vector2;
import engine.Objects.Tiles.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class CollisionHandler {

    private static boolean Run = false;
    private static Tile[][] map;
    private static Entity[] entities;
    private static NPC NearestNPCToPlayer;
    private static String Name = "No grid Collision";

    public static void SetMap(Tile[][] newMap){
        map = newMap;
    }

    public static void SetEntities(ArrayList<Entity> entitiesArray){
        entities = entitiesArray.toArray(new Entity[entitiesArray.size()]);
    }

    public static NPC GetNearestNPC(){
        return NearestNPCToPlayer;
    }

    public static void ResetNearestNPC(){
        NearestNPCToPlayer = null;
    }

    public static boolean CanCollide(Vector2 pos, MoveTo Direction){

        Vector2 PositionCollision = new Vector2(pos.GetX(), pos.GetY());
        PositionCollision.AddVector(DirectionsVector.MoveToVector2(Direction));

        Vector2 screenPos = GameLogicHandler.WorldPositionToScreen(pos);

        return (TileCollision(screenPos, Direction, pos) || EntityCollision(PositionCollision));
    }

    private static Vector2 DirectionAdd(MoveTo Direction){

        Vector2 DirectionGo = new Vector2(0,0);
        switch (Direction){
            case Up -> DirectionGo = new Vector2(0,0);
            case Down -> DirectionGo = new Vector2(0,1);
            case Left -> DirectionGo = new Vector2(0,0);
            case Right -> DirectionGo = new Vector2(1,0);

        }
        return DirectionGo;
    }

    private static boolean CornerCollision1 (MoveTo Direction, float TileX, float TileY, float PlayerXpos, float PlayerYpos){
        boolean IsCollision = false;

        float playerTileX = PlayerXpos / GameData.PixelSize;
        float playerTileY = PlayerYpos / GameData.PixelSize;
        Vector2 CornerTilePosition;
        switch (Direction ){
            case Down, Up:
                CornerTilePosition = new Vector2((TileX * GameData.PixelSize) + GameData.PixelSize, TileY * GameData.PixelSize);
                CornerTilePosition = GameLogicHandler.ScreenPositionToWorld(CornerTilePosition);
                float posX = CornerTilePosition.GetX() - (CornerTilePosition.GetX() % GameData.PixelSize);
                if(posX > PlayerXpos && posX - GameData.PixelSize < PlayerXpos){
                    return map[(int) TileY][(int) TileX + 1].canCollide;
                }
                break;
            case Right,Left:
                CornerTilePosition = new Vector2((TileX * GameData.PixelSize) + GameData.PixelSize, TileY * GameData.PixelSize);
                CornerTilePosition = GameLogicHandler.ScreenPositionToWorld(CornerTilePosition);

                float posY = CornerTilePosition.GetY() - (CornerTilePosition.GetY() % GameData.PixelSize);

                if( GameData.PixelSize + posY > PlayerYpos && posY < PlayerYpos){
                    return map[(int) TileY + 1][(int) TileX].canCollide;
                }
                break;
        }
        return IsCollision;
    }

    private static Boolean TileCollision (Vector2 screenPos, MoveTo Direction, Vector2 WorldPosPlayer){
        //Get Direction where the tile it can collide is stands

        int PlayerTileX = (int) Math.floor((screenPos.GetX() / GameData.PixelSize));
        int PlayerTileY = (int) Math.floor((screenPos.GetY() / GameData.PixelSize)) ;

        int CollisionTileX = (int) DirectionAdd(Direction).GetX() + PlayerTileX ;
        int CollisionTileY = (int) DirectionAdd(Direction).GetY() + PlayerTileY ;

        if(CollisionTileY < 0 || CollisionTileX < 0){
            return false;
        }

        boolean CollisionMainTile =  map[CollisionTileY][CollisionTileX].canCollide;

        boolean CornerCollision = CornerCollision1(Direction, CollisionTileX, CollisionTileY, WorldPosPlayer.GetX(), WorldPosPlayer.GetY());

        // Calculate corner positions relative to the current position
        return (CollisionMainTile ||  CornerCollision);
    }

    private static Boolean EntityCollision ( Vector2 PositionCollision){
        return Arrays.stream(entities)
                .anyMatch(entity -> {
                    if(entity.IsPlayer)
                        return false;

                    if(entity.Position.GetX() < PositionCollision.GetX() && entity.Position.GetX() + 8 > PositionCollision.GetX()) {
                        if(entity.Position.GetY() < PositionCollision.GetY() && entity.Position.GetY() + 8> PositionCollision.GetY()) {
                            if (entity instanceof NPC && NearestNPCToPlayer == null) {
                                NearestNPCToPlayer = (NPC) entity;
                            }
                            return true;
                        }
                    }
                    return false;
                });
    }
}