package tarea5;
import java.util.Scanner;

public class Ejercicio3Tarea5 {
	/*
	 * Implementa un programa Java que solicite al usuario una cadena de caracteres (String) 
	 * y muestre por pantalla dicha cadena sin el último caracter.
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
	 * Post: Este metodo pide al usuario que introduzca un string y lo devuelve
	 */
	private static String pedirCadena() {
		Scanner entrada = new Scanner(System.in);
		mostrarMensaje("Por favor introduzca una palabra o frase");
		String cadena = entrada.nextLine();
		return cadena;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main pide al usuario una cadena de caracteres y 
	 * muestra por pantalla esa cadena sin el ultimo caracter.
	 */
	public static void main(String[] args) {
		String frase = pedirCadena();
		mostrarMensaje(frase.substring(0, frase.length()-1));
	}
}
