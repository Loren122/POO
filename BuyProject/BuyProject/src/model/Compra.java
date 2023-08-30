package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {
	private static int contId = 0;
	private int id;
	private Date fecha;
	private Cliente cliente;
	private List<LineaCompra> lineasCompra = new ArrayList<>();
	
	
	public Compra(Date fecha, List<LineaCompra> lineasCompra, Cliente cliente){
		super();
		this.fecha = fecha;
		this.lineasCompra = lineasCompra;
		this.cliente = cliente;
		contId++;
		id = contId;
	}

	@Override
	public String toString() {
		return "Compra [Cliente=" + cliente.getNombre() + ", fecha=" + fecha + 
				", Lineas de Compra=" + 
				lineasCompra.get(0).toString() + "]";
	}
	public String returnLineas() {
		String lineas = new String();
		for (int i = 0; i< lineasCompra.size(); i++) {
			lineas = lineas + lineasCompra.get(i).toString();
		}
		return lineas;
	}

	public double getTotal(){
		double total = 0;
		for (int i = 0; i < lineasCompra.size(); i++) {
			total = total + lineasCompra.get(i).getSubTotal();
		}
		return total;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<LineaCompra> getLineasCompra() {
		return lineasCompra;
	}

	public void setLineasCompra(LineaCompra lCompra){
		this.lineasCompra.add(lCompra);
	}
	
}