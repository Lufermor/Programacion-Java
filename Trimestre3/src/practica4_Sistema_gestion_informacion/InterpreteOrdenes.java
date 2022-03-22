package practica4_Sistema_gestion_informacion;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class InterpreteOrdenes {
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
	 * Post: Extrae los datos almacenados en un fichero binario de matrículas de alumnos
	 * Luego creando un objeto de clase Matricula, lo añade a un arrayList de matrículas
	 * En el caso de que no haya ningún fichero accesible con ese nombre, 
	 * informa con un mensaje de la circunstancia.
	 */
	private static void leerMatriculas(String nombre, ArrayList<Matricula> matriculas) {
		try {
			/*
			 * Se crea un objeto [DataInputStream] al que se asocia un fichero denominado
			 * [matriculas].
			 */
			DataInputStream f = new DataInputStream(new FileInputStream(nombre));
			try {
//				System.out.println("\n\nMatriculas introducidas:\n"
//						+ "NIP Alumno  Codigo Asignatura");
//				System.out.println("==========  =================");
				while(true) {
					/*
					 * Se esriben por pantalla los datos de una de las ventas, tras
					 * haberlos leídos del fichero asociado a [f].
					 */
					int nipAlumno = f.readInt();
					int codAsign = f.readInt();
					matriculas.add(new Matricula(nipAlumno, codAsign));
					System.out.printf("%10d%17d%n", 
							matriculas.get(matriculas.size()-1).getNipAlumno(),
							matriculas.get(matriculas.size()-1).getCodAsignatura());
				}
				
			} catch(EOFException e) {}
			/*
			 * Se libera el fichero asociado al objeto [f]
			 */
			//System.out.println("\nEl total de asignaturas registradas es: " + matriculas.size());
			f.close();
		} catch(FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto");
		} catch (IOException e) {
			System.out.println("Error en operación de E/S con el fichero " + nombre);
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Extrae los datos almacenados en un fichero txt de asignaturas, 
	 * Luego creando un objeto de clase Asignatura, lo añade a un arrayList de asignaturas
	 * En el caso de que no haya ningún fichero accesible con ese nombre, 
	 * informa con un mensaje de la circunstancia.
	 */
	public static void leerAsignaturas(String nombre, ArrayList<Asignatura> asignaturas) {
		File file = new File(nombre);
		Scanner f;
		try {
			f = new Scanner(file);
			while(f.hasNextLine()) {
				String linea = f.nextLine();
				if(linea.equals("")) continue;
				String[] lineaSep = linea.split(" ");
//				if(!esEntero(lineaSep[0])) continue;
				int codigo = Integer.parseInt(lineaSep[0]);
				double creditos = Double.parseDouble(lineaSep[1]);
				int cuatrimestre = Integer.parseInt(lineaSep[2]);
				String tipologia = lineaSep[3];
				String denominacion = lineaSep[4];
				for(int i = 5; i < lineaSep.length;i++) denominacion += " " + lineaSep[i];
				asignaturas.add(new Asignatura(codigo, creditos, cuatrimestre, tipologia, denominacion));
			}
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto");
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Extrae los datos almacenados en un fichero csv de alumnos, 
	 * Luego creando un objeto de clase Alumno, lo añade a un arrayList de alumnos
	 * En el caso de que no haya ningún fichero accesible con ese nombre, 
	 * informa con un mensaje de la circunstancia.
	 */
	public static void leerAlumnos(String ruta, ArrayList<Alumno> alumnos) {
		File file = new File(ruta);
		Scanner f;
		try {
			f = new Scanner(file);
			f.nextLine();
			while(f.hasNextLine()) {
				String linea = f.nextLine();
				if(linea.equals("")) continue;
				String[] lineaSep = linea.split(";");
				int nip = Integer.parseInt(lineaSep[0]);
				String apellidos = lineaSep[1];
				String nombre = lineaSep[2];
				alumnos.add(new Alumno(nip, apellidos, nombre));
			}
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + ruta + " no ha podido ser abierto");
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este método recibe un arrayList de matrículas, uno de asignaturas,
	 * un nip de alumno (int) y una letra o ninguna (A | C | "")
	 * compara el nip con los almacenados en los objetos de matriculas, y luego
	 * obtiene los registros respectivos de asignaturas. 
	 * Imprime por pantalla las asignaturas del alumno con Nip = nip ordenadas según
	 * nombre o código en función de la letra proporcionada.
	 */
	private static void asignaturasNip(ArrayList<Matricula> matriculas, 
									ArrayList<Asignatura> asignaturas, int nip, String letra) {
		ArrayList<Asignatura> materias = new ArrayList<Asignatura>();
		for(Matricula m:matriculas) {
			if(m.getNipAlumno() == nip) {
				for(Asignatura a:asignaturas) {
					if(a.getCodigo() == m.getCodAsignatura()) {materias.add(a); break;}
				}
			}
		}
		if(letra.equalsIgnoreCase("a")) {
			materias.sort(Comparator.comparing(Asignatura::getDenominacion));
		}else {
			materias.sort(Comparator.comparing(Asignatura::getCodigo));
		}
		System.out.println("Asignaturas en las que se encuentra matriculado el alumno"
				+ "con nip = " + nip + ": \n");
		System.out.printf("%10s%10s%15s%11s%40s%n", "Codigo", "Creditos", 
							"Cuatrimestre", "Tipologia", "Denominacion");
		System.out.printf("%10s%10s%15s%11s%40s%n", "======", "========", 
				"============", "=========", "======================================");
		for(Asignatura a:materias) {
			System.out.printf("%10s%10s%15s%11s%40s%n", a.getCodigo(), a.getCreditos(), 
								a.getCuatrimestre(), a.getTipologia(), a.getDenominacion());
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este método recibe un arrayList de alumnos, uno de matrículas,
	 * un codigo de asignatura (int) y una letra o ninguna (A | N | "")
	 * compara el codigo con los almacenados en los objetos de matriculas, y luego
	 * con el nip correspondiente, obtiene los registros respectivos de alumnos. 
	 * Imprime por pantalla los alumnos matriculados en la asinatura con codigo = codigo 
	 * ordenados según nombre o nip en función de la letra proporcionada.
	 */
	private static void alumnosCodigo(ArrayList<Matricula> matriculas,
								ArrayList<Alumno> alumnos, int codigo, String letra) {
		ArrayList<Alumno> clase = new ArrayList<Alumno>();
		for(Matricula m:matriculas) {
			if(m.getCodAsignatura() == codigo) {
				for(Alumno a:alumnos) {
					if(a.getNip() == m.getNipAlumno()) {clase.add(a); break;}
				}
			}
		}
		if(letra.equalsIgnoreCase("a")) {
//			clase.sort(Comparator.comparing(Alumno::getNombre));
			clase.sort(Comparator.comparing(Alumno::getApellidos));
		}else {
			clase.sort(Comparator.comparing(Alumno::getNip));
		}
		System.out.println("Alumnos matriculados en la asignatura codigo " + codigo + ": \n");
		System.out.printf("%10s%20s%15s%n", "NIP", "Apellidos", "Nombre");
		System.out.printf("%10s%20s%15s%n", "======", "=================", "=============");
		for(Alumno a:clase) {
			System.out.printf("%10s%20s%15s%n", a.getNip(), a.getApellidos(), a.getNombre());
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo recibe un arrayList de matriculas, un nip y una  de codigos.
	 * Elimina del fichero todas las matriculas que se corresponden con el nip y los codigos 
	 * pasados en la lista. Si no se especifica ningún código en la lista, borra todas 
	 * las matrículas donde el nip se corresponda con el pasado por la matrícula.
	 */
	private static void eliminarMatri(ArrayList<Matricula> matriculas, int nip, int[] codigos) {
		if(codigos.length>0) {
			for(int i = 0; i< matriculas.size(); i++) {
				if(matriculas.get(i).getNipAlumno() == nip) {
					for(int cod:codigos) {
						if(cod == matriculas.get(i).getCodAsignatura()) {
							matriculas.remove(i); 
							System.out.println("Se ha eliminado la asignatura " + cod + "Para"
									+ "el alumno " + nip);
							i--;
							break;}
					}
				}
			}
		}else {
			for(int i = 0; i< matriculas.size(); i++) {
				if(matriculas.get(i).getNipAlumno() == nip) {matriculas.remove(i); i--;}
			}
		}
		System.out.println("Se han eliminado todas las matriculas del alumno " + nip);
		for(Matricula m:matriculas) {
			System.out.printf("%10d%17d%n", m.getNipAlumno(), m.getCodAsignatura());
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo devuelve un String predefinido
	 */
	public static String elManual(){
		return "• Matrículas\r\n"
				+ "\tInforma del número total de matrículas de alumnos en diferentes asignaturas.\r\n"
				+ "• Asignaturas nip [A | C]\r\n"
				+ "\tPresenta la lista de asignaturas en las que se encuentra matriculado el alumno cuyo NIP es igual a nip.\r\n"
				+ "\tSi al final de la orden se hace constar la letra A, el listado de asignaturas es presentado en orden\r\n"
				+ "\talfabético. Si se hace constar la letra C o no se hace constar ninguna letra el listado de asignaturas es\r\n"
				+ "\tpresentado en orden de valores de código de asignatura creciente.\r\n"
				+ "\r\n"
				+ "• Alumnos código [A | N]\r\n"
				+ "\tPresenta la lista de alumnos matriculados en la asignatura cuyo código es igual al código. Si al final de\r\n"
				+ "\tla orden se hace constar la letra A el listado de alumnos es presentado en orden alfabético. Si al final\r\n"
				+ "\tde la orden se hace constar la letra N o no se hace constar ninguna orden, el listado de asignaturas es\r\n"
				+ "\tpresentado en orden de valores de NIP crecientes.\r\n"
				+ "\r\n"
				+ "• Eliminar nip { código}\r\n"
				+ "\tEn el caso de que la lista de códigos no esté vacía, entonces elimina del fichero de matrículas las\r\n"
				+ "\tmatrículas del alumno cuyo NIP es igual a nip en las asignaturas cuyos códigos se especifican en la\r\n"
				+ "\tlista. En el caso de que la lista de códigos esté vacía entonces elimina del fichero de matrículas todas\r\n"
				+ "\tlas asignaturas en las que estuviera matriculado el alumno cuyo NIP es igual a nip. El programa informa\r\n"
				+ "\tal operador, mediante un mensaje, que ha eliminado las asignaturas especificadas o, en su caso, que\r\n"
				+ "\tha eliminado todas las asignaturas matriculadas por el alumno.\r\n"
				+ "\r\n"
				+ "• Matricular nip código { código }\r\n"
				+ "\tEn el caso de que el NIP corresponda a un alumno de la titulación, procede a añadir la matricula de las\r\n"
				+ "\tasignaturas cuyo código figura en la lista de códigos, siempre y cuando no estuviera ya matriculado\r\n"
				+ "\ten ellas. El programa informa al operador, mediante un mensaje, que el alumno ha sido matriculado\r\n"
				+ "\ten un número determinado de asignaturas.\r\n"
				+ "\r\n"
				+ "• Fin\r\n"
				+ "\tFinaliza la ejecución del programa de gestión de asignaturas matriculadas.";
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo main
	 */
	public static void main(String[] args) {
		String fMatriculas = "D:/Documentos/GradosuperiorDAM2021/Programación/Trimestre3/Practica_4/matriculas.dat";
		String fAsignaturas = "D:/Documentos/GradosuperiorDAM2021/Programación/Trimestre3/Practica_4/asignaturas.txt";
		String fAlumnos = "D:/Documentos/GradosuperiorDAM2021/Programación/Trimestre3/Practica_4/alumnos.csv";
		ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		leerMatriculas(fMatriculas, matriculas);
		leerAsignaturas(fAsignaturas, asignaturas);
		leerAlumnos(fAlumnos, alumnos);
//		for(Matricula matri:matriculas) System.out.println(matri.toString());
//		for(Asignatura a:asignaturas) System.out.println(a.toString());
//		for(Alumno a:alumnos) System.out.println(a.toString());
		asignaturasNip(matriculas, asignaturas, 627867, "");
		alumnosCodigo(matriculas, alumnos, 30201, "a");
		eliminarMatri(matriculas, 677090, new int[] {30201, 30203});
		eliminarMatri(matriculas, 627867, new int[] {});
	}
}
