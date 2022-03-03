package tarea3;
import java.util.Scanner;

public class Ejercicio1Tarea3 {
	/*Ejercicio 1:
	 *Implementa un programa Java que lea un n�mero real (decimales) y muestre su cuadrado. 
	 *Repetir el proceso hasta que se introduzca un n�mero negativo.
	 */
	/*
	 * Pre: ---
	 * Post: Este m�todo imprime por pantalla un mensaje dado
	 */
	private static void mostrarMensaje(String msj) {
		System.out.println(msj);
	}
	/*
	 * Pre: ---
	 * Post: Este m�todo devuelve el cuadrado de un n�mero
	 */
	private static double cuadrado(double a) {
		return a*a;
	}
	/*
	 * Pre: ---
	 * Post: Este m�todo main implementa un esc�ner y luego inicia un 
	 * bucle infinito para solicitar al usuario n�meros reales
	 * y mostrar su cuadrado en pantalla, esto se repite 
	 * hasta que se introduzca un n�mero negativo
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in); //Declaramos un Scanner
		while(true) { //Iniciamos un bucle infinito
			mostrarMensaje("Por favor introduzca un n�mero real:");//llamamos al m�todo y le damos un string para que opere
			double num = entrada.nextDouble();//Creamos una variable donde se introduce el n�mero introducido por el usuario
			if(num<0) {//iniciamos la comprobaci�n de una condici�n
				mostrarMensaje("El n�mero es negativo");
				break;//Se rompe el bucle infinito
			}else {//acci�n a realizar si el dato introducido es correcto
				mostrarMensaje("El cuadrado de " + num + " es: " + cuadrado(num));
				//se llama al m�todo para que muestre un mensaje en el que se muestra el cuadrado del n�mero introducido
			}
		}
	}
}
