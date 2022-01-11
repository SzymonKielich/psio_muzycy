package generator;

import muzycy.Pianista;
import muzycy.Saksofonista;
import muzycy.Wokalista;
import technika.Technik;
import zespol.Zespol;

import java.util.List;

public class AlgorytmNaiwny implements WyborAlgorytmu {
    @Override
    public Zespol Algorytm(List<Technik> technicy, List<Wokalista> wokalisci, List<Pianista> pianisci, List<Saksofonista> saksofonisci, int budzet) {
    	
    	
    	
        int iT = 0, iW = 0, iP = 0, iS = 0, suma = 0;

        for (int i = 0; i < technicy.size(); i++)
            for (int j = 0; j < wokalisci.size(); j++)
                for (int k = 0; k < pianisci.size(); k++)
                    for (int l = 0; l < saksofonisci.size(); l++) {
                        boolean czyWBudzecie = (technicy.get(i).getStawka() + wokalisci.get(j).getStawka() + pianisci.get(k).getStawka() + saksofonisci.get(l).getStawka() <= budzet);
                        int tempSuma = ((Technik)technicy.get(i)).getPoziomUmiejetnosci() + wokalisci.get(j).getPoziomUmiejetnosci() + pianisci.get(k).getPoziomUmiejetnosci() + saksofonisci.get(l).getPoziomUmiejetnosci();
                        boolean czyWiekszeUmiejetnosci = (tempSuma > suma);

                        if (czyWBudzecie && czyWiekszeUmiejetnosci) {
                            suma = tempSuma;
                            iT = i;
                            iW = j;
                            iP = k;
                            iS = l;
                        }
                    }


        if (suma == 0)
            return null;

        else return new Zespol(technicy.get(iT), wokalisci.get(iW), pianisci.get(iP), saksofonisci.get(iS));
    }
}
