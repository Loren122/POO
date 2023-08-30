package model;

public enum TipoProduct {
	LACTEO("Lacteo"),
	BEBIDA("Bebida"),
	LIMPIEZA("Limpieza"),
	VERDURA("Verdura"),
	FIAMBRE("Fiambre"),
	CONGELADO("Congelado"),
	EMBUTIDO("Embutido"),
	GALLETITAS("Galletitas");
	
	
	private String nombre;
	private TipoProduct(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}
}
