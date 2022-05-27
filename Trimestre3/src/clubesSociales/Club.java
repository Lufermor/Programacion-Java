package clubesSociales;

public class Club {
	private String nombre;
	private DoubleSociosLinkedList socios;
	private Club next;
	private Club previous;
	
	public Club(String nombre) {
		this.nombre = nombre;
		this.next = null;
		this.previous = null;
		socios = new DoubleSociosLinkedList();
	}

	public Club(String nombre, Club next) {
		this.nombre = nombre;
		this.next = next;
		this.previous = null;
		socios = new DoubleSociosLinkedList();
	}
	
	public Club(String nombre, Club next, Club previous) {
		this.nombre = nombre;
		this.next = next;
		this.previous = previous;
		socios = new DoubleSociosLinkedList();
	}

	public Club(String nombre, Club next, Club previous, DoubleSociosLinkedList socios) {
		this.nombre = nombre;
		this.next = next;
		this.previous = previous;
		this.socios = socios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DoubleSociosLinkedList getSocios() {
		return socios;
	}

	public void setSocios(DoubleSociosLinkedList socios) {
		this.socios = socios;
	}

	public Club getNext() {
		return next;
	}

	public void setNext(Club next) {
		this.next = next;
	}
	
	public Club getPrevious() {
		return previous;
	}

	public void setPrevious(Club previous) {
		this.previous = previous;
	}

	/*
	 * Pre:---
	 * Post: añade un socio al club
	 */
	public boolean add(Socio socio) {
		if(this.socios.add(socio)) {
//			System.out.println("Se ha inscrito un nuevo socio en el club " + this.nombre);
			return true;
		}else {
			System.out.println("No se ha podido inscribir el socio al club");
			return false;
		}
	}
	
	/*
	 * Pre:---
	 * Post: elimina del club el socio que se encuentre en la posición indicada
	 */
	public boolean delMember(int posicion) {
		if(this.socios.delete(posicion)) return true;
		else {
			System.out.println("No se ha podido eliminar al socio del club");
			return false;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Elimina un socio del club si sus datos básicos coinciden con los del socio que se le pasa
	 */
	public boolean delMember(Socio socio) {
		if(this.socios.delete(socio)) return true;
		else {
			System.out.println("No se ha podido eliminar al socio del club");
			return false;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Elimina un socio del club si sus datos básicos coinciden con los que se le pasan
	 */
	public boolean delMember(String nombre, String primerApellido, String segundoApellido, String clubName) {
		if(this.socios.delete(new Socio(nombre, primerApellido, segundoApellido, clubName))) return true;
		else {
			System.out.println("No se ha podido eliminar al socio del club");
			return false;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Agrega todos los socios de un club pasado como parámetro a este club
	 */
	public boolean fusion(Club otroClub) {
		Socio p = otroClub.getSocios().getFirst();
		for(int i = 0; i < otroClub.getSocios().getSize(); i++) {
			if(this.add(new Socio(p.getNombre(), p.getPrimerApellido(), 
					p.getSegundoApellido(), this.nombre))) 
				System.out.println("Socio " + p.getNombre() + " agregado");
			p = p.getNext();
		}
		return true;
	}

	/*
	 * Pre: ---
	 * Post: Método que comprueba la pertenencia o no de un socio al club, 
	 * devuelve true si pertenece, o false si no pertenece.
	 */
	public boolean comprobarPertenencia(Socio socio) {
		if(socios.comprobarPertenencia(socio)) {
			System.out.println("El socio " + socio.getNombre() + " pertenece al club " + nombre);
			return true;
		}else {
			System.out.println("El socio no pertenece al club");
			return false;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Imprime los valores básicos del club, así como los socios que son miembros
	 */
	public void imprimir() {
		System.out.println(toString());
		socios.show();
	}
	
	/*
	 * Pre: ---
	 * Post: Devuelve false si el club tiene algún socio, o true si no tiene ninguno.
	 */
	public boolean isEmpty() {
		if(socios.isEmpty()) {
			System.out.println("El club no tiene socios");
			return true;
		}else {
			System.out.println("El club tiene " + socios.getSize() + " socios.");
			return false;
		}
	}

	@Override
	public String toString() {
		String toString = "Club [nombre= " + nombre + ", socios= " + socios.getSize();
		if(next == null) toString += " next = null]";
		else toString += " next = " + next.getNombre() + "]";
		return toString;
	}
	
}
