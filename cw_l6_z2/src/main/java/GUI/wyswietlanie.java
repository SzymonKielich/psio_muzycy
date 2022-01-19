package GUI;

import generator.*;
import muzycy.*;
import rider.Rider;
import technika.Technik;
import zespol.Zespol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class wyswietlanie {
    private static JFrame frame;

    public void wyswietlanieZespolu(Zespol zespol){


        if(zespol != null) {
            frame = new JFrame("Zespol:");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1150,640);
            frame.setVisible(true);
            frame.setResizable(true);
            //frame.setLayout(new FlowLayout());

            JPanel panel = new JPanel();
            panel.setLayout((new BoxLayout(panel,BoxLayout.Y_AXIS)));
            frame.getContentPane().add(panel,BorderLayout.CENTER);
            Font small = new Font("Courier", Font.PLAIN, 16);
            Font big = new Font("Courier",Font.BOLD,20);
            Wokalista wokalista = zespol.getWokalista();
            Saksofonista saksofonista = zespol.getSaksofonista();
            Pianista pianista = zespol.getPianista();
            Technik technik = zespol.getTechnik();
            Rider rider = technik.getRider();

            String[] columns = {"", ""};
            String[][] data = {
                    {"Pianista:", pianista.getImie() + " " + pianista.getNazwisko()},
                    {"Wokalista:", wokalista.getImie() + " " + wokalista.getNazwisko()},
                    {"Saksofonista:", saksofonista.getImie() + " " + saksofonista.getNazwisko()},
                    {"Technik:", technik.getImie() + " " + technik.getNazwisko()},
                    {"Koszt:",(Generator.Generator_seePrice(wokalista, pianista, saksofonista) + technik.getStawka()) + " zl"},
                    {"Umiejetnosci sumaryczne zespolu (0-15):", String.valueOf(wokalista.getPoziomUmiejetnosci() + pianista.getPoziomUmiejetnosci() + saksofonista.getPoziomUmiejetnosci())},
                    {"Umiejetnosci klawiszowca:", String.valueOf(pianista.getPoziomUmiejetnosci())},
                    {"Umiejetnosci saksofonisty:", String.valueOf(saksofonista.getPoziomUmiejetnosci())},
                    {"Umiejetnosci wokalisty:", String.valueOf(wokalista.getPoziomUmiejetnosci())},
                    {"Umiejetnosci technika:",String.valueOf(technik.getPoziomUmiejetnosci())},
                    {"Instrument klawiszowca:",pianista.getStringKeyboard()},
                    {"Instrument saksofonisty:", saksofonista.getStringSaksofon()},
                    {"Przekaski:", rider.getPrzekaski()},
                    {"Minimalny standard hotelu:",rider.getHotel()},
                    {"Minimalne wymiary sceny:", rider.getStageSize()},
                    {"Czy potrzebni handzi? ", String.valueOf(rider.isHandsNeeded())},
                    {"Preferowany stol: ", technik.getPreferowanyStol()}

            };
            JTable tab = new JTable(data, columns);
            tab.setSize(300, 300);
            tab.setFont(small);
            tab.setRowMargin(10);
            tab.getColumnModel().setColumnMargin(10);
            tab.setRowHeight(30);

            JScrollPane pane = new JScrollPane(tab);
            pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            //frame.getContentPane().add(pane, BorderLayout.CENTER);
            JButton back = new JButton("Back");
            JPanel powrotPrzycisk = new JPanel();
            powrotPrzycisk.add(back);
            frame.getContentPane().add(powrotPrzycisk,BorderLayout.SOUTH);
            back.addActionListener(new Back());

            panel.add(pane);
            pane.setPreferredSize(new Dimension(700,500));
            frame.pack();
        }
        else{

            JOptionPane.showMessageDialog(null,"Z podanego budżetu nie można utworzyć zespołu","Za mały budżet",JOptionPane.ERROR_MESSAGE);

        }
    }

    class Back implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            wybor_algorytmu.GUI();
        }
    }

}