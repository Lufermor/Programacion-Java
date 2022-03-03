package examenProgrTrimestre2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExamenTrim2_Ejercicio3 {
	/*
	 * Pre: ---
	 * Post: Este nñetidi comprueba si una cadena dada es un numero entero
	 */
	private static boolean esEntero(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metod recibe un arrayList de Strings y un string, comprueba 
	 * que el string esté en el arrayList, en caso de no estarlo, lo añade.
	 */
	public static void addConsola(ArrayList<String> consolas, String consola){
		boolean nuevo = true;
		for(String tesoro : consolas) {
			if(tesoro.equalsIgnoreCase(consola)) {
				nuevo = false; break;
			}
		}
		if(nuevo) consolas.add(consola);
	}
	/*
	 * Pre: ---
	 * Post: Este método crea un objeto tipo file con una ruta a un fichero csv, lo lee con la clase Scanner.
	 * Al leerlo, parsea los datos y guarda los nombres de consolas que aparecen en un arrayList, 
	 * con yuda del método addConsola.
	 * Por último imprime todas las consolas en el arrayList.
	 */
	public static void informacionVideojuegos() {
		ArrayList<String> consolas = new ArrayList<String>();
		String fichero = "/Users/User/eclipse-workspace/Trimestre2/src/examenProgrTrimestre2/ventasVideojuegos.csv";
		File file = new File(fichero);
		try {
			Scanner f = new Scanner(file);
			f.nextLine();
			while(f.hasNextLine()) {
				String linea = f.nextLine();
				String[] lineaSep = linea.split(",");
				if(esEntero(lineaSep[lineaSep.length - 9] + "")) {
					if(lineaSep[lineaSep.length - 9].equals("2600")) {
						addConsola(consolas, lineaSep[lineaSep.length - 9]);
					}else addConsola(consolas, lineaSep[lineaSep.length - 10]);
				}else {
					addConsola(consolas, lineaSep[lineaSep.length - 9]);
				}
			}
			f.close(); //Se libera el fichero que estamos leyendo
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + fichero + " no ha podido ser leído.");
		}
		System.out.println("Las consolas que aparecen en el fichero son:");
		for(String consola : consolas) System.out.print(consola + ", ");
	}
	
	/*
	 * Pre: ---
	 * Post: Este método main llama al método informacionVideojuegos para obtener las diferentes consolas
	 * que aparecen en un determinado fichero csv
	 */
	public static void main(String[] args) {
		System.out.println("Vamos a comprobar el metodo informacionVideojuegos()");
		informacionVideojuegos();
		System.out.println("\n\nGracias por venir :D");
	}
}
