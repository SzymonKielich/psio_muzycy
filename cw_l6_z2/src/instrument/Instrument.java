package instrument;

import java.io.Serializable;

public abstract class Instrument implements Serializable{
    private String producent;
    private int cena;
    private int rokRrodukcji;


    public Instrument(String producent, int cena, int rok_produkcji)
    {
        this.producent = producent;
        this.cena = cena;
        this.rokRrodukcji = rok_produkcji;
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
        return rokRrodukcji;
    }

    public void setRokProdukcji(int rok_produkcji) {
        this.rokRrodukcji = rok_produkcji;
    }

    /*public void playAnInstrument(Instrument instrument)
    {
        System.out.println("Muzyk gra na instrumencie!");
    }*/

}
