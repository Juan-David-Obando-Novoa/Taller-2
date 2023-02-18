package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import logica.ProductoMenu;
import logica.Restaurante;
import logica.Bebida;
import logica.Combo;
import logica.Ingrediente;



public class Aplicacion {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();

	}
	

	
	public void mostrarMenu()
	{
		System.out.println("Opciones que el restaurante tiene para ti\n");
		System.out.println("1. Tomar datos antes de pedir algo");
		System.out.println("2. Elegir elemento del menu ");
		System.out.println("3. Elegir ingredientes adicional");
		System.out.println("4. Elegir combo");
		System.out.println("5. Elegir bebida");
		System.out.println("6. Generar Factura");
		System.out.println("7. ¿Alguien ha hecho un pedido igual al mio?");

		
		
		System.out.println("13. Salir de la aplicacion");
		
		
		;
	
	}

	
	
	public void ejecutarAplicacion() throws FileNotFoundException
	{

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				 
				Restaurante res = new Restaurante(); 
				Restaurante.cargarinformacionrestaurante();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
						
				String nombre = "";
				String direccion = "";
				
				if (opcion_seleccionada== 1) {
					//res.cerrarYGuardarPedido();
					nombre = input("¿Cual es tu nombre?\n");
					direccion = input("¿Cuál es tu dirección? \n");
					res.iniciarPedido(nombre, direccion);
					System.out.print("¡elige cualquiera menos la 1!\n");
				}

				if  (opcion_seleccionada == 2) {
					
					List<ProductoMenu> lista = Restaurante.loadmenu("data\\menu.txt"); 
					int contador = 1;
					for (ProductoMenu elemento: lista) {
						System.out.println("Opcion"+ contador);
						System.out.println(elemento.printproductomenu());
						contador ++;
					} 
					int pos = Integer.parseInt(input("Cual es la opcion que desea llevar \n"));
					pos -= 1 ; 
					ProductoMenu menu = lista.get(pos);
					
					res.addProductoMenus(menu);

					System.out.println(menu.getNombre());
					System.out.println(menu.getPrecio());
				}	
				else if (opcion_seleccionada == 3) {
					List<Ingrediente> lista = Restaurante.loadingre("data\\ingredientes.txt");
					int contador = 1;
					for (Ingrediente elemento: lista) {
						System.out.println("Opcion"+ contador);
						System.out.println(elemento.printingredientes());
						contador ++;
					}
					int pos = Integer.parseInt(input("Cual es la opcion que desea llevar \n"));
					pos -= 1 ; 
					Ingrediente ingredeinte= lista.get(pos);
					res.addingredientes(ingredeinte);
					System.out.println(ingredeinte.getNombre());
					System.out.println(ingredeinte.getCostoAdiconal());
				}
				else if (opcion_seleccionada== 4) {
					List<Combo> lista = Restaurante.loadcombos("data\\combos.txt");
					int contador = 1;
					for(Combo elemento: lista) {
						System.out.println("Opcion"+ contador);
						System.out.println(elemento.printcombos());
						contador ++ ; 
						System.out.println("Elija la Opcion que desea");
						
					}
					int pos = Integer.parseInt(input("Numero de la opcion que desea llevar \n"));
					pos -= 1 ; 
					Combo combo= lista.get(pos);
					System.out.println(combo.getNombre());
					res.addcombos(combo);
				}
				else if (opcion_seleccionada== 5 ) {
					List<Bebida> lista = Restaurante.loadbebidas("data\\bebidas.txt"); 
					int contador = 1;
					for (Bebida elemento: lista) {
						System.out.println("Opcion"+ contador);
						System.out.println(elemento.printbebida());
						contador ++;
					} 
					int pos = Integer.parseInt(input("Cual es la opcion que desea llevar \n"));
					pos -= 1 ; 
					Bebida bebida = lista.get(pos);
					
					res.addbebidas(bebida);

					System.out.println(bebida.getNombre());
					System.out.println(bebida.getPrecio());
				}
					
				else if (opcion_seleccionada== 6) {
					res.factura(); 
				}
				else if (opcion_seleccionada== 7) {
					System.out.print(res.pedidosiguale());
				}
				if (opcion_seleccionada == 13)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}

	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
}
