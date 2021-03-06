package practica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class MainBizi {
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
	 * Post: Este metodo muestra un menu al jugador, le pide que escoja una opcion y
	 * comprueba que el dato introducido sea un n?mero entero.
	 */
	private static int mostrarMenu(Scanner entrada) {
		System.out.println("\nBienvenido al archivo de registros de Bici, seleccione una opcion:\n"
				+ "1. Contar usos\n"
				+ "2. Usos por usuario\n"
				+ "0. Salir");
		String opcion = entrada.nextLine();
		if(esEntero(opcion)) return Integer.parseInt(opcion);
		else return -1;
	}
	
	/*
	 * Pre: ---
	 * Post: Este m?todo crea un objeto tipo File del que se leer? la informaci?n
	 * y luego copia las 10 primeras l?neas del file en un nuevo fichero
	 */
	public static void copiar10() {
		String fichero = "D:/Documentos/GradosuperiorDAM2021/Programaci?n/Practica3Trimestre2_BiZi/usos-16.csv";
		String newFile = "D:/Documentos/GradosuperiorDAM2021/Programaci?n/Practica3Trimestre2_BiZi/pruebas-10.csv";
		//String fichero = "usos-16.csv";
		//String newFile = "pruebas-10.csv";
		File file = new File(fichero);
		try {
			Formatter salida = new Formatter(newFile);
			try {
				Scanner f = new Scanner(file);
				for(int i = 0; i<10; i++) salida.format(f.nextLine() + "\n");
				//Se libera el fichero que estamos leyendo:
				f.close();
			} catch (FileNotFoundException e) {
				System.out.println("El fichero " + fichero + " no ha podido ser le?do.");
			}
			System.out.println("Fichero \"pruebas-10.csv\" generado correctamente");
			salida.close();
		} catch (FileNotFoundException e1) {
			System.out.println("El fichero " + newFile + " no ha podido ser creado.");
		}	
	}
	
	/*
	 * Pre: ---
	 * Post: Este m?todo crea un objeto tipo File del que se leer? la informaci?n
	 * y luego copia las 2000 primeras l?neas del file en un nuevo fichero
	 */
	public static void copiar2000() {
		String fichero = "D:/Documentos/GradosuperiorDAM2021/Programaci?n/Practica3Trimestre2_BiZi/usos-17.csv";
		String newFile = "D:/Documentos/GradosuperiorDAM2021/Programaci?n/Practica3Trimestre2_BiZi/pruebas-2000.csv";
		//String fichero = "usos-17.csv";
		//String newFile = "pruebas-2000.csv";
		File file = new File(fichero);
		try {
			Formatter salida = new Formatter(newFile);
			try {
				Scanner f = new Scanner(file);
				for(int i = 0; i<2000; i++) salida.format(f.nextLine() + "\n");
				//Se libera el fichero que estamos leyendo:
				f.close();
			} catch (FileNotFoundException e) {
				System.out.println("El fichero " + fichero + " no ha podido ser le?do.");
			}
			System.out.println("Fichero \"pruebas-2000.csv\" generado correctamente");
			salida.close();
		} catch (FileNotFoundException e1) {
			System.out.println("El fichero " + newFile + " no ha podido ser creado.");
		}	
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo lee un fichero, parsea sus datos y 
	 * luego muestra por pantalla los usos totales, los circulares y los traslados
	 */
	public static void contarUsos(Scanner entrada) {
		System.out.println("Escriba el nombre de un fichero de usos del sistema Bizi: ");
		String fichero = entrada.nextLine();
		File file = new File(fichero);
		int totalUsos = 0;
		int traslados = 0;
		int circulares = 0;
		try {
			Scanner f = new Scanner(file);
			f.nextLine();
			while(f.hasNextLine()) {
				String linea = f.nextLine();
				totalUsos++;
				String[] lineaSep = linea.split(";");
				if(!lineaSep[2].equalsIgnoreCase(lineaSep[4])) traslados++;
				else circulares++;
			}
			f.close(); //Se libera el fichero que estamos leyendo
			System.out.println(	
					String.format("%-40s", "Numero total de usos como traslado: ") +
							String.format("%9s",traslados + "\n") + 
					String.format("%-40s", "Numero total de usos circulares: ") + 
							String.format("%9s",circulares + "\n") +  
					String.format("%-40s", "Numero total de usos: ") + 
							String.format("%8s",totalUsos + ""));
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + fichero + " no ha podido ser le?do.");
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo comprueba si el usuario pasado como par?metro est? en el arrayList
	 * si lo est?, suma los datos del nuevo usuario a los atributos, sino, a?ade el usuario al arrayList
	 */
	public static void addRegistro(ArrayList<UsuarioBizi> usuarios, UsuarioBizi user) {
		boolean nuevo = true;
		for(UsuarioBizi us: usuarios) {
			if(us.getIDUsuario() == user.getIDUsuario()) {
				us.sumarUsos(user.getTraslados(), user.getCirculares());
				nuevo = false;
				break;
			}
		}
		if(nuevo) usuarios.add(user);
	}
	
	/*
	 * Pre: ---
	 * Post: Este m?todo muestra por pantalla los 15 primeros elementos de un arrayList de usuarios,
	 * en caso de que el arrayList tenga menos de 15 elementos, muestra los que hay.
	 */
	public static void imprimirUsos(ArrayList<UsuarioBizi> usuarios) {
		int regs = 15;
		if(usuarios.size()<15) regs = usuarios.size();
		System.out.println("   Usuario Traslados  Circular     Total\n"
						+  " ========= ========= ========= =========");
		for(int i = 0; i<regs; i++) {
			System.out.println(	
					String.format("%10s", usuarios.get(i).getIDUsuario()) +
					String.format("%10s", usuarios.get(i).getTraslados()) +
					String.format("%10s", usuarios.get(i).getCirculares()) +
					String.format("%10s", usuarios.get(i).getUsosTotales()));
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo lee un fichero, parsea sus datos, los almacena en un arrayList, y
	 * luego muestra por pantalla los usos totales, los circulares y los traslados
	 * de los 15 usuarios m?s activos.
	 */
	public static void usosPorUsuario(Scanner entrada, ArrayList<UsuarioBizi> usuarios) {
		usuarios.clear();
		System.out.println("Escriba el nombre de un fichero de usos del sistema Bizi: ");
		String fichero = entrada.nextLine();
		File file = new File(fichero);
		try {
			Scanner f = new Scanner(file);
			f.nextLine();
			while(f.hasNextLine()) {
				String linea = f.nextLine();
				String[] lineaSep = linea.split(";");
				if(lineaSep[2].equalsIgnoreCase(lineaSep[4])) {
					addRegistro(usuarios, new UsuarioBizi(Integer.parseInt(lineaSep[0]), 0, 1));
				}else addRegistro(usuarios, new UsuarioBizi(Integer.parseInt(lineaSep[0]), 1, 0));
			}
			f.close(); //Se libera el fichero que estamos leyendo
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + fichero + " no ha podido ser le?do.");
		}
		/*Con la siguiente l?nea ordenamos la lista de usuarios por el valor de 
		 * su atributo usosTotales, de mayor a menor: 		*/
		usuarios.sort(Comparator.comparing(UsuarioBizi::getUsosTotales).reversed());
		System.out.println("Numero de usuarios distintos: " + usuarios.size() + "\n");
		imprimirUsos(usuarios);
	}
	
	/*
	 * Pre: ---
	 * Post: Este m?todo main llama a los m?todos copiar para crear archivos de prueba,
	 * luego muestra el men? al usuario y realiza una acci?n en base a lo que este escoja
	 */
	public static void main(String[] args) {
		copiar10();
		copiar2000();
		ArrayList<UsuarioBizi> usuarios = new ArrayList<UsuarioBizi>();
		Scanner entrada = new Scanner(System.in);
		int opcion = -1;
		while(opcion!=0) {
			opcion = mostrarMenu(entrada);
			switch(opcion) {
			case 0:
				System.out.println("Programa finalizado");
				break;
			case 1:
				contarUsos(entrada);
				break;
			case 2:
				usosPorUsuario(entrada, usuarios);
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}
		}
		entrada.close();
	}
}
