package tarea3;
import java.util.Scanner;

public class Ejercicio2Tarea3 {
	/*Ejercicio 2:
	 * Implementa un programa Java que lea un n�mero real (decimales) 
	 * e indique si es positivo o negativo. El proceso se repetir� hasta que se 
	 * introduzca un 0.
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
	 * Post: Este m�todo dice si un n�mero es positivo o negativo
	 */
	private static void comprobarSigno(double a) {
		if(a>0) {
			mostrarMensaje("El n�mero es positivo");
		}else {
			mostrarMensaje("El n�mero es negativo");
		}
	}
	/*
	 * Pre: ---
	 * Post: Este m�todo main implementa un esc�ner y luego inicia un 
	 * bucle infinito para solicitar al usuario n�meros reales,
	 * comprueba si el n�mero es cero y sino llama a un m�todo para que indique el signo del n�mero. 
	 * Esto se repite hasta que se introduzca un cero
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);//Declaramos un Scanner
		while(true) { //Iniciamos un bucle infinito
			mostrarMensaje("Por favor introduzca un n�mero real:");//llamamos al m�todo y le damos un string para que opere
			double num = entrada.nextDouble();//Creamos una variable donde se introduce el n�mero introducido por el usuario
			if(num==0) {//iniciamos la comprobaci�n de una condici�n
				mostrarMensaje("El n�mero es cero");
				break;//Se rompe el bucle infinito
			}else {//acci�n a realizar si el dato introducido no es cero
				comprobarSigno(num);//llamamos al m�todo para hacer la comprobaci�n
			}
		}
	}
}
