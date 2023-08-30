package model;

public class Promo3 implements Promociones{

	@Override
	public double getDescuento(Compra compra) {
		return compra.getTotal()-(0.2 * compra.getTotal());
	}
	
}
