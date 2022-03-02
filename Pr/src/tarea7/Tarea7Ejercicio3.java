package tarea7;
/*: Implementa un programa Java con un método llamado
 * contains(String[] tabla, String cadena) que devuelva TRUE, sí o solo sí,
 * alguno de los elementos de la tabla pasada como parámetro es igual al
 * valor de la variable “cadena”.
 */
public class Tarea7Ejercicio3 {
	/*
	 * Pre:---
	 * Post: Este metodo devuelve true si la cadena dada es igual a alguna de las 
	 * celdas de la tabla, de lo contrario devuelve false.
	 */
	private static boolean contains(String[] tabla, String cadena) {
		boolean resultado = false;
		for(int i = 0; i < tabla.length; i++) {
			if(tabla[i].equals(cadena)) {
				resultado = true;
				break;
			}
		}
		return resultado;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main pone a prueba un metodo de comprobacion de string en tabla
	 */
	public static void main(String[] args) {
		String[] a = {"Avila","Burgos","Leon","Palencia","Salamanca",
				   "Segovia","Soria","Valladolid","Zamora"};
		String[] b = new String[] {"one", "Avila", "two", "three", "Soria", "four", "five",
					"six", "Palencia", "Leon", "seven", "Zamora", "Avila", "eight"};
		for(int i = 0; i < b.length; i++) {
			System.out.println(contains(a, b[i]));
		}
	}
}
