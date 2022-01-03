package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import generator.AlgorytmDynamiczny;
import generator.AlgorytmNaiwny;
import generator.WyborAlgorytmu;
import muzycy.Pianista;
import muzycy.Saksofonista;
import muzycy.Wokalista;
import technika.Technik;
import zespol.Zespol;
import generator.Generator;

public class GUI {

    static JButton button1;
    static JButton button2;


    static class Button1 implements ActionListener{

        JFrame frame;

        public Button1(JFrame frame){
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e){
            WyborAlgorytmu wybor = new AlgorytmNaiwny();
            Generator.idk(wybor);
            frame.dispose();
            GUI2();
        }

    }

    static class Button2 implements ActionListener{

        JFrame frame;
        public Button2(JFrame frame){
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e){
            WyborAlgorytmu wybor = new AlgorytmDynamiczny();
            Generator.idk(wybor);
            frame.dispose();
            GUI2();
        }
    }

    public static void GUI(){

        JFrame frame = new JFrame("Wybór algorytmu:");
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JLabel label = new JLabel("Proszę wybrać algorytm:");
        JLabel empty_label = new JLabel();

        frame.getContentPane().add(BorderLayout.NORTH, panel1);
        frame.getContentPane().add(BorderLayout.CENTER, panel2);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel2.setLayout(new GridLayout(1,3));

        button1 = new JButton("Algorytm naiwny");
        button2 = new JButton("Algorytm dynamiczny");

        panel1.add(label);
        panel2.add(button1);
        panel2.add(empty_label);
        panel2.add(button2);


        button1.addActionListener(new Button1(frame));
        button2.addActionListener(new Button2(frame));

        frame.pack();
        frame.setSize(400,400);

        frame.setVisible(true);
        frame.setResizable(false);

    }

    public static void GUI2(){
        JFrame frame = new JFrame("Dane");
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        frame.getContentPane().add(panel1);
        frame.getContentPane().add(panel2);

        ArrayList<JLabel> labels = new ArrayList<>();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1.setLayout(new GridLayout(4,2));


        for(int i=0; i<8; i++){
            labels.add(i, new JLabel());
            panel1.add(labels.get(i));
        }


        frame.pack();
        frame.setSize(400,400);

        frame.setVisible(true);
        frame.setResizable(false);


    }

}
