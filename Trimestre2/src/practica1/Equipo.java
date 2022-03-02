package practica1;

public class Equipo {
	private String nombre;
	private String estadio;
	private int anoFundacion;
	private Jugador[] jugadores;
	private int puntos;
	private int ganados;
	private int perdidos;
	private int empatados;
	private int golesFavor;
	
	public Equipo(String nombre, String estadio) {
		this.nombre = nombre;
		this.estadio = estadio;
		anoFundacion = 2022;
		ganados = 0;
		perdidos = 0;
		empatados = 0;
		calcularPuntos();
		crearEquipo();
		golesFavor();
	}
	
	public Equipo(String nombre, String estadio, 
			int anoFundacion, int ganados, int perdidos,
			int empatados) {
		this.nombre = nombre;
		this.estadio = estadio;
		comprobarAnoFundacion(anoFundacion);
		crearEquipo();
		comprobarGanados(ganados);
		comprobarPerdidos(perdidos);
		comprobarEmpatados(empatados);
		calcularPuntos();
		golesFavor();
	}
	
	public Equipo(String nombre, String estadio, 
			int anoFundacion, Jugador[] jugadores, int ganados, int perdidos,
			int empatados) {
		this.nombre = nombre;
		this.estadio = estadio;
		comprobarAnoFundacion(anoFundacion);
		this.jugadores = jugadores;
		comprobarGanados(ganados);
		comprobarPerdidos(perdidos);
		comprobarEmpatados(empatados);
		calcularPuntos();
		golesFavor();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEstadio() {
		return estadio;
	}
	
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	
	public int getFundacion() {
		return anoFundacion;
	}
	
	public void setFundacion(int anoFundacion) {
		comprobarAnoFundacion(anoFundacion);
	}
	
	public Jugador[] getJugadores() {
		return jugadores;
	}
	
	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
		golesFavor();
	}
	
	public int getPuntos() {
		return puntos;
	}
	/* Este metodo no se implementa ya que los puntos se calculan automaticamente
	 * a partir de los otros atributos
	 * 
	public void setPuntos(int puntos){ 
		this.puntos = puntos;
	}*/
	
	public int getGanados() {
		return ganados;
	}
	
	public void setGanados(int ganados){
		comprobarGanados(ganados);
		calcularPuntos();
	}
	
	public int getPerdidos() {
		return perdidos;
	}
	
	public void setPerdidos(int perdidos){
		comprobarPerdidos(perdidos);
	}
	
	public int getEmpatados() {
		return empatados;
	}
	
	public void setEmpatados(int empatados){
		comprobarEmpatados(empatados);
		calcularPuntos();
	}
	
	public int getGolesFavor() {
		return golesFavor;
	}
	
	/* Este metodo no se implementa ya que los goles a favor se calculan a partir de otros atributos:
	 * 
	public void setGolesFavor(int golesFavor){
	}*/
	
	/*
	 * Pre: ---
	 * Post: Este metodo calcula los puntos de un equipo en funcion de los resultados
	 * de sus partidos.
	 */
	public void calcularPuntos() {
		puntos = 3*ganados+empatados;
	}
	/*
	 * Pre: ---
	 * Post: este metodo comprueba que el dato introducido es correcto,
	 * de lo contrario introduce el valor por defecto en la variable local.
	 */
	public void comprobarAnoFundacion(int anoFundacion) {
		if(anoFundacion>=1800 && anoFundacion<=2022) {
			this.anoFundacion=anoFundacion;
		}else {
			this.anoFundacion=2022;
		}
	}
	/*
	 * Pre: ---
	 * Post: este metodo comprueba que el dato introducido es correcto,
	 * de lo contrario introduce el valor por defecto en la variable local.
	 */
	public void comprobarGanados(int ganados) {
		if(ganados>=0) {
			this.ganados=ganados;
		}else {
			this.ganados=0;
		}
	}
	/*
	 * Pre: ---
	 * Post: este metodo comprueba que el dato introducido es correcto,
	 * de lo contrario introduce el valor por defecto en la variable local.
	 */
	public void comprobarPerdidos(int perdidos) {
		if(perdidos>=0) {
			this.perdidos=perdidos;
		}else {
			this.perdidos=0;
		}
	}
	/*
	 * Pre: ---
	 * Post: este metodo comprueba que el dato introducido es correcto,
	 * de lo contrario introduce el valor por defecto en la variable local.
	 */
	public void comprobarEmpatados(int empatados) {
		if(empatados>=0) {
			this.empatados=empatados;
		}else {
			this.empatados=0;
		}
	}	
	/*
	 * Pre: ---
	 * Post: Este metodo rellena la tabla de jugadores, con 11 jugadores aleatorios.
	 */
	public void crearEquipo() {
		jugadores = new Jugador[11];
		for(int i = 0; i< jugadores.length; i++) {
			Jugador j = new Jugador(generarNombreAleatorio(), i, (int)(Math.random()*100),
					(int)(Math.random()*20), (int)(Math.random()*20));
			jugadores[i] = j;
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo crea nombres aleatorios para los jugadores
	 */
	public String generarNombreAleatorio() {
		String[] nombres = {"Antonio",	"Manuel",	"Jose",	"Francisco",	"David",	"Juan",	"Javier",	"Jose Antonio",	"Daniel",	"Jose Luis",	"Francisco Javier",	"Carlos",	"Jesus",	"Alejandro",	"Miguel",	"Jose Manuel",	"Rafael",	"Miguel Angel",	"Pablo",	"Pedro",	"Angel",	"Sergio",	"Jose Maria",	"Fernando",	"Jorge",	"Luis",	"Alberto",	"Alvaro",	"Juan Carlos",	"Adrian",	"Diego",	"Juan Jose",	"Raul",	"Ivan",	"Juan Antonio",	"Ruben",	"Enrique",	"Oscar",	"Ramon",	"Andres",	"Vicente",	"Juan Manuel",	"Santiago",	"Joaquin",	"Victor",	"Mario",	"Eduardo",	"Roberto",	"Jaime",	"Francisco Jose",	"Marcos",	"Ignacio",	"Hugo",	"Alfonso",	"Jordi",	"Ricardo",	"Salvador",	"Guillermo",	"Gabriel",	"Marc",	"Emilio",	"Mohamed",	"Gonzalo",	"Julio",	"Julian",	"Martin",	"Jose Miguel",	"Tomas",	"Agustin",	"Nicolas",	"Jose Ramon",	"Samuel",	"Ismael",	"Joan",	"Cristian",	"Felix",	"Lucas",	"Aitor",	"Hector",	"Juan Francisco",	"Iker",	"Alex",	"Jose Carlos",	"Josep",	"Sebastian",	"Mariano",	"Cesar",	"Alfredo",	"Domingo",	"Jose Angel",	"Felipe",	"Victor Manuel",	"Rodrigo",	"Jose Ignacio",	"Mateo",	"Luis Miguel",	"Jose Francisco",	"Juan Luis",	"Xavier",	"Albert",	"Gregorio",	"Pau",	"Lorenzo",	"Antonio Jose",	"Aaron",	"Borja",	"Esteban",	"Cristobal",	"Arturo",	"Eric",	"Izan",	"Mohammed",	"Jose Javier",	"Isaac",	"Joel",	"Juan Miguel",	"Antonio Jesus",	"Eugenio",	"Asier",	"Francisco Manuel",	"Jesus Maria",	"Jaume",	"Dario",	"German",	"Abel",	"Bruno",	"Jonathan",	"Unai",	"Pedro Jose",	"Ahmed",	"Jose Vicente",	"Mikel",	"Valentin",	"Marco",	"Sergi",	"Moises",	"Christian",	"Leo",	"Juan Ramon",	"Omar",	"Iñigo",	"Pol",	"Juan Pedro",	"Gerard",	"Jon",	"Manuel Jesus",	"Adolfo",	"Arnau",	"Ernesto",	"Israel",	"Miquel",	"Oriol",	"Isidro",	"Antonio Manuel",	"Adam",	"Benito",	"Bernardo",	"Gerardo",	"Jonatan",	"Eloy",	"Carmelo",	"Federico",	"Francesc",	"Jose Alberto",	"Jesus Manuel",	"Pascual",	"Luis Alberto",	"Oliver",	"Juan Jesus",	"Adria",	"Alonso",	"Roger",	"Saul",	"Kevin",	"Youssef",	"Elias",	"Iñaki",	"Matias",	"Josep Maria",	"Juan Pablo",	"Bartolome",	"Marti",	"Benjamin",	"Carles",	"Erik",	"Pere",	"Alexander",	"Guillem",	"Ander",	"Pedro Antonio",	"Carlos Alberto",	"Fermin",	"Marco Antonio",	"Marcelino",	"Lluis",	"Jose Enrique",	"Antoni",	"Angel Luis",	"Juan Ignacio",	"Abraham",	"Aurelio",	"Said",	"Julen",	"Francisco Jesus",	"Enzo",	"Aleix",	"Xabier",	"Gorka",	"Jeronimo",	"Ferran",	"Roman",	"Gustavo",	"Luis Fernando",	"Jacinto",	"Rachid",	"Leonardo",	"Manuel Angel",	"Jose Juan",	"Eusebio",	"Luis Manuel",	"Damian",	"Yeray",	"Carlos Javier",	"Jan",	"Victoriano",	"Jose David",	"Pedro Luis",	"Enric",	"Ali",	"Isidoro",	"Armando",	"Juan Bautista",	"Blas",	"Teodoro",	"Jose Joaquin",	"Dionisio",	"Eduard",	"Ian",	"Gines",	"Santos",	"Jairo",	"Eneko",	"Candido",	"Justo",	"Juan Maria",	"Julio Cesar",	"Florencio",	"Mustapha",	"Edgar",	"Francisco Antonio",	"Biel",	"Emiliano",	"Emilio Jose",	"Jose Andres",	"Nil",	"Luis Antonio",	"Simon",	"Jesus Angel",	"Luis Angel",	"Maximo",	"Serafin",	"Luis Maria",	"Faustino",	"Luca",	"Jacobo",	"Alexis",	"Igor",	"Fidel",	"Ramiro",	"Ezequiel",	"Dylan",	"Claudio",	"Hassan",	"Alexandre",	"Amador",	"Gael",	"Manuel Antonio",	"Yago",	"Francisco Miguel",	"Pedro Manuel",	"Juan Diego",	"Andreu",	"Muhammad",	"Rogelio",	"Ion",	"Jorge Luis",	"Jose Daniel",	"Jose Fernando",	"Luciano",	"Ibai",	"Mauro",	"Juan Dios",	"Joaquim",	"Carlos Manuel",	"Juan Andres",	"Juan Vicente",	"Ildefonso",	"Manuel Jose",	"Rayan",	"Iago",	"Thiago",	"Antonio Javier",	"Leandro",	"Aritz",	"Modesto",	"Cayetano",	"Antonio Miguel",	"Aimar",	"Khalid",	"Josue",	"Hamza",	"Ayoub",	"Florentino",	"Luis Javier",	"Antonio Luis",	"Luis Carlos",	"Fabian",	"Pedro Jesus",	"Paulino",	"Pedro Maria",	"Constantino",	"Abdellah",	"Nestor",	"Manel",	"Bilal",	"Eladio",	"Alan",	"Avelino",	"Celestino",	"Francesc Xavier",	"Juan Angel",	"Robert",	"Angel Manuel",	"Hicham",	"Markel",	"Saturnino",	"Fabio",	"Imanol",	"Vasile",	"Gheorghe",	"Marcelo",	"Oier",	"Rufino",	"Abdelkader",	"Ricard",	"Gaspar",	"Brais",	"Andoni",	"Luis Enrique",	"Brahim",	"Juan Alberto",	"Josu",	"Bernat",	"Clemente",	"Fernando Jose",	"Jesus Antonio",	"Basilio",	"Ibrahim",	"Raimundo",	"Roberto Carlos",	"Didac",	"Noel",	"Ioan",	"Angel Maria",	"Feliciano",	"Marcel",	"Joseba",	"Anas",	"Hilario",	"Yassine",	"Abdelaziz",	"Juan David",	"Anton",	"Evaristo",	"Pedro Pablo",	"Marcial",	"Eliseo",	"Patricio",	"Antonio Francisco",	"Abderrahim",	"Laureano",	"Mauricio",	"Adan",	"Narciso",	"Karim",	"Francisco Luis",	"Manuel Alejandro",	"Michael",	"Benigno",	"Hamid",	"Cecilio",	"Pedro Javier",	"Bernardino",	"Axel",	"Brian",	"Constantin",	"Camilo",	"Leopoldo",	"Segundo",	"Alain",	"Carlos Jose",	"Max",	"Pelayo",	"Roque",	"Marian",	"Valeriano",	"Pedro Miguel",	"Demetrio",	"Jose Gabriel",	"Francisco Borja",	"Cesareo",	"Ismail",	"Rodolfo",	"Mamadou",	"Octavio",	"Francisco Asis",	"Noah",	"Jose Felix",	"Denis",	"Zakaria",	"Jesus Miguel",	"Jose Rafael",	"Paul",	"Jamal",	"Eloi",	"Lluc",	"Jose Pedro",	"Florin",	"Luis Francisco",	"Bernabe",	"Abdeslam",	"Lazaro",	"Bienvenido",	"Manuel Francisco",	"Cipriano",	"Nicolae",	"Driss",	"Lucio",	"Anastasio",	"Jose Alejandro",	"Baltasar",	"Alberto Jose",	"Anselmo",	"Aziz",	"Amir",	"Beñat",	"Ignasi",	"Juan Enrique",	"Amadeo",	"Moussa",	"Liam",	"Teo",	"Jose Domingo",	"Jesus Javier",	"Alessandro",	"Carlos Enrique",	"Placido",	"Pablo Jose",	"Samir",	"Celso",	"Anibal",	"Gustavo Adolfo",	"Eulogio",	"Jorge Juan",	"Victor Jose",	"Fulgencio",	"Orlando",	"Ayman",	"Vicent",	"Casimiro",	"Noe",	"Juan Gabriel",	"Nabil",	"Luis Alfonso",	"Teofilo",	"Marcos Antonio",	"Ibon",	"Juan Fernando",	"Vicente Jose",	"Unax",	"Alexandru",	"Adil",	"Luis Eduardo",	"Baldomero",	"Iban",	"Yassin",	"Alejandro Jose",	"Herminio",	"Jose Pablo",	"Kilian",	"Maximino",	"Eduardo Jose",	"Norberto",	"Younes",	"Carlos Antonio",	"Gaizka",	"Aday",	"Jose Tomas",	"Jose Jesus",	"Antonio Maria"};
		String[] apellidos = {"Garcia",	"Rodriguez",	"Gonzalez",	"Fernandez",	"Lopez",	"Martinez",	"Sanchez",	"Perez",	"Gomez",	"Martin",	"Jimenez",	"Hernandez",	"Ruiz",	"Diaz",	"Moreno",	"Muñoz",	"Alvarez",	"Romero",	"Gutierrez",	"Alonso",	"Navarro",	"Torres",	"Dominguez",	"Vazquez",	"Ramos",	"Ramirez",	"Gil",	"Serrano",	"Molina",	"Blanco",	"Morales",	"Suarez",	"Ortega",	"Castro",	"Delgado",	"Ortiz",	"Marin",	"Rubio",	"Nuñez",	"Sanz",	"Medina",	"Iglesias",	"Castillo",	"Cortes",	"Garrido",	"Santos",	"Guerrero",	"Lozano",	"Cano",	"Mendez",	"Cruz",	"Prieto",	"Flores",	"Herrera",	"Peña",	"Leon",	"Marquez",	"Gallego",	"Cabrera",	"Calvo",	"Vidal",	"Campos",	"Vega",	"Reyes",	"Fuentes",	"Carrasco",	"Diez",	"Caballero",	"Aguilar",	"Nieto",	"Santana",	"Pascual",	"Herrero",	"Montero",	"Gimenez",	"Hidalgo",	"Lorenzo",	"Vargas",	"Ibañez",	"Santiago",	"Duran",	"Benitez",	"Ferrer",	"Arias",	"Mora",	"Carmona",	"Vicente",	"Crespo",	"Soto",	"Roman",	"Rojas",	"Pastor",	"Velasco",	"Saez",	"Parra",	"Moya",	"Bravo",	"Soler",	"Gallardo",	"Esteban",	"Rivera",	"Pardo",	"Franco",	"Silva",	"Rivas",	"Merino",	"Lara",	"Espinosa",	"Camacho",	"Izquierdo",	"Vera",	"Mendoza",	"Rios",	"Arroyo",	"Casado",	"Redondo",	"Sierra",	"Luque",	"Montes",	"Rey",	"Galan",	"Otero",	"Carrillo",	"Segura",	"Marcos",	"Bernal",	"Soriano",	"Heredia",	"Robles",	"Marti",	"Valero",	"Palacios",	"Contreras",	"Vila",	"Macias",	"Guerra",	"Varela",	"Exposito",	"Pereira",	"Benito",	"Roldan",	"Miranda",	"Mateo",	"Bueno",	"Andres",	"Guillen",	"Villar",	"Aguilera",	"Mateos",	"Escudero",	"Salazar",	"Acosta"};
		return nombres[(int)(Math.random()*(nombres.length - 1))] + " " + apellidos[(int)(Math.random()*(apellidos.length - 1))];
	}
	/*
	 * Pre: ---
	 * Post = Calculo de los goles a favor del equipo sumando los goles de sus jugadores
	 */
	public void golesFavor() {
		golesFavor = 0;
		for(int i =0; i<jugadores.length;i++) {
			golesFavor += jugadores[i].getGoles();
		}
	}
	
	@Override
	public String toString() {
		return "Equipo:"
				+ "\nNombre: " + nombre
				+ ", Estadio: " + estadio
				+ ", Fundado en : " + anoFundacion
				+ ", Partidos ganados: " + ganados
				+ ", Partidos perdidos: " + perdidos
				+ ", Partidos empatados: " + empatados
				+ ", Puntos: " + puntos
				+ ", Goles a favor: " + golesFavor;
	}
}