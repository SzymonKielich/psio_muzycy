package muzycy;
import java.io.Serializable;

import instrument.Keyboard;
import repertuar.Piosenka;


public class Pianista extends Muzyk {
	private static final long serialVersionUID = -3586698602335628625L;
	private String rodzajStatywu;
	private boolean czySpiewa;
	private Keyboard keyboard = null;

	public Pianista() {

	}

	public Pianista(String imie, String nazwisko, int poziomUmiejetnosci, int stawka, String rodzajStatywu, boolean czySpiewa, Piosenka[] tab) {

		super(imie, nazwisko, poziomUmiejetnosci, stawka, tab);

		this.rodzajStatywu = rodzajStatywu;
		this.czySpiewa = czySpiewa;
	}

	//metoda przyslonieta z klasy muzyk
	public void Muzyk_play(Pianista pianista) {

		System.out.println("Odtwarzam demo pianisty: " + pianista.getImie() + " " + pianista.getNazwisko());
	}


	// GETTERS & SETTERS

	public String getRodzajStatywu() {
		return rodzajStatywu;
	}


	public void setRodzajStatywu(String rodzajStatywu) {
		this.rodzajStatywu = rodzajStatywu;
	}


	public boolean isCzySpiewa() {
		return czySpiewa;
	}


	public void setCzySpiewa(boolean czySpiewa) {
		this.czySpiewa = czySpiewa;
	}


	public String getStringKeyboard() {
		return keyboard.getStringKeyboard();
	}

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}
	


}