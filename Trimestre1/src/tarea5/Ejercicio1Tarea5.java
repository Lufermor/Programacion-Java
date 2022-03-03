package tarea5;
import java.util.Scanner;

public class Ejercicio1Tarea5 {
	/*
	 *Implementa un programa Java que acepte 4 enteros por parte del usuario 
	 *y muestre por la pantalla la palabra “Igual” si los 4 enteros son iguales. 
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
	 * Post: Este metodo pide al usuario un numero entero y lo devuelve
	 */
	private static int pedirEntero() {
		Scanner entrada = new Scanner(System.in);
		mostrarMensaje("Introduzca un numero entero");
		int num = entrada.nextInt();
		return num;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main pide al usuario que introduzca cuatro numeros enteros y
	 * luego dice si son o no iguales
	 */
	public static void main(String[] args) {
		int a = pedirEntero();
		int b = pedirEntero();
		int c = pedirEntero();
		int d = pedirEntero();
		if(a == b && b == c && c== d) {
			mostrarMensaje("Los numeros son iguales");
		}else {
			mostrarMensaje("Los numeros no son iguales");
		}
	}
}
