package tarea5;
import java.util.Scanner;

public class Ejercicio11Tarea5 {
	/*Implementa un programa Java que solicite al usuario una cadena de caracteres 
	 * y devuelva dicha cadena, pero al revés.
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
	 * Post: Este metodo recibe un string y lo devuelve invertido
	 */
	private static String invertir(String str) {
		String resultado = "";
		int aux = str.length(); //declaramos una variable que nos ayudara a escribir el ciclo
		for(int i = 0; i < str.length(); i++) {
			resultado = resultado + str.substring(--aux, aux + 1);
			//str = str.substring(0, str.length()-1);
		}
		return resultado;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main pide al usuario una cadena y la devuelve al reves
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		mostrarMensaje("Introduzca una palabra o frase:");
		//String cadena = entrada.nextLine();
		mostrarMensaje(invertir(entrada.nextLine()));
	}
}
