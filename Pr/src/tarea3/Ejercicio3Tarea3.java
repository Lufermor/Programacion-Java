package tarea3;
import java.util.Scanner;

public class Ejercicio3Tarea3 {
	/*Ejercicio 3:Implementa un programa Java que lea números hasta que se teclee uno negativo. 
	 * Al final debe mostrar cuántos números se han introducido.
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
	 * Post: Este método main implementa un escáner y luego inicia un 
	 * bucle infinito para solicitar al usuario números reales
	 * y cuenta los números que se han introducido
	 * Esto se repite hasta que se introduzca un número negativo.
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);//Declaramos un Scanner
		int contador = 0;//iniciamos una variable auxiliar para que nos sirva de contador
		while(true) { //Iniciamos un bucle infinito
			mostrarMensaje("Por favor introduzca un número real:");//llamamos al método y le damos un string para que opere
			double num = entrada.nextDouble();//Creamos una variable donde se introduce el número introducido por el usuario
			contador++;//aumentamos el contador
			if(num<0) {//comprobamos si el número es negativo
				mostrarMensaje("El total de números introducidos es:" + contador );
				break;//rompemos el bucle infinito
			}
		}
	}
}
