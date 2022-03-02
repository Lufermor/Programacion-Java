package practica2;

import java.util.ArrayList;
import java.util.Scanner;

public class LifeGame {
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
	 * Post: Este metodo imprime una tabla bidimensional segun un formato especifico
	 */
	private static void imprimirTabla(String[][] tabla) {
		for(int i= 0; i<tabla.length; i++) {
			System.out.println("\n");
			for(int j = 0; j < tabla[i].length; j++) {
				System.out.print(tabla[i][j] + "  ");
			}
		}
		System.out.println("\n");
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo muestra un menu al jugador y le pide que escoja una opcion
	 */
	private static int mostrarMenu(String menu) {
		System.out.println(menu);
		int num;
		while(true) {
			String opcion = pedirDato("Seleccione una opcion:");
			if(esEntero(opcion)) {
				num = Integer.parseInt(opcion);
				if(0<num && num<4) {
					return num;
				}else {
					System.out.println("Opcion no valida. Escoja una opcion valida");
				}
			}else {
				System.out.println("Elija una opcion valida.");
			}
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo da inicio al juego de la vida, llamando a otros metodos
	 * para preguntarle al usuario por la opcion deseada y poner el marcha el juego
	 */
	private static void jugar() {
		int num = mostrarMenu("Bienvenido al juego de la vida!!\n"
				+ "1. Generar tablero aleatorio (tablero maximo de 30x30, generaciones maximas: 100)\n"
				+ "2. Realizar pruebas\n"
				+ "3. Cerrar");
		switch(num) {
			case 1:
				tableroAleatorio();
				break;
			case 2:
				pruebas();
				break;
			default:
				System.out.println("\nGracias por jugar :D");
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo 
	 */
	private static void tableroAleatorio() {
		int filas = 0;
		int columnas = 0;
		int generaciones = 0;
		ArrayList<Tripleta> resumen = new ArrayList<Tripleta>();
		
		while(filas == 0) {
			String dato = pedirDato("Introduzca el numero de filas: ");
			if(esEntero(dato)) filas = Integer.parseInt(dato);
			if(!(filas>0 && filas <=30)) filas = 0;
		}
		while(columnas == 0) {
			String dato = pedirDato("Introduzca el numero de columnas: ");
			if(esEntero(dato)) columnas = Integer.parseInt(dato);
			if(!(columnas>0 && columnas <=30)) columnas = 0;
		}
		while(generaciones == 0) {
			String dato = pedirDato("Introduzca el numero de generaciones: ");
			if(esEntero(dato)) generaciones = Integer.parseInt(dato);
			if(!(generaciones>0 && generaciones <=100)) generaciones = 0;
		}
		String[][] tabla = new String[filas][columnas];
		for(int i = 0; i< filas; i++) {
			for(int j = 0; j< columnas; j++) {
				 if((Math.random()*99)+1 <= 20) tabla[i][j] = "*";//esta condicion rellena las celdas con celulas vivas, con un 20% de posibilidad
				 else tabla[i][j] = " ";
			}
		}
		
		int vivas = contarVivas(tabla);
		int diferencia = 0;
		for(int i = 0; i<= generaciones; i++) {
			resumen.add(new Tripleta(i, contarVivas(tabla), diferencia));
			System.out.println("\nGeneracion " + i);
			imprimirTabla(tabla);
			tabla=nextGeneration(tabla, " ");
			vivas = contarVivas(tabla);
			if(vivas == 0) {
				System.out.println("\nGeneracion " + (i+1) + ":");
				imprimirTabla(tabla);
				System.out.println("Colonia extinguida");
				break;
			}
			diferencia = vivas - resumen.get(i).getVivas();
		}
		System.out.println("\nCelulas supervivientes: " + resumen.get(resumen.size()-1).getVivas() + "\n"
				+ "\nRESUMEN!!!:\n");
		for(int i = 0; i<resumen.size(); i++) {
			System.out.println(resumen.get(i).toString());
		}
	}
	
	/*
	 * Este metodo rellena las celdas null de la tabla por celdas sin celulas
	 */
	private static void rellenarTabla(String[][] tab) {
		for(int i= 0; i<tab.length; i++) {
			for(int j = 0; j < tab[i].length; j++) {
				if(tab[i][j] == null) tab[i][j]= "·";
			}
		}
	}
	/*
	 * Pre: recibe una tabla de Strings de ancho y largo >0
	 * Post: Este metodo calcula la tabla de la siguiente generacion del juego de acuerdo a las reglas de este,
	 * por medio de ciclos y condiciones
	 */
	private static String[][] nextGeneration(String[][] tab, String vacio){
		String[][] tab2 = new String[tab.length][tab[0].length];
		for(int i= 0; i<tab.length; i++) {
			for(int j = 0; j < tab[i].length; j++) {
				tab2[i][j] = tab[i][j];
				int contador = 0;
				for(int h = i-1; h<=i+1; h++) {//recorremos desde la fila superior hasta la inferior de la celda (3 lineas)
					for(int k = j-1; k<=j+1; k++) {//recorremos desde la columna de la izquierda hasta la de la derecha de la celda
						/*
						 * Con esta linea nos aseguraremos de no intentar comprobar valores por fuera de los limites de la tabla:*/
						if(!((0<=h && h<tab.length)&&(0<=k && k<tab[i].length))) continue; 
						if(h==i && k == j) continue;//Con esta linea nos aseguramos de no contar la celda actual
						if(tab[h][k].equalsIgnoreCase("*")) {
							contador++;
						}
					}
				}
				if(tab[i][j].equalsIgnoreCase(vacio)){
					if(contador==3) {
						tab2[i][j] = "*";//Nace una nueva celula
					}
				}else {
					if(contador<2 || contador>3) {
						tab2[i][j] = vacio;//La celula muere
					}
				}
			}
		}
		return tab2;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo recorre la tabla pasada como parametro, y devuelve el numero de celulas vivas en la tabla
	 */
	private static int contarVivas(String[][] tab) {
		int vivas = 0;
		for(int i= 0; i<tab.length; i++) {
			for(int j = 0; j < tab[i].length; j++) {
				if(tab[i][j].equalsIgnoreCase("*")) vivas++;
			}
		}
		return vivas;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo realiza una simulación de 30 generaciones de una 
	 * configuración inicial consistente en un patrón denominado bloque. 
	 * Esta configuración inicial consiste en un tablero de dimensión 4x4, 
	 * con sus celdas centrales ocupadas con celulas vivas
	 */
	private static void bloque() {
		String[][] tab = new String[4][4];
		tab[1][1] = tab[1][2] = tab[2][1] = tab[2][2] = "*";
		rellenarTabla(tab);
		for(int i = 1; i<=30; i++) {
			System.out.println("\nGeneracion " + i);
			imprimirTabla(tab);
			if(i==30) break;
			tab=nextGeneration(tab, "·");
		}
		System.out.println("\nCelulas supervivientes: " + contarVivas(tab));
	}
	/*
	 * Pre: ---
	 * Post: Este metodo realiza una simulación de 30 generaciones de una 
	 * configuración inicial consistente en un patrón denominado intermitente. 
	 * Esta configuración inicial consiste en un tablero de dimensión 5x5, 
	 * con tres de sus celdas centrales ocupadas con celulas vivas formando una linea.
	 */
	private static void intermitente() {
		String[][] tab = new String[5][5];
		tab[2][1] = tab[2][2] = tab[2][3] = "*";
		rellenarTabla(tab);
		for(int i = 1; i<=30; i++) {
			System.out.println("\nGeneracion " + i);
			imprimirTabla(tab);
			if(i==30) break;
			tab=nextGeneration(tab, "·");
		}
		System.out.println("\nCelulas supervivientes: " + contarVivas(tab));
	}
	/*
	 * Pre: ---
	 * Post: Este metodo realiza una simulación de 30 generaciones de una 
	 * configuración inicial consistente en un patrón denominado bloque. 
	 * Esta configuración inicial consiste en un tablero de dimensión 4x4, 
	 * con sus celdas centrales ocupadas con celulas vivas
	 */
	private static void faro() {
		String[][] tab = new String[6][6];
		tab[1][1] = tab[1][2] = tab[2][1] = tab[2][2] = tab[3][3] = tab[3][4] = tab[4][3] = tab[4][4] ="*";
		rellenarTabla(tab);
		for(int i = 1; i<=30; i++) {
			System.out.println("\nGeneracion " + i);
			imprimirTabla(tab);
			if(i==30) break;
			tab=nextGeneration(tab, "·");
		}
		System.out.println("\nCelulas supervivientes: " + contarVivas(tab));
	}
	/*
	 * Pre: ---
	 * Post: Este metodo obtiene un dato del usuario y en funcion de eso despliega diferentes
	 * metodos de prueba para el juego.
	 */
	private static void pruebas() {
		int num = mostrarMenu("Pruebas disponibles:\n"
				+ "1. Prueba con patron bloque\n"
				+ "2. Prueba con patron intermitente\n"
				+ "3. Prueba con patron faro");
		switch(num) {
			case 1:
				bloque();
				break;
			case 2:
				intermitente();
				break;
			case 3: 
				faro();
				break;
			default:
				break;
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main pone en marcha el juego de la vida, 
	 * ofreciendo opciones al usuario para jugar. Al terminar 
	 * pregunta al usuario si desea jugar de nuevo, en caso negativo, 
	 * finaliza el programa. 
	 */
	public static void main(String[] args) {
		jugar();
		String otra = "";
		while(!otra.equalsIgnoreCase("n")) {
			otra = pedirDato("¿Desea jugar de nuevo? (s/n)");
			if(otra.equalsIgnoreCase("s")) jugar();
			else if(!otra.equalsIgnoreCase("n")) System.out.println("No le he entendido");
			else System.out.println("\nGracias por jugar :D");
		}
	}
}
