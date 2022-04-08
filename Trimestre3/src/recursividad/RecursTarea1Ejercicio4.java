package recursividad;

/*
 *  Implementa un programa Java que dada una tabla de números enteros y un número N, 
 *  devuelva true sí o sólo sí N se encuentra dentro de la tabla dada.
 */

public class RecursTarea1Ejercicio4 {
	/*
	 * Pre: ---
	 * Post: comprueba de forma recursiva si un numero N se encuentra en una tabla,
	 * devuelve true o false
	 */
	private static boolean comprobarN(int[] tabla, int n, int i) {
//		boolean respuesta = false;
		if(i<1) return false;
		else if(tabla[i-1] == n) return true;
		else return comprobarN(tabla, n, i-1);
		
	}
	/*
	 * Pre: ---
	 * Post: 
	 */
	public static void main(String[] args) {
		int[] tabla = {1,2,3,4,5,6,7,8,9,0,10};
		for(int num: tabla) System.out.println(comprobarN(tabla, (int)(num*Math.pow(-1, num)), tabla.length));
	}
}
