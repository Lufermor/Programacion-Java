package tarea3;
import java.util.Scanner;

public class Ejercicio4Tarea3 {
	/*
	 * Ejercicio 4:
	 * �IMPLEMENTA TU PRIMER JUEGO! 
	 * Realiza un programa Java que adivine el n�mero. 
	 * El programa generar� un n�mero aleatorio entre 0 y 20 (usando Math.random()) 
	 * y luego ir� pidiendo n�meros al usuario indicando �mayor� o �menor� seg�n sea 
	 * mayor o menor con respecto al n�mero generado aleatoriamente. 
	 * El proceso termina cuando el usuario acierta, 
	 * y deber� mostrar un mensaje de felicitaciones 
	 * junto al n�mero de intentos que ha necesitado el usuario. 
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
	 * Post: Este m�todo comprueba dos enteros dados e indica si el primero es mayor o menor 
	 * que el primero o si son iguales
	 */
	private static String comprobarPremio(int a, int b, int c) {
		if(a>b) {
			return "Intenta un n�mero mayor";
		}else if(a<b) {
			return "Intenta un n�mero menor";
		}else {
			return "FELICIDADES!!!\nHas adivinado el n�mero\n"
					+ "El n�mero de intentos fue: " + c; 
		}
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
		int premio = (int)Math.floor(Math.random()*21); //generamos un n�mero aleatorio entre 0 y 20
		mostrarMensaje("���Bienvenido al juego m�s novedoso !!!\n"
				+ "Prueba tu suerte intentando adivinar un n�mero entre 0 y 20!\n"
				+ "Introduce un n�mero entre 0 y 20:");//Damos un mensaje de bienvenida al usuario y le pedimos que introduzca un n�mero
		int numeroDado = -1;//declaramos un n�mero entero donde luego guardaremos el n�mero dado por el usuario
		while(premio != numeroDado) {
			contador++;//aumentamos el contador
			numeroDado = entrada.nextInt(); //guardamos el n�mero dado por el usuario
			mostrarMensaje(comprobarPremio(premio, numeroDado, contador));//llamamos al m�todo comprobarPremio y luego su mensaje lo imprimimos con mostrarMensaje
		}
	}
}
