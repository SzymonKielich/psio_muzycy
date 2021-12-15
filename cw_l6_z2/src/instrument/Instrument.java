package instrument;

import java.io.Serializable;

public abstract class Instrument implements Serializable {

    private static final long serialVersionUID = -7995967695934150101L;

    private String producent;
    private int cena;
    private int rokProdukcji;


    public Instrument(String producent, int cena, int rok_produkcji) {
        this.producent = producent;
        this.cena = cena;
        this.rokProdukcji = rok_produkcji;
    }

    // GETTERS & SETTERS

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(int rok_produkcji) {
        this.rokProdukcji = rok_produkcji;
    }

    /*public void Instrument_playAnInstrument(Instrument instrument)
    {
        System.out.println("Muzyk gra na instrumencie!");
    }*/

}
