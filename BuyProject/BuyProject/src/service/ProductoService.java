package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Producto;
import model.TipoProduct;

public class ProductoService {
	private List<Producto> productos;
	
	public ProductoService() {
		super();
		productos = new ArrayList<>();
	}
	public boolean validarNombre(String nombre){
        return nombre.length() >= 2;
    }
	public boolean validarTipoProducto(String tipo) {
		for (TipoProduct prod: TipoProduct.values()) {
			if (prod.getNombre().equalsIgnoreCase(tipo)){
				return true;
			}
		}
		return false;
	}
	public boolean validarStock(int stock) {
		return stock>=0;
    }
	public boolean validarPrecio(double precio) {
		String stringprecio=String.valueOf(precio);
		Pattern pattern = Pattern.compile("^\\d+(?:\\.\\d{1,2})?$");
        Matcher matcher = pattern.matcher(stringprecio);
        return matcher.matches();
	}
	
//	metodo que agrega un prod a List<Producto> productos, si ya existe actualiza su stock y precio
	public String agregarProd(String nombre, String tipo, int stock, double precio){
		Map<String, Object> exist = buscar(nombre);
		if (exist == null) {
//			valida cada atributo, si es incorrecto retorna string
			if (!validarNombre(nombre)) {
	            return "El nombre debe tener al menos 2 caracteres.";
	        }else if (!validarTipoProducto(tipo)){
	            return "El tipo de producto no es válido.";
	        } else if (!validarStock(stock)) {
	            return "No hay stock de este producto.";
	        } else if (!validarPrecio(precio)) {
	            return "El precio ingresado no es valido.";
	        }else {
	        	Producto pd = new Producto(nombre, tipo, stock, precio);
	        	productos.add(pd);
	        	return "Producto registrado exitosamente!";
	        }
		}else {
			for (int i = 0; i<productos.size(); i++) {
				Producto prod = productos.get(i);
				if (prod.getNombre() == nombre) {
					Integer stock_act = prod.getStock() + stock;
					prod.setStock(stock_act);
					prod.setPrecio(precio);
					return "Producto actualizado exitosamente!";
				}
			}
		}
		return null;
	}
	
//	busca un prod por su nombre y retorna un Map(diccionario) con la info de este
	public Map<String, Object> buscar(String nombre) {
		if (productos.size() == 0){
			return null;
		}else {
			for (int i = 0; i<productos.size(); i++) {
				Producto prod = productos.get(i);
				if (prod.getNombre().equalsIgnoreCase(nombre)) {
					Map<String, Object> result = new HashMap<>();
					result.put("precio", prod.getPrecio());
					result.put("stock", prod.getStock());
					result.put("tipo", prod.getTipo());
					result.put("nombre", prod.getNombre());
					return result;
				}
			}
		}
		return null;
	}
	
	
	public boolean verProductos() {
		if (productos.size()> 0) {
			for (int i = 0; i<productos.size() ; i++) {
				System.out.println(". Producto: "+productos.get(i).getNombre()+" Precio: "+productos.get(i).getPrecio()+" Sotck: " +productos.get(i).getStock());
			}
			return true;
		}else {
			System.out.println("No hay productos registrados");
			return false;
		}
	}
	public String getTipos() {
		String prods = new String();
		for (TipoProduct prod: TipoProduct.values()) {
			prods = prods + " " +prod.getNombre();
		}
		return prods;
	}
	
	public void update(String nombre, Integer cant){
		for (int i = 0; i<productos.size(); i++) {
			if (productos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				Integer stock = productos.get(i).getStock();
				productos.get(i).setStock(stock - cant);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
}
