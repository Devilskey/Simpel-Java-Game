package Statics;

import Debuger.DebugWindow;

import javax.swing.*;

public class DebugSettings {
    public static boolean DebugPixelEqualsTile = false;
    public static boolean UseDebugWindow = true;

    public static void StartDebugWindow(){
        if(DebugSettings.UseDebugWindow) {
            SwingUtilities.invokeLater(DebugWindow::new);
            DebugWindow.log("Window Opend");
        }
    }

}
