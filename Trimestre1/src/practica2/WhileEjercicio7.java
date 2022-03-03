package practica2;

import java.util.Scanner;

public class WhileEjercicio7 {
	/**
	 * Pre: ---
	 * Post: esta clase Java implementa un método main que
	 * pregunta al usuario por un número entero
	 * y muestra por pantalla su tabla de multiplicar 
	 */	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Por favor introduzca un numero entero");
		int entero = entrada.nextInt();
		//System.out.println("La tabla de multiplicar del numero" + entero + "es:")
		int i=1;
		while(i<=10) {
			System.out.println(entero + " x " + i +" = " + entero*i);
			i++;
		}
	}
}
