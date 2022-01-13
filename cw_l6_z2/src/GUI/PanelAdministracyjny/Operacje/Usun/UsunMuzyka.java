package GUI.PanelAdministracyjny.Operacje.Usun;

import database.TextIO;
import generator.Generator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsunMuzyka implements ActionListener {

    private JFrame ramka;

    private JPanel panelTabela;
    private JScrollPane scrollpane;
    private JTable tabela;
    private JPanel panelUsun;
    private JLabel opisUsun;
    private JTextField poleUsun;
    private JButton usun;
    private JLabel komunikat;

    private int indeks;

    public UsunMuzyka() {
        panelTabela = new JPanel();
        ramka = new JFrame("Usuwanie muzyka");
        panelUsun = new JPanel();
        opisUsun = new JLabel("Wprowadz identyfikator muzyka, ktorego chcesz usunac");
        poleUsun = new JTextField(5);
        usun = new JButton("Usun");
        komunikat = new JLabel();

        String[] nazwyKolumn = {"Identyfikator", "imie", "nazwisko", "stawka", "poziom umiejetnosci"};

        final int n = Generator.getMuzycyLista().size(); //TUTAJ
        String[][] dane = new String[n][5];


        ramka.setLayout(new FlowLayout());
        tabela = new JTable(dane, nazwyKolumn);
        tabela.setBounds(30, 40, 200, 300);
        scrollpane = new JScrollPane(tabela);
        panelTabela.add(scrollpane);
        ramka.getContentPane().add(panelTabela);
        panelUsun.add(opisUsun);
        panelUsun.add(poleUsun);
        panelUsun.add(usun);
        panelUsun.add(komunikat);
        ramka.getContentPane().add(panelUsun);

        usun.addActionListener(new PrzyciskUsun());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String[] nazwyKolumn = {"Identyfikator", "imie", "nazwisko", "stawka", "poziom umiejetnosci"};

        final int n = Generator.getMuzycyLista().size(); //TUTAJ
        String[][] dane = new String[n][5];

        for (int i = 0; i < n; i++) {
            dane[i][0] = ""+(i+1);
            dane[i][1] = Generator.getMuzycyLista().get(i).getImie(); //TUTAJ
            dane[i][2] = Generator.getMuzycyLista().get(i).getNazwisko(); //TUTAJ
            dane[i][3] = "" + Generator.getMuzycyLista().get(i).getStawka(); //TUTAJ
            dane[i][4] = "" + Generator.getMuzycyLista().get(i).getPoziomUmiejetnosci(); //TUTAJ
        }

        tabela = new JTable(dane, nazwyKolumn);
        panelTabela.remove(scrollpane);
        scrollpane = new JScrollPane(tabela);
        panelTabela.add(scrollpane);


        ramka.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ramka.setSize(700, 600);
        ramka.setResizable(true);
        ramka.setVisible(true);
        komunikat.setText("");
    }

    class PrzyciskUsun implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            indeks = Integer.parseInt(poleUsun.getText());

            if (indeks<=Generator.getMuzycyLista().size() && indeks>0) {
                Generator.getMuzycyLista().remove(indeks - 1);
                komunikat.setText("Muzyk usuniety pomyslnie!");
                TextIO.TextIO_zapiszDane();
            }
            else
                komunikat.setText("Nie istnieje taki muzyk!");

        }
    }

}