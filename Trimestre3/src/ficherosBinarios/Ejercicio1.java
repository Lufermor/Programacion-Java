package ficherosBinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
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
	 * Post: Este comprueba si una cadena dada es un double
	 */
	private static boolean esDouble(String cadena){
		try {
			Double.parseDouble(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo solicita al usuario datos de un alumno, 
	 * y los introduce en un objeto de clase Alumno que se añade a un arrayList de Alumnos. 
	 */
	protected static void pedirDatos(Scanner entrada, ArrayList<Alumno> alumnos) {
		int cursadas = 0;
		int aprobadas = 0;
		int suspendidas = 0;
		double precio = 0;
		while(true) {
			System.out.println("Nuevo alumno: ");
			System.out.println("Numero de asignaturas cursadas:");
			String cadena = entrada.nextLine();
			if(esEntero(cadena)) {
				cursadas = Integer.parseInt(cadena);
				if(cursadas<0) {
					System.out.println("El dato no es correcto, intentelo de nuevo"); 
					cursadas = 0;
					continue;
				}
			}else {
				System.out.println("El dato no es correcto, intentelo de nuevo"); 
				continue;
			}
			System.out.println("Numero de asignaturas aprobadas:");
			cadena = entrada.nextLine();
			if(esEntero(cadena)) {
				aprobadas = Integer.parseInt(cadena);
				if(aprobadas<0) {
					System.out.println("El dato no es correcto, intentelo de nuevo"); 
					aprobadas = 0;
					continue;
				}
			}else {
				System.out.println("El dato no es correcto, intentelo de nuevo"); 
				continue;
			}
			System.out.println("Numero de asignaturas suspendidas:");
			cadena = entrada.nextLine();
			if(esEntero(cadena)) {
				suspendidas = Integer.parseInt(cadena);
				if(suspendidas<0) {
					System.out.println("El dato no es correcto, intentelo de nuevo"); 
					suspendidas = 0;
					continue;
				}
			}else {
				System.out.println("El dato no es correcto, intentelo de nuevo"); 
				continue;
			}
			if(cursadas != aprobadas + suspendidas) {
				System.out.println("Los datos introducidos no concuerdan, intentelo de nuevo");
				continue;
			}
			System.out.println("Precio de la matricula:");
			cadena = entrada.nextLine();
			if(esDouble(cadena)) {
				precio = Double.parseDouble(cadena);
				if(precio<0) {
					System.out.println("El dato no es correcto, intentelo de nuevo"); 
					precio = 0;
					continue;
				}
			}else {
				System.out.println("El dato no es correcto, intentelo de nuevo"); 
				continue;
			}
			alumnos.add(new Alumno(cursadas, aprobadas, suspendidas, precio));
			while(true) {
				System.out.println("Desea introducir datos de otro alumno? s/n:");
				cadena = entrada.nextLine();
				if(cadena.equalsIgnoreCase("n")) break;
				else if(cadena.equalsIgnoreCase("s")) break;
				else System.out.println("No le he entendido");
			}
			if(cadena.equalsIgnoreCase("n")) break;
		}
	}
	
	/**
	 * Pre: El objeto [f] está asociado a un fichero en modo escritura de datos
	 * Post: Escribe, al final del fichero asociado a [f], los datos [cursadas],
	 * 		[aprobadas], [suspendidas] y [precio] todo ellos codificados en binario.
	 */
	private static void escribir(DataOutputStream f, Alumno a) {
		try {
			f.writeInt(a.getCursadas());
			f.writeInt(a.getAprobadas());
			f.writeInt(a.getSuspendidas());
			f.writeDouble(a.getPrecio());
		} catch (IOException e) {
			System.out.println("Error al escribir en el fichero");
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Crea un fichero de con datos de alumnos denominado [Matriculados] y almacena en él los
	 * 		datos de las matrículas de los alumnos. Cada registro está caracterizado
	 * 		por la cuadrápula de valores (cursadas, aprobadas, suspendidas, precio).
	 */
	private static void crearFichero(String nombre,ArrayList<Alumno> alumnos) {
		try {
			/*
			 * Se crea un objbeto [DataOutputStream] al que se asocia un fichero
			 * denominado [nombre].
			 */
			DataOutputStream f = new DataOutputStream(new FileOutputStream(nombre));
			/*
			 * Se escriben los datos de cada uno de los alumnos en el fichero [f]
			 */
			for(int i = 0; i < alumnos.size(); i++) {
				escribir(f, alumnos.get(i));
			}
			//Se libera el fichero asociado al objeto [f]
			f.close();
		} catch(FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto");
		} catch (IOException e) {
			System.out.println("Error en operación de E/S con el fichero " + nombre);
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Presenta por pantalla los datos almacenados en un fichero de alumnos
	 * 		denominado [Matriculados]. En el caso de que no haya ningún fichero accesible con
	 * 		ese nombre informa con un mensaje de la circunstancia.
	 */
	private static void leerFichero(String nombre) {
		try {
			/*
			 * Se crea un objeto [DataInputStream] al que se asocia un fichero denominado
			 * [Matriculados].
			 */
			DataInputStream f = new DataInputStream(new FileInputStream(nombre));
			double sumaAprobadas = 0;
			double sumaPrecios = 0;
			int registros = 0;
			try {
				/*
				 * Se escriben por pantalla las dos líneas que encabezan la tabla de ventas
				 */
				System.out.println("\n\nAlumnos introducidos:\n"
						+ "CURSADAS  APROBADAS  SUSPENDIDAS  PRECIO");
				System.out.println("========  =========  ===========  ======");
				while(true) {
					/*
					 * Se esriben por pantalla los datos de una de las ventas, tras
					 * haberlos leídos del fichero asociado a [f].
					 */
					int cursadas = f.readInt();
					int aprobadas = f.readInt();
					int suspendidas = f.readInt();
					double precio = f.readDouble();
					sumaAprobadas += aprobadas;
					sumaPrecios += precio;
					registros++;
					System.out.printf("%8d%11d%13d%8.2f%n", cursadas, aprobadas, suspendidas, precio);
				}
				
			} catch(EOFException e) {}
			/*
			 * Se libera el fichero asociado al objeto [f]
			 */
			System.out.println("\nLa media de asignaturas aprobadas por alumno es: " + sumaAprobadas/registros);
			System.out.println("La media del precio de las matriculas es: " + sumaPrecios/registros);
			f.close();
		} catch(FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto");
		} catch (IOException e) {
			System.out.println("Error en operación de E/S con el fichero " + nombre);
		}
	}
	
	/**
	 * Pre: ---
	 * Post: ejecuta el programa de prueba de escitura y lectura de un fichero binario
	 * 		que almacena ventas.
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String fichero = "D:/Documentos/GradosuperiorDAM2021/Programación/Trimestre3/Matriculados.dat";
		System.out.println("Vamos a crear un fichero de datos binarios con informacion de "
				+ "matriculas de alumnos\n");
		//System.out.println("Introduzca la direccion del fichero a crear: ");
		//String fichero = entrada.nextLine();
		System.out.println("Vamos a ingresar datos de alumnos en el fichero");
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		pedirDatos(entrada, alumnos);
		crearFichero(fichero, alumnos);
		leerFichero(fichero);
		entrada.close();
	}
}
