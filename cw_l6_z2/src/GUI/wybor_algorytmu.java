package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.*;

import generator.AlgorytmDynamiczny;
import generator.AlgorytmNaiwny;
import wyjatki.WyjatekNiepoprawnyBudzet;
import generator.Generator;

public class wybor_algorytmu {

    static JRadioButton radiobutton1;
    static JRadioButton radiobutton2;
    static JTextField inputField;
    static JLabel label;
    static JLabel label2;
    static ButtonGroup buttonGroup;
//
//    static class Checkbox1 implements ActionListener{
//
//        JFrame frame;
//
////        public Checkbox1(JFrame frame){
//            this.frame = frame;
//        }
//
//        public void actionPerformed(ActionEvent e){
//
//            Generator.setWyborAlgorytmu(new AlgorytmNaiwny());
//            Generator.idk(Generator.getWyborAlgorytmu());
//            frame.dispose();
//            wyswietlanie.Wyswietlenie_brief(Generator.getParametersGUI());
//        }
//
//    }
//
//    static class Checkbox2 implements ActionListener{
//
//        JFrame frame;
//        public Checkbox2(JFrame frame){
//            this.frame = frame;
//        }
//
//        public void actionPerformed(ActionEvent e){
//
//            Generator.setWyborAlgorytmu(new AlgorytmDynamiczny());
//            Generator.idk(Generator.getWyborAlgorytmu());
//            frame.dispose();
//            wyswietlanie.Wyswietlenie_brief(Generator.getParametersGUI());
//        }
//    }

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
                Enumeration<AbstractButton> allRadioButton=buttonGroup.getElements();
                while(allRadioButton.hasMoreElements())
                {
                    JRadioButton temp=(JRadioButton)allRadioButton.nextElement();
                    if(temp.isSelected())
                    {
                        if(temp.equals(radiobutton1)) {
                            JOptionPane.showMessageDialog(null, "Ustawiono kwotę na: "+
                                    Generator.getKwota()+"\nWybrano : " + temp.getText());
                            Generator.setWyborAlgorytmu(new AlgorytmDynamiczny());
                            Generator.idk(Generator.getWyborAlgorytmu());
                            wyswietlanie.Wyswietlenie_brief(Generator.getParametersGUI());
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Ustawiono kwotę na: "+
                                    Generator.getKwota()+"\nWybrano : " + temp.getText());
                            Generator.setWyborAlgorytmu(new AlgorytmDynamiczny());
                            Generator.idk(Generator.getWyborAlgorytmu());
                            frame.dispose();
                            wyswietlanie.Wyswietlenie_brief(Generator.getParametersGUI());
                        }
                    }
                }
            } catch (WyjatekNiepoprawnyBudzet wnb) {
                wybor_algorytmu.getLabel().setText("Kwota musi być wielokrotnością 100!");
            }


        }


    }

    static class Back implements ActionListener
    {
        JFrame frame;

        public Back(JFrame frame)
        {
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e)
        {
            //tu bedzie ten panel poprzedni sie wyswietlac to ez sie ogarnie ale na razie nie ma na gicie
        }
    }

    public static void GUI(){

        JFrame frame = new JFrame("Wybór algorytmu:");
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        label = new JLabel("Proszę wybrać algorytm:");

        JLabel label2 = new JLabel("Wpisz KWOTĘ, którą chcesz zapłacić za zespół:");

        inputField = new JTextField(16);

        radiobutton1 = new JRadioButton("ALGORYTM NAIWNY");
        radiobutton2 = new JRadioButton("ALGORYTM DYNAMICZNY");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(radiobutton1);
        buttonGroup.add(radiobutton2);

        JButton submitButton = new JButton("WYLICZ");

        JButton back = new JButton("Back");
        back.setBounds(0,0,10,10);

       // panel4.setLayout(null);



        frame.getContentPane().add(BorderLayout.CENTER,panel4);
        frame.getContentPane().add(BorderLayout.NORTH, panel1);
        frame.getContentPane().add(BorderLayout.CENTER, panel2);
        frame.getContentPane().add(BorderLayout.SOUTH,panel3);
        //frame.getContentPane().add(BorderLayout.)

        panel4.setBounds(10,310,90,60);
        panel4.add(back);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel1.setLayout(new FlowLayout());

        panel1.setLayout(null);
        //panel2.setLayout(new GridLayout(9,4));
        panel2.setLayout(null);
        //panel3.setLayout(new FlowLayout());
        //panel3.setLayout(null);
       // panel3.setBounds(100,300,100,50);

//        checkbox1.addActionListener(new Checkbox1(frame));
//        checkbox2.addActionListener(new Checkbox2(frame));

        label.setFont(new Font("DialogInput",Font.BOLD,15));
        radiobutton2.setFont(new Font("DialogInput",Font.BOLD,15));
        radiobutton1.setFont(new Font("DialogInput",Font.BOLD,15));
        submitButton.setFont(new Font("DialogInput",Font.BOLD,15));
        label2.setFont(new Font("DialogInput",Font.BOLD,15));
        back.setFont(new Font("DialogInput",Font.BOLD,15));

        label2.setBounds(130,5,500,40);
        submitButton.setBounds(260,240,70,70);
        submitButton.setSize(100,50);

        inputField.setBounds(150,60,330,30);
        label.setBounds(220,120,250,30);

        radiobutton1.setBounds(120,175,200,30);
        radiobutton2.setBounds(320,175,200,30);

        panel2.add(label2);
        panel2.add(inputField);
        panel2.add(submitButton);

        panel2.add(label);
        panel2.add(radiobutton1);
        panel2.add(radiobutton2);



        //JPanel panel1 = new JPanel();

        //JLabel empty_label = new JLabel();



//        frame.getContentPane().add(BorderLayout.CENTER, panel1);
//
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        submitButton.addActionListener(new submitButton(frame));
        back.addActionListener(new Back(frame));

        frame.pack();
        frame.setSize(640,400);

        frame.setVisible(true);
        frame.setResizable(false);


    }

//    public static void GUI_Enter_Value() {
//
//
//
//
//
//    }
    

    
    
//    public static void GUI2(){
//        JFrame frame = new JFrame("Dane");
//        JPanel panel1 = new JPanel();
//        JPanel panel2 = new JPanel();
//
//        frame.getContentPane().add(panel1);
//        frame.getContentPane().add(panel2);
//
//        ArrayList<JLabel> labels = new ArrayList<>();
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        panel1.setLayout(new GridLayout(4,2));
//
//
//        for(int i=0; i<8; i++){
//            labels.add(i, new JLabel());
//            panel1.add(labels.get(i));
//        }
//
//
//        frame.pack();
//        frame.setSize(400,400);
//
//        frame.setVisible(true);
//        frame.setResizable(false);
//
//
//    }



	public static JLabel getLabel() {
		return label;
	}



	public static void setLabel(JLabel label) {
		wybor_algorytmu.label = label;
	}

    public static boolean validateKwota(int Kwota) throws WyjatekNiepoprawnyBudzet {
    	
    	if(Kwota % 100 != 0) {
    		throw new WyjatekNiepoprawnyBudzet();
    	}
    	
    	return true;
    }
    
    
}
