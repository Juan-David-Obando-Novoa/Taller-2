package logica;

public class ProductoMenu implements Producto{
// Atributos
	
private String nombre; 
private int precioBase;
private int calorias;

// Constructor
public ProductoMenu(String nombre, int precioBase, int calorias) {
	this.nombre = nombre; 
	this.precioBase= precioBase;
	this.calorias = calorias;
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

public int getCalorias() {
	return calorias; 
}

public String generarTextoFactura() {
	return null;
	
}
}
