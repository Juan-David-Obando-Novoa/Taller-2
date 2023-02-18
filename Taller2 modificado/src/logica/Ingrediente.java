package logica;

public class Ingrediente {
// Atributos
private String nombre;
private int costoAdicional; 
private String ingredeintes; 
// Contructor

public Ingrediente (String nombre, int costoAdicional) {
	this.nombre = nombre; 
	this.costoAdicional= costoAdicional;
}

public String printingredientes() {
	String respuesta = this.nombre + "\ncostoAdicional: "+ this.costoAdicional + "\n"; 
	
	return respuesta;
}


// Metodos

public String getNombre() {
	return nombre;
	
}

public int getCostoAdiconal() {
	return costoAdicional;
	
}
}
