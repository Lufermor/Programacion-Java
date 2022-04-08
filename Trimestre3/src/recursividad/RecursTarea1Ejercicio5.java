package recursividad;
/*
 * Implementa un programa Java que dada una tabla multidimensional 
 * de números enteros, muestre todos los sus elementos por pantalla de forma recursiva.
 */
public class RecursTarea1Ejercicio5 {
	/*
	 * Pre: m y n se refieren al valor (fila, columna) desde el que se empieza a imprimir la tabla 
	 * Post: imprime recursivamente los elementos en una tabla
	 */
	private static void imprimirTabla(int[][] tabla, int m, int n) {
		if(m == tabla.length-1) {
			if(n == tabla[0].length-1) {
				System.out.print(tabla[m][n]);
			}else {
				System.out.print(tabla[m][n]);
				imprimirTabla(tabla, m, n+1);
			}
		}else if(n == tabla[0].length-1) {
			System.out.println(tabla[m][n]);
			imprimirTabla(tabla, m+1, 0);
		}else {
			System.out.print(tabla[m][n]);
			imprimirTabla(tabla, m, n+1);
		}
	}
	/*
	 * Pre: ---
	 * Post: Realiza pruebas sobre el método imprimirTabla
	 */
	public static void main(String[] args) {
		int[][] laTabla = new int[5][5];
		for(int i = 0; i<laTabla.length; i++) {
			for(int j = 0; j<laTabla.length; j++) laTabla[i][j] = i+j;
		}
		imprimirTabla(laTabla, 0, 0);
	}
}
