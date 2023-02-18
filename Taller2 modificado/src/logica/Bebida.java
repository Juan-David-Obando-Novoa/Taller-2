package logica;

public class Bebida implements Producto{
	private String nombre; 
	private int precioBase;

	// Constructor
	public Bebida(String nombre, int precioBase) {
		this.nombre = nombre; 
		this.precioBase= precioBase;
	}


	public String printbebida() {
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

