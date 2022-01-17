package instrument;

public class Keyboard extends Instrument {

    private static final long serialVersionUID = 3778153046102205483L;

    private String klasa; // profesjonalna, srednia
    private String rodzajKlawiatury; // wazona, dowazana, syntezatorowa, pelna, mloteczkowa
    private String elementyDodatkowe; // sekwencer, glosniki, pulpit pod nuty, zasilacz sieciowy

    public Keyboard(String producent, int cena, int rokProdukcji, String klasa, String rodzajKlawiatury, String elementyDodatkowe) {
        super(producent, cena, rokProdukcji);

        this.klasa = klasa;
        this.rodzajKlawiatury = rodzajKlawiatury;
        this.elementyDodatkowe = elementyDodatkowe;
    }

    // GETTERS & SETTERS

    public String getKlasa() {
        return klasa;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    public String getRodzajKlawiatury() {
        return rodzajKlawiatury;
    }

    public void setRodzajKlawiatury(String rodzajKlawiatury) {
        this.rodzajKlawiatury = rodzajKlawiatury;
    }

    public String getElementyDodatkowe() {
        return elementyDodatkowe;
    }

    public void setElementyDodatkowe(String elementyDodatkowe) {
        this.elementyDodatkowe = elementyDodatkowe;
    }

    public String getStringKeyboard() {
        return "\tProducent: " + getProducent() + "\tCena: " + getCena() + "\tRok produkcji: "
                + getRokProdukcji() + "\tKlasa: " + getKlasa() + "\tRodzaj klawiatury: "
                + getRodzajKlawiatury() + "\tElementy dodatkowe: " + getElementyDodatkowe();
    }
}
