package engine.Handlers.Peripherals;

import Statics.Input;
import engine.Debugger.Logger;
import engine.Enums.LogLevel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInputHandler extends JFrame implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
       int pressed = e.getButton();
       System.out.println(pressed);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int input = e.getButton();
        switch (input){
            case 1:
                Input.Mouse_Left = true;
                break;
            case 2:
                Input.Mouse_Middle = true;
                break;
            case 3:
                Input.Mouse_Right = true;
                break;
            default:
                Logger.Log(LogLevel.Debug, "How did you manage");
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int input = e.getButton();
        switch (input){
            case 1:
                Input.Mouse_Left = false;
                break;
            case 2:
                Input.Mouse_Middle = false;
                break;
            case 3:
                Input.Mouse_Right = false;
                break;
            default:
                Logger.Log(LogLevel.Debug, "How did you manage");
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
