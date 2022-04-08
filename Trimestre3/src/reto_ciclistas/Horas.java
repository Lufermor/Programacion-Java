package reto_ciclistas;

import java.time.LocalTime;

public class Horas {
	private int posicionFichero;
	private LocalTime hora;
	private int posicionFinal;
	
	
	
	public Horas(int posicionFichero, LocalTime hora, int posicionFinal) {
		super();
		this.posicionFichero = posicionFichero;
		this.hora = hora;
		this.posicionFinal = posicionFinal;
	}
	
	public int getPosicionFinal() {
		return posicionFinal;
	}

	public void setPosicionFinal(int posicionFinal) {
		this.posicionFinal = posicionFinal;
	}

	public int getPosicion() {
		return posicionFichero;
	}
	
	public void setPosicion(int posicion) {
		this.posicionFichero = posicion;
	}
	
	public LocalTime getHora() {
		return hora;
	}
	
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Horas [posicionFichero=" + posicionFichero + ", hora=" + hora + ", posicionFinal=" + posicionFinal
				+ "]";
	}
	
	
}
