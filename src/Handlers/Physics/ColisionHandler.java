package Handlers.Physics;

import Debuger.DebugWindow;
import Handlers.GameLogicHandler;
import Statics.GameData;
import enums.MoveTo;
import objects.SizeObjects.Vector2;
import objects.Tiles.Tile;

public class ColisionHandler {
    private static Tile[][] map;
    public static void SetMap(Tile[][] newMap){
        map = newMap;
    }

    public static boolean CanCollideWithTile(Vector2 pos, MoveTo Direction){
        Vector2 screenPos = GameLogicHandler.WorldPositionToScreen(pos);
        int x = (int) (screenPos.GetX() / GameData.PixelSize);
        int y = (int) (screenPos.GetY() / GameData.PixelSize);

        if (Direction == MoveTo.Right)
            x += 1;
        if(Direction == MoveTo.Left && x == 0)
            return true;
        else if (Direction == MoveTo.Left )
            x -= 1;
        if(Direction == MoveTo.Up && y == 0)
            return true;
        if (Direction == MoveTo.Up)
            y -= 1;
        if (Direction == MoveTo.Down)
            y += 1;

        return map[y][x].canCollide;
    }
}
