package tarea5;

public class Ejercicio9Tarea5 {
	/*Implementa un programa Java que muestre por pantalla la siguiente cara.
 	 +"""""+                                                 
	[| o o |]                                                
 	 |  ^  |                                                 
 	 | '-' |                                                 
 	 +-----+

	 * 
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
	 * Post: Este metodo imprime por pantalla una cara formada por caracteres
	 */
	public static void main(String[] args) {
		mostrarMensaje(" +\"\"\"\"\"+\n"
				+ "[| o o |]\n"
				+ " |  ^  |\n"
				+ " | '-' |\n"
				+ " +-----+");
		
		/*mostrarMensaje("	 +\"\"\"\"\"+ \r\n"
				+ "	[| o o |] \r\n"
				+ " 	 |  ^  | \r\n"
				+ " 	 | '-' | \r\n"
				+ " 	 +-----+");
		*/
	}
}
