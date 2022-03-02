package tarea6;
import java.util.Scanner;

public class Tarea6Ejercicio5 {
	/*
	 * Pre: ---
	 * Post: Este metodo calcula una potencia en base a un numero y exponente recibidos 
	 */
	private static int potencia(int num, int expo) {
		int pot = 1;
		if(num == 1 || expo == 0) {
			return 1;
		}else if(num == 0) {
			return 0;
		}else {
			for(int i = 0; i < expo; i++) {
				pot = pot*num;
			}
			return pot;
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main imprime por pantalla las potencias de exponente
	 * desde 1 hasta 4, de un numero escrito por el usuario.
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca un numero entero");
		int n = entrada.nextInt();
		System.out.println("n\tn^2\tn^3\tn^4");
		for(int i = 0; i < n; i++) {
			System.out.println(i+1 + "\t" + potencia(i+1,2) + "\t" + potencia(i+1,3) + "\t" + potencia(i+1,4));
		}
	}
}