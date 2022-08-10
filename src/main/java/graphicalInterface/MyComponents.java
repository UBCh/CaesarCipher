package graphicalInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class MyComponents extends JComponent {
    String text;

    public MyComponents(String text) {
        this.text = text;
    }

    protected void paintComponent(Graphics g) {
        Font font = new Font("Calibri Light", Font.BOLD, 25);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setFont(font);
        graphics2D.drawString(text,10,50);
        Line2D line2D = new Line2D.Double(0, 55, 1090, 55);
        graphics2D.draw(line2D);


    }

}
