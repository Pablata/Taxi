package models;

import java.util.Date;

public class Cliente {
	
	protected int numeroCliente;
	protected String fechaSubida;
	protected String fechaBajada;
	protected float precioTotal;
	
	public Cliente(int numeroCliente, String fechaSubida, String fechaBajada, float precioTotal) {
		super();
		this.numeroCliente = numeroCliente;
		this.fechaSubida = fechaSubida;
		this.fechaBajada = fechaBajada;
		this.precioTotal = precioTotal;
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public int getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(int numeroCliente) {
		this.numeroCliente = numeroCliente;
	}

	public String getFechaSubida() {
		return fechaSubida;
	}

	public void setFechaSubida(String date) {
		this.fechaSubida = date;
	}

	public String getFechaBajada() {
		return fechaBajada;
	}

	public void setFechaBajada(String fechaBajada) {
		this.fechaBajada = fechaBajada;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	@Override
	public String toString() {
		return "Cliente [numeroCliente=" + numeroCliente + ", fechaSubida=" + fechaSubida + ", fechaBajada="
				+ fechaBajada + ", precioTotal=" + precioTotal + "]";
	}
	
	
	
	
}
