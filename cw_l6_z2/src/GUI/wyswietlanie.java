package GUI;

import generator.*;
import muzycy.*;
import rider.Rider;
import technika.Technik;
import zespol.Zespol;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class wyswietlanie {
     JTable tab;

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
    public static void wyswietlanie2(Zespol zespol){
        JFrame frame = new JFrame("Zespol:");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1150,640);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout((new BoxLayout(panel,BoxLayout.Y_AXIS)));
        frame.getContentPane().add(BorderLayout.CENTER,panel);
        Font small = new Font("Courier", Font.PLAIN, 16);
        Font big = new Font("Courier",Font.BOLD,20);


        if(zespol != null) {
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
            frame.getContentPane().add(pane, BorderLayout.CENTER);

            panel.add(pane);
            pane.setPreferredSize(new Dimension(700,500));
            frame.pack();
        }
        else{
            JLabel label = new JLabel("Z podanego budzetu nie mozna utworzyc zespolu");
            label.setFont(big);
            panel.add(label);
            frame.pack();
        }
    }

}
