package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.CarDAO;
import co.edu.unbosque.model.CarDTO;
import co.edu.unbosque.view.MainWindow;

public class Controller implements ActionListener {

	private CarDAO cdao;
	private MainWindow mw;

	public Controller() {
	}

	public void run() {
		cdao = new CarDAO();
		mw = new MainWindow();

		agregarLectores();
		actualizarLista();
	}

	public void agregarLectores() {
		mw.getPp().getAddButton().addActionListener(this);
		mw.getPp().getAddButton().setActionCommand("Add");

		mw.getPp().getDeleteButton().addActionListener(this);
		mw.getPp().getDeleteButton().setActionCommand("Delete");
	}

	public void actualizarLista() {
		mw.getPp().getCarList().setCellRenderer(new DefaultListCellRenderer() { 
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				Component comp = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if(cdao.getLista().get(index).getData().getSalida() != null) {
					comp.setForeground(Color.lightGray);
				}
				return comp;
			}
		});
		DefaultListModel<String> tempList = new DefaultListModel<>();

		for (int i = 0; i < cdao.getLista().size(); i++) {
			CarDTO aux = cdao.getLista().get(i).getData();
			tempList.addElement("<html><body>" + aux.getPlaca() + "<br>Fecha de Entrada: " + aux.getEntrada() + "<br>Fecha de Salida:" + aux.getSalida() + "</body></html>");
		}
		mw.getPp().getCarList().setModel(tempList);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Add": {
			String placa = mw.getPp().getInput().getText();
			int cont = 1; 
			for (int i = 0; i < cdao.getLista().size(); i++) {
				if (cdao.getLista().get(i).getData().getSalida() == null) {
					cont++;
				}
			}
			
			if(cont <= 100) {
				if (placa.equals("")) {
					JOptionPane.showMessageDialog(mw, "Digite una placa valida.", "Error en el Registro", JOptionPane.ERROR_MESSAGE);
					break;
				}
				for (int i = 0; i < cdao.getLista().size(); i++) {
					if (placa.equals(cdao.getLista().get(i).getData().getPlaca()) && cdao.getLista().get(i).getData().getSalida() == null) {
						JOptionPane.showMessageDialog(mw, "Esta placa ya esta registrada. Intente nuevamente.","Error en el Registro", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				if (!checkPlate(placa)) {
					JOptionPane.showMessageDialog(mw, "Digite una placa valida. Siga el siguiente formato: ABC-123","Error en el Registro", JOptionPane.ERROR_MESSAGE);
					break;
					
					
				} else {
					CarDTO temp = new CarDTO(placa, new Date(), null);
					cdao.agregar(temp);
					actualizarLista();
					JOptionPane.showMessageDialog(mw, "Registro Exitoso de la placa: " + placa, "Exito en el Registro", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
			JOptionPane.showMessageDialog(mw, "Numero de Maximo de Vehiculos Alcanzado", "Error en el Registro", JOptionPane.ERROR_MESSAGE);
			break;
		}
		case "Delete": {
			int posDel = mw.getPp().getCarList().getSelectedIndex();
			if (posDel == -1) {
				JOptionPane.showMessageDialog(mw,"Seleccione un vehiculo valido.","Error en la Eliminacion", JOptionPane.ERROR_MESSAGE);
				break; 
			}
			
			CarDTO temp = cdao.getLista().get(posDel).getData();
			if (temp.getSalida() != null) {
				JOptionPane.showMessageDialog(mw,"El vehiculo con placa: " + temp.getPlaca() + " ya no se encuentra en el estacionamiento.", "Error en la Eliminacion", JOptionPane.ERROR_MESSAGE);
				break;
			}
			
			cdao.actualizar(posDel, new CarDTO(temp.getPlaca(), temp.getEntrada(), new Date()));
			actualizarLista();
			JOptionPane.showMessageDialog(mw, "Eliminacion Exitosa de la placa: " + temp.getPlaca(), "Exito en la Eliminacion", JOptionPane.INFORMATION_MESSAGE);
			break;
		}

		}
	}

	public boolean checkPlate(String placa) {
		if (!placa.contains("-") || placa.replaceAll("[^-]", "").length() > 1) return false;
		String[] parts = placa.split("-");
		if (parts[0].matches(".[^A-Z].") || parts[1].matches(".[^0-9].") || parts[0].length() != 3 || parts[1].length() != 3) return false;
		return true;
	}
}
