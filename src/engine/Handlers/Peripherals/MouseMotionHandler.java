package engine.Handlers.Peripherals;

import engine.Objects.SizeObjects.Scale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionHandler extends JFrame  implements MouseMotionListener {
    public static Scale MousePosition = new Scale(0,0);

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
       Point point = e.getPoint();
       MousePosition = new Scale(point.x, point.y);
    }
}
