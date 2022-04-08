package practica1;

public class Jugador {
	private String nombre;
	private int dorsal;
	private int goles;
	private int tarjetasAmarillas;
	private int tarjetasRojas;
	
	public Jugador() {
		this.nombre = "";
		this.dorsal = -1;
		goles = 0;
		tarjetasAmarillas = 0;
		tarjetasRojas = 0;
	}
	
	public Jugador(String nombre, int dorsal) {
		this.nombre = nombre;
		this.dorsal = dorsal;
		goles = 0;
		tarjetasAmarillas = 0;
		tarjetasRojas = 0;
	}
	public Jugador(String nombre, int dorsal, int goles,
			int tarjetasAmarillas, int tarjetasRojas) { 
		this.nombre = nombre;
		this.dorsal = dorsal;
		comprobarGoles(goles);
		comprobarTarjetasAmarillas(tarjetasAmarillas);
		comprobarTarjetasRojas(tarjetasRojas);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getDorsal() {
		return dorsal;
	}
	
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	
	public int getGoles() {
		return goles;
	}
	
	public void setGoles(int goles) {
		comprobarGoles(goles);
	}
	
	public int getTarjetasAmarillas() {
		return tarjetasAmarillas;
	}
	
	public void setTarjetasAmarillas(int tarjetasAmarillas) {
		comprobarTarjetasAmarillas(tarjetasAmarillas);
	}
	
	public int getTarjetasRojas() {
		return tarjetasRojas;
	}
	
	public void setTarjetasRojas(int tarjetasRojas) {
		comprobarTarjetasRojas(tarjetasRojas);
	}
	/*
	 * Pre: ---
	 * Post: este metodo comprueba que el dato introducido es correcto,
	 * de lo contrario introduce el valor por defecto en la variable local.
	 */
	public void comprobarGoles(int goles) {
		if(goles>=0) {
			this.goles=goles;
		}else {
			this.goles=0;
		}
	}
	/*
	 * Pre: ---
	 * Post: este metodo comprueba que el dato introducido es correcto,
	 * de lo contrario introduce el valor por defecto en la variable local.
	 */
	public void comprobarTarjetasAmarillas(int tarjetasAmarillas) {
		if(tarjetasAmarillas>=0) {
			this.tarjetasAmarillas=tarjetasAmarillas;
		}else {
			this.tarjetasAmarillas=0;
		}
	}
	/*
	 * Pre: ---
	 * Post: este metodo comprueba que el dato introducido es correcto,
	 * de lo contrario introduce el valor por defecto en la variable local.
	 */
	public void comprobarTarjetasRojas(int tarjetasRojas) {
		if(tarjetasRojas>=0) {
			this.tarjetasRojas=tarjetasRojas;
		}else {
			this.tarjetasRojas=0;
		}
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", dorsal=" + dorsal + ", goles=" + goles + ", tarjetasAmarillas="
				+ tarjetasAmarillas + ", tarjetasRojas=" + tarjetasRojas + "]";
	}
	
//	@Override
//	public String toString() {
//		return "Jugador:"
//				+ "\nNombre: " + nombre
//				+ "\nDorsal: " + dorsal
//				+ "\nGoles: " + goles
//				+ "\nTarjetas Amarillas: " + tarjetasAmarillas
//				+ "\nTarjetas Rojas: " + tarjetasRojas;
//	}
	
}