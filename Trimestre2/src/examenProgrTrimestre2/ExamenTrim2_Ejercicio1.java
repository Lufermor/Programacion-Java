package examenProgrTrimestre2;

import java.util.ArrayList;

public class ExamenTrim2_Ejercicio1 {
	/*
	 * Pre: ---
	 * Post: Este metodo crea 10 objetos de clase Jugador, y los mete en el ArrayList
	 */
	public static void prepararPartida(ArrayList<Jugador> jugadores) {
		for(int i =0; i<10; i++) {
			jugadores.add(new Jugador("Jugador" + (i+1), (i+1)));
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo main crea un arrayList de jugadores para jugar
	 */
	public static void main(String[] args) {
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		prepararPartida(jugadores);
	}
}
