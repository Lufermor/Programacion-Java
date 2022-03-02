package tarea5;
import java.util.Scanner;

public class Ejercicio8Tarea5 {
	/*Implementa un programa Java que genere números randoms entre N y M (incluidos). 
	 * Los valores de N y M son números enteros introducidos por el usuario.
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
	 * Post: Este metodo genera un numero aleatorio entre dos numeros dados
	 */
	private static double generarNum(double n, double m) {
		return Math.random()*(m-n) + n;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo comprueba si un string es un numero entero
	 */
	public static boolean esNumero(String cadena) {
        boolean resultado;
        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
	/*
	 * Pre: ---
	 * Post: Este metodo main pide dos numeros al usuario, luego llama al metodo
	 * generarNum para obtener un numero aleatorio entre los dados 
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		double mayor = 0;
		double menor = 0;
		while(true) {
			mostrarMensaje("Introduzca el numero menor o pulse \"n\" para terminar.");
			String dato = entrada.nextLine();
			if(dato.equals("n")){//se comprueba si el usuario quiere salir del programa
				break;
			}else if(esNumero(dato)) {//se comprueba si el dato introducido es un numero
				menor = Double.parseDouble(dato);
				mostrarMensaje("Introduzca el numero mayor");
				dato = entrada.nextLine();
				if(esNumero(dato)) {
					mayor = Double.parseDouble(dato);
					mostrarMensaje("Numero aleatorio entre los introducidos :\n"
							+ generarNum(menor, mayor));
				}
			}else {
				mostrarMensaje("El dato introducido no es un numero\n");
			}
		}
	}
}
