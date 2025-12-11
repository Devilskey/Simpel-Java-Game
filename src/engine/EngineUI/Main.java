package engine.EngineUI;

import Statics.DebugSettings;
import engine.Debugger.DebugWindow;
import engine.Debugger.Logger;
import engine.Enums.LogLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public String EngineTitle = "";
    public String EngineVersion = "";

    public static void main(String[] args){
        Logger.LoggerInit();
        DebugSettings.StartDebugWindow();
        Logger.Log(LogLevel.Info,"UI Engine Works");
        DebugWindow.log(1);
        // Create the main frame
        JFrame mainFrame = new JFrame("Dockable Panel Example");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 400);
        mainFrame.setLayout(new BorderLayout());

        // Create the docking area (a panel that holds other panels)
        JPanel dockingArea = new JPanel();
        dockingArea.setLayout(new GridLayout(1, 2)); // Holds multiple dockable panels
        dockingArea.setBackground(Color.LIGHT_GRAY);

        // Add docking area to the main frame
        mainFrame.add(dockingArea, BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }
}