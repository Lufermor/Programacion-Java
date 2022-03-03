package examenProgrTrimestre2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExamenTrim2_Ejercicio3 {
	/*
	 * Pre: ---
	 * Post: Este método crea un objeto tipo file con una ruta a un fichero csv, lo lee con la clase Scanner
	 * y 
	 */
	public static void informacionVideojuegos() {
		ArrayList<String> consolas = new ArrayList<String>();
		String fichero = "/Users/User/eclipse-workspace/Trimestre2/src/examenProgrTrimestre2/ventasVideojuegos.csv";
		File file = new File(fichero);
		int cuentaLineas=0;
		try {
			Scanner f = new Scanner(file);
			f.nextLine();
			while(f.hasNextLine()) {
				String linea = f.nextLine();
				cuentaLineas+=1;
				String[] lineaSep = linea.split(",");
				if(lineaSep.length > 11) {
					
				}
			}
			f.close(); //Se libera el fichero que estamos leyendo
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
