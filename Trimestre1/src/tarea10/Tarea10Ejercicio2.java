package tarea10;

public class Tarea10Ejercicio2 {
	/*
	 * Pre: ---
	 * Post: Este metodo recibe una tabla bidimensional de enteros, 
	 * ordena una fila dada, de mayor a menor, y la imprime 
	 * por pantalla en un formato pre-establecido 
	 */
	private static void ordenarTabla(int [][] tabla, int fila) {
		//for(int fila=0; fila<tabla.length; fila++) {
		for(int j = 0; j<tabla[fila].length; j++) {
			for(int k=j+1; k<tabla[fila].length; k++) {
				if(tabla[fila][k]>tabla[fila][j]) {
					int aux = tabla[fila][j];
					tabla[fila][j] = tabla[fila][k];
					tabla[fila][k] = aux;
				}
			}
			if(j==tabla[fila].length-1) {
				System.out.println(tabla[fila][j]);
			}else {
				System.out.print(tabla[fila][j] + " / ");
			}
		}
		//}
	}
	/*
	 * Pre: ---
	 * Post: este metodo main imprime los nombres de cada empleado y llama al metodo
	 * ordenarTabla para que imprima a continuación, los salarios del empleado, ordenados
	 * de mayor a menor
	 */
	public static void main(String[] args) {
		/*para asegurarnos de que el metodo ordenarTabla funciona bien, añadimos unos datos aleatorios 
		a la tabla de salarios*/
		int salarios[][] = { {700, 900, 1300, 1, 2, 3, 1500, 2000, 1800, 1700, 4, 5, 1900, 50, 40, 30, 20} , 
				{1000, 950, 1080, 1, 2, 3, 1500, 2000, 1800, 1700, 4, 1900, 5, 50, 40, 30, 20}, 
				{1300, 930, 1200, 1, 1500, 2000, 1800, 1700, 2, 3, 4, 5, 50, 40, 1900, 30, 20} };
		String empleados[] = {"Javier Marías", "Antonio Muñoz", "Isabel Allende"};
		for(int i=0; i<empleados.length; i++) {
			System.out.print(empleados[i]+ " -> ");
			ordenarTabla(salarios, i);
		}
	}
}
