package examenProgramacionMayo2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Disponemos del fichero Divorcios.csv, que contiene la información sobre los divorcios
 * en España según exista o no separación previa, separado por localidades y años (estos datos
 * pertenecen al Instituto Nacional de Estadística). Queremos desarrollar un programa Java que sea
 * capaz de mostrar por pantalla:
 * 1. El número total de divorcios CON separación previa en el año 2019.
 * 2. El número total de divorcios SIN separación previa en el año 2018.
 * 3. La localidad cuyo número de divorcios (suma de ambos) desde 2013 hasta 2019 haya sido mayor.
 */
public class DivorciosExamenProgramacionEjercicio2 {
	
	/*
	 * Pre: ---
	 * Post: Este método recibe una ruta de un fichero, lee cada registro del fichero y 
	 * los almacena en un arrayList de objetos Divorcio. 
	 */
	private static void leerDivorcios(ArrayList<Divorcio> divorcios, String ruta) {
		divorcios.clear();
		File file = new File(ruta);
		try {
			Scanner f = new Scanner(file);
			f.nextLine();
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				String[] lineaSep = linea.split(";");
				if(lineaSep[3].replaceAll("\\.", "").equals("")) lineaSep[3] = "0";
				divorcios.add(new Divorcio(lineaSep[0], lineaSep[1], Integer.parseInt(lineaSep[2]), 
											Integer.parseInt(lineaSep[3].replaceAll("\\.", ""))));
			}
			f.close(); // Se libera el fichero que estamos leyendo
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + ruta + " no ha podido ser leido.");
		}
		//Imprimimos los objetos en el arrayList para comprobar:
//		for(Divorcio p :  divorcios) System.out.println(p.toString());
	}
	
	/*
	 * Pre: El año que se pasa como parámetro debe existir en el fichero original de datos. 
	 * Post: Imprime por pantalla el numero total de divorcios en un año, 
	 * segun si hubo separación previa o no. 
	 */
	private static void totalDivorciosYear(ArrayList<Divorcio> divorcios, String separacion, int year) {
		int total = 0;
		for(Divorcio p :  divorcios) {
			if(p.getSeparacion().equalsIgnoreCase(separacion.strip()) 
					&& p.getYear()==year) total+=p.getDivorcios();
		}
		if("si".equalsIgnoreCase(separacion.strip())) {
			System.out.println("El numero total de divorcios CON separacion en el año " 
								+ year + " es = " + total);
		}else if("no".equalsIgnoreCase(separacion.strip())) {
			System.out.println("El numero total de divorcios SIN separacion en el año " 
					+ year + " es = " + total);
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Imprimer por pantalla la provincia donde se han registrado más divorcios
	 * desde 2013 hasta 2019
	 */
	private static void provinciaMasDivorciada(ArrayList<Divorcio> divorcios) {
		Divorcio mayor = new Divorcio(divorcios.get(0).getProvincia(), "", 0, 0);
//		System.out.println(mayor.toString());
		Divorcio actual = new Divorcio(divorcios.get(0).getProvincia(), "", 0, 0);
		for(Divorcio p :  divorcios) {
			if(p.getProvincia().equals(actual.getProvincia())) {
				actual.setDivorcios(actual.getDivorcios()+p.getDivorcios());
			}else if(actual.getDivorcios()>mayor.getDivorcios()) {
				mayor = actual;
//				System.out.println(mayor.toString());
				actual = new Divorcio(p.getProvincia(), "", 0, p.getDivorcios());
			}
		}
		System.out.println("La provincia con mayor numero de divorcios es: " +mayor.getProvincia()
							+ " con " + mayor.getDivorcios() + " divorcios");
	}
	
	/*
	 * Pre: ---
	 * Post: Este método main crea un arrayList de objetos Divorcio, luego llama a un metodo para 
	 * rellenarlo con registros de un fichero csv, a continuación realiza una prueba sobre el 
	 * método totalDivorciosYear, para comprobar que puede calcular el número de divorcios 
	 * con o sin separacion en un año 
	 */
	public static void main(String[] args) {
		String ruta = "C:/Users/User/eclipse-workspace/Trimestre3/src/examenProgramacionMayo2022/Divorcios.csv";
		ArrayList<Divorcio> divorcios = new ArrayList<Divorcio>();
		leerDivorcios(divorcios, ruta);
		totalDivorciosYear(divorcios, "si", 2019);
		provinciaMasDivorciada(divorcios);
	}

}
