package recursividad;
/*
 *  Implementa un programa Java que dada una tabla de números enteros, 
 *  muestre por pantalla sus valores de forma recursiva.
 */
public class RecursTarea1Ejercicio3 {
	/*
	 * Pre: al llamar al método desde el main, i debe ser la longitud de la tabla
	 * Post: Imprime por pantalla los valores de la tabla empezando por el último
	 */
	public static void imprimirTablaDesc(int[] tabla, int i) {
		if(i == 1) {
			System.out.println(tabla[i-1]);
		}
		else {
			System.out.println(tabla[i-1]);
			imprimirTablaDesc(tabla, i-1);
		}
	}
	/*
	 * Pre: al llamar al método desde el main, i debe ser 0
	 * Post: Imprime por pantalla los valores de la tabla recursivamente
	 */
	public static void imprimirTabla(int[] tabla, int i) {
		if(i == tabla.length-1) {
			System.out.println(tabla[i]);
		}
		else {
			System.out.println(tabla[i]);
			imprimirTabla(tabla, i+1);
		}
	}
	/*
	 * Pre: ---
	 * Post: Realiza pruebas sobre los métodos recursivos
	 */
	public static void main(String[] args) {
		int[] tabla = {1,2,3,4,5,6,7,8,9,0,10};
		imprimirTabla(tabla, 0);
	}
}
