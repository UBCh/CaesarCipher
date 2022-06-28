package graphicalInterface;

import endgin.Analisator;
import endgin.BruteForse;
import endgin.Key;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFour {
      static JFrame jFrame=getJFrame();
      static JPanel jPanel=new JPanel();

    public static void getPanelFour (){
        jFrame.add(jPanel);
        jPanel.add(new JLabel( "введите зашифрованный текст" ));
        JTextField jTextField1=new JTextField("введите текст",20);
        jPanel.add(jTextField1);
        jPanel.revalidate();
        jPanel.add(new JLabel( "введите кодовое слово" ));
        JTextField jTextField2=new JTextField("кодовое слово",10);
        jPanel.add(jTextField2);
        JButton jButton = new JButton(" включить дешифратор");
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame( ) {
                };
                jFrame.setVisible(true);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.setTitle("ПОЛУЧИТЕ, РАСПИШИТЕСЬ");
                Toolkit toolkit = Toolkit.getDefaultToolkit( );  // инструменты для окна
                Dimension dimension = toolkit.getScreenSize( ); // получаем размер экрана
                jFrame.setBounds(dimension.width / 2 - 500, dimension.height / 2 - 400, 1000, 800);
                String string = jTextField1.getText( );
                String test = jTextField2.getText( );

                jFrame.add(new MyComponents(BruteForse.hakker(string, test)));

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
