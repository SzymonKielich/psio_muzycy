package sprzet;

import java.io.Serializable;

public class Mikrofon implements Serializable {

	private static final long serialVersionUID = 2801013545969244616L;

	private String marka;
	private String model;
	private boolean czyDynamiczny;

	public Mikrofon() {
		marka = "Shure";
		model = "SM58-LCE";
		czyDynamiczny = true;
	}

	public Mikrofon(String marka, String model, boolean czyDynamiczny) {
		this.marka = marka;
		this.model = model;
		this.czyDynamiczny = czyDynamiczny;
	}


	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean getCzyDynamiczny() {
		return czyDynamiczny;
	}

	public void setCzyDynamiczny(boolean czyDynamiczny) {
		this.czyDynamiczny = czyDynamiczny;
	}

}
