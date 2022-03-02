package tarea1;
import java.util.Scanner;
/*
 * Implementa un programa Java que PREGUNTE al usuario por dos
números enteros (x, y) y muestre por pantalla la suma de ambos.
 */
public class Tarea1Ejercicio4 {
	public static void main(String[] args) {
		int x;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca un numero entero:");
		x = entrada.nextInt();
		System.out.println("Introduzca otro numero entero:");
		int y = entrada.nextInt();
		System.out.println(x+y);
	}
}
