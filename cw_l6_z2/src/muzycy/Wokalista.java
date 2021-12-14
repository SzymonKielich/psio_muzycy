package muzycy;
import repertuar.Piosenka;
import sprzet.Mikrofon;

public class Wokalista extends Muzyk {
	
	private static final long serialVersionUID = 2861962873409064960L;
	
	private String skalaPoczatek;
	private String skalaKoniec;
	
	private Mikrofon mikro = null;
	
	public Wokalista(String imie, String nazwisko, int poziomUmiejetnosci, int stawka, String skalaPoczatek, String skalaKoniec, Piosenka[]tab) {
		
		super(imie,nazwisko,poziomUmiejetnosci,stawka,tab);
		
		this.skalaPoczatek = skalaPoczatek;
		this.skalaKoniec = skalaKoniec;
		
	}
	//metoda przyslonieta z klasy muzyk
	public void Muzyk_play(Wokalista wokalista) {
		
		System.out.print("Odtwarzam demo wokalisty: " + wokalista.getImie() + " " + wokalista.getNazwisko());
		System.out.println(": oOooooOo lalala!!");
	}
	
	public void Wokalista_wybierzMikrofon(String marka, String model, boolean CzyDynamiczny) {
		this.mikro = new Mikrofon(marka, model, CzyDynamiczny);
	}
	
	public void Wokalista_wyswietlUlubionyMikrofon() {
		
		System.out.print(mikro.getMarka() + " " + mikro.getModel() + ". ");
		
		if(mikro.getCzyDynamiczny())
			System.out.println("Jest on dynamiczny.");
		else
			System.out.println("Nie jest on dynamiczny.");
		
	}

	// GETTERS & SETTERS
	
	public void setMikrofon(Mikrofon m) {
		this.mikro = m;
	}
	
	public Mikrofon getMikrofon() {
		return mikro;
	}
	
	public String getSkalaPoczatek() {
		return skalaPoczatek;
	}

	public void setSkalaPoczatek(String skalaPoczatek) {
		this.skalaPoczatek = skalaPoczatek;
	}

	public String getSkalaKoniec() {
		return skalaKoniec;
	}

	public void setSkalaKoniec(String skalaKoniec) {
		this.skalaKoniec = skalaKoniec;
	}
	
}
