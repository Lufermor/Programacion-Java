package highLevelFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class TextFilesExercise2 {
	/*
	 * Pre: ---
	 * Post: Este m?todo crea un objeto tipo File del que se leer? la informaci?n
	 * de cada l?nea se parsean los datos y se guardan en variables, 
	 * calcula los puntos necesarios para obtener la longitud deseada
	 * y finalmente guarda en un nuevo archivo, cada l?nea con el nuevo formato. 
	 */
	public static void copiarFichero(String fichero, String newFile) {
		String nombre = "";
		String apellidos = "";
		String dni = "";
		String puntos = "";
		File file = new File(fichero);
		try {
			Formatter salida = new Formatter(newFile);
			
			try {
				Scanner f = new Scanner(file);
				while(f.hasNextLine()) {
					String linea = f.nextLine();
					//Limpiamos la l?nea
					linea = linea.replaceAll(",", "");
					String[] lineaSep = linea.split(" ");
					dni = lineaSep[0];
					apellidos = lineaSep[1] + " " + lineaSep[2];
					if(lineaSep.length == 4) nombre = lineaSep[3];
					else if(lineaSep.length == 5) nombre = lineaSep[3] + " " + lineaSep[4];
					int p = 59-nombre.length()-apellidos.length()-9; //calculamos los puntos que nos faltan para tener la longitud deseada en el String
					/*	En la siguiente l?nea utilizamos el especificador 'width' de String format() para indicar la cantidad de caracteres deseados,
					 *  String format() nos rellena el String con espacios, por tanto los reemplazamos por puntos */
					puntos = String.format("%" + p + "s", "").replaceAll(" ", ".");
					//System.out.println(nombre + " " + apellidos + puntos + dni);
					salida.format(nombre + " " + apellidos + puntos + dni + "\n"); 
				}
				//Se libera el fichero que estamos leyendo:
				f.close();
			} catch (FileNotFoundException e) {
				System.out.println("El fichero " + fichero + " no ha podido ser le?do.");
			}
			salida.close();
		} catch (FileNotFoundException e1) {
			System.out.println("El fichero " + newFile + " no ha podido ser creado.");
		}
		
	}
	/*
	 * Pre: ---
	 * Post: Este m?todo main con una ruta dada y otra ruta pedida al usuario,
	 * llama al m?todo copiarFichero para copiar la informaci?n con un formato espec?fico.
	 */
	public static void main(String[] args) {
		//String fichero = "/Users/User/Documents/Java/PruebaHighLevelFiles/personas.txt";
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca el nombre (con ruta completa) para el fichero a leer:");
		String fichero = entrada.nextLine();
		System.out.println("Introduzca el nombre (con ruta completa) para el nuevo fichero:");
		String nuevoFile = entrada.nextLine();
		copiarFichero(fichero, nuevoFile);
		System.out.println("Operaci?n terminada.");
		entrada.close();
	}
}
