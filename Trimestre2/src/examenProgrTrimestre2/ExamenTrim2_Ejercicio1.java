package examenProgrTrimestre2;

import java.util.ArrayList;
import java.util.Scanner;

public class ExamenTrim2_Ejercicio1 {
	/*
	 * Pre: ---
	 * Post: Este metodo crea 10 objetos de clase Jugador, y los mete en el ArrayList
	 */
	public static void prepararPartida(ArrayList<Jugador> jugadores) {
		for(int i =0; i<10; i++) {
			String nombre = "Jugador" + (i+1);
			int dorsal = i+1;
			jugadores.add(new Jugador(nombre, dorsal));
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este método desarrolla el juego, va eliminando jugadores 
	 * e imprime por pantalla al último jugador que queda
	 */
	public static void jugar(ArrayList<Jugador> jugadores) {
		while(jugadores.size()>1) {
			for(int i = 0; i<jugadores.size(); i++) {
				if(jugadores.size() == 1) break;
				//if()
			}
		}
		System.out.println("El jugador ganador es: \n" + jugadores.get(0).toString());
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo main crea un arrayList de jugadores para jugar
	 */
	public static void main(String[] args) {
		System.out.println("JUEGO \"EL RAPIDO\"\n"
				+ "*presione enter para continuar*");
		Scanner entrada = new Scanner(System.in);
		entrada.nextLine();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		prepararPartida(jugadores);
		jugar(jugadores);
		System.out.println("Gracias por jugar :D");
		entrada.close();
	}
}
