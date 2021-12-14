package generator;

import muzycy.Pianista;
import muzycy.Saksofonista;
import muzycy.Wokalista;
import technika.Technik;
import zespol.Zespol;

import java.util.List;

public interface WyborAlgorytmu
{
    Zespol Algorytm(List<Technik> technicy , List <Wokalista> wokalisci , List <Pianista> pianisci , List <Saksofonista> saksofonisci , int budzet);
}
