package model;

public class Producto {
	private String nombre;
	private String tipo;
	private int stock;
	private double precio;
	
	public Producto(String nombre, String tipo, int stock, Double precio) {
		super();
		this.nombre=nombre;
		this.tipo=tipo;
		this.stock=stock;
		this.precio=precio;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
