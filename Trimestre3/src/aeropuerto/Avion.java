package aeropuerto;

public class Avion {
	private int id;
	private SimplePasajerosLinkedList pasajeros;
	private Avion next;
	
	public Avion(int id, Avion next) {
		this.id = id;
		this.next = next;
		pasajeros = new SimplePasajerosLinkedList();
	}

	public Avion(int id, Avion next, SimplePasajerosLinkedList pasajeros) {
		this.id = id;
		this.next = next;
		this.pasajeros = pasajeros;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SimplePasajerosLinkedList getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(SimplePasajerosLinkedList pasajeros) {
		this.pasajeros = pasajeros;
	}

	public Avion getNext() {
		return next;
	}

	public void setNext(Avion next) {
		this.next = next;
	}
	
	/*
	 * Pre:---
	 * Post: añade un pasajero al avión
	 */
	public void board(Pasajero pasajero) {
		this.pasajeros.add(pasajero);
	}

	@Override
	public String toString() {
		return "Avion [id=" + id + ", pasajeros= " + pasajeros.getSize() + "]";
	}
	
}
