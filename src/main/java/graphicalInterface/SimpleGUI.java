package graphicalInterface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI extends JFrame {

    private JButton button = new JButton("нажми на кнопку");
    private JTextField iтput = new JTextField("", 10);
    private JLabel label=new JLabel("введите текст");
    private JRadioButton radioButton1=new JRadioButton("шифровать");
    private JRadioButton radioButton2=new JRadioButton("расшифровать");
    private JCheckBox checkBox=new JCheckBox("есть кодовое слово",false);




    public SimpleGUI(){

        super("Simple example");
       this.setBounds(100,100,250,100);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       Container container=this.getContentPane();
       container.setLayout(new GridLayout( 3, 2, 2, 2 ));
       container.add(label);
       container.add(iтput);
        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        container.add(radioButton1);
        radioButton1.setSelected(true);
        container.add(radioButton2);
        container.add(checkBox);
        button.addActionListener(new ButtonEventListener());
       container.add(button);



    }

    public class ButtonEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String message="";
            message +="button was pressed\n";
            message+=(radioButton1.isSelected()? "кодировать":"раскодировать") +"is selected\n";
            message+="СheckBox is" + (checkBox.isSelected()? "есть кодовое слово":"нет кодового слова\n");
            JOptionPane.showMessageDialog(null,message,"Output",JOptionPane.PLAIN_MESSAGE);
        }




    }













}
