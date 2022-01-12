package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import database.Dane;

public class LogowanieGUI {
	
	private JFrame ramka;
	private JPanel overlord;
	private JPanel north;
	private JPanel south;
	private JPanel center;
	private JPanel presubcenter;
	private JPanel subcenter1;
	private JPanel subcenter2;
	private JLabel titel;
	private JLabel log;
	private JLabel pass;
	private JLabel komunikat;
	private JTextField login;
	private JPasswordField haslo;
	private JButton zaloguj;
	
	
	public LogowanieGUI()
	{
		ramka = new JFrame("Logowanie");
		overlord = new JPanel();
		north = new JPanel();
		south = new JPanel();
		center = new JPanel();
		presubcenter = new JPanel();
		subcenter1 = new JPanel();
		subcenter2 = new JPanel();
		titel = new JLabel("ZALOGUJ DO BAZY DANYCH");
		log = new JLabel("Login:");
		pass = new JLabel("Haslo:");
		komunikat = new JLabel("");
		login = new JTextField(12);
		haslo = new JPasswordField(12);
		zaloguj = new JButton("Zaloguj");
	}
	
	public void logowanie()
	{
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramka.setSize(640,400);
		ramka.setVisible(true);
		ramka.getContentPane().add(overlord, BorderLayout.CENTER);
		overlord.setLayout(new BoxLayout(overlord, BoxLayout.Y_AXIS));
		
		titel.setFont(titel.getFont().deriveFont(28.0f));
		
		//ramka.getContentPane().add(north, BorderLayout.NORTH);
		overlord.add(north);
		north.add(titel);
		
		
		//ramka.getContentPane().add(center, BorderLayout.CENTER);
		overlord.add(center);
		center.add(presubcenter);
		//center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		presubcenter.setLayout(new BoxLayout(presubcenter, BoxLayout.Y_AXIS));
		presubcenter.add(subcenter1);
		presubcenter.add(subcenter2);
		presubcenter.add(komunikat);
		
		log.setFont(log.getFont().deriveFont(14.0f));
		subcenter1.add(log);
		login.setFont(login.getFont().deriveFont(14.0f));
		login.setPreferredSize(new Dimension(50,30));
		subcenter1.add(login);
		
		pass.setFont(pass.getFont().deriveFont(14.0f));
		subcenter2.add(pass);
		haslo.setFont(haslo.getFont().deriveFont(14.0f));
		haslo.setPreferredSize(new Dimension(50,30));
		subcenter2.add(haslo);
		
		//ramka.getContentPane().add(south, BorderLayout.SOUTH);
		overlord.add(south);
		south.add(zaloguj);
		zaloguj.addActionListener(new LogowanieGUI.ButtonListener());
		
		
	}
	
	class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			String userLogin = login.getText();
			String userPass = new String(haslo.getPassword());
			boolean flag = true;
			
			for(int i=0; i<Dane.getUzytkownicy().size() ;i++)
			{
				if(Dane.getUzytkownicy().get(i).getLogin().equals(userLogin))
				{
					flag=false;
					if(Dane.getUzytkownicy().get(i).User_hasloCheck(userPass))
					{
						Dane.getUzytkownicy().get(i).User_logowanie();
						//tutaj kolejne gui
						komunikat.setText("poprawne logowanie");
					}
					else
					{
						komunikat.setText("Nieprawidlowe haslo dla "+userLogin);
					}
				}
			}
			if(flag)
			{
				komunikat.setText("Uzytkownik "+userLogin+" nie jest zarejestrowany!");
			}
			
		}
		
	}

}
