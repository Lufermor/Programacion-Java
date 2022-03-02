package practica2;

import java.util.Scanner;

public class WhileEjercicio9 {
	/**
	 * Pre: ---
	 * Post: esta clase Java implementa un método main que 
	 * pregunta al usuario por 10 números enteros y muestra por pantalla:
	 *  
	 * El número total de veces que el usuario ha introducido el 0, 
	 * El número total de enteros mayores que 0 introducidos y 
	 * El número total de enteros menores que 0 introducidos.
	 * */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Vamos a introducir diez números");
		int ceros = 0;
		int positivos = 0;
		int negativos = 0;
		int i = 0;
		int num;
		while(i<10) {
			System.out.println("Introduce el número nº" + ++i);
			num = entrada.nextInt();
			if(num == 0) {
				ceros++;
			}else if(num>0) {
				positivos++;
			}else {
				negativos++;
			}
		}
		System.out.println("El número de veces que se ha introducido el 0 es " + ceros);
		System.out.println("El número de números mayores que 0 es " + positivos);
		System.out.println("El número de números menores que 0 es " + negativos);
	}
}
