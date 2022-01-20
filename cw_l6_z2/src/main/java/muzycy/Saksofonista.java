package muzycy;
import instrument.Keyboard;
import instrument.Saksofon;
import repertuar.Piosenka;

public class Saksofonista extends Muzyk {
    private boolean czySiedzi;
    private Saksofon saksofon = null;
    private static final long serialVersionUID = 123456789;

    public Saksofonista(String imie, String nazwisko, int poziomUmiejetnosci, int stawka, boolean czySiedzi, Piosenka[] tab) {

        super(imie, nazwisko, poziomUmiejetnosci, stawka, tab);

        this.czySiedzi = czySiedzi;


    }

    // GETTERS & SETTERS

    public Saksofonista() {
		// TODO Auto-generated constructor stub
	}

	public boolean isCzySiedzi() {
        return czySiedzi;
    }

    public void setCzySiedzi(boolean czySiedzi) {
        this.czySiedzi = czySiedzi;
    }

    public String getStringSaksofon() {
        return saksofon.getStringSaksofon();
    }

    public void setSaksofon(Saksofon saksofon) {
        this.saksofon = saksofon;
    }

	public Saksofon getSaksofon() {
		return saksofon;
	}

    
    
}
