package graphicalInterface;

import endgin.Analisator;
import endgin.BruteForse;
import endgin.Key;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelThree {
      static JFrame jFrame=getJFrame();
      static JPanel jPanel=new JPanel();

    public static void getPanelThree (){
        jFrame.add(jPanel);
        jPanel.add(new JLabel( "введите  текст" ));
        JTextField jTextField1=new JTextField("введите текст",20);
        jPanel.add(jTextField1);
        jPanel.revalidate();
        JButton jButton = new JButton("срочно шифровать");
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
                String tmp1 = BruteForse.cryptographer(jTextField1.getText( ));
                String tmp2 = BruteForse.getСodeWord( );
                jFrame.add(new MyComponents("запомните кодовое слово : "+tmp2 + " ;  Зашифрованный текст :  " +tmp1));

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
