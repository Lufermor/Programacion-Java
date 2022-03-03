package repaso1;
import java.util.Scanner;
/*
 * Escribe un programa Java que pregunte al usuario por dos
Strings, y devuelva la concatenación de ambos.
 */

public class Repaso1Ejercicio2 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		for(int i = 0; i<5; i++) {
			System.out.println("Introduzca una cadena: ");
			String cadena1 = entrada.nextLine();
			System.out.println("Introduzca otra cadena: ");
			String cadena2 = entrada.nextLine();
			System.out.println(cadena1 + cadena2);
		}
	}
}
