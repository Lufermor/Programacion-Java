package reto_ciclistas;
import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	/*
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[]args) {
		ArrayList<Horas> lista = new ArrayList<Horas>();
		File f = new File("D:/Documentos/GradosuperiorDAM2021/Programación/Trimestre3/Reto_ciclistas/Reto_ciclistas2.txt");
		LocalTime hora = null;
		int posicionFichero = 0;
		try {
			Scanner lector = new Scanner(f);
			lector.nextLine();
			while(lector.hasNextLine()) {
				String x = lector.nextLine();
				try {
				       hora = LocalTime.parse(x);
				       posicionFichero +=1;
				       // otra lógica
				    } catch(DateTimeParseException e) {
				       // la hora de entrada o salida es inválida,
				       // informar al usuario y volver a pedirla
				       System.out.println("Error al parsear hora");
				    }
				lista.add(new Horas(posicionFichero, hora, 0));
			}
			lector.close();
		}
		catch(Exception e){
			System.out.println("Error al leer fichero");
		}
		lista.sort(Comparator.comparing(Horas::getHora));
		int posicion = 1;
		for(int i =0; i<lista.size(); i++) {
			if(i ==0) {
				lista.get(i).setPosicionFinal(posicion); 
				continue;
			}
			int segundos = (int) ChronoUnit.SECONDS.between(lista.get(i-1).getHora(), lista.get(i).getHora());
			if(segundos <=1) lista.get(i).setPosicionFinal(posicion);
			else posicion = i+1; lista.get(i).setPosicionFinal(posicion);
		}
		lista.sort(Comparator.comparing(Horas::getPosicion));
		for(Horas h:lista) {
			System.out.println(h.getPosicionFinal());
//			System.out.println(h.toString());
		}
	}
}