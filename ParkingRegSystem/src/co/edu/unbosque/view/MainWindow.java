package co.edu.unbosque.view;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	private PrincipalPanel pp;
	
	public MainWindow() {

		setSize(750, 480);
		setTitle("Parking Registration System");
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pp = new PrincipalPanel();
		
		add(pp).setVisible(true);
		
		setVisible(true);
		
		
	}

}
