package tarea10;
/*
 * Implementa un método Java llamado “modificar” que, dado una tabla
 * multidimensional y un entero positivo, multiplique todos los elementos
 * de dicha tabla por el entero dado. Al finalizar la operación, se debe
 * mostrar el resultado de final de la tabla en el método main.
 */

public class Tarea10Ejercicio3 {
	/*
	 * Pre: ---
	 * Post: Este metodo recibe una tabla de enteros, y un entero dado, devuelve 
	 * una nueva tabla con todos los elementos de la primera tabla multiplicados por el entero.
	 */
	private static int[][] modificar(int tabla[][], int factor){
		for(int i=0; i<tabla.length; i++) {
			for(int j=0; j<tabla[i].length; j++) {
				tabla[i][j] = tabla[i][j]*factor;
			}
		}
		return tabla;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main tiene una tabla multidimensional, e implementa un bucle
	 * para llamar al metodo modificar, y obtener e imprimir varias tablas según 
	 * el factor utilizado.
	 */
	public static void main(String[] args) {
		int tabla[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		for(int i =2; i<6; i++) {
			modificar(tabla, i);
			System.out.println("Tabla " + (i-1) + ":");
			for(int j = 0; j<tabla.length; j++) {
				for(int k = 0; k < tabla[j].length; k++) {
					if(k == tabla[j].length - 1) {
						System.out.println(tabla[j][k]);
					}else {
						System.out.print(tabla[j][k] + ", ");
					}
				}
			}
			System.out.println();
		}
	}
}
