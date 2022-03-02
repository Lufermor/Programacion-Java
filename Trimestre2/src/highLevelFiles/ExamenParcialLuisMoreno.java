package highLevelFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * Clase en la que se lee un fichero csv y se realizan algunos cálculos sobre los datos que contiene.
 */
public class ExamenParcialLuisMoreno {
	/*
	 * Pre: ---
	 * Post: Este metodo le pide un dato al usuario
	 */
	private static String pedirDato(String frase) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(frase);
		return entrada.nextLine();
	}
	
	/*
	 * Pre: ---
	 * Post: Este comprueba si una cadena dada es un numero entero
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
	 * Post: Este metodo muestra un menu al usuario y le pide que escoja una opcion, 
	 * 		comprueba que sea válida y si no lo es se la vuelve a pedir.
	 */
	private static int mostrarMenu(String menu) {
		System.out.println(menu);
		int num;
		while(true) {
			String opcion = pedirDato("Seleccione una opcion:");
			if(esEntero(opcion)) {
				num = Integer.parseInt(opcion);
				if(0<=num && num<=5) {
					return num;
				}else {
					System.out.println("Opcion no valida. Escoja una opcion valida");
				}
			}else {
				System.out.println("Elija una opcion valida (introduzca solo el digito)");
			}
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo calcula el número total de pasajeros en el Titanic
	 */
	public static int totalPasajeros(File file) {
		int num = -1;
		Scanner f;
		try {
			f = new Scanner(file);
			while(f.hasNextLine()) {
				String linea = f.nextLine();
				num++;
			}
			f.close();
		} catch (FileNotFoundException e) {
		}
		return num;
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo calcula el número total de mujeres en el Titanic
	 */
	public static int totalMujeres(File file) {
		int num = 0;
		Scanner f;
		try {
			f = new Scanner(file);
			while(f.hasNextLine()) {
				String[] linea = f.nextLine().split(",");
				if(linea[5].equalsIgnoreCase("female"))	num++;
			}
			f.close();
		} catch (FileNotFoundException e) {

		}
		return num;
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo calcula el número total de hombres en el Titanic
	 */
	public static int totalHombres(File file) {
		int num = 0;
		Scanner f;
		try {
			f = new Scanner(file);
			while(f.hasNextLine()) {
				String[] linea = f.nextLine().split(",");
				if(linea[5].equalsIgnoreCase("male"))	num++;
			}
			f.close();
		} catch (FileNotFoundException e) {

		}
		return num;
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo calcula el número total de mujeres fallecidas en el Titanic
	 */
	public static int totalFallecidas(File file) {
		int fallecidas = 0;
		Scanner f;
		try {
			f = new Scanner(file);
			while(f.hasNextLine()) {
				String[] linea = f.nextLine().split(",");
				if(linea[5].equalsIgnoreCase("female") && linea[1].equalsIgnoreCase("0"))	fallecidas++;
			}
			f.close();
		} catch (FileNotFoundException e) {

		}
		return fallecidas;
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo calcula el número total de hombres fallecidos en el Titanic
	 */
	public static int totalFallecidos(File file) {
		int fallecidos = 0;
		Scanner f;
		try {
			f = new Scanner(file);
			while(f.hasNextLine()) {
				String[] linea = f.nextLine().split(",");
				if(linea[5].equalsIgnoreCase("male") && linea[1].equalsIgnoreCase("0"))	fallecidos++;
			}
			f.close();
		} catch (FileNotFoundException e) {

		}
		return fallecidos;
	}
	
	/*
	 * Pre: ---
	 * Post: El método main abre un fichero csv para poder consultar sus datos, 
	 * muestra un menú al usuario y llama a un método determinado según la opción escogida por este.
	 * Finalmente, muestra por pantalla el resultado.
	 * Esto se repite hasta que el usuario introduce un 0
	 */
	public static void main(String[] args) {
		File file;// = new File("./titanic.csv");
		while(true) {
			String nombre = pedirDato("Escriba la ruta para File (con nombre): ");
			try {
				file = new File(nombre);
				break;
			} catch(Exception e) {
				System.out.println("El fichero " + nombre + " no ha podido ser abierto.");
			}
		}
		int pasajeros = -1;
		int mujeres =0;
		int hombres = 0;
		int fallecidas = 0;
		int fallecidos = 0;
		int opcion = -1;
		
		while(opcion !=0) {
			opcion = mostrarMenu("Bienvenidos a la biblioteca del Titanic! Datos que se pueden consultar: \n"
					+ "1. Numero total de pasajeros del Titanic\n"
					+ "2. Numero total de mujeres del Titanic\n"
					+ "3. Numero total de hombres del Titanic\n"
					+ "4. Numero total de mujeres fallecidas y su porcentaje \n" 
					+ "5. Numero total de hombres fallecidos y su porcentaje \n"
					+ "0. Salir");
			switch(opcion) {
				case 1:
					pasajeros = totalPasajeros(file);
					System.out.println("El numero de pasajeros en el Titanic era de: " + pasajeros);
					break;
				case 2:
					mujeres = totalMujeres(file);
					System.out.println("El numero de mujeres en el Titanic era de: " + mujeres);
					break;
				case 3: 
					hombres = totalHombres(file);
					System.out.println("El numero de hombres en el Titanic era de: " + hombres);
					break;
				case 4: 
					mujeres = totalMujeres(file);
					fallecidas = totalFallecidas(file);
					System.out.println("El numero de mujeres fallecidas en el Titanic fue: " + fallecidas + 
							" Representando un " + (100*fallecidas/mujeres) + "% del total");
					break;
				case 5:
					hombres = totalHombres(file);
					fallecidos = totalFallecidos(file);
					System.out.println("El numero de hombres fallecidos en el Titanic fue: " + fallecidos + 
							" Representando un " + (100*fallecidos/hombres) + "% del total");
					break;
				default:
					break;
			}
		}
		
		
		//file.close();
	}
}
