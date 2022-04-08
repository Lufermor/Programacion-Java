package recursividad;
//Programar un algoritmo recursivo que permita sumar los elementos de una matriz.
public class RecursTarea3Ejercicio3 {
	/*
	 * Pre: m y n se refieren al valor (fila, columna) desde el que se empieza a sumar 
	 * los valores de la matriz 
	 * Post: suma recursivamente los elementos en una matriz
	 */
	private static int sumarMatriz(int[][] matriz, int m, int n, int suma) {
		if(m == matriz.length-1) {
			if(n == matriz[0].length-1) {
				return suma + matriz[m][n];
			}else {
				suma += matriz[m][n];
				return sumarMatriz(matriz, m, n+1, suma);
			}
		}else if(n == matriz[0].length-1) {
			suma += matriz[m][n];
			return sumarMatriz(matriz, m+1, 0, suma);
		}else {
			suma += matriz[m][n];
			return sumarMatriz(matriz, m, n+1, suma);
		}
	}
	/*
	 * Pre: ---
	 * Post: realiza pruebas sobre el método sumarMatriz
	 */
	public static void main(String[] args) {
		int[][] matriz = new int[5][5];
		for(int i = 0; i<matriz.length; i++) {
			for(int j = 0; j<matriz.length; j++) matriz[i][j] = (int)(Math.random()*1000);
		}
		System.out.println(sumarMatriz(matriz, 0, 0, 0));
		//las siguientes líneas son para comprobar:
		int suma = 0;
		for(int i = 0; i<matriz.length; i++) {
			for(int j = 0; j<matriz.length; j++) suma += matriz[i][j];
		}	
		System.out.println(suma);
	}
}
