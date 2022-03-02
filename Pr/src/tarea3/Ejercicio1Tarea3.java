package tarea3;
import java.util.Scanner;

public class Ejercicio1Tarea3 {
	/*Ejercicio 1:
	 *Implementa un programa Java que lea un número real (decimales) y muestre su cuadrado. 
	 *Repetir el proceso hasta que se introduzca un número negativo.
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
	 * Post: Este método devuelve el cuadrado de un número
	 */
	private static double cuadrado(double a) {
		return a*a;
	}
	/*
	 * Pre: ---
	 * Post: Este método main implementa un escáner y luego inicia un 
	 * bucle infinito para solicitar al usuario números reales
	 * y mostrar su cuadrado en pantalla, esto se repite 
	 * hasta que se introduzca un número negativo
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in); //Declaramos un Scanner
		while(true) { //Iniciamos un bucle infinito
			mostrarMensaje("Por favor introduzca un número real:");//llamamos al método y le damos un string para que opere
			double num = entrada.nextDouble();//Creamos una variable donde se introduce el número introducido por el usuario
			if(num<0) {//iniciamos la comprobación de una condición
				mostrarMensaje("El número es negativo");
				break;//Se rompe el bucle infinito
			}else {//acción a realizar si el dato introducido es correcto
				mostrarMensaje("El cuadrado de " + num + " es: " + cuadrado(num));
				//se llama al método para que muestre un mensaje en el que se muestra el cuadrado del número introducido
			}
		}
	}
}
