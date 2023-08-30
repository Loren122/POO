package model;

public class Promo1 implements Promociones{

	@Override
	public double getDescuento(Compra compra) {
		return compra.getTotal()-(0.1 * compra.getTotal());
		
	}
	
}
