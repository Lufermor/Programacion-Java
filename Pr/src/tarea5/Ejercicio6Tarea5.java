package tarea5;
import java.util.Scanner;

public class Ejercicio6Tarea5 {
	/*
	 * Implementa un programa Java que solicite al usuario 
	 * una cadena de caracteres (String) y muestre por pantalla dicha cadena, 
	 * pero con el primer y último carácter cambiados de posición.
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
	 * Post: Este metodo solicita una frase al usuario, para ello recibe un string
	 * para indicar al usuario lo que debe ingresar.
	 */
	private static String pedirFrase(String text) {
		Scanner entrada = new Scanner(System.in);
		mostrarMensaje(text);
		return entrada.nextLine();
	}
	/*
	 * Pre: ---
	 * Post: Este metodo recibe una cadena y devuelve la misma cadena pero con el 
	 * primer y ultimo caracter cambiado.
	 */
	private static String cambiazo(String cadena) {
		return cadena.substring(cadena.length()-1) + cadena.substring(1, cadena.length()-1) + cadena.substring(0, 1);
	}
	/*
	 * Pre: ---
	 * Post: este metodo main pide una cadena al usuario y luego llama 
	 * al metodo cambiazo para recibir la cadena cambiada e imprimirla
	 */
	public static void main(String[] args) {
		String cad = pedirFrase("Por favot introduzca una palabra o frase");
		mostrarMensaje(cambiazo(cad));
	}
}
