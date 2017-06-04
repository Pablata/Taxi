package models;

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

	public int getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(int numeroCliente) {
		this.numeroCliente = numeroCliente;
	}

	public String getFechaSubida() {
		return fechaSubida;
	}

	public void setFechaSubida(String fechaSubida) {
		this.fechaSubida = fechaSubida;
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
	
	
	
	
}
