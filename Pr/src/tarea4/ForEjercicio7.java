package tarea4;
import java.util.Scanner;

public class ForEjercicio7 {
	/*Escribe un programa Java que pregunte al usuario por un número entero 
	 * y muestre por pantalla su tabla de multiplicar
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
	 * Post: Este metodo muestra por pantalla la tabla de multiplicar de un numero dado 
	 * del 1 al 10
	 */
	private static void tablaMultiplicar(int n) {
		mostrarMensaje("La tabla de multiplicar del numero " + n + " es:");
		for(int i=1; i<=10; i++) {
			mostrarMensaje(n + " x " + i + " = " + n*i);
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main pregunta al usuario por un entero y luego 
	 * llama a un metodo para imprimir su tabla de multiplicar
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		mostrarMensaje("Introduzca un numero entero");
		int num = entrada.nextInt();
		tablaMultiplicar(num);
	}
}
