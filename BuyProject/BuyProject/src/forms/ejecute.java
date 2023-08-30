package forms;

import java.util.Map;
import java.util.Scanner;

import service.ClientService;
import service.CompraService;
import service.ProductoService;

public class ejecute {

	public static void main(String[] args) {
		
//		Pruebas ProductoService
//		ProductoService prueba = new ProductoService();
		
//		String resultado = prueba.agregarProd("leche", "LACTEOS", 4, 5);
//		System.out.println(resultado);
//		String resultado2 = prueba.agregarProd("leche", "LACTEOS", 4, 7);
//		System.out.print(resultado2);
		
//		Map prod = prueba.buscar("leche");
//		System.out.println(prod);
		
//		Pruebas ClienteService
//		ClientService pruebaCl = new ClientService();
		
//		pruebaCl.agregar("Franco", "20-44952222-3", "franco@gmail.com", "03445470994");
//		System.out.print(pruebaCl.searchByCuit("20-44952222-3"));
		
		
//		Prueba Compra Service 
//		CompraService compS = new CompraService();
//		compS.agregarLineaCompra(2, "leche", prueba);
		
//		compS.crear(null, pruebaCl.searchByCuit("20-44952222-3"));
//		System.out.println("bdhba");
//		System.out.println(compS.getCompras());
		
		
		ClientService clientS = new ClientService();
		ProductoService prodS = new ProductoService();
		CompraService compraS = new CompraService();
		
		
		Scanner scanner = new Scanner(System.in);
		int respuesta;
		
		do{
			System.out.println("----------------------------------");
			System.out.println("Selecciona una opcion");
			System.out.println("1. Registrar Producto");
			System.out.println("2. Registrar Cliente");
			System.out.println("3. Registrar Compra");
			System.out.println("4. Salir");
			System.out.println("----------------------------------");
			respuesta = scanner.nextInt();
			
			switch(respuesta) {
			case 1:
				System.out.println("----- Ingrese Nombre del Producto -----");
				String nombreProd = scanner.next();
				scanner.nextLine();
				System.out.println("----- Ingrese Tipo del Producto -----");
				System.out.println(prodS.getTipos());
				String tipoProd = scanner.nextLine();
				System.out.println("----- Ingrese Stock del Producto -----");
				String cantProd = scanner.nextLine();
				System.out.println("----- Ingrese Precio del Producto -----");
				String precioProd = scanner.nextLine();
				String resultado = prodS.agregarProd(nombreProd, tipoProd, Integer.parseInt(cantProd), Double.valueOf(precioProd));
				System.out.println(resultado);
				System.out.println(prodS.buscar(nombreProd));
				break;
			case 2:
				System.out.println("----- Ingrese Nombre del Cliente -----");
				String nombreClient = scanner.next();
				scanner.nextLine();
				System.out.println("----- Ingrese Cuit del Cliente -----");
				String cuitClient = scanner.nextLine();
				System.out.println("----- Ingrese email del Cliente -----");
				String emailClient = scanner.nextLine();
				System.out.println("----- Ingrese numero celular del Cliente -----");
				String numeroClient = scanner.nextLine();
				clientS.agregar(nombreClient, cuitClient, emailClient, numeroClient);
				if (clientS.searchByCuit(cuitClient) == null) {
					System.out.println("No se registro el cliente. Verifique los campos ingresados...");
				}else {
					System.out.println("Cliente registrado exitosamente!");
					System.out.println(clientS.searchByCuit(cuitClient));
				}
				break;
			case 3:
				if(clientS.size() > 0) {
					System.out.println("----- Ingrese Cuit para realizar la Compra -----");
					String cuitProd = scanner.next();
					Map<String, Object> clientProd = clientS.searchByCuit(cuitProd);
					scanner.nextLine();
					System.out.println("----- Cargar Lineas de Compra -----");
					Boolean bucle = true;
					do {
						System.out.println("Seleccione Nombre del Producto...");
						if (prodS.verProductos()) {
							String productoSelec = scanner.nextLine();
							System.out.println("Ingrese Cantidad del Producto");
							String cantIngresada = scanner.nextLine();
							
							Map<String, Object> prodStock = prodS.buscar(productoSelec);
							if (prodStock.get("nombre") != null) {
								Integer stockProd = Integer.parseInt(prodStock.get("stock").toString());
								if (Integer.parseInt(cantIngresada) <= stockProd) {
									compraS.agregarLineaCompra(Integer.parseInt(cantIngresada), productoSelec, prodS);
									prodS.update(productoSelec, Integer.parseInt(cantIngresada));
									System.out.println("----- Desea agregar otro producto? (si/no) -----");
									String mas = scanner.nextLine();
									if (mas.equalsIgnoreCase("si")) {
										bucle = true;
									}else {
										compraS.crear(null, clientProd);
										System.out.println(compraS.ultimaCompra());
										bucle = false;
									}
								}else {
									System.out.println("La cantidad ingresada exede nuesto stock...");
									bucle = true;
								}
							}
						}
					}while(bucle);
				}else {
					System.out.println("No existen Clientes registrados para realizar una Compra");
				}
				break;
			default:
				break;
			}
			
		}while(respuesta != 4);
		
		
		

	}

}
