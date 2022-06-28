package graphicalInterface;

import endgin.Analisator;
import endgin.Key;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOne {
      static JFrame jFrame=getJFrame();
      static JPanel jPanel=new JPanel();

    public static void getPanelOne (){
        jFrame.add(jPanel);
        jPanel.add(new JLabel( "введите текст" ));
        JTextField jTextField1=new JTextField("введите текст",20);
        jPanel.add(jTextField1);
        jPanel.revalidate();
        jPanel.add(new JLabel( "введите ключ" ));
        JTextField jTextField2=new JTextField("введите ключ",10);
        jPanel.add(jTextField2);
        JButton jButton = new JButton(" включить шифратор");
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                Key.setKey(Integer.parseInt(jTextField2.getText()));

                JFrame jFrame = new JFrame( ) {
                };
                jFrame.setVisible(true);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.setTitle("ПОЛУЧИТЕ, РАСПИШИТЕСЬ");
                Toolkit toolkit = Toolkit.getDefaultToolkit( );  // инструменты для окна
                Dimension dimension = toolkit.getScreenSize( ); // получаем размер экрана
                jFrame.setBounds(dimension.width / 2 - 500, dimension.height / 2 - 400, 1000, 800);
                jFrame.add(new MyComponents(Analisator.analisatorText(jTextField1.getText( ))));

            }
        });


    }











   static JFrame getJFrame(){

       JFrame jFrame = new JFrame( ) {
       };
       jFrame.setVisible(true);
       jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jFrame.setTitle("ЗАДАЙТЕ КЛЮЧ И ВВЕДИТЕ ТЕКСТ");
       Toolkit toolkit = Toolkit.getDefaultToolkit( );  // инструменты для окна
       Dimension dimension = toolkit.getScreenSize( ); // получаем размер экрана
       jFrame.setBounds(dimension.width / 2 - 500, dimension.height / 2 - 400, 1000, 800);
       return jFrame;
   }

}
