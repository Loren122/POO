package model;

public enum TipoProduct {
	LACTEO("Lacteo"),
	BEBIDA("Bebida");
	
	private String nombre;
	private TipoProduct(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}
}
