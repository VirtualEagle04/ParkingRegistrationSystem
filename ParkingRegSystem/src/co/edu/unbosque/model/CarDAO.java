package co.edu.unbosque.model;

import co.edu.unbosque.model.persistance.FileHandler;

public class CarDAO {

	private MyLinkedList<CarDTO> lista;
	
	public CarDAO() {
//		lista = new MyLinkedList<>();

		lista = (MyLinkedList<CarDTO>) FileHandler.leerSerializado("registration.txt");
		if (lista == null) {
			lista = new MyLinkedList<CarDTO>();
		}
		
	}

	public MyLinkedList<CarDTO> getLista() {
		return lista;
	}

	public void setLista(MyLinkedList<CarDTO> lista) {
		this.lista = lista;
	}
	
	public void escribirArchivo() {
		FileHandler.escribirSerializado("registration.txt", lista);
	}
	
	public void agregar(CarDTO nuevoCarro) {
		lista.addLast(nuevoCarro);
		escribirArchivo();
	}
	
	public void eliminar(int index) {
		lista.remove(index);
		escribirArchivo();
	}
	
	public void actualizar(int index, CarDTO nuevoCarro) {
		lista.replace(index, nuevoCarro);
		escribirArchivo();
	}
	
	public String mostrar() {
		StringBuilder sb = new StringBuilder();
		sb.append("Carros:\n");
		for(int i = 0; i < lista.size(); i++) {
			sb.append(lista.get(i).getData().toString()+"\n");
			sb.append("---------------------------------------------");
		}
		return sb.toString();
	}
	
	
}
