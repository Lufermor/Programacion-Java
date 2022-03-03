package examenProgrTrimestre2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExamenTrim2_Ejercicio3 {
	/*
	 * Pre: ---
	 * Post: Este método crea un objeto tipo file con una ruta a un fichero csv, lo lee con la clase Scanner
	 * y 
	 */
	public static void informacionVideojuegos() {
		String fichero = "/Users/User/eclipse-workspace/Trimestre2/src/examenProgrTrimestre2/ventasVideojuegos.csv";
		File file = new File(fichero);
		try {
			Scanner f = new Scanner(file);
			f.nextLine();
			while(f.hasNextLine()) {
				String linea = f.nextLine();
				String[] lineaSep = linea.split(";");
				f.close(); //Se libera el fichero que estamos leyendo
			}
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + fichero + " no ha podido ser leído.");
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este método main llama al método informacionVideojuegos para obtener las diferentes consolas
	 * que aparecen en un determinado fichero csv
	 */
	public static void main(String[] args) {
		System.out.println("Vamos a comprobar el metodo informacionVideojuegos()");
		informacionVideojuegos();
		System.out.println("Gracias por venir :D");
	}
}
