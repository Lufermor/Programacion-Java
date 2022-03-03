package tarea6;
import java.util.Scanner;
/*Escribe un programa Java que solicite al usuario un entero N y escriba 
 * un patron de asteriscos por pantalla
 */
public class Tarea6Ejercicio3 {
	/*
	 * Pre: ---
	 * Post: Este metodo imprime un patron de asteriscos segun un entero que se le introduzca
	 */
	private static void asteriscos(int n) {
		//Creamos una cadena auxiliar que sera la que contenga los asteriscos
		String aux = "";
		for(int i = 0; i < n; i++) {
			aux += "*";
		}
		for(int i = n; i > 0; i--) {
			//System.out.print(i + " ");
			System.out.println(aux);
			aux = aux.substring(0, aux.length()-1);
		}
		//System.out.println(aux);
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main pide al usuario un entero y luego llama al metodo asteriscos
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca un entero del 3 al 10: ");
		int lon = entrada.nextInt();
		asteriscos(lon);
	}
}
