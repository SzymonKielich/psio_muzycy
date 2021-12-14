package generator;

import muzycy.*;
import technika.Technik;
import zespol.Zespol;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class AlgorytmDynamiczny implements WyborAlgorytmu
{
    @Override
    public Zespol Algorytm(List<Technik> technicy , List <Wokalista> wokalisci , List <Pianista> pianisci , List <Saksofonista> saksofonisci , int budzet)
    {
        ArrayList<Osoba> osoby = new ArrayList<Osoba>();

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
}
