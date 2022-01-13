package GUI;

import GUI.PanelAdministracyjny.Administracja;

import java.awt.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;

public class EkranPoczatkowy {
	private JFrame frame;

	private JButton buttonGenerator;
	private JButton buttonPanelAdministracyjny;

	class ReakcjaNaButtonGenerator implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// todo
			wybor_algorytmu screen = new wybor_algorytmu();
			screen.GUI();
		}
	}

	class ReakcjaNaButtonPanelAdministracyjny implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("*panel otwiera sie*");
			LogowanieGUI g = new LogowanieGUI();
			g.logowanie();
			frame.dispose();
		}
	}

	public EkranPoczatkowy() {

		frame = new JFrame("Ekran startowy");
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JLabel label = new JLabel("Witaj użytkowniku! :)");
		label.setFont(new Font("Calibri", Font.BOLD, 20));

		frame.setSize(640, 400);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.NORTH, panel1);
		frame.getContentPane().add(BorderLayout.CENTER, panel2);

		buttonGenerator = new JButton("Generator");
		buttonPanelAdministracyjny = new JButton("Panel Administracyjny");

		panel2.setLayout(new GridLayout(1, 2, 20, 1));
		buttonGenerator.setFont(new Font("Calibri", Font.BOLD, 25));
		buttonPanelAdministracyjny.setFont(new Font("Calibri", Font.BOLD, 25));
		buttonGenerator.setForeground(Color.BLUE);
		buttonPanelAdministracyjny.setForeground(Color.RED);

		panel1.add(label);
		panel2.add(buttonGenerator);
		panel2.add(buttonPanelAdministracyjny);
		panel1.setPreferredSize(new Dimension(640, 40));
		panel2.setPreferredSize(new Dimension(640, 360));

		try {
			Image img = ImageIO.read(getClass().getResource("generatorIcon.jpg"));
			Image mniejszy = img.getScaledInstance(180, 200, java.awt.Image.SCALE_SMOOTH);
			buttonGenerator.setIcon(new ImageIcon(mniejszy));

		} catch (Exception ex) {
			System.out.println(ex);
		}

		buttonGenerator.setHorizontalTextPosition(JButton.CENTER);
		buttonGenerator.setVerticalTextPosition(JButton.CENTER);
		buttonGenerator.setVerticalTextPosition(SwingConstants.TOP);
		buttonGenerator.setHorizontalTextPosition(SwingConstants.CENTER);

		try {
			Image img = ImageIO.read(getClass().getResource("administratorIcon.jpg"));
			Image mniejszy = img.getScaledInstance(180, 200, java.awt.Image.SCALE_SMOOTH);
			buttonPanelAdministracyjny.setIcon(new ImageIcon(mniejszy));

		} catch (Exception ex) {
			System.out.println(ex);
		}

		buttonPanelAdministracyjny.setHorizontalTextPosition(JButton.CENTER);
		buttonPanelAdministracyjny.setVerticalTextPosition(JButton.CENTER);
		buttonPanelAdministracyjny.setVerticalTextPosition(SwingConstants.TOP);
		buttonPanelAdministracyjny.setHorizontalTextPosition(SwingConstants.CENTER);

		panel1.add(label);
		panel2.add(buttonGenerator);
		panel2.add(buttonPanelAdministracyjny);
		panel1.setPreferredSize(new Dimension(640, 40));
		panel2.setPreferredSize(new Dimension(640, 360));

		/*
		 * kolory Color c1 = new Color(51-153-255);
		 * buttonPanelAdministracyjny.setBackground(c1);
		 * buttonGenerator.setBackground(c1);
		 */
//        buttonPanelAdministracyjny.setBackground(Color.white);
//        buttonGenerator.setBackground(Color.white);

		frame.pack();

		buttonGenerator.addActionListener(new ReakcjaNaButtonGenerator());
		buttonPanelAdministracyjny.addActionListener(new ReakcjaNaButtonPanelAdministracyjny());
	}
}
