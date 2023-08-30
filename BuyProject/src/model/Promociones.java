package model;

public interface Promociones {
	public default double getDescuento(Compra compra) {
		return 0;
	}
}
