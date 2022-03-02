package tarea6;
import java.util.Scanner;

/*Implementa un programa Java que le solicite al usuario un número entero
 *positivo y escriba dicho número con letra por pantalla. Únicamente debe
 *mostrar los nombres de los números del 0 al 9, el resto los mostrará con
 *el nombre “Otros”. 
 */
public class Tarea6Ejercicio1 {
	/*
	 * Pre: ---
	 * Post: Este método imprime por pantalla un mensaje dado
	 */
	private static void mostrarMensaje(String msj) {
		System.out.println(msj);
	}
	/*
	 * Pre: ---
	 * Post: Este metodo imprime por pantalla un mensaje segun la opcion que se introduzca
	 */
	private static void numeroALetra(int opcion) {
		switch(opcion) {
			case 0:
				mostrarMensaje("cero");
				break;
			case 1:
				mostrarMensaje("uno");
				break;
			case 2:
				mostrarMensaje("dos");
				break;
			case 3:
				mostrarMensaje("tres");
				break;
			case 4:
				mostrarMensaje("cuatro");
				break;
			case 5:
				mostrarMensaje("cinco");
				break;
			case 6:
				mostrarMensaje("seis");
				break;
			case 7:
				mostrarMensaje("siete");
				break;
			case 8:
				mostrarMensaje("ocho");
				break;
			case 9:
				mostrarMensaje("nueve");
				break;
			default:
				mostrarMensaje("otros");
		}
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
	 * Pre: ---
	 * Post: Este metodo main pide al usuario un entero positivo y llama 
	 * a un metodo para devolver su nombre en letras.
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		while(true) {
			mostrarMensaje("Introduzca un numero entero positivo o pulse \"n\" para salir.");
			String dato = entrada.nextLine();
			if(dato.equals("n")) {
				break;
			}else if(esEntero(dato)){
				int num = Integer.parseInt(dato);
				if(num<0) {
					mostrarMensaje("Recuerde que debe ser un entero positivo");
				}else {
					numeroALetra(num);
				}
			}else{
				mostrarMensaje("Vuelvalo a intentar");
			}
			
		}
	}
}
