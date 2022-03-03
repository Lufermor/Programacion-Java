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
			System.out.println(jugadores.get(i).toString());
		}
		System.out.println();
	}
	
	/*
	 * Pre: ---
	 * Post: Este método desarrolla el juego, va eliminando jugadores 
	 * e imprime por pantalla al último jugador que queda
	 */
	public static void jugar(ArrayList<Jugador> jugadores) {
		Jugador tirador;
		Jugador portero;
		int ronda =0;
		while(jugadores.size()>1) {
			System.out.println("\n------------------------Ronda: " + ++ronda + 
					"\n----------------------------------------------------------");
			for(int i = 0; i<jugadores.size(); i++) {
				if(jugadores.size() == 1) break;
				if(i == jugadores.size() - 1) {
					portero = jugadores.get(i);
					tirador = jugadores.get(0);
				}else {
					portero = jugadores.get(i);
					tirador = jugadores.get(i+1);
				}
				int probabilidadGol = tirador.habilidadDisparo()-portero.habilidadPorteria();
				if(probabilidadGol<5) probabilidadGol = 5;
				System.out.println(tirador.getNombre() + " contra " + portero.getNombre() + 
						", probabilidad de gol = " + probabilidadGol + "%");
				if((Math.random()*100) <= probabilidadGol) {
					portero.restarVida();
					System.out.println("El jugador " + tirador.getNombre() + " metió gol al jugador " + portero.getNombre());
				}else System.out.println(portero.getNombre() +" tapo un gol de " + tirador.getNombre());
				if(portero.getVidas() == 0 ) {
					System.out.println("El jugador "+ portero.getNombre() + " Ha sido eliminado ");
					jugadores.remove(portero);
					i--;
				}
				
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
