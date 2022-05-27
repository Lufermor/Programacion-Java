package practicaMiPrimerVideojuego;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
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
	 * Pre: ---
	 * Post: Muestra al usuario las opciones generales del juego e interactúa
	 * para que el usuario pueda elegir.
	 */
	private static void iniciarJuego(MySQLAccess dao, ArrayList<Arma> armas, ArrayList<Evento> eventos,
			ArrayList<Personaje> personajes, ArrayList<Rank> ranking, Scanner entrada) throws Exception {
		while(true) {
			System.out.println("Bienvenido a La aventura extravagante!\n"
					+ "Seleccione una opcion:\n"
					+ "1. Nueva partida\n"
					+ "2. Ingresar nuevos items\n"
					+ "3. Ver el ranking\n"
					+ "0. Salir");
			String opcion = entrada.nextLine();
			if(esEntero(opcion)) {
				int o = Integer.parseInt(opcion);
				switch(o) {
					case 1:
						partidaAventura(dao, armas, eventos, personajes, ranking, entrada);
						break;
					case 2:
						insertarItems(dao, armas, eventos, personajes, ranking, entrada);
						break;
					case 3:
						dao.writeResultSet("ranking");
						break;
					case 0:
						System.out.println("Hasta luego!");
						System.exit(0);
						break;
					default:
						System.out.println("La opcion elegida no es correcta");
						break;
				}
			}else System.out.println("Escoja una opcion corecta, introduzca solo el digito de la opcion");
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Inicia una nueva partida aventura, haciéndole preguntas al jugador y realizando 
	 * acciones en función de las elecciones de este.
	 */
	private static void partidaAventura(MySQLAccess dao, ArrayList<Arma> armas, ArrayList<Evento> eventos,
			ArrayList<Personaje> personajes, ArrayList<Rank> ranking, Scanner entrada) {
		try {
			personajes = dao.getPersonajes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int puntuacion = 0;
		//Primero pedimos al usuario que escoja un personaje de la lista
		System.out.println("Escoja un personaje: ");
		System.out.println(String.format("%25s", "Personaje") + 
							String.format("%20s", "Habilidad")+ "\n");
		for(int i = 0; i< personajes.size(); i++) {
			System.out.println(String.format("%5s", (i+1)) +	
					String.format("%20s", personajes.get(i).getNombre()) +
					String.format("%20s", personajes.get(i).getHabilidad()));
		}
		int elec = -1;
		while(true) {
			String eleccion = entrada.nextLine();
			if(esEntero(eleccion)) {
				elec = Integer.parseInt(eleccion);
				if(elec>0 && elec <=personajes.size()) break;
				else System.out.println("Por favor elija una opcion correcta");
			}else System.out.println("Por favor elija una opcion correcta");
		}
		Personaje personaje = personajes.get(elec-1);
		
		//A continuacion le pedimos al usuario que escoja un arma de la lista
		System.out.println("Escoja un arma: ");
		System.out.println(String.format("%25s", "Arma") + 
							String.format("%20s", "Daño")+ "\n");
		for(int i = 0; i< armas.size(); i++) {
			System.out.println(String.format("%5s", (i+1)) +	
					String.format("%20s", armas.get(i).getNombre()) +
					String.format("%20s", armas.get(i).getAtaque()));
		}
		while(true) {
			String eleccion = entrada.nextLine();
			if(esEntero(eleccion)) {
				elec = Integer.parseInt(eleccion);
				if(elec>0 && elec <=armas.size()) break;
				else System.out.println("Por favor elija una opcion correcta");
			}else System.out.println("Por favor elija una opcion correcta");
		}
		Arma arma = armas.get(elec-1);
		
		System.out.println("Buena eleccion!\n"
				+ "Tu personaje es: " + personaje.getNombre() + " con la habilidad de "
				+ personaje.getHabilidad() + " con la cual " + personaje.getDescripcionHabilidad()
				+ "\nSe supone que tu arma te ayudara tambien en la aventura pero sera verdad?\n"
				+ "Inicia la aventura!");
		while(personaje.getVida()>0) {
			Evento evento = eventos.get((int)(Math.random()*(eventos.size())));
			System.out.println(evento.getPregunta() 
					+ "\n1. " + evento.getRespuesta1()
					+ "\n2. " + evento.getRespuesta2());
			String eleccion = entrada.nextLine();
			if(esEntero(eleccion)) {
				elec = Integer.parseInt(eleccion);
				switch(elec) {
					case 1:
						System.out.println(evento.getConsecuencia1());
						if((Math.random()*100) <= personaje.getEfectoHabilidad()) {
							int amortigua = (int)(((Math.random()*personaje.getEfectoHabilidad())/100)*evento.getEfecto1());
							System.out.println("La habilidad de " + personaje.getNombre()
							+ " se activa");
							if(evento.getEfecto1()>0) {
								System.out.println("La vida de tu personaje aumenta en " + (evento.getEfecto1()+amortigua));
								personaje.setVida(personaje.getVida()+evento.getEfecto1()+amortigua);
							}else {
								System.out.println("La vida de tu personaje disminuye en " + (evento.getEfecto1()-amortigua));
								personaje.setVida(personaje.getVida()+evento.getEfecto1()-amortigua);
							}
						}
						break;
					case 2:
						System.out.println(evento.getConsecuencia2());
						if((Math.random()*100) <= personaje.getEfectoHabilidad()) {
							int amortigua = (int)(((Math.random()*personaje.getEfectoHabilidad())/100)*evento.getEfecto2());
							System.out.println("La habilidad de " + personaje.getNombre()
							+ " se activa");
							if(evento.getEfecto2()>0) {
								System.out.println("La vida de tu personaje aumenta en " + (evento.getEfecto2()+amortigua));
								personaje.setVida(personaje.getVida()+evento.getEfecto2()+amortigua);
							}else {
								System.out.println("La vida de tu personaje disminuye en " + (evento.getEfecto2()-amortigua));
								personaje.setVida(personaje.getVida()+evento.getEfecto2()-amortigua);
							}
						}
						break;
					default:
						System.out.println("Opcion incorrecta, la vida de tu personaje disminuye en 50 ");
						personaje.setVida(personaje.getVida()-50);
						break;
				}
			}else {
				System.out.println("Opcion incorrecta, la vida de tu personaje disminuye en 50 ");
				personaje.setVida(personaje.getVida()-50);
			}
			puntuacion+=1;
		}
		System.out.println("Fin del juego! \n" + "Puntuacion = "+ puntuacion 
				+ "\nIntroduzca su nombre: ");
		String nombre = entrada.nextLine();
		try {
			dao.insertRank(nombre, puntuacion);
			dao.writeResultSet("ranking");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * Pre: ---
	 * Post: Pregunta al usuario sobre las cosas que quiere insertar, luego llama a los métodos
	 * del repositorio para ejecutar los comandos adecuados sobre la base de datos
	 */
	private static void insertarItems(MySQLAccess dao, ArrayList<Arma> armas, ArrayList<Evento> eventos,
			ArrayList<Personaje> personajes, ArrayList<Rank> ranking, Scanner entrada) {
		
		System.out.println("Seleccione el item ue desea ingresar:\n"
				+ "1. Nueva arma\n"
				+ "2. Nuevo evento\n"
				+ "3. Nuevo personaje\n"
				+ "4. Volver al menu principal");
		String opcion = entrada.nextLine();
		if(esEntero(opcion)) {
			int o = Integer.parseInt(opcion);
			switch(o) {
				case 1:
					System.out.println("Ingrese el nombre del nuevo arma:");
					String nombre = entrada.nextLine();
					System.out.println("Ingrese el daño del nuevo arma:");
					opcion = entrada.nextLine();
					if(esEntero(opcion)) {
						try {
							dao.insertArma(nombre, Integer.parseInt(opcion));
							System.out.println("Se ha añadido el nuevo arma");
							dao.writeResultSet("armas");
						} catch (Exception e) {
							e.printStackTrace();
						}
						try {
							armas = dao.getArmas();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}else System.out.println("El dato introducido no es correcto\n"
							+ "Volviendo al menu principal");
					break;
				case 2:
					System.out.println("Ingrese el nuevo evento:");
					String pregunta = entrada.nextLine();
					System.out.println("Ingrese la primera opcion:");
					String respuesta1 = entrada.nextLine();
					System.out.println("Ingrese la segunda opcion:");
					String respuesta2 = entrada.nextLine();
					System.out.println("Ingrese el primer desenlace:");
					String consecuencia1 = entrada.nextLine();
					System.out.println("Ingrese el segundo desenlace:");
					String consecuencia2 = entrada.nextLine();
					System.out.println("Ingrese los puntos que afectarán "
							+ "la vida del personaje en el primer desenlace:");
					String efecto1 = entrada.nextLine();
					int e1 = 0;
					if(esEntero(efecto1)) {
						e1 = Integer.parseInt(efecto1);
					}else {
						System.out.println("A la vida solo deben afectar numeros enteros\n"
								+ "Volviendo al menu principal");
						break;
					}
					System.out.println("Ingrese los puntos que afectarán "
							+ "la vida del personaje en el segundo desenlace:");
					String efecto2 = entrada.nextLine();
					int e2 = 0;
					if(esEntero(efecto2)) {
						e2 = Integer.parseInt(efecto2);
					}else {
						System.out.println("A la vida solo deben afectar numeros enteros\n"
								+ "Volviendo al menu principal");
						break;
					}
					try {
						dao.insertEvento(pregunta, respuesta1, respuesta2, consecuencia1, consecuencia2, e1, e2);
						System.out.println("Se ha añadido el nuevo evento");
						dao.writeResultSet("eventos");
						eventos = dao.getEventos();
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 3:
					System.out.println("Ingrese nombre del nuevo personaje");
					nombre = entrada.nextLine();
					System.out.println("Ingrese la vida inicial del personaje");
					String vida = entrada.nextLine();
					int v = 0;
					if(esEntero(vida)) {
						v = Integer.parseInt(vida);
					}else {
						System.out.println("A la vida solo deben afectar numeros enteros\n"
								+ "Volviendo al menu principal");
						break;
					}
					System.out.println("Ingrese el nombre de la habilidad del personaje: ");
					String nombreHabilidad = entrada.nextLine();
					System.out.println("Breve descripcion del efecto de la habilidad:");
					String descripcion = entrada.nextLine();
					System.out.println("Probabilidad de que se active la habilidad (%): ");
					String prob = entrada.nextLine();
					int p = 0;
					if(esEntero(prob)) {
						p = Integer.parseInt(prob);
					}else {
						System.out.println("Solo se pueden introducir porcentajes enteros");
						break;
					}
					System.out.println("Es una habilidad ofensiva(1)? o defensiva(2)?");
					String tipo = entrada.nextLine();
					int t = 0;
					if(esEntero(tipo)) {
						t = Integer.parseInt(tipo);
						if(t == 1 || t ==2) {
							try {
								dao.insertPersonaje(nombre, v, nombreHabilidad, descripcion, p, t);
								System.out.println("Se ha añadido el nuevo evento");
								dao.writeResultSet("personajes");
								 personajes = dao.getPersonajes();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}else System.out.println("Opcion incorrecta, solo se puede introducer el "
												+ "tipo 1 o el tipo 2");
					}else {
						System.out.println("Opcion incorrecta, solo se puede introducer el \"\r\n"
											+ "tipo 1 o el tipo 2");
						break;
					}
					break;
				case 4:
					System.out.println("Volviendo al menu principal");
					break;
				default:
					System.out.println("La opcion no es correcta. Volviendo al menu principal");
					break;
			}
		}
	}
	
	/*
	 * Pre: ---
	 * Post:Este método main inicia el repositorio para conectar con la base de datos, 
	 * y carga las tablas en arrayLists. luego llama al método iniciarPartida
	 */
	public static void main(String[] args) throws Exception {
		Scanner entrada = new Scanner(System.in);
		MySQLAccess dao = new MySQLAccess();
		ArrayList<Arma> armas = dao.getArmas();
		ArrayList<Evento> eventos = dao.getEventos();
		ArrayList<Personaje> personajes = dao.getPersonajes();
		ArrayList<Rank> ranking = dao.getRankings();
//		dao.writeResultSet("ranking");
		iniciarJuego(dao, armas, eventos, personajes, ranking, entrada);
	}
	
}
