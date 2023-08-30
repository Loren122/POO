package model;

public class Cliente {
	private String nombre;
	private String cuit;
	private String email;
	private String numero_celular;
	
	public Cliente(String nombre,String cuit, String email,String numero_celular) {
		super();
		this.nombre = nombre;
		this.cuit = cuit;
		this.email = email;
		this.numero_celular = numero_celular;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumero_celular() {
		return numero_celular;
	}
	public void setNumero_celular(String numero_celular) {
		this.numero_celular = numero_celular;
	}
}
