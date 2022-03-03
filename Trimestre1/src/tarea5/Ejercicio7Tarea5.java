package tarea5;
import java.util.Scanner;

public class Ejercicio7Tarea5 {
	/*
	 * Implementa un programa Java que detecte si el número entero introducido 
	 * por el usuario es un “Número Feo”. Los números feos son aquellos enteros positivos 
	 * cuyos únicos factores primos son 2, 3 o 5. Por convención el 1 está incluido. 
	 * Los primeros 10 números feos son los siguientes: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12.
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
	 * Post: Este metodo recibe un numero entero y devuelve true si el numero es feo
	 * o false si no lo es.
	 */
	private static boolean esFeo(int c) {
		if(c < 1) {
			return false;
		}else if(c == 1 || c%2 == 0 || c%3 == 0 || c%5 == 0) {
			return true;
		}else {
			return false;
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo comprueba si un string es un numero entero
	 */
	public static boolean esEntero(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
	/*
	 * Pre: ---
	 * Post: Este metodo main pide al usuario un numero entero y luego 
	 * llama al metodo esFeo para saber si el numero es feo o no
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		while(true) {
			mostrarMensaje("Introduzca un numero entero o pulse \"n\" para terminar.");
			String dato = entrada.nextLine();
			if(dato.equals("n")){//se comprueba si el usuario quiere salir del programa
				break;
			}else if(esEntero(dato)) {//se comprueba si el dato introducido es entero
				if(esFeo(Integer.parseInt(dato))) {//se coprueba si el numero es feo
					mostrarMensaje("El numero es feo\n");
				}else {
					mostrarMensaje("El numero no es feo\n");
				}
			}else {
				mostrarMensaje("El dato introducido no es un numero entero\n");
			}
		}
	}
}
