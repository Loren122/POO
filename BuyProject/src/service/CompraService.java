package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import model.Cliente;
import model.Compra;
import model.LineaCompra;
import model.Producto;

public class CompraService {
	private List<LineaCompra> lineas;
	private List<Compra> compras = new ArrayList<>();
	
	public CompraService() {
		super();
		lineas = new ArrayList<>();
	}

	public void crear(Date fecha, Map clienteMap) {
		Cliente cliente = new Cliente((String) clienteMap.get("nombre"), (String) clienteMap.get("cuit"), (String) clienteMap.get("email"), (String)clienteMap.get("numero_calular"));
		Compra compra = new Compra(fecha, lineas, cliente);
		compras.add(compra);
		lineas = new ArrayList<>();
		
	}
	
	public void agregarLineaCompra(Integer cantProd, String nombreProd, ProductoService pds) {
		Map<String, Object> prod = pds.buscar(nombreProd);
		if (prod!= null) {
			String nombre = prod.get("nombre").toString();
			String tipo = prod.get("tipo").toString();
			String stock = prod.get("stock").toString();
			String precio = prod.get("precio").toString();
			Producto pd = new Producto(nombre, tipo, Integer.valueOf(stock) , Double.valueOf(precio));
			LineaCompra line = new LineaCompra(cantProd, pd);
			lineas.add(line);
		}
	}

	public List<LineaCompra> getLineas() {
		return lineas;
	}
	public String getCompras() {
		return compras.get(0).toString();
	}

	
	
	
	
	
	
}
