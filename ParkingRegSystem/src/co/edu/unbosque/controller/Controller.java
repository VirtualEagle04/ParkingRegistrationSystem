package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import co.edu.unbosque.model.CarDAO;
import co.edu.unbosque.model.CarDTO;
import co.edu.unbosque.view.MainWindow;

public class Controller implements ActionListener{
	
	private CarDAO cdao;
	private MainWindow mw;
	
	public Controller() {
		cdao = new CarDAO();
		mw = new MainWindow();
		
		
		agregarLectores();
	}
	
	public void run() {
	}
	
	public void agregarLectores() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
}
