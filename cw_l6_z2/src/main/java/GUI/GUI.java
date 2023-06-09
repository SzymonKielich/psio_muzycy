package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.*;

import generator.AlgorytmDynamiczny;
import generator.AlgorytmNaiwny;
import generator.WyborAlgorytmu;
import muzycy.Pianista;
import muzycy.Saksofonista;
import muzycy.Wokalista;
import technika.Technik;
import wyjatki.WyjatekNiepoprawnyBudzet;
import zespol.Zespol;
import generator.Generator;

public class GUI {

    static JButton button1;
    static JButton button2;
    static JTextField inputField;
    static JLabel label;

    static class Button1 implements ActionListener{

        JFrame frame;

        public Button1(JFrame frame){
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e){

            Generator.setWyborAlgorytmu(new AlgorytmNaiwny());
            Generator.idk(Generator.getWyborAlgorytmu());
            frame.dispose();
            GUI3(Generator.getParametersGUI());
        }

    }

    static class Button2 implements ActionListener{

        JFrame frame;
        public Button2(JFrame frame){
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e){
      
            Generator.setWyborAlgorytmu(new AlgorytmDynamiczny());
            Generator.idk(Generator.getWyborAlgorytmu());
            frame.dispose();
            GUI3(Generator.getParametersGUI());
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


    
    public static void GUI3(ArrayList<String> parametersGUI) {
    	

        JFrame frame = new JFrame("Wybór algorytmu:");
        Panel p = new Panel();
        p.setLayout(new BorderLayout());

        frame.getContentPane().add(p);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        frame.setSize(1150,640);

        frame.setVisible(true);
        frame.setResizable(true);
    	
    	ArrayList<JLabel> output = new ArrayList<JLabel>();


        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);

        p.add(textArea, BorderLayout.CENTER);

        for(int i = 0; i < Generator.getParametersGUI().size(); i++) {

        	textArea.append(Generator.getParametersGUI().get(i) + "\n");
        	
        }
        
        
        

    }
    static class submitButton implements ActionListener{

        JFrame frame;

        public submitButton(JFrame frame){
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e){
            
        	String input = (inputField.getText());
        	System.out.println("Wpisano kwotę " + input);
        	Generator.setKwota(Integer.parseInt(input.toString()));
        	System.out.println("Ustawiono kwotę na: " + Generator.getKwota());
        	try {
        		validateKwota(Generator.getKwota());
        		GUI();
        	} catch (WyjatekNiepoprawnyBudzet wnb) {
        		GUI.getLabel().setText("Kwota musi być wielokrotnością 100!");
        	}
        	
        }

    }
    
    public static void GUI_Enter_Value() {
    	
        JFrame frame = new JFrame("Wpisz kwotę, którą chcesz zapłacić za zespół:");
        JPanel panel1 = new JPanel();
        label = new JLabel("Wpisz kwotę, którą chcesz zapłacić za zespół:");
        JLabel empty_label = new JLabel();

        inputField = new JTextField(16);
        
        frame.getContentPane().add(BorderLayout.CENTER, panel1);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton submitButton = new JButton("Wylicz");

        panel1.add(label);
        panel1.add(inputField);
        panel1.add(submitButton);
        
        submitButton.addActionListener(new submitButton(frame));
        

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



	public static JLabel getLabel() {
		return label;
	}



	public static void setLabel(JLabel label) {
		GUI.label = label;
	}

    public static boolean validateKwota(int Kwota) throws WyjatekNiepoprawnyBudzet {
    	
    	if(Kwota % 100 != 0) {
    		throw new WyjatekNiepoprawnyBudzet();
    	}
    	
    	return true;
    }
    
    
}
