package tarea7;
/* Implementa un programa Java con un método llamado
 * indexContains(String[] tabla, String cadena) que devuelva el índice de la
 * tabla cuyo valor es igual al valor de “cadena”. En caso de no haber ningún
 * valor igual, devuelve -1
 */

public class Tarea7Ejercicio4 {
	/*
	 * Pre: ---
	 * Post: Este metodo recibe una tabla y un string, y comprueba si alguno de los 
	 * elementos de la tabla coincide con el string, devolviendo el indice de 
	 * este elemento, o en su defecto devuelve -1
	 */
	private static int indexContains(String[] tabla, String cadena) {
		for(int j = 0; j < tabla.length; j++) {
			if(tabla[j].equals(cadena)) {
				return j;
			}
		}
		return -1;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main comprueba que el metodo indexContains funciona correctamente
	 * enviando varias cadenas para comprobar en una tabla.
	 */
	public static void main(String [] args) {
		String[] a = {"Avila","Burgos","Leon","Palencia","Salamanca",
				   "Segovia","Soria","Valladolid","Zamora"};
		String[] b = new String[] {"one", "Avila", "two", "three", "Soria", "four", "five",
				"six", "Palencia", "Leon", "seven", "Zamora", "Avila", "eight"};
		for(int i = 0; i < b.length; i++) {
			System.out.println(indexContains(a, b[i]));
		}
	}
}
