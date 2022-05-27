package clubesSociales;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.Scanner;

public class Menu {
	private String rutaFicheros;
	private DoubleClubesLinkedList clubes;
	private Club club;
	
	public Menu() {
		this.rutaFicheros = "";
		this.clubes = new DoubleClubesLinkedList();
		this.club = null;
	}

	public Menu(DoubleClubesLinkedList clubes) {
		this.rutaFicheros = "";
		this.clubes = clubes;
		this.club = null;
	}
	
	public Menu(String rutaFicheros) {
		this.rutaFicheros = rutaFicheros;
		this.clubes = new DoubleClubesLinkedList();
		this.club = null;
		cargarClubes(new File(rutaFicheros));
	}
	
	public String getRutaFicheros() {
		return rutaFicheros;
	}

	public void setRutaFicheros(String rutaFicheros) {
		this.rutaFicheros = rutaFicheros;
	}

	public DoubleClubesLinkedList getClubes() {
		return clubes;
	}

	public void setClubes(DoubleClubesLinkedList clubes) {
		this.clubes = clubes;
	}
	
	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
	
	/*
	 * Pre: El nombre del nuevo club no debe coincidir con un club ya existente.
	 * Post: Crea un club y lo añade a la lista
	 */
	public boolean crearClub(String nombre) {
		if(clubes.isEmpty()) {
			if(clubes.add(new Club(nombre))) return true;
			else return false;
		}else {
			Club c = clubes.getFirst();
			for(int i = 0; i < clubes.getSize(); i++) {
				if(c.getNombre().equals(nombre)) {
					System.out.println("El club ya existe");
					return false;
				}
			}
			if(clubes.add(new Club(nombre))) return true;
			else return false;
		}
	}

	/*
	 * Pre: La lista de clubes no debe estar vacía
	 * Post: elimina el club cuyo nombre se pasa como parámetro, si existe.
	 */
	public boolean eliminarClub(String nombre) {
		if(this.club.getNombre().equals(nombre)) this.club = null;
		return clubes.delete(nombre);
	}
	
	/*
	 * Pre: Los ficheros a cargar no deben tener nombres de clubes que ya estén cargados
	 * Post: Carga los datos de un club desde un fichero, y añade el club a la lista enlazada
	 */
	public boolean cargarClub(File file) {
		Club c = clubes.getFirst();
		for(int i = 0; i < clubes.getSize(); i++) {
			if(c.getNombre().equals(file.getName().split("\\.")[0])) {
				System.out.println("El club ya existe");
				return false;
			}
		}
		try {
			Scanner f = new Scanner(file);
			String clubName = f.nextLine().split(",")[0].split("=")[1].strip();
			Club club = new Club(clubName);
			clubes.add(club);
			System.out.println("Cargando el club " + clubName);
			while(f.hasNextLine()) {
				String[] datos = f.nextLine().split(",");
				String nombre = datos[0].split("=")[1].strip();
				String primerApellido = datos[1].split("=")[1].strip();
				String segundoApellido = datos[2].split("=")[1].strip();
				LocalDate fIncorporacion = LocalDate.parse(datos[3].split("=")[1].strip());
				if(club.add(new Socio(nombre, primerApellido, segundoApellido, 
						fIncorporacion, club.getNombre()))) System.out.println("Se ha cargado un socio");
			}f.close();
			return true;
		}catch (FileNotFoundException e) {
			System.out.println("El fichero " + file.getName() + " no ha podido ser leído.");
			return false;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: obtiene los nombres de los clubes en la carpeta que se le pasa, luego 
	 * llama a otro metodo para extraer los datos de cada club y añadirlo a la lista clubes.
	 */
	public void cargarClubes(File carpeta) {
		for (File file : carpeta.listFiles()) {
			if (!file.isDirectory()) {
				cargarClub(file);
			} else {
				cargarClubes(file);
			}
		}
	}
	
	/*
	 * Pre: ---
	 * Post: obtiene los nombres de los clubes en la carpeta que se le pasa, luego 
	 * llama a otro metodo para extraer los datos de cada club y añadirlo a la lista clubes.
	 */
	public void cargarClubes() {
		File carpeta = new File(rutaFicheros);
		for (File file : carpeta.listFiles()) {
			if (!file.isDirectory()) {
				cargarClub(file);
			} else {
				cargarClubes(file);
			}
		}
	}
	
	/*
	 * Pre:---
	 * Post: muestra los clubes cargados junto con sus contenidos
	 */
	public boolean visualizarClubes() {
		if(clubes.isEmpty()) {
			System.out.println("No hay clubes para mostrar");
			return false;
		}else {
			clubes.show();
			return true;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: muestra los datos básicos de los clubes guardados
	 */
	public boolean visualizarClubesNombres() {
		if(clubes.isEmpty()) {
			System.out.println("No hay clubes para mostrar");
			return false;
		}else {
			Club c = clubes.getFirst();
			for(int i= 0; i<clubes.getSize(); i++) {
				System.out.println(c.toString());
				c = c.getNext();
			}
			return true;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: devuelve, si existe, el club cuyo nombre coincide con el pasado como parámetro. 
	 */
	public boolean elegirClub(String clubName) {
		Club c = clubes.getFirst();
		for(int i = 0; i < clubes.getSize(); i++) {
			if(c.getNombre().equals(clubName)) {
				this.club = c;
				return true;
			}
			else c = c.getNext();
		}
		System.out.println("No existe ningún club que corresponda al nombre introducido");
		return false;
	}
	
	/*
	 * Pre: Debe haber un club activo en el menú.
	 * Post: Agrega un socio al club activo.
	 */
	public boolean altaSocio(String nombre, String primerApellido, String segundoApellido) {
		if(this.club == null) {
			System.out.println("No hay nigún club seleccionado");
			return false;
		}
		if(this.club.add(new Socio(nombre, primerApellido, segundoApellido, this.club.getNombre()))) {
			System.out.println("Se inscrito el socio " + nombre + " en el club " + this.club.getNombre());
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * Pre: Debe haber un club activo en el menú.
	 * Post: Elimina un socio del club activo, cuya posición en la lista 
	 * de socios del club coincida con el entero que se le pasa
	 */
	public boolean bajaSocio(int posicion) {
		if(this.club == null) {
			System.out.println("No hay nigún club seleccionado");
			return false;
		}if(this.club.delMember(posicion)) return true;
		return false;
	}
	
	/*
	 * Pre: Debe haber un club activo en el menú.
	 * Post: Elimina un socio del club activo, si sus datos coinciden con los proporcionados.
	 */
	public boolean bajaSocio(String nombre, String primerApellido, String segundoApellido) {
		if(this.club == null) {
			System.out.println("No hay nigún club seleccionado");
			return false;
		}
		if(this.club.delMember(new Socio(nombre, primerApellido, segundoApellido, this.club.getNombre()))) {
			//System.out.println("Se ha eliminado un socio del club " + this.club.getNombre());
			return true;
		}
		return false;
	}
	
	/*
	 * Pre: Debe haber un club activo en el menú.
	 * Post: muestra el nombre del club activo y su lista de socios.
	 */
	public void visualizarSociosClub() {
		if(this.club == null) System.out.println("No hay nigún club seleccionado");
		else this.club.imprimir();
	}
	
	/*
	 * Pre: Debe haber al menos dos clubes en lista. Debe haber un club activo en el menú.
	 * 		El nombre pasado como parámetro no debe ser el mismo que el del club activo.
	 * 		Debe existir un club con un nombre igual al que se pasa como parámetro.
	 * Post: Añade todos los socios del club cuyo nombre se añada como parámetro al club activo
	 */
	public boolean fusionarClub(String nombre) {
		if(this.club == null) {
			System.out.println("No hay ningún club seleccionado");
			return false;
		}else if(this.club.getNombre().equals(nombre)) {
			System.out.println("No es posible fusionar un club consigo mismo.");
			return false;
		}else {
			Club c = clubes.getFirst();
			for(int i = 0; i < clubes.getSize(); i++) {
				if(c.getNombre().equals(nombre)) {
					this.club.fusion(c);
					clubes.delete(nombre);
					System.out.println("Se ha fusionado el club " + nombre + 
									" al club " + this.club.getNombre());
					return true;
				}
				c = c.getNext();
			}
			System.out.println("No hay ningun club con el nombre proporcionado");
			return false;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Método que comprueba la pertenencia o no de un socio al club seleccionado
	 */
	public boolean comprobarPertenencia(String nombre, String primerApellido, String segundoApellido) {
		if(this.club == null) {
			System.out.println("No hay nigún club seleccionado");
			return false;
		}
		else {
			Socio s = new Socio(nombre, primerApellido, segundoApellido, this.club.getNombre());
			if(this.club.comprobarPertenencia(s)) return true;
			else return false;
		}
	}

	/*
	 * Pre: ---
	 * Post: comprueba si el club seleccionado está vacío, si lo está devuelve true, sino, devuelve false.
	 */
	public boolean isClubEmpty() {
		if(this.club == null) {
			System.out.println("No hay nigún club seleccionado");
			return false;
		}
		return this.club.isEmpty();
	}
	
	/*
	 * Pre: ---
	 * Post: Guarda los datos del club que recibe en un fichero csv
	 */
	public void guardarClubFichero(Club club){
		String newFile = "" + rutaFicheros + club.getNombre() + ".csv";
		try {
			Formatter salida = new Formatter(newFile);
			salida.format(club.toString() + "\n");
			Socio p = club.getSocios().getFirst();
			for(int i = 1; i <= club.getSocios().getSize(); i++) {
				salida.format("[" +i + "] -> " + p.toString() + "\n");
				p = p.getNext();
			}salida.close();
			System.out.println("club " + club.getNombre() + " guardado");
		}catch (FileNotFoundException e1) {
			System.out.println("El fichero " + newFile + " no ha podido ser creado.");
		}	
	}
	
	/*
	 * Pre: La lista de clubes no debe estar vacía
	 * Post: Guarda los datos de todos los clubes de la lista en ficheros csv, un fichero por club.
	 */
	public boolean guardarClubes() {
		if(clubes.isEmpty()) {
			System.out.println("No hay ningún club para guardar.");
			return false;
		}else {
			Club c = clubes.getFirst();
			for(int i = 0; i < clubes.getSize(); i++) {
				guardarClubFichero(c);
				c = c.getNext();
			}
			return true;
		}
	}
}
