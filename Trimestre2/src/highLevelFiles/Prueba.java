package highLevelFiles;

import java.io.File;
import java.util.Scanner;

/**
 * Esta clase presenta un programa de prueba que ilustra c�mo trabjar con ficheros haciendo
 * uso de los recursos que ofrece la clase java.io.File
 * 
 * @Author: �lvaro Juan Ciriaco
 */

public class Prueba {
	
	/**
	 * Pre: ---
	 * Post: Si existe un fichero cuyo nombre es igual al asociado al objeto [f], entonces
	 * 		 informa por pantalla de los atributos y principales caracter�sticas del fichero.
	 * 		 En caso contrario no produce ning�n resultado.
	 */
	public static void mostrarInformacion(File f) {
		if(f.isFile()) {
			System.out.println();
			System.out.println(" ---------------------");
			System.out.println("| INFORMACI�N DE FILE |");
			System.out.println(" ---------------------");
			System.out.println("| Nombre del fichero:                             " + f.getName());
			System.out.println("| Ruta relativa del directorio del fichero:       " + f.getParent());
			System.out.println("| Nombre del fichero (ruta relativa):             " + f.getPath());
			System.out.println("| Nombre del fichero (ruta absoluta):             " + f.getAbsolutePath());
			System.out.println("| Tama�o del fichero (en bytes):                  " + f.length());
			System.out.println("| Puede ser le�do:                                " + f.canRead());
			System.out.println("| Puede ser escrito:                              " + f.canWrite());
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Muestra por pantalla el menu de la aplicaci�n.
	 */
	public static void mostrarMenu() {
		System.out.println("Selecciona una opci�n: ");
		System.out.println("  1) Crear File usando ruta");
		System.out.println("  2) Crear File usando ruta + nombre");
		System.out.println("  3) Cambiar el nombre del File usando ruta + nombre");
		System.out.println("  4) Borrar el File");
		System.out.print("Opci�n seleccionada (0 para finalizar): ");
	}
	
	/**
	 * Pre: ---
	 * Post: Presenta informaci�n por pantalla del fichero [nombre] ubicado en [ruta], le cambia
	 * 		 su nombre y, finalmente, lo elimina.
	 */
	public static void main(String[] args) {
		/*
		 * Crea objeto de clase [Scanner] y presenta por pantalla el menu de la aplicaci�n.
		 */
		Scanner entrada = new Scanner(System.in);
		mostrarMenu();
		int opcion = entrada.nextInt();
		while(opcion != 0) {
			File f;
			/*
			 * Si el usuario selecciona la opci�n 1 el objeto [File] se crea llamando
			 * a su constructor public File(String ruta_y_nombre), si selecciona la opci�n
			 * 2 el objeto [File] se crea llamando al constructor public File(String ruta, nombre).
			 */
			if(opcion == 1 || opcion == 2) {
				if(opcion == 1) {
					System.out.print("Escriba la ruta para File: ");
					String rutaFinal = entrada.next();
					f = new File(rutaFinal);
				} else{
					System.out.print("Escriba la ruta para File (sin nombre): ");
					String ruta = entrada.next();
					System.out.print("Escriba el nombre para File: ");
					String nombre = entrada.next();
					f = new File(ruta, nombre);
				}
				/*
				 * Muestra informaci�n relevante del fichero
				 */
				mostrarInformacion(f);
			}else if(opcion ==3) {
				System.out.print("Escriba la ruta para File a renombrar(con nombre): ");
				String ruta = entrada.next();
				System.out.print("Escriba el nuevo nombre para File: (con ruta)");
				String nombre = entrada.next();
				f = new File(ruta);
				File f2 = new File(nombre); 
				f.renameTo(f2);
				mostrarInformacion(f);
			}else if(opcion == 4){
				System.out.print("Escriba la ruta para File a borrar (con nombre): ");
				String ruta = entrada.next();
				f = new File(ruta);
				System.out.print("Esta a punto de borrar File, �continuar? (s/n)");
				String confirmar = entrada.next();
				if(confirmar.equalsIgnoreCase("s")) {
					f.delete();
				}
			} else {
				System.out.println("�Opci�n incorrecta. Indique un n�mero v�lido!");
			}
			/*
			 * Separaci�n est�tica para la aplicaci�n.
			 */
			System.out.println();
			System.out.println("==================================================");
			System.out.println();
			/*
			 * Presenta por pantalla el menu y pregunta al usuario por una nueva opci�n.
			 * Esto se repite hasta que el usuario selecciona la opci�n 0 (finalizar).
			 */
			mostrarMenu();
			opcion = entrada.nextInt();
		}
	}
}