package practica1;

import java.util.Scanner;

public class LigaSaiyajin {
	/*
	 * Pre: ---
	 * Post: Este metodo le pide un dato al usuario
	 */
	private static String pedirDato(String frase) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(frase);
		return entrada.nextLine();
	}
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
	 * Post: Este metodo main crea una liga y ofrece opciones para mostrar algunas estadisticas
	 */
	public static void main(String[] args) {
		Liga liga = new Liga("Liga Saiyajin");
		while(true) {
			System.out.println("\n" + liga.getNombre() + ": "
					+ "\n1. Visualizar clasificación ordenada por puntos"
					+ "\n2. Visualizar los 5 máximos goleadores"
					+ "\n3. Visualizar los 5 jugadores con más expulsiones"
					+ "\n4. Obtener los 3 equipos más goleadores"
					+ "\n5. Salir"
					+ "\nIntroduzca el digito de la opción deseada.\n");
			
			int num = 0;
			String opcion = pedirDato("");
			if(esEntero(opcion)) {
				num = Integer.parseInt(opcion);
				switch(num) {//Creamos switch en el cual, cada case se corresponde con una opcion del menu
					case 1:
						System.out.println("Clasificacion de la liga:\n");
						for(int i = 0; i< liga.getClasificacion().length; i++) {
							System.out.println((i+1) + ". " + liga.getClasificacion()[i].toString());
						}
						break;
					case 2:
						System.out.println("Maximos goleadores:");
						Jugador[] goleadores = new Jugador[5]; //Tabla de jugadores donde pondremos a los 5 maximos goleadores
						int goles = -1;
						for(int k = 0; k<goleadores.length; k++) {							
							if(k == 0) {//buscaremos primero el maximo goleador de todos
								for(int i = 0; i< liga.getClasificacion().length; i++) {
									for( int j = 0; j < liga.getClasificacion()[i].getJugadores().length; j++) {
										if(liga.getClasificacion()[i].getJugadores()[j].getGoles()>goles) { /*con esta condicion comparamos 
												el numero de goles del jugador en la iteracion actual con el maximo registrado hasta esta algura del bucle*/
											goleadores[0]=liga.getClasificacion()[i].getJugadores()[j];
											goles = liga.getClasificacion()[i].getJugadores()[j].getGoles(); 
										}
									}
								}
							}else {
								goles =-1;
								boolean siguiente = false; //variable auxiliar que nos ayudara con las comparaciones
								for(int i = 0; i< liga.getClasificacion().length; i++) {
									for( int j = 0; j < liga.getClasificacion()[i].getJugadores().length; j++) {
										if(liga.getClasificacion()[i].getJugadores()[j].getGoles()>goles) {
											if(liga.getClasificacion()[i].getJugadores()[j].getGoles()>goleadores[k-1].getGoles()) {
												continue;//saltamos a este jugador porque si sus goles son mayores, ya estara incluido en la tabla
											}
											if(liga.getClasificacion()[i].getJugadores()[j].getGoles()==goleadores[k-1].getGoles()) {
												for(int h = 0; h<k;h++) { //si sus goles son iguales, puede ser un jugador ya introducido, o uno nuevo, hacemos un bucle para comparar
													if(liga.getClasificacion()[i].getJugadores()[j]==goleadores[h]) {
														siguiente = true;//si se cumple la comparacion, el jugador ya esta en la tabla
														break;
													}
												}
												if(siguiente) {
													siguiente = false;
													continue;//como el jugador ya esta en la tabla, lo saltamos
												}
												goleadores[k]=liga.getClasificacion()[i].getJugadores()[j];//si el jugador no esta en la tabla, lo ponemos
												goles = liga.getClasificacion()[i].getJugadores()[j].getGoles();
											}else {
												goleadores[k]=liga.getClasificacion()[i].getJugadores()[j];
												goles = liga.getClasificacion()[i].getJugadores()[j].getGoles();
											}
										}
									}
								}
							}
							System.out.println((k+1) + ". " + goleadores[k].toString());
						}
						break;
					case 3:
						System.out.println("Jugadores con mas expulsiones:");
						Jugador[] expulsados = new Jugador[5]; //Tabla de jugadores donde pondremos a los 5 mas expulsados
						int redCards = -1;
						for(int k = 0; k<expulsados.length; k++) {
							if(k == 0) {//buscaremos primero el mas expulsado de todos
								for(int i = 0; i< liga.getClasificacion().length; i++) {
									for( int j = 0; j < liga.getClasificacion()[i].getJugadores().length; j++) {
										if(liga.getClasificacion()[i].getJugadores()[j].getTarjetasRojas()>redCards) {/*con esta condicion comparamos 
												el numero de tarjetas del jugador en la iteracion actual con el maximo registrado hasta esta algura del bucle*/
											expulsados[0]=liga.getClasificacion()[i].getJugadores()[j];
											redCards = liga.getClasificacion()[i].getJugadores()[j].getTarjetasRojas(); 
										}
									}
								}
							}else {
								redCards =-1;
								boolean siguiente = false;//variable auxiliar que nos ayudara con las comparaciones
								for(int i = 0; i< liga.getClasificacion().length; i++) {
									for( int j = 0; j < liga.getClasificacion()[i].getJugadores().length; j++) {
										if(liga.getClasificacion()[i].getJugadores()[j].getTarjetasRojas()>redCards) {
											if(liga.getClasificacion()[i].getJugadores()[j].getTarjetasRojas()>expulsados[k-1].getTarjetasRojas()) {
												continue;//saltamos a este jugador porque si sus tarjetas son mayores, ya estara incluido en la tabla
											}else if(liga.getClasificacion()[i].getJugadores()[j].getTarjetasRojas()==expulsados[k-1].getTarjetasRojas()) {
												for(int h = 0; h<k;h++) {//si sus tarjetas son iguales, puede ser un jugador ya introducido, o uno nuevo, hacemos un bucle para comparar
													if(liga.getClasificacion()[i].getJugadores()[j]==expulsados[h]) {
														siguiente = true;//si se cumple la comparacion, el jugador ya esta en la tabla
														break;
													}
												}
												if(siguiente) {
													siguiente = false;
													continue;//como el jugador ya esta en la tabla, lo saltamos
												}
												expulsados[k]=liga.getClasificacion()[i].getJugadores()[j];//si el jugador no esta en la tabla, lo ponemos
												redCards = liga.getClasificacion()[i].getJugadores()[j].getTarjetasRojas();
											}else {
												expulsados[k]=liga.getClasificacion()[i].getJugadores()[j];
												redCards = liga.getClasificacion()[i].getJugadores()[j].getTarjetasRojas();
											}
										}
									}
								}
							}
							System.out.println((k+1) + ". " + expulsados[k].toString());
						}
						break;
					case 4:
						System.out.println("Equipos mas goleadores:");
						Equipo[] eGoleadores = new Equipo[3];//Tabla de equipos donde pondremos a los 3 mas goleadores
						goles = -1;
						for(int k = 0; k<eGoleadores.length; k++) {
							if(k == 0) {//buscaremos primero el maximo goleador de todos
								for(int i = 0; i< liga.getClasificacion().length; i++) {
									if(liga.getClasificacion()[i].getGolesFavor()>goles) {
										eGoleadores[0]=liga.getClasificacion()[i];
										goles = liga.getClasificacion()[i].getGolesFavor(); 
									}
								}
							}else {
								goles =-1;
								boolean siguiente = false;//variable auxiliar que nos ayudara con las comparaciones
								for(int i = 0; i< liga.getClasificacion().length; i++) {
									if(liga.getClasificacion()[i].getGolesFavor()>goles) {
										if(liga.getClasificacion()[i].getGolesFavor()>eGoleadores[k-1].getGolesFavor()) {
											continue;//saltamos a este equipo porque si sus goles son mayores, ya estara incluido en la tabla
										}else if(liga.getClasificacion()[i].getGolesFavor()==eGoleadores[k-1].getGolesFavor()) {
											for(int h = 0; h<k;h++) { //si sus goles son iguales, puede ser un equipo ya introducido, o uno nuevo, hacemos un bucle para comparar
												if(liga.getClasificacion()[i]==eGoleadores[h]) {
													siguiente = true;//si se cumple la comparacion, el equipo ya esta en la tabla
													break;
												}
											}
											if(siguiente) {
												siguiente = false;
												continue;//como el equipo ya esta en la tabla, lo saltamos
											}else {
												eGoleadores[k]=liga.getClasificacion()[i];//si el equipo no esta en la tabla, lo ponemos
												goles = liga.getClasificacion()[i].getGolesFavor();
											}
										}else {
											eGoleadores[k]=liga.getClasificacion()[i];
											goles = liga.getClasificacion()[i].getGolesFavor();
										}
									}
								}
							}
							System.out.println((k+1) + ". " + eGoleadores[k].toString());
						}
						break;
					case 5:
						break;
					default:
						System.out.println("Opcion incorrecta");
				}
			}else {
				System.out.println("Por favor introduzca una opcion correcta, recuerde solo introducir el digito de la opcion\n");
			}
			if(num == 5) {
				break;
			}
		}
	}
}
