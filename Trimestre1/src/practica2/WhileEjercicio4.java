package practica2;

import java.util.Scanner;

public class WhileEjercicio4 {
	/*
	 * Pre: ---
	 * Post: esta clase Java implementa un m�todo main que 
	 * 	pregunta al usuario por 2 n�meros, y muestra por pantalla 
	 * 	todos los n�meros situados entre ambos
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Por favor introduce el numero menor");
		int menor = entrada.nextInt();
		System.out.println("Por favor introduce el numero mayor");
		int mayor = entrada.nextInt();
		while(menor<mayor-1) {
			System.out.println(++menor);
		}
	}
}
