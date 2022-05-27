package examenProgramacionMayo2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Queremos desarrollar un programa Java que sea capaz de analizar la información de un
 * fichero de texto. El algoritmo recibe como parámetro la dirección de un fichero de texto junto a una 
 * letra del abecedario. El resultado debe mostrar por pantalla cada una de las palabras del texto que
 * empiezan o terminan con dicha letra, junto a la línea en la que se encuentran.
 * Con la finalidad de que la información mostrada por el algoritmo sea persistente, el programa
 * deberá almacenarla en una Base de Datos formada por una única tabla,
 */

public class ExamenProgramacionEjercicio1 {
	
	/*
	 * Pre: 
	 * Post: Este método se encarga de leer las líneas de un fichero del que se le pasa la ruta.
	 * Busca en cada línea las palabras que empiecen por una letra indicada. 
	 * Cuando encuentra las palabras, guardará en un arraylist de objetos Palabra
	 * cada ocurrencia, indicando la letra, palabra encontrada y número de línea donde se encuentra.
	 * Por último, llama a un método de la clase MySQLAccess, para guardar cada objeto palabra
	 * en una base de datos.
	 */
	public static void buscarPalabras(ArrayList<Palabra> palabras, String letra, String ruta) {
		palabras.clear();
		File file = new File(ruta);
		try {
			Scanner f = new Scanner(file);
			int line = 0;
			while (f.hasNextLine()) {
				String linea = f.nextLine(); line++;
				String[] lineaSep = linea.split(" ");
				for(String p : lineaSep) {
					if(letra.equalsIgnoreCase(p.substring(0,1))){
						palabras.add(new Palabra(letra, p.replaceAll(",", ""), line));
					}
				}
			}
			f.close(); // Se libera el fichero que estamos leyendo
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + ruta + " no ha podido ser leído.");
		}
		/*
		 * Con la siguiente línea ordenamos la lista de usuarios por el valor de su
		 * atributo usosTotales, de mayor a menor:
		 */
		for(Palabra p :  palabras) System.out.println(p.toString());
	}
	
	/*
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		String ruta = "C:/Users/User/eclipse-workspace/Trimestre3/src/examenProgramacionMayo2022/HablanosDelDon.txt";
		ArrayList<Palabra> palabras = new ArrayList<Palabra>();
		buscarPalabras(palabras, "p", ruta);
	}

}
