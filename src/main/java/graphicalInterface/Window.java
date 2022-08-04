package graphicalInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Window {
    static JFrame jFrame = getJFrame( );
    static JPanel jPanel = new JPanel( );

    public static void getApplication() {
        jFrame.add(jPanel);
        JButton jButton1 = new JButton(" задать ключ и выполнить шифрование");
        jPanel.add(jButton1);
        jButton1.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PanelOne.getPanelOne( );
                } catch (IOException ex) {
                    ex.printStackTrace( );
                }
            }
        });

        JButton jButton2 = new JButton(" знаете ключ?-выполнить дешифровку");
        jPanel.add(jButton2);
        jButton2.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelTwo.getPanelTwo( );
            }
        });

        JButton jButton3 = new JButton(" знаете кодовое слово-выполнить дешифровку");
        jPanel.add(jButton3);
        jButton3.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelFour.getPanelFour( );
            }
        });

        JButton jButton4 = new JButton(" зашиифровать случайным ключем");
        jPanel.add(jButton4);
        jButton4.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelThree.getPanelThree( );
            }
        });

        JButton jButton5 = new JButton(" выйти из программы");
        jPanel.add(jButton5);
        jButton5.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }


    static JFrame getJFrame() {

        JFrame jFrame = new JFrame( ) {
        };
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("ДЛЯ ВЫБОРА ОПЕРАЦИИ НАЖМИТЕ НУЖНУЮ КНОПКУ");
        Toolkit toolkit = Toolkit.getDefaultToolkit( );  // инструменты для окна
        Dimension dimension = toolkit.getScreenSize( ); // получаем размер экрана
        jFrame.setBounds(dimension.width / 2 - 500, dimension.height / 2 - 400, 500, 200);
        return jFrame;
    }


}
