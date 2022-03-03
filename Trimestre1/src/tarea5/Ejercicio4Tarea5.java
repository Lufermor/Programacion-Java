package tarea5;
import java.util.Scanner;

public class Ejercicio4Tarea5 {
	/*
	 * Implementa un programa Java que solicite al usuario una cadena de caracteres (String) 
	 * y muestre por pantalla la longitud de esta.
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
	 * Post: Este metodo pide al usuario una cadena de caracteres y devuelve su longitud
	 */
	private static int contarLetras() {
		Scanner entrada = new Scanner(System.in);
		mostrarMensaje("Introduzca una palabra o frase: ");
		String cadena = entrada.nextLine();
		return cadena.length();
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main llama al metodo contarLetras para pedir una cadena 
	 * de caracteres, y luego imprimir su longitud.
	 */
	public static void main(String[] args) {
		mostrarMensaje("La longitud de la cadena introducida es: "+String.valueOf(contarLetras()));
	}
}
