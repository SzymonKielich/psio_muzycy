package GUI.PanelAdministracyjny.Operacje.Dodaj;

import database.TextIO;
import generator.Generator;
import muzycy.Saksofonista;
import repertuar.Piosenka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajSaksofoniste implements JakiMuzyk, ActionListener {

    private JFrame ramka;

    private JPanel panelImie;
    private JTextField imie;
    private JPanel panelNazwisko;
    private JTextField nazwisko;
    private JPanel panelPoziomUmiejetnosci;
    private JTextField poziomUmiejetnosci;
    private JPanel panelStawka;
    private JTextField stawka;
    private JPanel panelCzySiedzi;
    private JLabel opisCzySiedzi;
    private JCheckBox czySiedzi;
    private JPanel panelLiczbaUtworow;
    private JTextField liczbaUtworow;
    private JPanel panelRepertuar;
    private JButton repertuar;
    private JLabel komunikat;

    private String IMIE;
    private String NAZWISKO;
    private int POZIOMUMIEJETNOSCI;
    private int STAWKA;
    private boolean CZYSIEDZI;
    private int LICZBAUTWOROW;
    private Piosenka[] REPERTUAR;

    public DodajSaksofoniste() {
        ramka = new JFrame("Nowy saksofonista");
        panelImie = new JPanel();
        imie = new JTextField("Imie", 15);
        panelNazwisko = new JPanel();
        nazwisko = new JTextField("Nazwisko", 15);
        panelPoziomUmiejetnosci = new JPanel();
        poziomUmiejetnosci = new JTextField("Poziom umiejetnosci", 15);
        panelStawka = new JPanel();
        stawka = new JTextField("Stawka", 15);
        panelCzySiedzi = new JPanel();
        opisCzySiedzi = new JLabel("Czy siedzi?");
        czySiedzi = new JCheckBox();
        panelLiczbaUtworow = new JPanel();
        liczbaUtworow = new JTextField("Liczba utworow w repertuarze");
        panelRepertuar = new JPanel();
        repertuar = new JButton("Dodaj repertuar");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Dodaj();
    }

    @Override
    public void Dodaj() {
        ramka.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ramka.setSize(550, 400);
        ramka.setResizable(false);
        ramka.setVisible(true);
        ramka.setLayout(new GridLayout(4, 2));

        panelImie.add(imie);
        panelNazwisko.add(nazwisko);
        panelPoziomUmiejetnosci.add(poziomUmiejetnosci);
        panelStawka.add(stawka);
        panelCzySiedzi.add(opisCzySiedzi);
        panelCzySiedzi.add(czySiedzi);
        panelLiczbaUtworow.add(liczbaUtworow);
        panelRepertuar.add(repertuar);

        ramka.getContentPane().add(panelImie);
        ramka.getContentPane().add(panelNazwisko);
        ramka.getContentPane().add(panelPoziomUmiejetnosci);
        ramka.getContentPane().add(panelStawka);
        ramka.getContentPane().add(panelCzySiedzi);
        ramka.getContentPane().add(panelLiczbaUtworow);
        ramka.getContentPane().add(panelRepertuar);

        PrzyciskRepertuar przyciskrepertuar = new PrzyciskRepertuar();

        repertuar.addActionListener(new PrzyciskRepertuar());
    }

    class PrzyciskRepertuar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            IMIE = imie.getText();
            NAZWISKO = nazwisko.getText();
            POZIOMUMIEJETNOSCI = Integer.parseInt(poziomUmiejetnosci.getText());
            STAWKA = Integer.parseInt(stawka.getText());
            CZYSIEDZI = czySiedzi.isSelected();
            LICZBAUTWOROW = Integer.parseInt(liczbaUtworow.getText());

            ramka.dispose();
            TworzenieRepertuaru();
        }

    }


    public void TworzenieRepertuaru() {

        JFrame ramka1 = new JFrame("Repertuar");
        REPERTUAR = new Piosenka[LICZBAUTWOROW];
        JTextField[][] piosenki = new JTextField[LICZBAUTWOROW][3];
        JPanel[] panele = new JPanel[LICZBAUTWOROW];
        JPanel panelDodaj = new JPanel();
        JButton dodaj = new JButton("Dodaj");
        JPanel panelKomunikat = new JPanel();
        komunikat = new JLabel();

        for (int i = 0; i < LICZBAUTWOROW; i++) {
            piosenki[i][0] = new JTextField("Tytul utworu nr " + (i + 1), 15);
            piosenki[i][1] = new JTextField("Gatunek utworu nr " + (i + 1), 15);
            piosenki[i][2] = new JTextField("Rok wydania utworu nr " + (i + 1), 15);

            panele[i] = new JPanel();
            panele[i].add(piosenki[i][0]);
            panele[i].add(piosenki[i][1]);
            panele[i].add(piosenki[i][2]);
        }

        ramka1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ramka1.setSize(550, 400);
        ramka1.setResizable(true);
        ramka1.setVisible(true);
        ramka1.setLayout(new FlowLayout());

        for (int i = 0; i < LICZBAUTWOROW; i++)
            ramka1.getContentPane().add(panele[i]);

        panelDodaj.add(dodaj);
        panelKomunikat.add(komunikat);

        ramka1.getContentPane().add(panelDodaj);
        ramka1.getContentPane().add(panelKomunikat);

        REPERTUAR = new Piosenka[LICZBAUTWOROW];

        for (int i = 0; i < LICZBAUTWOROW; i++)
            REPERTUAR[i] = new Piosenka(piosenki[i][0].getText(), piosenki[i][1].getText(), piosenki[i][2].getText());

        dodaj.addActionListener(new PrzyciskDodaj());
    }

    class PrzyciskDodaj implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Generator.getMuzycyLista().add(new Saksofonista(IMIE, NAZWISKO, STAWKA, POZIOMUMIEJETNOSCI, CZYSIEDZI, REPERTUAR));
            komunikat.setText("Saksofonista dodany pomyślnie!");
            TextIO.TextIO_zapiszDane();
        }
    }
}
