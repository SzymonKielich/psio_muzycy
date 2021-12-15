package zespol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import generator.AlgorytmDynamiczny;
import generator.AlgorytmNaiwny;
import generator.Generator;
import generator.WyborAlgorytmu;
import muzycy.Muzyk;
import muzycy.Osoba;
import muzycy.Pianista;
import muzycy.Saksofonista;
import muzycy.Wokalista;
import technika.Technik;
import java.lang.Math;
import java.util.Scanner;

import static java.lang.Math.*;
import muzycy.*;
public class Zespol {

    private Technik technik;
    private Wokalista wokalista;
    private Pianista pianista;
    private Saksofonista saksofonista;
    private static WyborAlgorytmu wybor;

    public static void WybierzAlgorytm() {
        System.out.println("\nWybierz algorytm tworzacy zespol:");
        System.out.println("[1] Algorytm naiwny");
        System.out.println("[2] Algorytm dynamiczny");

        Scanner skan = new Scanner(System.in);
        int opcja = skan.nextInt();

        while (opcja < 1 && opcja > 2) {
            System.out.println("Wprowadzona powinna zostac liczba 1 albo 2! Sprobuj ponownie:");
            opcja = skan.nextInt();
        }

        if (opcja == 1)
            wybor = new AlgorytmNaiwny();

        else
            wybor = new AlgorytmDynamiczny();

    }

    public Zespol(Technik technik, Wokalista wokalista, Pianista pianista, Saksofonista saksofonista) {
        this.technik = technik;
        this.wokalista = wokalista;
        this.pianista = pianista;
        this.saksofonista = saksofonista;
    }

    public Technik getTechnik() {
        return technik;
    }

    public Wokalista getWokalista() {
        return wokalista;
    }

    public Pianista getPianista() {
        return pianista;
    }

    public Saksofonista getSaksofonista() {
        return saksofonista;
    }


    public static void Zespol_optimalTeam(Technik[] technicytmp, Muzyk[] muzycy, int budzet) {

        List<Technik> technicy = Arrays.asList(technicytmp);
        List<Wokalista> wokalisci = Zespol_arrayWokalisci(muzycy);
        List<Pianista> pianisci = Zespol_arrayPianisci(muzycy);
        List<Saksofonista> saksofonisci = Zespol_arraySaksofonisci(muzycy);
        Zespol zespol = wybor.Algorytm(technicy, wokalisci, pianisci, saksofonisci, budzet);

        Zespol_showOptimalTeam(zespol, budzet);


    }

    /*
	public static Zespol wybierzZespol( List <Technik> technicy , List <Wokalista> wokalisci , List <Pianista> pianisci , List <Saksofonista> saksofonisci , int budzet )
    {
        int iT=0, iW=0, iP=0, iS=0, suma=0;
       
        for (int i=0; i<technicy.size(); i++)
            for (int j=0; j<wokalisci.size(); j++)
                for (int k=0; k<pianisci.size(); k++)
                    for (int l=0; l<saksofonisci.size(); l++)
                    {
                        boolean czyWBudzecie = ( technicy.get(i).getStawka() + wokalisci.get(j).getStawka() + pianisci.get(k).getStawka() + saksofonisci.get(l).getStawka() <= budzet );
                        int tempSuma = technicy.get(i).getPoziom_umiejetnosci() + wokalisci.get(j).getPoziomUmiejetnosci() + pianisci.get(k).getPoziomUmiejetnosci() + saksofonisci.get(l).getPoziomUmiejetnosci();
                        boolean czyWiekszeUmiejetnosci = ( tempSuma > suma );
                        if ( czyWBudzecie && czyWiekszeUmiejetnosci )
                        {
                            suma = tempSuma;
                            iT = i;
                            iW = j;
                            iP = k;
                            iS = l;
                        }
                    }
        if ( suma == 0 )
            return null;
        else return new Zespol ( technicy.get(iT) , wokalisci.get(iW) , pianisci.get(iP) , saksofonisci.get(iS) );
        
    }
	
	public static Zespol wybierzZespol2(List<Technik> technicy , List <Wokalista> wokalisci , List <Pianista> pianisci , List <Saksofonista> saksofonisci , int budzet )
    {
		
        ArrayList <Osoba> osoby = new ArrayList<Osoba>();
        osoby.addAll(saksofonisci);
        osoby.addAll(wokalisci);
        osoby.addAll(pianisci);
        osoby.addAll(technicy);
        System.out.println(osoby);
        final int n = osoby.size(), m = budzet / 100;
        int[][] T = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            T[i][0] = 0;
        for (int i = 0; i < m + 1; i++)
            T[0][i] = 0;
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < m + 1; j++) {
                if ((osoby.get(i - 1)).getStawka() > j)
                    T[i][j] = T[i][j - 1];
                else
                {
                T[i][j] = max(T[i-1][j] , T[i-1][j-osoby.get(i-1).getStawka()] + ((Muzyk)osoby.get(i-1)).getPoziomUmiejetnosci());	
                	
                }
            }
        List <Osoba> wynik = new ArrayList();
            int j=m;
        for (int i=n; i>0 && j>0; i--)
            if ( T[i][j] != T[i-1][j] )
            {
                j -= osoby.get(i-1).getStawka();
                wynik.add(osoby.get(i));
            }
        if ( wynik.size() == 4 )
        {
            if ( wynik.get(0) instanceof Saksofonista && wynik.get(1) instanceof Wokalista && wynik.get(2) instanceof Pianista  && wynik.get(3) instanceof Technik )
                return new Zespol( (Technik)wynik.get(3) , (Wokalista)wynik.get(1) , (Pianista)wynik.get(2) , (Saksofonista)wynik.get(0) );
            else
                return null;
        }
        else
            return null;
    }
*/

    public static List<Pianista> Zespol_arrayPianisci(Muzyk[] tab) {

        List<Pianista> pianisci = new ArrayList<Pianista>();

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] instanceof Pianista) {
                pianisci.add((Pianista) tab[i]);
            }
        }
        ((ArrayList<Pianista>) pianisci).trimToSize();
        return pianisci;
    }


    public static List<Saksofonista> Zespol_arraySaksofonisci(Muzyk[] tab) {

        List<Saksofonista> saksofonisci = new ArrayList<Saksofonista>();

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] instanceof Saksofonista) {
                saksofonisci.add((Saksofonista) tab[i]);
            }
        }
        ((ArrayList<Saksofonista>) saksofonisci).trimToSize();
        return saksofonisci;
    }


    public static List<Wokalista> Zespol_arrayWokalisci(Muzyk[] tab) {

        List<Wokalista> wokalisci = new ArrayList<Wokalista>();

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] instanceof Wokalista) {
                wokalisci.add((Wokalista) tab[i]);
            }
        }
        ((ArrayList<Wokalista>) wokalisci).trimToSize();
        return wokalisci;
    }

    public static void Zespol_showOptimalTeam(Zespol zespol, int budzet) {

        if (zespol == null)
            System.out.println("Z danej grupy nie mozna utworzyc zespolu w twoim budzecie!");

        else {
            System.out.println("\n-------------------------");
            System.out.println("\nNajbardziej optymalny zespol pod wzgledem ceny oraz poziomu umiejetnosci w stosunku do budzetu wynoszacego: " + budzet);
            Generator.sendBrief(zespol.getWokalista(), zespol.getPianista(), zespol.getTechnik(), zespol.getSaksofonista());

        }


    }


}
