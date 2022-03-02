package tarea8;
/*
 *  Implementa un método Java llamado copiarTabla, el cual
recibe como parámetro una tabla de Strings, y devuelve una nueva tabla
con los elementos en orden inverso.
 */

public class Tarea8Ejercicio4 {
	/*
	 * Pre: ---
	 * Post: Este metodo recibe una tabla de Strings, 
	 * y devuelve una nueva tabla con los elementos en orden inverso
	 */
	private static String[] copiarTabla(String[] tab) {
		String[] table = new String[tab.length];
		int j = 0;
		for(int i = tab.length; i > 0 ; i--) {
			table[j] = tab[i-1];
			j++;
		}
		return table;
	}
	/*
	 * Pre: --- 
	 * Post: Este metodo main pone a prueba el metodo copiarTabla 
	 * enviandole una tabla de Strings 
	 */
	public static void main(String[] args) {
		String[] tabla = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
		String[] tabla2 = new String[tabla.length];
		System.out.println("Tabla inicial: ");
		for(int i = 0; i < tabla.length; i++) {
			System.out.print(tabla[i] + " ");
		}
		tabla2 = copiarTabla(tabla);
		System.out.println("\nTabla final: ");
		for(int j = 0; j < tabla2.length; j++) {
			System.out.print(tabla2[j] + " ");
		}
	}
}
