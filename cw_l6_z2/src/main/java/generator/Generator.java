package generator;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;

import javax.swing.JLabel;

import instrument.Keyboard;
import instrument.Saksofon;
import muzycy.Muzyk;
import muzycy.Pianista;
import muzycy.Wokalista;
import repertuar.Piosenka;
import rider.Rider;
import technika.Technik;
import wyjatki.WyjatekNiepoprawnyBudzet;
import zespol.Zespol;
import muzycy.Saksofonista;
import instrument.Instrument;
import sprzet.Mikrofon;
import repertuar.Krytyk;
import database.Dane;
import database.TextIO;
import GUI.EkranPoczatkowy;
import GUI.GUI;

public class Generator {

	static Muzyk[] muzycy;
	static ArrayList<Muzyk> muzycyLista = new ArrayList<>();
	static Rider podstawowy;
	static Rider bogatszy;
	static Rider najbogatszy;
	static Technik[] technicy;
	static Instrument[] instrument;
	static Mikrofon[] mikrofony;
	static Piosenka[] baza;
	static int kwota;
	static WyborAlgorytmu wyborAlgorytmu;
	
	static ArrayList<String> parametersGUI = new ArrayList<String>();

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		Dane.Dane_initializeDatabase();		
//		TextIO.TextIO_zresetujDane();	
		TextIO.TextIO_zresetujDane();
//		TextIO.TextIO_pobierzDane();
		
		EkranPoczatkowy start = new EkranPoczatkowy();
//		GUI.GUI_Enter_Value();

//		Dane.Dane_initializeDatabase();
//		




		podstawowy = Dane.getPodstawowy();
		bogatszy = Dane.getBogatszy();
		najbogatszy = Dane.getNajbogatszy();
		technicy = Dane.getTechnicy();


//		TextIO.TextIO_zresetujDane();
//		muzycy[0].setImie("Test");
//		Dane.Dane_wydrukujMuzykow(muzycy);


//		Wokalista wokalista = (Wokalista) Generator_generateMuzyk("class muzycy.Wokalista");
//		Pianista pianista = (Pianista) Generator_generateMuzyk("class muzycy.Pianista");
//		Saksofonista saksofonista = (Saksofonista) Generator_generateMuzyk("class muzycy.Saksofonista");
//		Technik technik = Generator_generateTechnik(wokalista, pianista, saksofonista);
//
//
//		Generator_sendBrief(wokalista, pianista, technik, saksofonista);

		try{
		     Zespol.Zespol_WybiierzAlgorytm();
		 }
		 catch(IllegalArgumentException e)
		 {
			 System.out.println("Wprowadzona powinna zostac liczba 1 albo 2!");
			 e.printStackTrace();
		 }
		 
		 
	/*	try {
			Zespol.Zespol_optimalTeam(technicy, muzycy, 2500);
		} catch (WyjatekNiepoprawnyBudzet e) {
			
			e.printStackTrace();
		}
		catch(NullPointerException e)
		{
			System.out.println("Blad, nie wybrano algorytmu");
			e.printStackTrace();
		}*/



//		System.out.println("-----------------");
//		System.out.println("Demonstracja mechanizmu polimorfizmu na przykladzie metody play:");
//		pianista.Muzyk_play(pianista);
//		wokalista.Muzyk_play(wokalista);


		TextIO.TextIO_zapiszDane();
	}
public static void idk(WyborAlgorytmu wybor)
{

	try {
		Zespol.Zespol_optimalTeam(technicy, muzycy, Generator.getKwota(), wybor);
	} catch (WyjatekNiepoprawnyBudzet e) {
		
		GUI.setLabel(new JLabel("esefgs"));
		GUI.GUI_Enter_Value();
		parametersGUI.add("Kwota powinna być wielokrotnością 100. Spróbuj ponownie.");
		e.printStackTrace();
	}
}

public static String test(){
		return "test";
}

	//generowanie propozycji koncertu
	public static void Generator_sendBrief(Wokalista wokalista, Pianista pianista, Technik technik, Saksofonista saksofonista) {

		Rider rider = technik.getRider();

		System.out.println("Brief koncertu " + wokalista.getImie() + " " + wokalista.getNazwisko() + " przy akompaniamencie " + pianista.getImie() + " " + pianista.getNazwisko() + ", " + saksofonista.getImie() + " " + saksofonista.getNazwisko());
		System.out.println("--------------------------------");
		System.out.println("\u001B[31m" + "Stawka zespolu: " + Generator_seePrice(wokalista, pianista, saksofonista) + " zl" + "\u001B[0m");
		System.out.println("Umiejetnosci sumaryczne zespolu w skali 0-15: " + (wokalista.getPoziomUmiejetnosci() + pianista.getPoziomUmiejetnosci() + saksofonista.getPoziomUmiejetnosci()));
		System.out.println("W tym klawiszowiec: " + pianista.getPoziomUmiejetnosci() + "/5 Saksofonista: " + saksofonista.getPoziomUmiejetnosci() + "/5 Wokalista: " + wokalista.getPoziomUmiejetnosci() + "/5");
		System.out.println("Instrument klawiszowca: " + pianista.getStringKeyboard());


		System.out.println("Instrument saksofonisty: " + saksofonista.getStringSaksofon());
		System.out.println("--------------------------------");
		System.out.println("Szczegoly dotyczace rideru:");
		System.out.print("Mikrofon wokalistki: ");
		wokalista.Wokalista_wyswietlUlubionyMikrofon();
		System.out.println("Przekaski: " + rider.getPrzekaski());
		System.out.println("W przypadku wyjazdu, minimalny standard hotelu: " + rider.getHotel());
		System.out.println("Minimalne wymiary sceny: " + rider.getStageSize());
		System.out.println("Czy potrzebni handzi? " + rider.isHandsNeeded());
		System.out.println("Technik: " + technik.getImie() + " " + technik.getNazwisko());
		System.out.println("Poziom umiejetnosci technika: " + technik.getPoziomUmiejetnosci() + "/5");
		System.out.println("Preferowany stol: " + technik.getPreferowanyStol());
		System.out.println("Stawka technika: " + technik.getStawka() + " zl");
		System.out.println("--------------------------------");
		System.out.println("\u001B[31m" + "Koszt zespolu: " + (Generator_seePrice(wokalista, pianista, saksofonista) + technik.getStawka()) + " zl" + "\u001B[0m");
		System.out.println("--------------------------------");
		System.out.println("Repertuar:");
		
		
		
		
		parametersGUI.add("Brief koncertu " + wokalista.getImie() + " " + wokalista.getNazwisko() + " przy akompaniamencie " + pianista.getImie() + " " + pianista.getNazwisko() + ", " + saksofonista.getImie() + " " + saksofonista.getNazwisko());
		parametersGUI.add("--------------------------------");
		parametersGUI.add("Stawka zespolu: " + Generator_seePrice(wokalista, pianista, saksofonista) + " zl");
		parametersGUI.add("Umiejetnosci sumaryczne zespolu w skali 0-15: " + (wokalista.getPoziomUmiejetnosci() + pianista.getPoziomUmiejetnosci() + saksofonista.getPoziomUmiejetnosci()));
		parametersGUI.add("W tym klawiszowiec: " + pianista.getPoziomUmiejetnosci() + "/5 Saksofonista: " + saksofonista.getPoziomUmiejetnosci() + "/5 Wokalista: " + wokalista.getPoziomUmiejetnosci() + "/5");
		parametersGUI.add("Instrument klawiszowca: " + pianista.getStringKeyboard());


		parametersGUI.add("Instrument saksofonisty: " + saksofonista.getStringSaksofon());
		parametersGUI.add("--------------------------------");
		parametersGUI.add("Szczegoly dotyczace rideru:");
		parametersGUI.add("Przekaski: " + rider.getPrzekaski());
		parametersGUI.add("W przypadku wyjazdu, minimalny standard hotelu: " + rider.getHotel());
		parametersGUI.add("Minimalne wymiary sceny: " + rider.getStageSize());
		parametersGUI.add("Czy potrzebni handzi? " + rider.isHandsNeeded());
		parametersGUI.add("Technik: " + technik.getImie() + " " + technik.getNazwisko());
		parametersGUI.add("Poziom umiejetnosci technika: " + technik.getPoziomUmiejetnosci() + "/5");
		parametersGUI.add("Preferowany stol: " + technik.getPreferowanyStol());
		parametersGUI.add("Stawka technika: " + technik.getStawka() + " zl");
		parametersGUI.add("--------------------------------");
		parametersGUI.add("Koszt zespolu: " + (Generator_seePrice(wokalista, pianista, saksofonista) + technik.getStawka()) + " zl");
		parametersGUI.add("--------------------------------");
		parametersGUI.add("Repertuar:");
		
		Generator_wydrukujRepertuar(wokalista, pianista, saksofonista);

	}

	//wydrukuj liste zawierajaca utwory wszystkich muzyków, bez powtórzeń
	public static void Generator_wydrukujRepertuar(Wokalista wokalista, Pianista pianista, Saksofonista saksofonista) {

		ArrayList<Piosenka> repertuar = new ArrayList<Piosenka>();

		repertuar.addAll(Arrays.asList(wokalista.getRepertuar()));

		for (int i = 0; i < pianista.getRepertuar().length; i++) {

			if (repertuar.contains(pianista.getRepertuar()[i]) == false) {
				repertuar.add(pianista.getRepertuar()[i]);
			}

		}
		for (int i = 0; i < saksofonista.getRepertuar().length; i++) {

			if (repertuar.contains(saksofonista.getRepertuar()[i]) == false) {
				repertuar.add(saksofonista.getRepertuar()[i]);
			}

		}

		//drukowanie

		System.out.println("Liczba utworów mozliwych do zagrania: " + repertuar.size());

		for (int i = 0; i < repertuar.size(); i++) {

			System.out.println(repertuar.get(i));
			parametersGUI.add(repertuar.get(i).toString());

		}
		
		


	}


	//metoda zwracajaca cene wystepu wokalisty i pianisty przeslanego jako parametr
	public static int Generator_seePrice(Wokalista wokalista, Pianista pianista, Saksofonista saksofonista) {

		int price = wokalista.getStawka() + pianista.getStawka() + saksofonista.getStawka();

		return price;
	}
	

	//przydzielenie technika w zależności od budżetu
	public static Technik Generator_generateTechnik(Wokalista wokalista, Pianista pianista, Saksofonista saksofonista) {

		int price = Generator_seePrice(wokalista, pianista, saksofonista);

		if (price < 1800) {
			return technicy[0];
		} else if (price < 2500) {
			return technicy[1];
		} else {
			return technicy[2];
		}


	}

	//zastepuje metody generateWokaliska, generatePianista, generateSaksofonista
	public static Muzyk Generator_generateMuzyk(String jakiMuzyk) //format wprowadzania: "class packageName.className" na przyklad "class muzycy.Pianista"
	{
		Random generator = new Random();
		int randomNumber;

		do {
			randomNumber = generator.nextInt(muzycy.length);

		} while (!(muzycy[randomNumber].getClass().toString().equals(jakiMuzyk)));

		return muzycy[randomNumber];
	}


	//generowanie przypadkowego wokalisty
	/*public static Wokalista Generator_generateWokalista() {
		
		Random generator = new Random();
		Wokalista wokalista;
		int randomNumber = generator.nextInt(muzycy.length);
		
		//wybierz wokaliste
		
		while(!(muzycy[randomNumber] instanceof Wokalista)) {
			
			randomNumber = generator.nextInt(muzycy.length);
			
		}
		wokalista = (Wokalista) muzycy[randomNumber];
				
		
		
		return wokalista;
		
	}
	
	//generowanie przypadkowego pianisty
	public static Pianista Generator_generatePianista() {
		
		Random generator = new Random();
		Pianista pianista;
		int randomNumber = generator.nextInt(muzycy.length);		
		
		//wybierz pianista
		
		while(!(muzycy[randomNumber] instanceof Pianista)) {
			
			randomNumber = generator.nextInt(muzycy.length);
		
		}
		pianista = (Pianista) muzycy[randomNumber];		
		
		
		
		return pianista;
		
	}
	//generowanie losowego saksofonisty
	public static Saksofonista Generator_generateSaksofonista() {
		Random generator = new Random();
		Saksofonista saksofonista;
		int randomNumber = generator.nextInt(muzycy.length);
		//wybierz saksofoniste
		while (!(muzycy[randomNumber] instanceof Saksofonista)) {
			randomNumber = generator.nextInt(muzycy.length);
		}
		saksofonista = (Saksofonista) muzycy[randomNumber];
		return saksofonista;
	} */

	//zastepuje generateKeyboard i generateSaksofon
	public static Instrument Generator_generateInstrument(String jakiInstrument) //format wprowadzania: "class packageName.className" na przyklad "class instrument.Keyboard"
	{
		Random generator = new Random();
		int randomNumber;

		do {

			randomNumber = generator.nextInt(instrument.length);

		} while (!(instrument[randomNumber].getClass().toString().equals(jakiInstrument)));

		return instrument[randomNumber];
	}

	//generowanie losowego keyboarda
	/*public static Keyboard Generator_generateKeyboard() {
		Random generator = new Random();
		Keyboard keyboard;
		int randomNumber = generator.nextInt(instrument.length);
		//wybierz keyboard
		while (!(instrument[randomNumber] instanceof Keyboard)) {
			randomNumber = generator.nextInt(instrument.length);
		}
		keyboard = (Keyboard) instrument[randomNumber];
		return keyboard;
	}
	//generowanie losowego saksofonu
	public static Saksofon Generator_generateSaksofon() {
		Random generator = new Random();
		Saksofon saksofon;
		int randomNumber = generator.nextInt(instrument.length);
		//wybierz saksofon
		while (!(instrument[randomNumber] instanceof Saksofon)) {
			randomNumber = generator.nextInt(instrument.length);
		}
		saksofon = (Saksofon) instrument[randomNumber];
		return saksofon;
	} */

	//generowanie losowego mikrofonu
	public static Mikrofon Generator_generateMikrofon() {

		Random generator = new Random();
		Mikrofon mikrofon;
		int randomNumber = generator.nextInt(mikrofony.length);

		//wybierz mikrofon

		randomNumber = generator.nextInt(mikrofony.length);

		mikrofon = mikrofony[randomNumber];


		return mikrofon;


	}

	//generowanie przypadkowego trio i wydrukowanie imienia i nazwiska, metoda nieużywana
	public static void Generator_generateTrio() {

		Wokalista wokalista = (Wokalista) Generator_generateMuzyk("class muzycy.Wokalista");
		Pianista pianista = (Pianista) Generator_generateMuzyk("class muzycy.Pianista");
		Saksofonista saksofonista = (Saksofonista) Generator_generateMuzyk("class muzycy.Saksofonista");

		System.out.println("Wygenerowano trio:");
		System.out.println("Pianista: " + pianista.getImie() + " " + pianista.getNazwisko());
		System.out.println("Wokalista: " + wokalista.getImie() + " " + wokalista.getNazwisko());
		System.out.println("Saksofonista: " + saksofonista.getImie() + " " + saksofonista.getNazwisko());


	}


// GETTERS & SETTERS

	

	public static void pobierzListeDoTablicy() {
		final int n=muzycyLista.size();
		muzycy = new Muzyk[n];
		for (int i=0; i<n; i++)
			muzycy[i] = muzycyLista.get(i);
	}

	public static void pobierzTabliceDoListy() {
		final int n=muzycy.length;
		muzycyLista.clear();
		 for (int i=0; i<n; i++)
			 muzycyLista.add(muzycy[i]);
	}
	
	public static Muzyk[] getMuzycy() {
		return muzycy;
	}
	public static ArrayList<Muzyk> getMuzycyLista() {
		return muzycyLista;
	}


	public static int getKwota() {
		return kwota;
	}
	public static void setKwota(int kwota) {
		Generator.kwota = kwota;
	}
	public static WyborAlgorytmu getWyborAlgorytmu() {
		return wyborAlgorytmu;
	}
	public static void setWyborAlgorytmu(WyborAlgorytmu wyborAlgorytmu) {
		Generator.wyborAlgorytmu = wyborAlgorytmu;
	}
	public static void setMuzycy(Muzyk[] muzycy) {
		Generator.muzycy = muzycy;
	}
	public static void setMuzycyLista(ArrayList muzycyLista) {
		Generator.muzycyLista = muzycyLista;
	}


	public static Instrument[] getInstrument() {
		return instrument;
	}


	public static void setInstrument(Instrument[] instrument) {
		Generator.instrument = instrument;
	}


	public static Mikrofon[] getMikrofony() {
		return mikrofony;
	}


	public static void setMikrofony(Mikrofon[] mikrofony) {
		Generator.mikrofony = mikrofony;
	}


	public static Piosenka[] getBaza() {
		return baza;
	}


	public static void setBaza(Piosenka[] baza) {
		Generator.baza = baza;
	}
	public static ArrayList<String> getParametersGUI() {
		return parametersGUI;
	}
	public void setParametersGUI(ArrayList<String> parametersGUI) {
		this.parametersGUI = parametersGUI;
	}

	
	

}