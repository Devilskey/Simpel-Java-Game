package Debuger;

import Statics.GameData;

public class DebugCMD {
    public static void CMD (String cmdText){
        switch (cmdText){
            case "get-fps":
                DebugWindow.log(String.valueOf(GameData.fps));
                break;
        }
    }
}
