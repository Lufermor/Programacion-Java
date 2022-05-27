package aeropuerto;

public class Pasajero {
	private String nombre;
	private String dni;
	private Pasajero next;
	private int avionID;
	
	public Pasajero(String nombre, String dni, Pasajero next, int avionID) {
		this.nombre = nombre;
		this.dni = dni;
		this.next = next;
		this.avionID = avionID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Pasajero getNext() {
		return next;
	}

	public void setNext(Pasajero next) {
		this.next = next;
	}

	public int getAvionID() {
		return avionID;
	}

	public void setAvionID(int avionID) {
		this.avionID = avionID;
	}

	@Override
	public String toString() {
		String toString = "Pasajero [nombre=" + this.nombre + ", dni=" + this.dni;
		if(this.getNext() == null) toString += ", next= null" + ", avionID=" + this.avionID + "]";
		else toString += ", next= " + next.getNombre() + ", avionID=" + this.avionID + "]";
		return toString;
	}
	
}
