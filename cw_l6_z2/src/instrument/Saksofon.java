package instrument;

public class Saksofon extends Instrument {
	
	private static final long serialVersionUID = -3391940550943806736L;
	

    private String rodzaj; // sopranowy, altowy, tenorowy, barytonowy
    private String strojMuzyczny; // B, Es

    public Saksofon(String producent, int cena, int rokProdukcji, String rodzaj, String strojMuzyczny)
    {
        super(producent, cena, rokProdukcji);

        this.rodzaj = rodzaj;
        this.strojMuzyczny = strojMuzyczny;
    }

    // GETTERS & SETTERS

    public String getStrojMuzyczny() {
        return strojMuzyczny;
    }

    public void setStrojMuzyczny(String strojMuzyczny) {
        this.strojMuzyczny = strojMuzyczny;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getStringSaksofon()
    {
        return "Producent: "+getProducent()+"\tCena: "+getCena()+"\tRok produkcji: "+getRokProdukcji()
                +"\tRodzaj: "+getRodzaj()+"\tStrój muzyczny: "+ getStrojMuzyczny();
    }


}

