package repaso1;
import java.util.Scanner;
/*
 * Escribe un programa Java que pregunte al usuario por dos
Strings, y compruebe si el primero de ellos contiene al segundo.
 */

public class Repaso1Ejercicio3 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		for(int i = 0; i<5; i++) {
			System.out.println("Introduzca una cadena: ");
			String cadena1 = entrada.nextLine();
			System.out.println("Introduzca otra cadena: ");
			String cadena2 = entrada.nextLine();
			if(cadena2.contains(cadena1)) {
				System.out.println("La cadena 1 esta contenida en la cadena 2");
			}else {
				System.out.println("La cadena 1 no esta contenida en la cadena 2");
			}
		}
	}
}
