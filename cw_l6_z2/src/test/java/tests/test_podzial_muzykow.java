package tests;

import muzycy.Muzyk;
import muzycy.Pianista;
import muzycy.Saksofonista;
import muzycy.Wokalista;
import java.util.ArrayList;
import java.util.List;
import repertuar.Piosenka;
import zespol.Zespol;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;


public class test_podzial_muzykow {

    private int p = 3;
    private int w = 3;
    private int s = 2;

    public static Piosenka[] rep()
    {
        int a = 4;

        Piosenka[] repertuar = new Piosenka[a];

        repertuar[0] = new Piosenka("Mamma mia", "pop", "1982");
        repertuar[1] = new Piosenka("Does your mother know", "pop", "2000");
        repertuar[2] = new Piosenka("Crusin' for a Brusin' ", "Classical", "1987");
        repertuar[3] = new Piosenka("Sleep on the floor", "pop", "2003");
        return repertuar;
    }

    public static Muzyk[] baza()

    {
        int w = 7;

        Muzyk[] listaMuzykow = new Muzyk[w];
        listaMuzykow[0] = new Pianista("Jan", "Kowalski", 3, 400, "Pojedynczy", false, rep());
        listaMuzykow[1] = new Pianista("Malgorzata", "Testowa", 4, 500, "Pojedynczy", true, rep());
        listaMuzykow[2] = new Pianista("Aleksander", "Prawdziwy", 4, 900, "Podwójny", false, rep());
        listaMuzykow[3] = new Wokalista("Janina", "Kowalska", 2, 100, "C3", "D6", rep());
        listaMuzykow[4] = new Wokalista("Arnold", "Fajny", 4, 600, "F3", "H5", rep());
        listaMuzykow[5] = new Saksofonista("Maria", "Nowak", 4, 1000, false, rep());
        listaMuzykow[6] = new Saksofonista("Marzena", "Dąbrowska", 2, 500, false, rep());
        return listaMuzykow;
    }

    @BeforeEach
    public void setUp(){

    }

    @Test

    public void test_podzial_wokal() {

        Muzyk[] muzycy = new Muzyk[w];
        List<Wokalista> result = new ArrayList<>();

        muzycy[0] = new Wokalista("Janina", "Kowalska", 2, 100, "C3", "D6", rep());
        muzycy[1] = new Wokalista("Arnold", "Fajny", 4, 600, "F3", "H5", rep());

        result.add((Wokalista) muzycy[0]);
        result.add((Wokalista) muzycy[1]);
        ((ArrayList<Wokalista>) result).trimToSize();

        assertTrue(result.toString().equals((Zespol.Zespol_arrayWokalisci(baza())).toString()));
    }

    @Test

    public void test_podzial_saks() {

        Saksofonista[] muzycy = new Saksofonista[s];
        List<Saksofonista> result = new ArrayList<>();

        muzycy[0] = new Saksofonista("Maria", "Nowak", 4, 1000, false, rep());
        muzycy[1] = new Saksofonista("Marzena", "Dąbrowska", 2, 500, false, rep());

        result.add(muzycy[0]);
        result.add(muzycy[1]);

        assertTrue(result.toString().equals((Zespol.Zespol_arraySaksofonisci(baza())).toString()));
    }

    @Test

        public void test_podzial_pian() {

        Muzyk[] muzycy = new Muzyk[p];
        List<Pianista> result = new ArrayList<>();

        muzycy[0] = new Pianista("Jan", "Kowalski", 3, 400, "Pojedynczy", false, rep());
        muzycy[1] = new Pianista("Malgorzata", "Testowa", 4, 500, "Pojedynczy", true, rep());
        muzycy[2] = new Pianista("Aleksander", "Prawdziwy", 4, 900, "Podwójny", false, rep());

        result.add((Pianista) muzycy[0]);
        result.add((Pianista) muzycy[1]);
        result.add((Pianista) muzycy[2]);

        assertTrue(result.toString().equals((Zespol.Zespol_arrayPianisci(baza())).toString()));
        }
}
