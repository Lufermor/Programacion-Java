package examenProgrTrimestre2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExamenTrim2_Ejercicio2 {
	/*
	 * Pre: ---
	 * Post: 
	 */
	public static int palabrasMasLargasQue(int lon, String fichero) {
		int numPalabras = 0;
		File file = new File(fichero);
		try {
			Scanner f = new Scanner(file);
			f.nextLine();
			while(f.hasNextLine()) {
				String linea = f.nextLine();
				//Limpiamos la linea:
				linea = linea.replaceAll(",", "").replaceAll("\\.", "").replaceAll(":", "");
				linea = linea.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\"", "");
				String[] lineaSep = linea.split(" ");
				for(String palabra : lineaSep) if(palabra.length() >= lon) numPalabras++;
			}
			f.close(); //Se libera el fichero que estamos leyendo
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + fichero + " no ha podido ser leído.");
		}
		return numPalabras;
	}
	
	/*
	 * Pre: ---
	 * Post: Este método main
	 */
	public static void main(String[] args) {
		String fichero = "/Users/User/eclipse-workspace/Trimestre2/src/examenProgrTrimestre2/textoExamen.txt";
		System.out.println("Vamos a comprobar el metodo palabrasMasLargasQue, haciendo "
				+ "varias pruebas sobre el fichero textoExamen.txt");
		/*Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca la ");
		String longitud = entrada.nextLine();*/
		for(int i = 0; i<=10; i++) {
			System.out.println("Numero de palabras en el texto, con longitud igual o mayor de "
								+ i + " = " + palabrasMasLargasQue(i, fichero));
		}
		System.out.println("Gracias por venir :D");
	}
}
