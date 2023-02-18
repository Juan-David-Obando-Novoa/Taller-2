package logica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//atributos


public class Pedido {
	
	
	
public static void main1(String[] args) {
	
	
	
}
private Restaurante restaurante = new Restaurante();
private ArrayList<Producto> productos = new ArrayList();


public void main(String[] args) {
	System.out.print(generarTextoFactura());
}
private int numerospedido;
private int idpedido; 
private String nombreCliente; 
private String direccionCliente;
private Combo combo;
private ProductoMenu productomenu;


//contructor 

// cuando es * lista del objeto y cuando es 1 es variable unica cuando es 0 es null
public Pedido(String nombreCliente, String direccionCliente) {
	this.direccionCliente = direccionCliente;
	this.nombreCliente = nombreCliente;
	
}


public String getnombre () {
	return nombreCliente;
}

public int getidpedido() {
	return idpedido;
	
}
public void agregarProducto(Producto nuevoitem) {
	productos.add(nuevoitem); 
	
}
// Precio de TODO los ingredientes
public int precioingredientes() {
    ArrayList<Ingrediente> ingrediente = restaurante.getingredientes();
    int precio = 0; 
    for (Ingrediente ingre : ingrediente) {
        precio += ingre.getCostoAdiconal();
       
 
    }
	return precio;
}   
// Precio de todos los menus 
public int preciomenu() {
    ArrayList<ProductoMenu> menu = restaurante.getproductomenu();
    int precio = 0; 
    for (ProductoMenu eleme : menu) {
        precio += eleme.getPrecio();
    }
    return precio;    

}   

public int preciocombo() {
    ArrayList<Combo> combo = restaurante.getcombos();
    int precio = 0; 
    for (Combo eleme : combo) {
        precio += eleme.getPrecio();
    }
    return precio;       

}   

	
	
private int getPrecioTotalPedido() {
	int precioingredeintes = precioingredientes(); 
	int preciomenu = preciomenu(); 
	int preciocombo = preciocombo(); 
	int total = precioingredeintes + preciomenu + preciocombo;
	return total;
	
}
private int getprecioIVAPedido() {
	int precio = getPrecioTotalPedido(); 
	double iva = precio*0.19;
	int totaliva = (int)(precio + iva);
	
	
	return totaliva;
	
}
private String generarTextoFactura() {
	String factura = "Precio sin iva " + getPrecioTotalPedido() + "\n" +"precio con iva " + getprecioIVAPedido() + "\n";

	return factura;
	
}

public void guardarFactura(String archivo) {
	
	File file = new File(archivo);

    try {
      // Crea un objeto FileWriter para escribir en el archivo
      FileWriter writer = new FileWriter(file);

      // Escribe una línea en el archivo
      writer.write("Estimado: "+ nombreCliente+"\n"+ "Direccion: "+ direccionCliente +"\n"+generarTextoFactura());

      // Cierra el objeto FileWriter
      writer.close();
    } catch (IOException e) {
      System.out.println("Error al escribir en el archivo: " + e.getMessage());
    }
}


		
}


