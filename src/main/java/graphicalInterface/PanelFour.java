package graphicalInterface;

import dao.StrimDao;
import endgin.BruteForse;
import exception.SymbolNotFoundException;
import exception.TextNotFoundException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PanelFour {
      static JFrame jFrame=getJFrame();
      static JPanel jPanel=new JPanel();

    public static void getPanelFour () {
        jFrame.add(jPanel);
//        jPanel.add(new JLabel( "введите зашифрованный текст" ));
//        JTextField jTextField1=new JTextField("введите текст",20);
//        jPanel.add(jTextField1);
//        jPanel.revalidate();
        jPanel.add(new JLabel("введите кодовое слово"));
        JTextField jTextField2 = new JTextField(10);
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
                String string = null;
                try {
                    string = StrimDao.inputFiles( );
                } catch (IOException | TextNotFoundException ex) {
                    ex.printStackTrace( );
                }
                String test = jTextField2.getText( );
                String itog = null;
                try {
                    itog = BruteForse.hakker(string, test);
                } catch (SymbolNotFoundException ex) {
                    ex.printStackTrace( );
                }
                jFrame.add(new MyComponents(itog));
                try {
                    StrimDao.outputFiles(itog);
                } catch (IOException ex) {
                    ex.printStackTrace( );
                }
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
