package repaso1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Dado el fichero "drivers.csv" que contiene toda la información historica de los pilotos de Fórmula 1, 
 * muestra por pantalla el número de pilotos de cada una de las nacionalidades 
 * (ordenados de mayor a menor número de ocurrencias).
 */
public class Repaso1Ejercicio2 {

	/*
	 * Pre: --- Post: Lee el fichero csv en la ruta indicada, luego llama al metodo
	 * addRegistro para ir sumando cada registro a la nacionalidad adecuada.
	 */
	public static void ordenarPilotos(ArrayList<Tupla> tuplas, String ruta) {
		tuplas.clear();
		File file = new File(ruta);
		try {
			Scanner f = new Scanner(file);
			f.nextLine();
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				String[] lineaSep = linea.split(",");
				addRegistro(tuplas, new Tupla(lineaSep[7], 1));
			}
			f.close(); // Se libera el fichero que estamos leyendo
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + ruta + " no ha podido ser leído.");
		}
		/*
		 * Con la siguiente línea ordenamos la lista de usuarios por el valor de su
		 * atributo usosTotales, de mayor a menor:
		 */
		tuplas.sort(Comparator.comparing(Tupla::getDrivers).reversed());
		System.out.println("Numero de nacionalidades distintas: " + tuplas.size() + "\n");
		imprimirTuplas(tuplas);
	}

	/*
	 * Pre: --- Post: Añade una tupla al ArrayList, si la nacionalidad es nueva, si
	 * no lo es, aumenta el contador de la tupla respectiva en el ArrayList
	 */
	public static void addRegistro(ArrayList<Tupla> tuplas, Tupla tupla) {
		boolean nuevo = true;
		for (Tupla tup : tuplas) {
			if (tup.getNacionalidad().equalsIgnoreCase(tupla.getNacionalidad())) {
				tup.setDrivers(tup.getDrivers() + 1);
				nuevo = false;
				break;
			}
		}
		if (nuevo)
			tuplas.add(tupla);
	}

	/*
	 * Pre: --- Post: Imprime el contenido del ArrayList de Tupla, según un formato
	 * específico.
	 */
	public static void imprimirTuplas(ArrayList<Tupla> tuplas) {
		System.out.println(String.format("%25s", "Nacionalidad")
						+ String.format("%20s", "Pilotos"));
		for (int i = 0; i < tuplas.size(); i++) {
			System.out.println(String.format("%5s", (i+1))
					+ String.format("%20s", tuplas.get(i).getNacionalidad())
					+ String.format("%20s", tuplas.get(i).getDrivers()));
		}
	}

	/*
	 * Pre: --- Post:
	 */
	public static void main(String[] args) {
		String ruta = "C:\\Users\\User\\eclipse-workspace\\Trimestre3\\src\\repaso1\\drivers.csv";
		ArrayList<Tupla> tuplas = new ArrayList<Tupla>();
		ordenarPilotos(tuplas, ruta);
		
	}

}
