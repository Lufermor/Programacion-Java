package examenProgrTrimestre2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExamenTrim2_Ejercicio2 {
	/*
	 * Pre: ---
	 * Post: Este metodo recibe un entero y una ruta de un fichero, crea un objeto tipo file
	 * y lo lee con un objeto de tipo Scanner. Al leer cada linea, la limpia y la separa por palabras, 
	 * finalmente comprueba palabra por palabra, si estas tienen una longitud mayor o igual que el entero pasado como atributo
	 * devuelve el n�mero de palabras que cumplen la condici�n.
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
			System.out.println("El fichero " + fichero + " no ha podido ser le�do.");
		}
		return numPalabras;
	}
	
	/*
	 * Pre: ---
	 * Post: Este m�todo main implementa un m�todo for que realiza varias pruebas sobre el 
	 * m�todo palabrasMasLargasQue.
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
