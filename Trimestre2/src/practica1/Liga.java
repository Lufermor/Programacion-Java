package practica1;

public class Liga {
	private String nombre;
	private Equipo[] clasificacion;
	
	public Liga() {
		nombre = "Liga";
		clasificacion = new Equipo[15];
		crearLiga();
	}
	
	public Liga(String nombre) {
		this.nombre = nombre;
		clasificacion = new Equipo[15];
		crearLiga();
	}
	
	public Liga(String nombre, Equipo[] clasificacion) {
		this.nombre = nombre;
		this.clasificacion = clasificacion;
		clasificar();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Equipo[] getClasificacion() {
		return clasificacion;
	}
	
	public void setClasificacion(Equipo[] equipos) {
		this.clasificacion = equipos;
		clasificar();
	}
	/*
	 * Pre: ---
	 * Post: Este metodo crea equipos aleatorios y los introduce en la clasificacion
	 */
	public void crearLiga() {
		for(int i = 0; i<clasificacion.length; i++) {
			Equipo e = new Equipo(generarNombreAleatorio(), generarEstadioAleatorio(), 
					(int)(Math.random()*(2022-1880)+1880), (int)(Math.random()*20), 
					(int)(Math.random()*20), (int)(Math.random()*20));
			clasificacion[i] = e;
		}
		clasificar();
	}
	/*
	 * Pre: ---
	 * Post: Este metodo devuelve un nombre de equipo aleatorio 
	 */
	public String generarNombreAleatorio() {
		String[] nombres = {"Atlético De Madrid",	"Real Madrid",	"Fc Barcelona",	"Sevilla",	"Real Sociedad",	"Real Betis",	"Villarreal",	"Celta De Vigo",	"Granada",	"Athletic",	"Osasuna",	"Cádiz",	"Valencia",	"Levante Ud",	"Getafe",	"Alavés",	"Elche",	"Huesca",	"Real Valladolid",	"Eibar"};
		return nombres[(int)(Math.random()*(nombres.length - 1))];
	}
	/*
	 * Pre: ---
	 * Post: Este metodo devuelve un nombre de estadio aleatorio
	 */
	public String generarEstadioAleatorio() {
		String[] nombres = {"Camp Nou",	"Santiago Bernabéu",	"Estadio Metropolitano",	"Benito Villamarín",	"La Cartuja",	"Olímpico Lluís Companys",	"Mestalla",	"San Mamés",	"Ramón Sánchez-Pizjuán",	"Rcde Stadium",	"Reale Arena",	"Abanca-Riazor",	"Martínez Valero",	"La Romareda",	"Gran Canaria",	"Enrique Roca De Murcia",	"Municipal Carlos Tartiere",	"La Rosaleda",	"Municipal El Molinón-Enrique Castro",	"José Rico Pérez"};
		return nombres[(int)(Math.random()*(nombres.length - 1))];
	}
	/*
	 * Pre: ---
	 * Post: Este metodo ordena los equipos de la tabla equipos, en funcion de sus puntos y 
	 * goles a favor
	 */
	public void clasificar() {
		for(int i = 0; i<clasificacion.length-1; i++) {
			for(int j = i+1; j<clasificacion.length; j++) {
				if(clasificacion[j].getPuntos()>clasificacion[i].getPuntos()) {
					Equipo e = clasificacion[i];			//objeto auxiliar para ordenar la tabla
					clasificacion[i] = clasificacion[j];
					clasificacion[j] = e;
				}else if(clasificacion[j].getPuntos()==clasificacion[i].getPuntos()) {
					if(clasificacion[j].getGolesFavor()>clasificacion[i].getGolesFavor()){
						Equipo e = clasificacion[i];
						clasificacion[i] = clasificacion[j];
						clasificacion[j] = e;
					}
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "Liga:"
				+ "\nNombre: " + nombre
				+ " Equipos: " + clasificacion.length;
	}
}
