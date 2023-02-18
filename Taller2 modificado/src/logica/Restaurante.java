package logica;
import java.io.*;
import java.util.Scanner;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurante {
	//atributos
	private static ArrayList<Pedido> pedidos = new ArrayList(); 
	private static Pedido pedidoencurso = null;
	private static ArrayList<Ingrediente> ingredientes = new ArrayList();
	private static ArrayList<Combo> combos = new ArrayList();
	private static ArrayList<ProductoMenu> ProductoMenus  = new ArrayList();
	private static ArrayList<Bebida> bebidas  = new ArrayList();
	
public static void main(String[] args) {
	try {
		System.out.print(pedidoencurso);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
	
	
	
	
	// Metdodo 1
	public static void restaurante()
	{
		Restaurante restaurante= new Restaurante();
	}
	
	// Metdodo 2

	public void iniciarPedido(String nombreCliente, 
				String direccionCliente) {
		Pedido pedido = new Pedido (nombreCliente, direccionCliente); 
		pedidoencurso= pedido; 
		pedidos.add(pedidoencurso);
		
		System.out.print(pedidos +"\n");
		System.out.print(pedidoencurso+"\n");
		System.out.print(pedido.getnombre() +"\n");
		
		
		pedido.guardarFactura("data\\Factura.txt");
	}
	
	
	// Metdodo 3

	public void cerrarYGuardarPedido() {
	
		pedidoencurso = null;
		ingredientes.clear();
		
	}
	

	// Metdodo 4
	public Pedido getPedidoEnCurso() {
		return pedidoencurso;
		
	}
	// añadimos a las diferentes listas 
	public void addingredientes (Ingrediente ingredeinte ) {
		ingredientes.add(ingredeinte);
		System.out.print(ingredientes); 
	}
		
	public void addcombos (Combo combo ) {
	
		combos.add(combo);
		System.out.print(combos); 
	}
	public void addProductoMenus (ProductoMenu productomenu ) {
		ProductoMenus.add(productomenu);
		System.out.print(ProductoMenus); 
	}
	
	public void addbebidas (Bebida bebida ) {
		bebidas.add(bebida);
		System.out.print(bebidas); 
	}	
		
	// funciones de consulta
	public ArrayList<Ingrediente> getingredientes () {
		return ingredientes;
	}
		
			
	public ArrayList<Combo> getcombos () {
		return combos; 
		}
	public ArrayList<ProductoMenu> getproductomenu () {
		return ProductoMenus; 
	}
	
	public ArrayList<Bebida> getbebida () {
		return bebidas; 	
		
	}
	
	public void factura() {
		pedidoencurso.guardarFactura("data\\Factura.txt");
		
	}
	
	
		


	
	public static void cargarinformacionrestaurante() {
        try {
        	
        	List<Combo> combinacion= loadcombos("data\\combos.txt");
        	List<ProductoMenu> menu = loadmenu("data\\menu.txt");
        	List<Ingrediente> ingredientes = loadingre("data\\ingredientes.txt");
        	//System.out.print("Los combos son\n"+ combinacion + "\n\n\n" + " el menu es\n" +
        									//menu + "\n"+ "los ingredeintes son\n"+ ingredientes+ "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Alguno de los archivos no se ha encontrado: " + e.getMessage());
        }
    }
	
	
		
	

	public static List<Combo> loadcombos(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        List<Combo> combos = new ArrayList<>();
		
		
        //System.out.println("Contenido del archivo " + filename + ":");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            //System.out.print(line);
            String[] partes = line.split(";"); 
            String nombrecombo = partes[0];
            double porcentaje = Double.parseDouble((partes[1]).replace("%", ""));
            String tipopapas = partes[2]; 
            boolean gaseosa = partes[3].equals("gaseosa");
            
            Combo combito = new Combo(nombrecombo, porcentaje ); 
            combos.add(combito);
            
          
        }
        
        scanner.close();
        
        return combos;
    }
	public static List<ProductoMenu> loadmenu(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        List<ProductoMenu> menu = new ArrayList<>();
		
        //System.out.println("Contenido del archivo " + filename + ":");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            //System.out.print(line);
            String[] partes = line.split(";"); 
            String producto = partes[0];
            int precio = Integer.parseInt(partes[1]);
            int calorias = Integer.parseInt(partes[2]);
            
            
            ProductoMenu clasemenu = new ProductoMenu(producto, precio, calorias); 
            menu.add(clasemenu);
            
          
        }
        
        scanner.close();
        
        return menu;
    }
	public static List<Bebida> loadbebidas(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        List<Bebida> bebida = new ArrayList<>();
		
        //System.out.println("Contenido del archivo " + filename + ":");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            //System.out.print(line);
            String[] partes = line.split(";"); 
            String producto = partes[0];
            int precio = Integer.parseInt(partes[1]);
            
            
            Bebida clasemenu = new Bebida(producto, precio ); 
            bebida.add(clasemenu);
            
          
        }
        
        scanner.close();
        
        return bebida;
    }
    
	public static List<Ingrediente> loadingre(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        List<Ingrediente> listaingredeintes = new ArrayList<>();
		
		
        //System.out.println("Contenido del archivo " + filename + ":");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            //System.out.print(line);
            String[] partes = line.split(";"); 
            String ingre = partes[0];
            int precio = Integer.parseInt(partes[1]);
           
            
            Ingrediente ingrediente = new Ingrediente(ingre, precio );
            
            listaingredeintes.add(ingrediente);
            
        }
            scanner.close();
            
         return listaingredeintes;
        }
        
	public boolean pedidosiguale() {
		boolean centinela = false;
		if (pedidos.size() >=1 ) {
		int contador = 0;
		while(contador+1<= (pedidos.size())){
	
		Pedido pedidocomp = pedidos.get(contador);	
		Pedido pedidocomp2 = pedidos.get(contador+1);	
		if (pedidocomp.getnombre().equals(pedidocomp2.getnombre()));
		contador ++; 

		return true; 
				
		}	
		}
		return centinela;
	}





	
    //public static void main(String[] args) throws FileNotFoundException {
    	//List<Combo> combinacion = loadcombos("data\\combos.txt");
    	//List<ProductoMenu> menu = loadmenu("data\\menu.txt");
    	//List<Ingrediente> ingre = loadingre("data\\ingredientes.txt");
    	//System.out.print(combinacion);
    	//System.out.print(menu);
    	//System.out.print(ingre);
        //}
    
}
 		
		



	







