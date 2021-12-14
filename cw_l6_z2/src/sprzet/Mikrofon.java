package sprzet;

import java.io.Serializable;

public class Mikrofon implements Serializable{
	private String marka;
	private String model;
	private boolean czyDynamiczny;
	
	public Mikrofon() {
		marka = "Shure";
		model = "SM58-LCE";
		czyDynamiczny = true;
	}
	
	public Mikrofon(String marka, String model, boolean CzyDynamiczny) {
		this.marka = marka;
		this.model = model;
		this.czyDynamiczny = CzyDynamiczny;
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
