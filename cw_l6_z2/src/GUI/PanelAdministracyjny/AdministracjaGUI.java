package GUI.PanelAdministracyjny;

import GUI.PanelAdministracyjny.Operacje.Dodaj.DodajMuzyka;
import GUI.PanelAdministracyjny.Operacje.Pokaz.PokazListeMuzykow;
import GUI.PanelAdministracyjny.Operacje.Usun.UsunMuzyka;

import javax.swing.*;
import java.awt.*;

public class AdministracjaGUI {

    private JFrame ramka;

    private JButton dodajMuzyka;
    private JButton usunMuzyka;
    private JButton pokazListeMuzykow;

    public AdministracjaGUI() {
        ramka = new JFrame("Panel Administracyjny");

        dodajMuzyka = new JButton("Dodaj muzyka");
        usunMuzyka = new JButton("Usun muzyka");
        pokazListeMuzykow = new JButton("Lista muzykow");
    }

    public void PanelAdministracyjny() {
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(500, 100);
        ramka.setResizable(false);
        ramka.setVisible(true);
        ramka.setLayout(new GridLayout());

        ramka.add(pokazListeMuzykow);
        ramka.add(dodajMuzyka);
        ramka.add(usunMuzyka);

        dodajMuzyka.addActionListener(new DodajMuzyka());
        usunMuzyka.addActionListener(new UsunMuzyka());
        pokazListeMuzykow.addActionListener(new PokazListeMuzykow());

    }

}
