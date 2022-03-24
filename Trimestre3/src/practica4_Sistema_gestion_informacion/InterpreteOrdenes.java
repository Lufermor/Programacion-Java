package practica4_Sistema_gestion_informacion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	 * Pre: [nombre] se corresponde con una ruta completa de un fichero binario válido
	 * Post: Extrae los datos almacenados en un fichero binario de matrículas de alumnos
	 * Luego creando un objeto de clase Matricula, lo añade a un arrayList de matrículas
	 * En el caso de que no haya ningún fichero accesible con ese nombre, 
	 * informa con un mensaje de la circunstancia.
	 */
	private static void leerMatriculas(String nombre, ArrayList<Matricula> matriculas) {
		try {
			// Se crea un objeto [DataInputStream] al que se asocia un fichero denominado [matriculas].
			DataInputStream f = new DataInputStream(new FileInputStream(nombre));
			try {
				while(true) {
					/*
					 * Se esriben por pantalla los datos de una de las ventas, tras
					 * haberlos leídos del fichero asociado a [f].
					 */
					int nipAlumno = f.readInt();
					int codAsign = f.readInt();
					matriculas.add(new Matricula(nipAlumno, codAsign));
				}
				
			} catch(EOFException e) {}
			// Se libera el fichero asociado al objeto [f]
			f.close();
		} catch(FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto");
		} catch (IOException e) {
			System.out.println("Error en operación de E/S con el fichero " + nombre);
		}
	}
	
	/*
	 * Pre: [nombre] se corresponde con una ruta completa de un fichero txt válido
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
			while(f.hasNextLine()) { //leemos el fichero línea a línea
				String linea = f.nextLine();
				if(linea.equals("")) continue;//Nos saltamos las filas vacías
				String[] lineaSep = linea.split(" ");
				int codigo = Integer.parseInt(lineaSep[0]);
				double creditos = Double.parseDouble(lineaSep[1]);
				int cuatrimestre = Integer.parseInt(lineaSep[2]);
				String tipologia = lineaSep[3];
				String denominacion = lineaSep[4];
				//Construimos [denominacion] ya que puede haber quedado separada en varias celdas:
				for(int i = 5; i < lineaSep.length;i++) denominacion += " " + lineaSep[i];
				asignaturas.add(new Asignatura(codigo, creditos, cuatrimestre, tipologia, denominacion));
			}
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto");
		}
	}
	
	/*
	 * Pre: [nombre] se corresponde con una ruta completa de un fichero csv válido
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
			while(f.hasNextLine()) { //leemos el fichero línea a línea
				String linea = f.nextLine();
				if(linea.equals("")) continue; //Nos saltamos las filas vacías
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
		//ArrayList donde guardaremos las asignaturas del alumno:
		ArrayList<Asignatura> materias = new ArrayList<Asignatura>(); 
		for(Matricula m:matriculas) {
			if(m.getNipAlumno() == nip) {
				for(Asignatura a:asignaturas) {
					if(a.getCodigo() == m.getCodAsignatura()) {materias.add(a); break;}
				}
			}
		}
		if(letra.equalsIgnoreCase("a")) { //ordenamos en orden ascendente por el atributo [denominacion]:
			materias.sort(Comparator.comparing(Asignatura::getDenominacion));
		}else {				//ordenamos en orden ascendente por el atributo [codigo]:
			materias.sort(Comparator.comparing(Asignatura::getCodigo));
		}
		if(materias.size()==0) System.out.println("El alumno con NIP = " + nip 
								+" no se encuentra matriculado en ninguna asignatura.");
		else {
			System.out.println("Asignaturas en las que se encuentra matriculado el alumno"
					+ "con nip = " + nip + ": \n");
			System.out.printf("%10s%10s%15s%11s%40s%n", "Codigo", "Creditos", 
								"Cuatrimestre", "Tipologia", "Denominacion");
			System.out.printf("%10s%10s%15s%11s%40s%n", "======", "========", 
					"============", "=========", "======================================");
			for(Asignatura a:materias) { //Imprimimos las asignaturas con formato
				System.out.printf("%10s%10s%15s%11s%40s%n", a.getCodigo(), a.getCreditos(), 
									a.getCuatrimestre(), a.getTipologia(), a.getDenominacion());
			}
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
		//ArrayList donde guardaremos los alumnos de la asignatura:
		ArrayList<Alumno> clase = new ArrayList<Alumno>();
		for(Matricula m:matriculas) {
			if(m.getCodAsignatura() == codigo) {
				for(Alumno a:alumnos) {
					if(a.getNip() == m.getNipAlumno()) {clase.add(a); break;}
				}
			}
		}
		if(letra.equalsIgnoreCase("a")) {
			clase.sort(Comparator.comparing(Alumno::getApellidos));
		}else {
			clase.sort(Comparator.comparing(Alumno::getNip));
		}
		if(clase.size() == 0) System.out.println("No hay ningun alumno matriculado en esta asignatura");
		else {
			System.out.println("Alumnos matriculados en la asignatura codigo " + codigo + ": \n");
			System.out.printf("%10s%20s%15s%n", "NIP", "Apellidos", "Nombre");
			System.out.printf("%10s%20s%15s%n", "======", "=================", "=============");
			for(Alumno a:clase) { //Imprimimos los alumnos con formato:
				System.out.printf("%10s%20s%15s%n", a.getNip(), a.getApellidos(), a.getNombre());
			}
		}
	}
	
	/**
	 * Pre: El objeto [f] está asociado a un fichero en modo escritura de datos
	 * Post: Escribe, al final del fichero asociado a [f], los datos [nip] y [codigo],
	 * 		 codificados en binario.
	 */
	private static void escribir(DataOutputStream f, int nip, int codigo) {
			try {
				f.writeInt(nip);
				f.writeInt(codigo);
			} catch (IOException e) {
				System.out.println("Error al escribir en el fichero");
			}
	}
	
	/**
	 * Pre: ---
	 * Post: Crea un fichero de matrículas denominado [nombre] y almacena en él los
	 * 		valores definidos en las matrículas de alumnos. Cada matrícula está 
	 * 		caracterizada por la tupla de valores (nipAlumno, codigoAsignatura).
	 */
	private static void crearFichero(ArrayList<Matricula> matriculas, String nombre) {
		try {
			/* Se crea un objbeto [DataOutputStream] al que se asocia un fichero
			 * denominado [nombre].
			 */
			DataOutputStream f = new DataOutputStream(new FileOutputStream(nombre));
			//Se escriben los datos de cada una de las matrículas en el fichero [f]
			for(Matricula m: matriculas) {
				escribir(f, m.getNipAlumno(), m.getCodAsignatura());
			}
			//Se libera el fichero asociado al objeto [f]
			f.close();
		} catch(FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto");
		} catch (IOException e) {
			System.out.println("Error en operación de E/S con el fichero " + nombre);
		}
	}
	
	/*
	 * Pre: las tablas recibidas deben tener la misma longitud
	 * Post: recibe una tabla de enteros y una de Strings, si es posible convierte los string
	 * a enteros, los guarda en la tabla de enteros y devuelve [true]
	 */
	private static boolean tablaCorrecta(int[] codes, String[] codigos) {
		boolean esCorrecta = true;
		for(int i = 0; i<codigos.length; i++) {
			if(esEntero(codigos[i])) codes[i] = Integer.parseInt(codigos[i].trim());
			else {
				esCorrecta = false;
				System.out.println("Los datos en la tabla "
						+ "pasada como parametro no son correctos");
				break;
			}
		}
		return esCorrecta;
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo recibe un arrayList de matriculas, un nip y una  tabla de codigos.
	 * Elimina del fichero todas las matriculas que se corresponden con el nip y los codigos 
	 * pasados en la lista. Si no se especifica ningún código en la lista, borra todas 
	 * las matrículas donde el nip se corresponda con el pasado por la matrícula.
	 */
	private static void eliminarMatri(ArrayList<Matricula> matriculas, int nip, int[] codigos, String ruta) {
		String eliminadas = "";
		if(codigos.length>0) { //Comprobamos que la tabla no esté vacía
			for(int i = 0; i< matriculas.size(); i++) {
				if(matriculas.get(i).getNipAlumno() == nip) {
					for(int cod:codigos) {
						if(cod == matriculas.get(i).getCodAsignatura()) {
							eliminadas += matriculas.get(i).getCodAsignatura();
							matriculas.remove(i); //Eliminaos la matricula
							System.out.println("Se ha eliminado la asignatura " + cod + " para "
									+ "el alumno " + nip);
							i--;
							break;
						}
					}
				}
			}
		}else {
			for(int i = 0; i< matriculas.size(); i++) {
				if(matriculas.get(i).getNipAlumno() == nip) {
					matriculas.remove(i); 
					i--;
					eliminadas += matriculas.get(i).getCodAsignatura();
					}
			}
			System.out.println("Se han eliminado todas las matriculas del alumno " + nip);
		}
		if(eliminadas.equals("")) { //Comprobamos si no se ha eliminado alguna matricula
			System.out.println("No se ha eliminado ninguna matricula del alumno " + nip);
		}else{
			crearFichero(matriculas, ruta); //Sobreescribimos el fichero de matriculas
//			for(Matricula m:matriculas) {
//				System.out.printf("%10d%17d%n", m.getNipAlumno(), m.getCodAsignatura());
//			}
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo recibe un arrayList de matrículas, uno de asignaturas y uno de alumnos, 
	 * un nip y una  tabla de códigos. Comprueba si el nip se corresponde con el de un alumno
	 * matriculado, en cuyo caso, comprueba los códigos que se le pasan en la tabla y verifica
	 * si el alumno ya está matriculado en esas asignaturas, de no ser así, añade una nueva
	 * matrícula al arrayList de matrículas con el nip y el código correspondiente.
	 * Finalmente informa al usuario en qué asingaturas se ha matriculado al alumno.
	 */
	private static String addMatricula(ArrayList<Matricula> matriculas, ArrayList<Asignatura> asignaturas,
									ArrayList<Alumno> alumnos, int nip, int[] codigos, String ruta) {
		boolean esAlumno = false;
		String newMatri = ""; //Aquí almacenaremos los códigos con los que se hagan nuevas matrículas
		String yaMatris = ""; //Aquí almacenaremos los códigos que ya estaban matriculados
		for(Alumno a: alumnos) { //Comprobamos que el nip se corresponde con un alumno de la titulación:
			if(a.getNip() == nip) {esAlumno=true; break;}
		}
		if(!esAlumno) return "El nip introducido no corresponde a ningun estudiante de la titulacion";
		for(int cod:codigos) {
			boolean yaMatriculado = false;
			//Comprobamos si el alumno ya esta matriculado en la asignatura con codigo = cod
			for(Matricula m: matriculas) {
				if(m.getNipAlumno() == nip && m.getCodAsignatura()==cod) {yaMatriculado=true;break;}
			}
			if(!yaMatriculado) {
				boolean esAsignatura = false; //variable con la que comprobaremos que cod es un codigo valido
				for(Asignatura a:asignaturas) {//Comprobamos que el código pertenece a una asignatura real:
					if(a.getCodigo() == cod) {
						matriculas.add(new Matricula(nip, cod));
						newMatri += cod + ", ";
						esAsignatura =true; 
						break;
					}
				}
				if(!esAsignatura) System.out.println("El codigo " + cod + " no se corresponde con ninguna "
						+ "asignatura de la titulacion");
			}else yaMatris += cod + ", ";
		}
		if(!yaMatris.equals("")) {
			System.out.println("Las asignaturas con codigo " + yaMatris + "Ya estaban matriculadas "
			+ "para el alumno " + nip);
		}
		if(newMatri.equals("")) {
			return "No se ha matriculado ninguna nueva asignatura para el alumno " + nip;
		}else{
			crearFichero(matriculas, ruta);//Sobreescribimos el fichero de matriculas
			return "Las asignaturas con codigo " + newMatri +"Han sido matriculadas "
			+ "para el alumno " + nip;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo devuelve un String predefinido
	 */
	public static String elManual(){
		return "• help: \r\n"
				+ "\tImprime por pantalla los comandos disponibles y sus funciones\r\n\n"
				+ "• matriculas\r\n"
				+ "\tInforma del numero total de matriculas de alumnos en diferentes asignaturas.\r\n\n"
				+ "• asignaturas nip [A | C]\r\n"
				+ "\tPresenta la lista de asignaturas en las que se encuentra matriculado el alumno\r\n"
				+ "\tcuyo nip es pasado como atributo.\r\n"
				+ "\tSi se pone como segundo atributo la letra A, el listado de asignaturas \r\n"
				+ "\tes presentado en orden alfabetico.\r\n"
				+ "\tSi se pone como segundo atributo la letra C, el listado de asignaturas es\r\n"
				+ "\tpresentado en orden de valores de codigo de asignatura creciente.\r\n\n"
				+ "• alumnos codigo [A | N]\r\n"
				+ "\tPresenta la lista de alumnos matriculados en la asignatura cuyo codigo se pasa "
				+ "como atributo.\r\n"
				+ "\tSi se pone como segundo atributo la letra A, el listado se presenta en orden\r\n"
				+ "\talfabetico de apellidos de alumnos.\r\n"
				+ "\tSi se pone como segundo atributo la letra N, el listado se presenta en orden \r\n"
				+ "\tde valores de NIP crecientes.\r\n\n"
				+ "• eliminar nip {codigos}\r\n"
				+ "\tElimina del fichero de matriculas las matriculas del alumno cuyo NIP se pasa\r\n"
				+ "\tcomo parametro en las asignaturas cuyos codigos se pasan en la tabla parametro\r\n"
				+ "\tSi la tabla esta vacia, elimina todas las matriculas del alumno.\r\n"
				+ "\tLos elementos en la tabla deben estar separados unicamente por comas.\r\n\n"
				+ "• matricular nip {codigos}\r\n"
				+ "\tRealiza la matricula de las asignaturas que se pasan en la lista parametro\r\n"
				+ "\tpara el alumno con nip pasado como parametro.\r\n"
				+ "\tLos elementos en la tabla deben estar separados unicamente por comas.\r\n\n"
				+ "• fin\r\n"
				+ "\tFinaliza la ejecucion del programa.\r\n";
	}
	
	/*
	 * Pre:---
	 * Post Método que simula un prompt en el que se le piden órdenes al usuario, 
	 * comprueba que la orden está bien introducida, si es así la ejecuta.
	 * Esto se repite hasta que el usuario introduce la cadena "fin".
	 */
	private static void prompt(ArrayList<Matricula> matriculas, ArrayList<Asignatura> asignaturas, 
			ArrayList<Alumno> alumnos, String fMatriculas, Scanner entrada) {
		System.out.println("Sistema de gestion de informacion del instituto salesianos, "
				+ "para informacion introduzca el comando: \'help\'");
		String comando = "";
		while(!comando.equals("fin")) {
			System.out.print("orden>");
			comando = entrada.nextLine(); //Obtenemos el comando del usuario
			String[] com = comando.split(" ");
			switch(com[0]) {//comprobamos la primera parte del comando
				case "help":
					System.out.println(elManual());
					break;
				case "matriculas":
					if(com.length == 1) { //Comprobamos que el comando está bien escrito
						System.out.println("El numero total de matriculas de alumnos es:"
								+ matriculas.size());
					}else {
						System.out.println("Comado incorrecto");
					}
					break;
				case "asignaturas":
					if(com.length == 2 && esEntero(com[1])) {//comprobamos si el comando es valido
						asignaturasNip(matriculas, asignaturas, Integer.parseInt(com[1]), "");
					}else if(com.length == 3 && esEntero(com[1]) && 
							(com[2].equalsIgnoreCase("a")||com[2].equalsIgnoreCase("c"))) {
						asignaturasNip(matriculas, asignaturas, Integer.parseInt(com[1]), com[2]);
					}else System.out.println("Comando incorrecto");
					break;
				case "alumnos":
					if(com.length == 2 && esEntero(com[1])) {//comprobamos si el comando es valido
						alumnosCodigo(matriculas, alumnos, Integer.parseInt(com[1]), "");
					}else if(com.length == 3 && esEntero(com[1]) && 
							(com[2].equalsIgnoreCase("a")||com[2].equalsIgnoreCase("n"))) {
						alumnosCodigo(matriculas, alumnos, Integer.parseInt(com[1]), com[2]);
					}else System.out.println("Comando incorrecto");
					break;
				case "eliminar":
					if(com.length == 3 && esEntero(com[1])) {
						if(com[2].length()<2) {System.out.println("Comando incorrecto"); break;}
						//Obtenemos los códigos de la tabla introducida por el usuario:
						String[] codigos = com[2].substring(1,com[2].length()-1).split(",");
						int[] codes = new int[codigos.length];
						//Comprobamos que la tabla es viable y la copiamos en la tabla int[] codes
						if(!tablaCorrecta(codes, codigos)) break; 
						eliminarMatri(matriculas, Integer.parseInt(com[1]), codes, fMatriculas);
					}else System.out.println("Comando incorrecto");
					break;
				case "matricular":
					if(com.length == 3 && esEntero(com[1])) {
						if(com[2].length()<2) {System.out.println("Comando incorrecto"); break;} 
						//Obtenemos los códigos de la tabla introducida por el usuario:
						String[] codigos = com[2].substring(1,com[2].length()-1).split(",");
						int[] codes = new int[codigos.length];
						//Comprobamos que la tabla es viable y la copiamos en la tabla int[] codes
						if(!tablaCorrecta(codes, codigos)) break;
						System.out.println(addMatricula(matriculas, asignaturas, alumnos,
										Integer.parseInt(com[1]), codes, fMatriculas));
					}else System.out.println("Comando incorrecto");
					break;
				case "fin":
					if(com.length ==1) {//Comprobamos que el comando se escribió correctamente
						comando = com[0];
						System.out.println("Programa finalizado");
					}else System.out.println("Comando incorrecto");
					break;
				default:
					System.out.println("La cadena introducida no se reconoce como comando");
			}
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo main crea arrayList de objetos tipo Matricula, Asignaturas y Alumno,
	 * guarda en estos la información almacenada en los ficheros respectivos
	 * luego ejecuta el intérprete de órdenes.
	 */
	public static void main(String[] args) {
		String fMatriculas = "D:/Documentos/GradosuperiorDAM2021/Programación"
									+ "/Trimestre3/Practica_4/matriculas.dat";
		String fAsignaturas = "D:/Documentos/GradosuperiorDAM2021/Programación"
									+ "/Trimestre3/Practica_4/asignaturas.txt";
		String fAlumnos = "D:/Documentos/GradosuperiorDAM2021/Programación"
									+ "/Trimestre3/Practica_4/alumnos.csv";
		ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		leerMatriculas(fMatriculas, matriculas);
		leerAsignaturas(fAsignaturas, asignaturas);
		leerAlumnos(fAlumnos, alumnos);
		Scanner entrada = new Scanner(System.in);
		prompt(matriculas, asignaturas, alumnos, fMatriculas, entrada);
		entrada.close();
	}
}
