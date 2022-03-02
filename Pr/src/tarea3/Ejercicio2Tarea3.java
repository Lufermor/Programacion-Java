package tarea3;
import java.util.Scanner;

public class Ejercicio2Tarea3 {
	/*Ejercicio 2:
	 * Implementa un programa Java que lea un número real (decimales) 
	 * e indique si es positivo o negativo. El proceso se repetirá hasta que se 
	 * introduzca un 0.
	 */
	/*
	 * Pre: ---
	 * Post: Este método imprime por pantalla un mensaje dado
	 */
	private static void mostrarMensaje(String msj) {
		System.out.println(msj);
	}
	/*
	 * Pre: ---
	 * Post: Este método dice si un número es positivo o negativo
	 */
	private static void comprobarSigno(double a) {
		if(a>0) {
			mostrarMensaje("El número es positivo");
		}else {
			mostrarMensaje("El número es negativo");
		}
	}
	/*
	 * Pre: ---
	 * Post: Este método main implementa un escáner y luego inicia un 
	 * bucle infinito para solicitar al usuario números reales,
	 * comprueba si el número es cero y sino llama a un método para que indique el signo del número. 
	 * Esto se repite hasta que se introduzca un cero
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);//Declaramos un Scanner
		while(true) { //Iniciamos un bucle infinito
			mostrarMensaje("Por favor introduzca un número real:");//llamamos al método y le damos un string para que opere
			double num = entrada.nextDouble();//Creamos una variable donde se introduce el número introducido por el usuario
			if(num==0) {//iniciamos la comprobación de una condición
				mostrarMensaje("El número es cero");
				break;//Se rompe el bucle infinito
			}else {//acción a realizar si el dato introducido no es cero
				comprobarSigno(num);//llamamos al método para hacer la comprobación
			}
		}
	}
}
