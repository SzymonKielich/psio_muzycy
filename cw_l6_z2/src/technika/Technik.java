package technika;

import muzycy.Osoba;
import rider.Rider;

public class Technik extends Osoba{
	
	private int stawka;
	private int poziomUmiejetnosci;
	private String preferowanStol;
	Rider rider;
	
	
	public Technik(String imie, String nazwisko, int stawka, int poziomUmiejetnosci, String preferowanyStol, Rider rider){
		
		super(imie, nazwisko);
		this.stawka = stawka;
		this.poziomUmiejetnosci = poziomUmiejetnosci;
		this.preferowanStol = preferowanyStol;
		this.rider = rider;
		
		
		
	}

	// GETTERS & SETTERS

	public int getStawka() {
		return stawka;
	}


	public void setStawka(int stawka) {
		this.stawka = stawka;
	}


	public int getPoziomUmiejetnosci() {
		return poziomUmiejetnosci;
	}


	public void setPoziomUmiejetnosci(int poziomUmiejetnosci) {
		this.poziomUmiejetnosci = poziomUmiejetnosci;
	}


	public String getPreferowanStol() {
		return preferowanStol;
	}


	public void setPreferowanStol(String preferowanStol) {
		this.preferowanStol = preferowanStol;
	}


	public Rider getRider() {
		return rider;
	}


	public void setRider(Rider rider) {
		this.rider = rider;
	}
	
	
	
	

}
