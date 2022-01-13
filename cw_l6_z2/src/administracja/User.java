package administracja;

import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class User implements Serializable{

	private static final long serialVersionUID = -2231947533818882779L;
	
	private String login;
	private String haslo;
	private ArrayList<LocalDateTime> logowania;
	
	public User(String login, String haslo)
	{
		this.login = login;
		this.haslo = haslo;
		logowania = new ArrayList<LocalDateTime>();
	}
	
	public void User_logowanie()
	{
		logowania.add(LocalDateTime.now());
	}
	
	public boolean User_hasloCheck(String haslo)
	{
		if(this.haslo.equals(haslo))
		{
			return true;
		}
		else
			return false;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public ArrayList<LocalDateTime> getLogowania() {
		return logowania;
	}

	public void setLogowania(ArrayList<LocalDateTime> logowania) {
		this.logowania = logowania;
	}
	
	
	

}