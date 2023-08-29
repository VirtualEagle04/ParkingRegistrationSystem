package co.edu.unbosque.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CarDTO implements Serializable {

	private static final long serialVersionUID = 5469349475206911930L;
	
	private String placa;
	private Date entrada;
	private Date salida;

	public CarDTO() {
	}

	public CarDTO(String placa, Date entrada, Date salida) {
		super();
		this.placa = placa;
		this.entrada = entrada;
		this.salida = salida;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Date getEntrada() {

		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSalida() {
		return salida;
	}

	public void setSalida(Date salida) {
		this.salida = salida;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy - HH:mm:ss");

		return "(Placa: " + getPlaca() + ", Entrada: " + sdf.format(getEntrada()) + ", Salida: "
				+ sdf.format(getSalida()) + ")";

	}

}
