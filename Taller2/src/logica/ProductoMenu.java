package logica;

public class ProductoMenu implements Producto{
// Atributos
	
private String nombre; 
private int precioBase;

// Constructor
public ProductoMenu(String nombre, int precioBase) {
	this.nombre = nombre; 
	this.precioBase= precioBase;
}


public String printproductomenu() {
	String respuesta=  this.nombre + "\nPreciobase: "+ this.precioBase + "\n"; 
	return respuesta; 
}

public String getNombre() {
	return nombre;
	
}

public int getPrecio() {
	return precioBase;

}

public String generarTextoFactura() {
	return null;
	
}
}
