package practica2;

import java.util.Scanner;

public class WhileEjercicio10 {
	/**
	 * Pre: ---
	 * Post: esta clase Java implementa un m�todo main que 
	 * devuelve los N n�meros de la Sucesi�n de Fibonacci, donde N es un numero dado por el usuario
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Este programa calcula la sucesi�n de Fibonacci "
				+ "para un n�mero introducido");
		System.out.println("Introduce un n�mero entero:");
		int n = entrada.nextInt();
		int suma1 = 0;
		int suma2 = 1;
		int suma = 0;
		int i = 0;
		System.out.println("Los " + n + " primeros numeros de la sucesion de Fibonacci son:");
		while(i<n) {
			suma = suma + suma1;
			suma1 = suma2;
			suma2 = suma;
			System.out.print(suma + " ");
			i++;
		}
		//System.out.println("La suma de Fibonacci para el n�mero " + n + " es:\n" + suma); 
	}
}
