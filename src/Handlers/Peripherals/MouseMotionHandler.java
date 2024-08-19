package Handlers.Peripherals;

import objects.SizeObjects.Scale;
import objects.SizeObjects.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

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
