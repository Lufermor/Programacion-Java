package tarea3;
import java.util.Scanner;

public class Ejercicio4Tarea3 {
	/*
	 * Ejercicio 4:
	 * ¡IMPLEMENTA TU PRIMER JUEGO! 
	 * Realiza un programa Java que adivine el número. 
	 * El programa generará un número aleatorio entre 0 y 20 (usando Math.random()) 
	 * y luego irá pidiendo números al usuario indicando “mayor” o “menor” según sea 
	 * mayor o menor con respecto al número generado aleatoriamente. 
	 * El proceso termina cuando el usuario acierta, 
	 * y deberá mostrar un mensaje de felicitaciones 
	 * junto al número de intentos que ha necesitado el usuario. 
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
	 * Post: Este método comprueba dos enteros dados e indica si el primero es mayor o menor 
	 * que el primero o si son iguales
	 */
	private static String comprobarPremio(int a, int b, int c) {
		if(a>b) {
			return "Intenta un número mayor";
		}else if(a<b) {
			return "Intenta un número menor";
		}else {
			return "FELICIDADES!!!\nHas adivinado el número\n"
					+ "El número de intentos fue: " + c; 
		}
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
		int premio = (int)Math.floor(Math.random()*21); //generamos un número aleatorio entre 0 y 20
		mostrarMensaje("¡¡¡Bienvenido al juego más novedoso !!!\n"
				+ "Prueba tu suerte intentando adivinar un número entre 0 y 20!\n"
				+ "Introduce un número entre 0 y 20:");//Damos un mensaje de bienvenida al usuario y le pedimos que introduzca un número
		int numeroDado = -1;//declaramos un número entero donde luego guardaremos el número dado por el usuario
		while(premio != numeroDado) {
			contador++;//aumentamos el contador
			numeroDado = entrada.nextInt(); //guardamos el número dado por el usuario
			mostrarMensaje(comprobarPremio(premio, numeroDado, contador));//llamamos al método comprobarPremio y luego su mensaje lo imprimimos con mostrarMensaje
		}
	}
}
