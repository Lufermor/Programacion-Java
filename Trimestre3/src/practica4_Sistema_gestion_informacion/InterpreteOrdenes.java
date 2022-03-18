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
	 * Post: Extrae los datos almacenados en un fichero binario de matr�culas de alumnos
	 * Luego creando un objeto de clase Matricula, lo a�ade a un arrayList de matr�culas
	 * En el caso de que no haya ning�n fichero accesible con ese nombre, 
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
					 * haberlos le�dos del fichero asociado a [f].
					 */
					int nipAlumno = f.readInt();
					int codAsign = f.readInt();
					matriculas.add(new Matricula(nipAlumno, codAsign));
//					System.out.printf("%10d%17d%n", 
//							matriculas.get(matriculas.size()-1).getNipAlumno(),
//							matriculas.get(matriculas.size()-1).getCodAsignatura());
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
			System.out.println("Error en operaci�n de E/S con el fichero " + nombre);
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Extrae los datos almacenados en un fichero txt de asignaturas, 
	 * Luego creando un objeto de clase Asignatura, lo a�ade a un arrayList de asignaturas
	 * En el caso de que no haya ning�n fichero accesible con ese nombre, 
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
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Extrae los datos almacenados en un fichero txt de asignaturas, 
	 * Luego creando un objeto de clase Asignatura, lo a�ade a un arrayList de asignaturas
	 * En el caso de que no haya ning�n fichero accesible con ese nombre, 
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
				String nip = lineaSep[0];
				String apellidos = lineaSep[1];
				String nombre = lineaSep[2];
				alumnos.add(new Alumno(nip, apellidos, nombre));
			}
			f.close();
		} catch (FileNotFoundException e) {
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este m�todo recibe un arrayList de matr�culas, uno de asignaturas,
	 * un nip de alumno (int) y una letra o ninguna (A | C | "")
	 * compara el nip con los almacenados en los objetos de matriculas, y luego
	 * obtiene los registros respectivos de asignaturas. 
	 * Imprime por pantalla las asignaturas del alumno con Nip = nip ordenadas seg�n
	 * nombre o c�digo en funci�n de la letra proporcionada.
	 */
	private static void asignaturasNip(ArrayList<Matricula> matriculas, 
									ArrayList<Asignatura> asignaturas, int nip, String letra) {
		ArrayList<Asignatura> materias = new ArrayList<Asignatura>();
//		System.out.println("Las asignaturas en las que se ");
		for(Matricula m:matriculas) {
			if(m.getNipAlumno() == nip) {
				System.out.println(m.toString());
				for(Asignatura a:asignaturas) {
					if(a.getCodigo() == m.getCodAsignatura()) materias.add(a);
					break;
				}
			}
		}
		if(letra.equalsIgnoreCase("a")) {
			materias.sort(Comparator.comparing(Asignatura::getDenominacion));
		}else {
			materias.sort(Comparator.comparing(Asignatura::getCodigo));
		}
		for(Asignatura a:materias) System.out.println(a.toString());
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo devuelve un String predefinido
	 */
	public static String elManual(){
		return "� Matr�culas\r\n"
				+ "\tInforma del n�mero total de matr�culas de alumnos en diferentes asignaturas.\r\n"
				+ "� Asignaturas nip [A | C]\r\n"
				+ "\tPresenta la lista de asignaturas en las que se encuentra matriculado el alumno cuyo NIP es igual a nip.\r\n"
				+ "\tSi al final de la orden se hace constar la letra A, el listado de asignaturas es presentado en orden\r\n"
				+ "\talfab�tico. Si se hace constar la letra C o no se hace constar ninguna letra el listado de asignaturas es\r\n"
				+ "\tpresentado en orden de valores de c�digo de asignatura creciente.\r\n"
				+ "\r\n"
				+ "� Alumnos c�digo [A | N]\r\n"
				+ "\tPresenta la lista de alumnos matriculados en la asignatura cuyo c�digo es igual al c�digo. Si al final de\r\n"
				+ "\tla orden se hace constar la letra A el listado de alumnos es presentado en orden alfab�tico. Si al final\r\n"
				+ "\tde la orden se hace constar la letra N o no se hace constar ninguna orden, el listado de asignaturas es\r\n"
				+ "\tpresentado en orden de valores de NIP crecientes.\r\n"
				+ "\r\n"
				+ "� Eliminar nip { c�digo}\r\n"
				+ "\tEn el caso de que la lista de c�digos no est� vac�a, entonces elimina del fichero de matr�culas las\r\n"
				+ "\tmatr�culas del alumno cuyo NIP es igual a nip en las asignaturas cuyos c�digos se especifican en la\r\n"
				+ "\tlista. En el caso de que la lista de c�digos est� vac�a entonces elimina del fichero de matr�culas todas\r\n"
				+ "\tlas asignaturas en las que estuviera matriculado el alumno cuyo NIP es igual a nip. El programa informa\r\n"
				+ "\tal operador, mediante un mensaje, que ha eliminado las asignaturas especificadas o, en su caso, que\r\n"
				+ "\tha eliminado todas las asignaturas matriculadas por el alumno.\r\n"
				+ "\r\n"
				+ "� Matricular nip c�digo { c�digo }\r\n"
				+ "\tEn el caso de que el NIP corresponda a un alumno de la titulaci�n, procede a a�adir la matcula de las\r\n"
				+ "\tasignaturas cuyo c�digo figura en la lista de c�digos, siempre y cuando no estuviera ya matriculado\r\n"
				+ "\ten ellas. El programa informa al operador, mediante un mensaje, que el alumno ha sido matriculado\r\n"
				+ "\ten un n�mero determinado de asignaturas.\r\n"
				+ "\r\n"
				+ "� Fin\r\n"
				+ "\tFinaliza la ejecuci�n del programa de gesti�n de asignaturas matriculadas.";
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo main
	 */
	public static void main(String[] args) {
		String fMatriculas = "D:/Documentos/GradosuperiorDAM2021/Programaci�n/Trimestre3/Practica_4/matriculas.dat";
		String fAsignaturas = "D:/Documentos/GradosuperiorDAM2021/Programaci�n/Trimestre3/Practica_4/asignaturas.txt";
		String fAlumnos = "D:/Documentos/GradosuperiorDAM2021/Programaci�n/Trimestre3/Practica_4/alumnos.csv";
		ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		leerMatriculas(fMatriculas, matriculas);
		leerAsignaturas(fAsignaturas, asignaturas);
		leerAlumnos(fAlumnos, alumnos);
//		for(Matricula matri:matriculas) System.out.println(matri.toString());
//		for(Asignatura a:asignaturas) System.out.println(a.toString());
//		for(Alumno a:alumnos) System.out.println(a.toString());
		asignaturasNip(matriculas, asignaturas, 627867, "a");
	}
}
