package GUI;

import generator.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class wyswietlanie {

    public static void Wyswietlenie_brief(ArrayList<String> parametersGUI) {


        JFrame frame = new JFrame("Wybór algorytmu:");
        Panel p = new Panel();
        p.setLayout(new BorderLayout());

        frame.getContentPane().add(p);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        frame.setSize(1150,640);

        frame.setVisible(true);
        frame.setResizable(true);

        ArrayList<JLabel> output = new ArrayList<JLabel>();

//        JScrollBar scroll = new JScrollBar();

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);

       // textArea.setForeground(Color.PINK);
        textArea.setFont(new Font("DialogInput",Font.BOLD,14));
        textArea.setOpaque(false);

        p.add(textArea, BorderLayout.CENTER);
//        p.add(scroll,BorderLayout.EAST);

        for(int i = 0; i < Generator.getParametersGUI().size(); i++) {

            textArea.append(Generator.getParametersGUI().get(i) + "\n");

        }

    }
}
