package GUI.PanelAdministracyjny.Operacje.Pokaz;

import generator.Generator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokazListeMuzykow implements ActionListener {

    private JFrame ramka;

    private JScrollPane panel;
    private JTable tabela;

    public PokazListeMuzykow() {
        ramka = new JFrame("Lista muzykow");


        String[] nazwyKolumn = {"imie", "nazwisko", "stawka", "poziom umiejetnosci"};

        final int n = Generator.getMuzycyLista().size(); //TUTAJ

        String[][] dane = new String[n][4];

        tabela = new JTable(dane, nazwyKolumn);
        tabela.setBounds(30, 40, 200, 300);
        panel = new JScrollPane(tabela);
        ramka.getContentPane().add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        final int n = Generator.getMuzycyLista().size(); //TUTAJ

        String[] nazwyKolumn = {"imie", "nazwisko", "stawka", "poziom umiejetnosci"};
        String[][] dane = new String[n][4];

        for (int i = 0; i < n; i++) {
            dane[i][0] = Generator.getMuzycyLista().get(i).getImie(); //TUTAJ
            dane[i][1] = Generator.getMuzycyLista().get(i).getNazwisko(); //TUTAJ
            dane[i][2] = "" + Generator.getMuzycyLista().get(i).getStawka(); //TUTAJ
            dane[i][3] = "" + Generator.getMuzycyLista().get(i).getPoziomUmiejetnosci(); //TUTAJ

            tabela = new JTable(dane, nazwyKolumn);
            ramka.getContentPane().remove(panel);
            panel = new JScrollPane(tabela);
            ramka.getContentPane().add(panel);


            ramka.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ramka.setSize(700, 600);
            ramka.setResizable(true);
            ramka.setVisible(true);
        }

    }
}