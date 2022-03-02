package arrayListas2;

import java.util.ArrayList;

public class ArrayListas2Ejercicio2 {
	
	/*
	 * Pre: ---
	 * Post: Crea un arraylist de personas en la cola, y luego calcula la cantidad recaudada en el cine
	 */
	public static void main(String[] args) {
		int cuantos = (int)(Math.random()*49+1);
		String[] nombres = "Jesús Pozo,Pía Mancebo Sanjuan,Emiliano Egea Bayona,Goyo Villaverde,Armando Aurelio Roldán Cabello,Norberto Guardiola Saavedra,Sebastian Ciriaco Lago Gallo,Feliciana Iglesias Carlos,Carmela Ferrando Llorente,Edelmiro Suárez Guzmán,Noé Franco Alberdi,Otilia Perea,Carmelo del Prado,Elisa Berrocal Puente,Martina Echevarría Sáenz,Rosalinda Barrena Nogueira,Marianela Ortiz,Teresa Ascensión Huertas Olivera,Maura Graciana Ayuso Alcalá,Alondra Oller Rebollo,Paco Mas Garzón,Alondra Calzada-Cortina,Ignacio Velázquez Lastra,Glauco Crespi Llorens,Ramón Huertas Quintanilla,Reynaldo Simó Laguna,Loreto Cortés Ariño,Liliana Miranda Bárcena,Manuel Roura Gimeno,Epifanio Taboada Cervera,Bernarda Pedrero Escribano,Anna Jaume López,Nidia Castañeda Gracia,Guadalupe Vendrell Pazos,Albert Marcos Pagès,Ricarda Carmona Pelayo,Maximino Almeida Blázquez,Sigfrido Bosch Pallarès,Dora Morillo Bejarano,Cayetano Rosendo Peinado Corbacho,Yago Manrique Garmendia,Susanita Roca-Menendez,Teo Borja Mariño Corral,Cayetana de Hidalgo,Iker Lloret-Egea,Darío del Artigas,Cecilia Pastor Gibert,Nico Carrasco Rosell,Jordana Imelda Benet Barba,Jacinta Araujo Calatayud".split(",");
		ArrayList<Persona> personas = new ArrayList<Persona>();
		for(int i = 0; i<cuantos; i++) {
			Persona cliente = new Persona(nombres[i], (int)(Math.random()*95+6));
			personas.add(cliente);
		}
		int ingresos = 0;
		for(Persona persona:personas) {
			System.out.println(persona);
			if(persona.getEdad()<=10) ingresos+=1;
			else if(persona.getEdad()<=17) ingresos+=25;
			else ingresos+=35;
		}
		System.out.println("Ingresos totales = " + ingresos);
	}
}
