package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Cliente;


public class ClientService {
	private List<Cliente> clientes;

	public ClientService(){
		super();
		this.clientes = new ArrayList<>();
	}
	public boolean validarNombre(String nombre) {
        return nombre.length() >= 2;
    }
    public boolean validarCuit(String cuit) {
        Pattern pattern = Pattern.compile("\\d{2}-\\d{8}-\\d{1}");
        Matcher matcher = pattern.matcher(cuit);
        return matcher.matches();
    }
    public boolean validarEmail(String email) {
        String pattern = "^[\\w.-]+@[\\w.-]+\\.[\\w]+$";
        return email.matches(pattern);
    }
    public boolean validarCelular(String numero_celular) {
        String pattern = "^[\\d-()]+$";
        return numero_celular.matches(pattern);
    }
	
	
	public void agregar(String nombre,String cuit, String email,String numero_celular){
		if (searchByCuit(cuit) == null) {
			if (validarNombre(nombre) & validarCuit(cuit) & validarEmail(email) & validarCelular(numero_celular)) {
				Cliente client = new Cliente(nombre, cuit, email, numero_celular);
				clientes.add(client);
			}
		}
	}

	
//	Busca un cliente por su cuit y retorna un diccionario con su info
	public Map<String, Object> searchByCuit(String cuit){
		if (clientes.size() == 0) {
			return null;
		}else {
			for (int i = 0; i<clientes.size() ; i++) {
				Cliente client = clientes.get(i);
				if (client.getCuit().equalsIgnoreCase(cuit)) {
					Map<String, Object> result = new HashMap<>();
					result.put("cuit", client.getCuit());
					result.put("email", client.getEmail());
					result.put("numero_celular", client.getNumero_celular());
					result.put("nombre", client.getNombre());
					return result;
				}
			}
		}
		return null;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public Integer size() {
		return clientes.size();
	}
	
	
	
}
