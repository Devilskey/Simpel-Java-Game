package engine.Debugger;

import Game.Statics.DebugSettings;
import Game.Statics.GameData;

public class DebugCMD {
    public static void CMD (String cmdText){
        switch (cmdText){
            case "get-fps":
                DebugWindow.log(String.valueOf(GameData.fps));
                break;
            case "dump-game-data":
                DebugWindow.log(" GameData dump: \n SpriteSize: " + GameData.SpriteSize +
                        "\n Sprite or Tile To Screen (pixel Size) " + GameData.PixelSize +
                        "\n WindowSize: " + GameData.WindowSize.print() +
                        "\n FPS: " + GameData.fps +
                        "\n TICKS: " + GameData.MS_PER_TICK
                );
                break;
            case "dump-debug-settings":
                DebugWindow.log(" Debug Settings dump: \n Use Debug window: " + DebugSettings.UseDebugWindow +
                        "\n Pixel color equals tile: " + DebugSettings.DebugPixelEqualsTile);
                break;
            case "fuck":
                DebugWindow.log("FUCK YOU");
                break;
            case "render-map-piece":
                DebugSettings.RenderMap = !DebugSettings.RenderMap;
                break;
            case "test-write-log":
                Logger.LogDebug("Testing debug log");
                break;
            default:
                DebugWindow.log("No CMD FOUND");
                break;

        }
    }
}
