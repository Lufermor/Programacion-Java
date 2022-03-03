package tarea4;

import java.util.Scanner;

public class ForEjercicio8 {
	/*Escribe un programa Java que pregunte al usuario por 10 números enteros 
	 * y muestre por pantalla el número mayor y el menor de todos los introducidos
	 */
	/*
	 * Pre: ---
	 * Post: Este metodo imprime por pantalla un mensaje dado
	 */
	private static void mostrarMensaje(String msj) {
		System.out.println(msj);
	}
	/*
	 * Pre: ---
	 * Post: Este metodo pide al usuario un numero entero y lo devuelve
	 */
	private static int pedirEntero() {
		Scanner entrada = new Scanner(System.in);
		mostrarMensaje("Introduzca un numero entero");
		int num = entrada.nextInt();
		return num;
	}
	/*
	 * Pre: ---
	 * Post: este metodo pide al usuario un numero entero inicial y luego
	 * implementa un bucle for en el que pide al usuario 9 numeros mas.
	 * finalmente imprime en pantalla el numero mayor y el menor de los introducidos 
	 */
	private static void mayorMenor() {
		int mayor = pedirEntero();
		int menor = mayor;
		for(int i=0; i<9; i++) {
			int aux = pedirEntero(); //Introducimos una variable auxiliar para ayudar con la comprobacion
			if(mayor > aux) {
				mayor = aux;
			}else if(menor < aux) {
				menor = aux;
			}
		}
		mostrarMensaje("El numero mayor de los introducidos es: " + mayor);
		mostrarMensaje("El numero menor de los introducidos es: " + menor);
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main ejecuta el metodo mayorMenor para mostrar en pantalla
	 * el numero mayor y el menor de 10 introducidos.
	 */
	public static void main(String[] args) {
		mayorMenor();
	}
}
