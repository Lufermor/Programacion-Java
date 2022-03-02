package tarea5;
import java.util.Scanner;

public class Ejercicio2Tarea5 {
	/*
	 * Implementa un programa Java que solicite al usuario dos números reales 
	 * y muestre TRUE o FALSE dependiendo de si ambos están entre 0.0 y 1.0.
	 */
	/*
	 * Pre: ---
	 * Post: Este metodo imprime por pantalla un mensaje dado
	 */
	private static void mostrarMensaje(String msj) {
		System.out.println(msj);
	}
	/*
	 * Pre: ---
	 * Post: Este metodo pide al usuario un numero real y lo devuelve
	 */
	private static double pedirNumero() {
		Scanner entrada = new Scanner(System.in);
		mostrarMensaje("Introduzca un numero real");
		double num = entrada.nextDouble();
		return num;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main pide al usuario dos numeros reales y
	 * comprueba si ambos estan entre 0.0 y 1.0
	 */
	public static void main(String[] args) {
		double a = pedirNumero();
		double b = pedirNumero();
		boolean respuesta = false;
		/*if(0 <= a && a <= 1 && 0 <= b && b <= 1) {
			mostrarMensaje("TRUE");
		}else {
			mostrarMensaje("FALSE");
		}*/
		if(0 <= a && a <= 1 && 0 <= b && b <= 1) {
			respuesta = true;
		}
		mostrarMensaje(String.valueOf(respuesta).toUpperCase());
	}
}
