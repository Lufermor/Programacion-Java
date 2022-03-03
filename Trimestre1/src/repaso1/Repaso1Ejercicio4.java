package repaso1;
import java.util.Scanner;
/*
 * Escribe un programa Java que pregunte al usuario por dos
Strings, y compruebe si el primero de ellos finaliza con el valor del segundo.
 */

import java.util.Scanner;

public class Repaso1Ejercicio4 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		for(int i = 0; i<5; i++) {
			System.out.println("Introduzca una cadena: ");
			String cadena1 = entrada.nextLine();
			System.out.println("Introduzca otra cadena: ");
			String cadena2 = entrada.nextLine();
			if(cadena1.substring(cadena1.length()-cadena2.length()).compareTo(cadena2) == 0) {
				System.out.println("verdadero");
			}else {
				System.out.println("falso");
			}
		}
	}	
}
