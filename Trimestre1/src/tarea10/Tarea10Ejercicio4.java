package tarea10;

public class Tarea10Ejercicio4 {
	/*
	 * Pre: ---
	 * Post: Este metodo main tiene tres tablas, combina las tres para
	 * imprimir por pantalla el total de kilos vendidos de cada fruta y 
	 * los ingresos totales por las ventas.
	 */
	public static void main(String[] args) {
		int kilos[][] = {{5, 6, 9, 23, 7, 14, 0}, {16, 8, 4, 33, 15, 21, 2}};
		String frutas[] = {"Pera", "Manzana"};
		int precios[] = {6, 7};
		for(int i = 0; i<frutas.length; i++) {
			int totalKilos = 0;
			for(int j = 0; j < kilos[i].length; j++) {
				totalKilos += kilos[i][j];
			}
			System.out.println(frutas[i] + " -> " + totalKilos +"kg x " + precios[i]
					+ "€ = " + (totalKilos*precios[i]) + "€");
		}
	}
}
