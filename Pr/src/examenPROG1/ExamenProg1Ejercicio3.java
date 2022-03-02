package examenPROG1;

public class ExamenProg1Ejercicio3 {
	/*
	 * Pre: ---
	 * Post: Este metodo recibe una tabla bidimensional de enteros, y un indicador de fila
	 * segun la fila indicada, imprime por pantalla el valor maximo de la fila.
	 */
	private static void maxFila(int[][] tabla, int fila) {
		int max = tabla[fila][0];
		for(int i = 1; i <tabla[fila].length; i++) {
			if(tabla[fila][i]>max) {
				max = tabla[fila][i];
			}
		}
		System.out.println("El salario maximo del empleado fue de: " + max);
	}
	/*
	 * Pre: ---
	 * Post: Este metodo pone a prueba el metodo maxFila, haciendole imprimir el 
	 * valor maximo de cada fila de una tabla bidimensional.
	 */
	public static void main(String[] args) {
		int salarios[][] = { {700, 900, 1300, 800, 790, 850} , 
				{1000, 950, 1080, 1070, 1200, 1100}, {1300, 930, 1200, 1170, 1000, 1000} , 
				{1500, 1950, 1880, 1978, 2200, 2100} };
		for(int i = 0; i< salarios.length; i++) {
			maxFila(salarios, i);
		}
		
	}
}
