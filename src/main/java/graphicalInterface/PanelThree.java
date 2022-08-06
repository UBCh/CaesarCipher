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

public class PanelThree {
      static JFrame jFrame=getJFrame();
      static JPanel jPanel=new JPanel();

    public static void getPanelThree () {
        jFrame.add(jPanel);
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
                BruteForse bruteForse = new BruteForse( );
                String tmp1 = null;
                try {
                    tmp1 = BruteForse.cryptographer(StrimDao.inputFiles( ));
                } catch (IOException ex) {
                    ex.printStackTrace( );
                } catch (SymbolNotFoundException ex) {
                    ex.printStackTrace( );
                } catch (TextNotFoundException ex) {
                    ex.printStackTrace( );
                }
                String tmp2 = BruteForse.getCodeWord( );
                jFrame.add(new MyComponents("запомните кодовое слово : " + tmp2));

                try {
                    StrimDao.outputFiles(tmp1);
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
       jFrame.setTitle("ПОМЕСТИТЕ ТЕКСТ В text.txt");
       Toolkit toolkit = Toolkit.getDefaultToolkit( );  // инструменты для окна
       Dimension dimension = toolkit.getScreenSize( ); // получаем размер экрана
       jFrame.setBounds(dimension.width / 2 - 500, dimension.height / 2 - 400, 500, 200);
       return jFrame;
   }

}
