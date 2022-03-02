package tarea10;

public class Tarea10Ejercicio1 {
	/*
	 * Pre: --
	 * Post: Este metodo main muestra por pantalla los salarios trimestrales de una lista 
	 * de empleados, dada una tabla de empleados y otra de sus salarios por tres meses.
	 */
	public static void main(String[] args) {
		int salarios[][] = { {700, 900, 1300} , {1000, 950, 1080}, {1300, 930, 1200} };
		String empleados[] = {"Javier Marías", "Antonio Muñoz", "Isabel Allende"};
		for(int i=0; i<empleados.length; i++) {
			System.out.print(empleados[i] + " -> ");
			int salarioTrimestral = 0;
			for(int j=0; j < salarios[i].length; j++) {
				System.out.print(salarios[i][j]);
				salarioTrimestral+= salarios[i][j];
				if(j==salarios[i].length -1) {//Esto es si estamos en la ultima posicion de la fila i
					System.out.println(" = " + salarioTrimestral +"€");
				}else {
					System.out.print(" + ");
				}
			}
		}
	}
}
