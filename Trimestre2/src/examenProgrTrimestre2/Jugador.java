package examenProgrTrimestre2;

public class Jugador {
	private String nombre;
	private int dorsal;
	private int potenciaDisparo;
	private int calidadPorteria;
	private int vidas;
	
	public Jugador() {
		this.nombre = "";
		this.dorsal = 0;
		this.potenciaDisparo = 1;
		this.calidadPorteria = 1;
		this.vidas = 2;
	}

	public Jugador(String nombre, int dorsal) {
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.potenciaDisparo = (int)Math.random()*100;
		this.calidadPorteria = (int)Math.random()*100;
		this.vidas = 2;
	}

	public Jugador(String nombre, int dorsal, int potenciaDisparo, int calidadPorteria) {
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.potenciaDisparo = potenciaDisparo;
		this.calidadPorteria = calidadPorteria;
		this.vidas = 2;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	
	public int getDorsal() {
		return dorsal;
	}
	
	public void setPotenciaDisparo(int potenciaDisparo) {
		this.potenciaDisparo = potenciaDisparo;
	}
	
	public int getPotenciaDisparo() {
		return potenciaDisparo;
	}
	
	public void setCalidadPorteria(int calidadPorteria) {
		this.calidadPorteria = calidadPorteria;
	}
	
	public int getCalidadPorteria() {
		return calidadPorteria;
	}
	
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	public int getVidas() {
		return vidas;
	}
	
	/*
	 * Pre: ---
	 * Post: devuelve la potencia de disparo
	 */
	public int habilidadDisparo() {
		return potenciaDisparo;
	}
	
	/*
	 * Pre: ---
	 * Post: devuelve la calidad de portero
	 */
	public int habilidadPorteria() {
		return calidadPorteria;
	}
	
	@Override
	public String toString() {
		return "[Nombre = " + nombre + ", Dorsal = " + dorsal + ", Potencia de disparo = " + potenciaDisparo
				+ ", Calidad en porteria = " + calidadPorteria + ", Vidas = " + vidas + "]";
	}
}
