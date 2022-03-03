package tarea5;
import java.util.Scanner;

public class Ejercicio5Tarea5 {
	/*
	 * Implementa un programa Java que solicite al usuario una cadena de caracteres (String) 
	 * y muestre por pantalla el número de veces que aparece la sub-cadena “aaa” 
	 * dentro de dicho String.
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
	 * Post: Este metodo recibe una cadena y una subcadena, y cuenta cuantas veces aparece
	 * la subcadena dentro de la cadena. 
	 * NOTA: si la subcadena aparece dos o mas veces seguidas, y se superpone sobre si misma, 
	 * el metodo la contara todas las veces superpuestas.
	 */
	private static int contarSubcadenas(String cadena, String subCadena) {
		int contador = 0;
		int posicion = 0;
		while(posicion != -1) {
			if(!cadena.contains(subCadena)) {
				break;
			}
			/*Esta linea comentada serviria si se quiere ignorar las veces que 
			 * la cadena se superpone sobre si misma:
			 */
			//posicion = cadena.indexOf(subCadena, posicion + subCadena.length());
			//Con esta linea si se cuentan las veces que la cadena se superpone sobre si misma:
			posicion = cadena.indexOf(subCadena, posicion + 1);
			contador ++;
		}
		return contador;
	}
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		mostrarMensaje("Por favor introduzca una palabra o frase: ");
		String cad = entrada.nextLine();
		String subCad = "aaa";
		mostrarMensaje("El numero de veces que aparece la cadena \"" + subCad
				+ "\" en la cadena introducida es: " 
				+ contarSubcadenas(cad.toLowerCase(), subCad.toLowerCase()));
	}
}
