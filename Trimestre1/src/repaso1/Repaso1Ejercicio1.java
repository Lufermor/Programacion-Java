package repaso1;
import java.util.Scanner;
/*
 * Escribe un programa Java que pregunte al usuario por dos
Strings y los compare lexicográficamente. Dos Strings son lexicográficamente
iguales si tienen la misma longitud y contienen los mismos caracteres en las
mismas posiciones.
 */

public class Repaso1Ejercicio1 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		for(int i = 0; i<5; i++) {
			System.out.println("Introduzca una cadena: ");
			String cadena1 = entrada.nextLine();
			System.out.println("Introduzca otra cadena: ");
			String cadena2 = entrada.nextLine();
			if(cadena1.compareTo(cadena2)==0) {
				System.out.println("Las cadenas son iguales");
			}else {
				System.out.println("Las cadenas son diferentes");
			}
		}
		
	}
}
