package practica2;

import java.util.Scanner;

public class WhileEjercicio8 {
	/*
	 * Pre: ---
	 * Post: programa Java que pregunte al usuario por 10 números enteros 
	 *  y muestre por pantalla el número mayor y el menor 
	 *  de todos los introducidos
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Vamos a introducir diez números");
		System.out.println("Introduce el primer número");
		int num = entrada.nextInt();
		int mayor = num;
		int menor = num;
		int i=1;
		while(i<=9) {
			System.out.println("Introduce el número nº" + ++i);
			num = entrada.nextInt();
			if(num>mayor) {
				mayor = num;
			}else if(num<menor) {
				menor = num;
			}
		}
		System.out.println("El número mayor es " + mayor);
		System.out.println("El número menor es " + menor);
	}
}
