package logica;

public class Combo implements Producto{

	private double descuento; 
	
	private String nombreCombo;
	
	
	
	public Combo (String nombre, double descuento) {
		this.descuento = descuento; 
		this.nombreCombo = nombre;
	}
	
	public String printcombos() {
		
		String respuesta = this.nombreCombo + "\ndescuento: "+ this.descuento + "\n"; 
		
		return respuesta;
	}
	
	
	public void agregaritemACombo(Producto itemCombo) {
		
	}
	
	@Override
	public int getPrecio() {
		if(nombreCombo.equals("combo corral")) {
			return 22050;
		}
		else if (nombreCombo.equals("combo corral queso")) {
			return 23850;
		}
		else if (nombreCombo.equals( "combo todoterreno")) {
			return 34317;
		}
		else if (nombreCombo.equals("combo especial")) {
			return 32085;
		}
		return 0;
		
		
		
		

		
	}
	
	public String generarTextoFactura() {
		return nombreCombo;
		
	}
	
	public String getNombre() {
		return nombreCombo;
		
	}
	
}
