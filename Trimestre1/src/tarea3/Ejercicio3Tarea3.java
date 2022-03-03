package tarea3;
import java.util.Scanner;

public class Ejercicio3Tarea3 {
	/*Ejercicio 3:Implementa un programa Java que lea n�meros hasta que se teclee uno negativo. 
	 * Al final debe mostrar cu�ntos n�meros se han introducido.
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
	 * Post: Este m�todo main implementa un esc�ner y luego inicia un 
	 * bucle infinito para solicitar al usuario n�meros reales
	 * y cuenta los n�meros que se han introducido
	 * Esto se repite hasta que se introduzca un n�mero negativo.
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);//Declaramos un Scanner
		int contador = 0;//iniciamos una variable auxiliar para que nos sirva de contador
		while(true) { //Iniciamos un bucle infinito
			mostrarMensaje("Por favor introduzca un n�mero real:");//llamamos al m�todo y le damos un string para que opere
			double num = entrada.nextDouble();//Creamos una variable donde se introduce el n�mero introducido por el usuario
			contador++;//aumentamos el contador
			if(num<0) {//comprobamos si el n�mero es negativo
				mostrarMensaje("El total de n�meros introducidos es:" + contador );
				break;//rompemos el bucle infinito
			}
		}
	}
}
