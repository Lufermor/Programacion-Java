package tarea4;
import java.util.Scanner;

public class ForEjercicio4 {
	/* Escribe un programa Java que pregunte al usuario por 2 números, 
	 * y te muestre por pantalla todos los números situados entre ambos 
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
	 * Post: Este metodo imprime por pantalla los numeros enteros entre dos numeros dados
	 */
	private static void mostrarNumeros(int a, int b) {
		if(a==b-1) {
			mostrarMensaje("No hay numeros enteros entre los dados");
		}else {
			for(int i=a+1; i<b; i++) {
				mostrarMensaje("" + i);
			}
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main pregunta al usuario por dos numeros enteros y luego 
	 * llama a un metodo para mostrar los enteros entre ambos
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		mostrarMensaje("Por favor introduce el numero menor");
		int menor = entrada.nextInt();
		mostrarMensaje("Por favor introduce el numero mayor");
		int mayor = entrada.nextInt();
		mostrarMensaje("Los numeros enteros entre los introducidos son: ");
		mostrarNumeros(menor, mayor);
	}
}
