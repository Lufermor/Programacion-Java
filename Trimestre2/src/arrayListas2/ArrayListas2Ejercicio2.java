package arrayListas2;

import java.util.ArrayList;

public class ArrayListas2Ejercicio2 {
	
	/*
	 * Pre: ---
	 * Post: Crea un arraylist de personas en la cola, y luego calcula la cantidad recaudada en el cine
	 */
	public static void main(String[] args) {
		int cuantos = (int)(Math.random()*49+1);
		String[] nombres = "Jes�s Pozo,P�a Mancebo Sanjuan,Emiliano Egea Bayona,Goyo Villaverde,Armando Aurelio Rold�n Cabello,Norberto Guardiola Saavedra,Sebastian Ciriaco Lago Gallo,Feliciana Iglesias Carlos,Carmela Ferrando Llorente,Edelmiro Su�rez Guzm�n,No� Franco Alberdi,Otilia Perea,Carmelo del Prado,Elisa Berrocal Puente,Martina Echevarr�a S�enz,Rosalinda Barrena Nogueira,Marianela Ortiz,Teresa Ascensi�n Huertas Olivera,Maura Graciana Ayuso Alcal�,Alondra Oller Rebollo,Paco Mas Garz�n,Alondra Calzada-Cortina,Ignacio Vel�zquez Lastra,Glauco Crespi Llorens,Ram�n Huertas Quintanilla,Reynaldo Sim� Laguna,Loreto Cort�s Ari�o,Liliana Miranda B�rcena,Manuel Roura Gimeno,Epifanio Taboada Cervera,Bernarda Pedrero Escribano,Anna Jaume L�pez,Nidia Casta�eda Gracia,Guadalupe Vendrell Pazos,Albert Marcos Pag�s,Ricarda Carmona Pelayo,Maximino Almeida Bl�zquez,Sigfrido Bosch Pallar�s,Dora Morillo Bejarano,Cayetano Rosendo Peinado Corbacho,Yago Manrique Garmendia,Susanita Roca-Menendez,Teo Borja Mari�o Corral,Cayetana de Hidalgo,Iker Lloret-Egea,Dar�o del Artigas,Cecilia Pastor Gibert,Nico Carrasco Rosell,Jordana Imelda Benet Barba,Jacinta Araujo Calatayud".split(",");
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
