package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import generator.AlgorytmNaiwny;
import technika.Technik;
import muzycy.*;
import repertuar.Piosenka;
import rider.Rider;
import zespol.*;

import java.util.ArrayList;
import java.util.List;

public class AlgorytmNaiwnyTest {

	Technik t1;
	Technik t2;
	Wokalista w1;
	Wokalista w2;
	Pianista p1;
	Pianista p2;
	Saksofonista s1;
	Saksofonista s2;
	Piosenka[] p;
	List<Technik> technicy;
	List<Wokalista> wokalisci;
	List<Pianista> pianisci;
	List<Saksofonista> saksofonisci;
	int budzet;
	AlgorytmNaiwny n;
	Zespol z;
	Zespol z2;
	String S1;
	String S2;
	Rider podstawowy;
	
	@Before
	public void setUp() throws Exception {
		
		technicy = new ArrayList<Technik>();
		wokalisci = new ArrayList<Wokalista>();
		pianisci = new ArrayList<Pianista>();
		saksofonisci = new ArrayList<Saksofonista>();
		n = new AlgorytmNaiwny();
	}

	@Test
	public void test1() {
		ustawDane(5,400,2,400,5,400,2,400,5,400,2,400,5,400,2,400);
		z = new Zespol(t1,w1,p1,s1);
		budzet = 4000;
		S1=zespolZnacznik(z);
		z2=n.Algorytm(technicy, wokalisci, pianisci, saksofonisci, budzet);
		S2=zespolZnacznik(z2);

		assertEquals(S1,S2);
	}
	
	@Test
	public void test2()
	{
		budzet = 200;
		ustawDane(5,400,2,400,5,400,2,400,5,400,2,400,5,400,2,400);
		assertEquals(null,n.Algorytm(technicy, wokalisci, pianisci, saksofonisci, budzet));
	}
	
	public void ustawDane(int ut1, int st1, int ut2, int st2, int uw1, int sw1, int uw2, int sw2,int up1, int sp1, int up2, int sp2,int us1, int ss1, int us2, int ss2)
	{
		podstawowy = new Rider("Chipsy, paluszki", "4 gwiazdki", false, "10x5m", 3);
		p=null;
		t1 = new Technik("Adam", "Janiak", st1, ut1, "Behringer X32", podstawowy);
		t2 = new Technik("Adam", "Kowalski", st2, ut2, "Behringer X32", podstawowy);
		p1 = new Pianista("Jan", "Badurski", sp1, up1, "Pojedynczy", false, p);
		p2 = new Pianista("Jan", "Kowalski", sp2, up2, "Pojedynczy", false, p);
		w1 = new Wokalista("Janina", "Stecka", sw1, uw1, "C3", "D6", p);
		w2 = new Wokalista("Janina", "Kowalska", sw2, uw2, "C3", "D6", p);
		s1 = new Saksofonista("Maria", "Blosz", ss1, us1, false, p);
		s2 = new Saksofonista("Maria", "Nowak", ss2, us2, false, p);
		
		technicy.add(t1);
		technicy.add(t2);
		
		wokalisci.add(w1);		
		wokalisci.add(w2);	
		
		pianisci.add(p1);
		pianisci.add(p2);
		
		saksofonisci.add(s1);
		saksofonisci.add(s2); 
	}
	
	public String zespolZnacznik(Zespol z)
	{
		String s=z.getPianista().toString()+z.getPianista().getPoziomUmiejetnosci()+z.getPianista().getStawka()+z.getTechnik().toString()+z.getTechnik().getPoziomUmiejetnosci()+z.getTechnik().getStawka()+z.getWokalista().toString()+z.getWokalista().getPoziomUmiejetnosci()+z.getWokalista().getStawka()+z.getSaksofonista().toString()+z.getSaksofonista().getPoziomUmiejetnosci()+z.getSaksofonista().getStawka();
		return s;
	}
	
	

}

