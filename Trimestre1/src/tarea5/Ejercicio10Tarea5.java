package tarea5;
import java.util.Scanner;

public class Ejercicio10Tarea5 {
	/* Implementa un programa Java muestre por pantalla la suma de los dígitos 
	 * de un número entero. Ej: 23 -> 2 + 3 = 5
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
	 * Post: Este metodo comprueba si un string es un numero entero
	 */
	public static boolean esEntero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException excepcion) {
            return false;
        }
    }
	/*
	 * Este metodo suma los digitos de un entero dado
	 */
	private static int sumarDigitos(String u) {
		int suma = 0;
		for(int i = 0; i < u.length(); i++){
			suma += Integer.parseInt(u.substring(i, i + 1));
		}
		return suma;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main pide al usuario un numero entero, comprueba que 
	 * el dato introducido es un entero, luego suma sus digitos.
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		while(true) {
			mostrarMensaje("Introduzca un numero entero o pulse \"n\" para terminar.");
			String dato = entrada.nextLine();
			if(dato.equals("n")){//se comprueba si el usuario quiere salir del programa
				break;
			}else if(esEntero(dato)) {//se comprueba si el dato introducido es entero
				mostrarMensaje("La suma de los digitos del numero introducido es:\n" 
						+ sumarDigitos(dato));
			}else {
				mostrarMensaje("El dato introducido no es un numero entero\n");
			}
		}
	}
}
