package Statics;

import Debuger.DebugWindow;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class DebugSettings {
    public static boolean DebugPixelEqualsTile = false;

    public static boolean RenderMap = true;

    public static BufferedImage Map;
    public static boolean UseDebugWindow = true;

    public static void StartDebugWindow(){
        if(DebugSettings.UseDebugWindow) {
            SwingUtilities.invokeLater(DebugWindow::new);
            DebugWindow.log("Window Opened");
        }
    }

}
