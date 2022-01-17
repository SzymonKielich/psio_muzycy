package wyjatki;

public class WyjatekNiepoprawnyBudzet extends Exception{
	
	public String getMessage()
	{
		return super.getMessage() + " Kwota wprowadzonego budzetu powinna byc wielokrotnoscia 100";
	}

}
