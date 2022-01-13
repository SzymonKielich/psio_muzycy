package GUI.PanelAdministracyjny.Operacje.Dodaj;


import GUI.PanelAdministracyjny.Administracja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajMuzyka implements ActionListener {

    private JFrame ramka;

    private JButton dodajWokaliste;
    private JButton dodajPianiste;
    private JButton dodajSaksofoniste;

    private Administracja administracja;

    public DodajMuzyka() {
        ramka = new JFrame("Dodawanie muzyka");

        dodajWokaliste = new JButton("Wokalista");
        dodajPianiste = new JButton("Pianista");
        dodajSaksofoniste = new JButton("Saksofonista");

        administracja = new Administracja();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ramka.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ramka.setSize(500, 100);
        ramka.setResizable(false);
        ramka.setVisible(true);
        ramka.setLayout(new GridLayout());

        ramka.add(dodajWokaliste);
        ramka.add(dodajPianiste);
        ramka.add(dodajSaksofoniste);

        dodajWokaliste.addActionListener(new WybranoWokaliste());
        dodajPianiste.addActionListener(new WybranoPianiste());
        dodajSaksofoniste.addActionListener(new WybranoSaksofoniste());
    }


    class WybranoWokaliste implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            administracja.setWyborWokalista();
            administracja.getWybor().Dodaj();
        }
    }

    class WybranoPianiste implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            administracja.setWyborPianista();
            administracja.getWybor().Dodaj();
        }
    }

    class WybranoSaksofoniste implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            administracja.setWyborSaksofonista();
            administracja.getWybor().Dodaj();
        }
    }

}