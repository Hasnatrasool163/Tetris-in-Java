package tetris;

import javax.swing.*;
import java.awt.*;

public class window extends JFrame{

    window(){

        setLayout(null);
        setLocation(50,100);
        setSize(500,500);
        setTitle("mywindow");
        getContentPane().setBackground(Color.GREEN);
        JLabel label1 = new JLabel("mylabel");
        label1.setBounds(100,20,200,100);
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("TimesNewRoman",Font.BOLD,22));
        add(label1);
        setVisible(true);
        JButton mybutton = new JButton("clickme");
        mybutton.setBounds(200,100,100,40);
        add(mybutton);
    }
    public static void main(String[]args){

        new window();
    }
}