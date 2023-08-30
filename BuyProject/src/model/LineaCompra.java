package model;

public class LineaCompra {
	private Integer cantidad;
	private Producto producto;
	
	
	
	public LineaCompra(Integer cantidad, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
	}
	

	@Override
	public String toString() {
		return "LineaCompra [cantidad=" + cantidad + ", producto=" + producto.getNombre() + "]";
	}


	public double getSubTotal() {
		return this.producto.getPrecio() * cantidad;
	}

	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
