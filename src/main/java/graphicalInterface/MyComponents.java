package graphicalInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.MalformedURLException;
import java.net.URL;

public class MyComponents extends JComponent {
    String text;

    public MyComponents(String text) {
        this.text = text;
    }

    protected void paintComponent(Graphics g) {
       Font font=new Font("Calibri Light",Font.BOLD,25);
      Graphics2D graphics2D=(Graphics2D)g;
      graphics2D.setFont(font);
       graphics2D.drawString(text,10,50);
       Line2D line2D=new Line2D.Double( 0,55,1090,55 );
       graphics2D.draw(line2D);
                JPanel jPanel=new JPanel();
          jPanel.add(new JButton( "нажми на кнопку" ));




    }
}
