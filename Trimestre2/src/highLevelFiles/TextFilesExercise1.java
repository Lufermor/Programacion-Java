package highLevelFiles;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class TextFilesExercise1 {
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
	 * Post: Este metodo recibe una cadena de caracteres y dice si es valida al no contener espacios, o no
	 */
	private static String comprobarEntrada(String nombre) {
		while(true) {
			if(nombre.contains(" ")) {
				nombre = pedirDato("El dato introducido no es válido, recuerde que no debe contener espacios\n"
						+ "Por favor introduzcalo de nuevo: ");
			}else {
				break;
			}
		}
		return nombre;
	}
	/*
	 * Pre: ---
	 * Post: Crea un fichero con la ruta especificada, 
	 *  Solicita un datos al usuario, comprueba que sean validos y los introduce en el fichero, hasta que el usuario introduce "fin"
	 */
	private static void nuevoFile(String nombre) {
		try {
			Formatter salida = new Formatter(nombre);
			String dato = "";
			while(!dato.equalsIgnoreCase("fin")) {
				dato = pedirDato("Introduzca lo que desea escribir: ");
				dato = comprobarEntrada(dato);
				if(!dato.equalsIgnoreCase("fin")) {
					if(esEntero(dato)) {
						salida.format("- Número entero introducido por el usuario: " + dato+ "\r\n");
						System.out.println("El número entero " + dato + " se ha escrito correctamente en el fichero: \r\n" +  nombre + "\n");
					}else {
						salida.format("- Cadena de caracteres introducida por el usuario: \"" + dato + "\" \r\n");
						System.out.println("La cadena de caracteres \"" + dato + "\" se ha escrito correctamente en el fichero: \r\n" +  nombre + "\n");
					}
					
				}else {
					System.out.println("¡El programa ha finalizado! ¡Hasta luego!");
				}
			}
			salida.close();
		}catch(FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser creado.");
		}
	}
	/*
	 * Pre:---
	 * Post: Muestra por pantalla un mensaje de bienvenida al usuario y le pide una ruta, 
	 * comprueba la ruta introducida y crea un fichero al cual se le introduciran datos.
	 */
	public static void main(String args[]) {
		String nombreFichero = pedirDato("¡Bienvenido al programa de escritura sobre ficheros de texto!\r\n"
				+ "Indique la ruta del fichero a escribir:\r\n"
				+ "(Escriba \"fin\" para salir)");
		nombreFichero = comprobarEntrada(nombreFichero);
		System.out.println("-------------------------------------------------------------------------------------------------\r\n");
		if(!nombreFichero.equalsIgnoreCase("fin")) {
			nuevoFile(nombreFichero);
		}else {
			System.out.println("¡El programa ha finalizado! ¡Hasta luego!");
		}
	}
}
