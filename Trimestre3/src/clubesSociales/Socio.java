package clubesSociales;

import java.time.LocalDate;
//import java.time.temporal.TemporalAdjusters;
import java.util.Objects;

public class Socio {
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private LocalDate fIncorporacion;
	private Socio next;
	private Socio previous;
	private String clubName;
	
	public Socio(String nombre, String primerApellido, String segundoApellido, String clubName) {
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.next = null;
		this.previous = null;
		this.fIncorporacion = LocalDate.now();//.with(TemporalAdjusters.firstDayOfYear());
		this.clubName = clubName;
	}
	
	public Socio(String nombre, String primerApellido, String segundoApellido, 
				LocalDate fIncorporacion, String clubName) {
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.next = null;
		this.previous = null;
		this.fIncorporacion = fIncorporacion;
		this.clubName = clubName;
	}

	public Socio(String nombre, String primerApellido, String segundoApellido, Socio next, 
			Socio previous, LocalDate fIncorporacion, String clubName) {
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.next = next;
		this.previous = previous;
		this.fIncorporacion = fIncorporacion;
		this.clubName = clubName;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public LocalDate getFIncorporacion() {
		return fIncorporacion;
	}

	public void setFIncorporacion(LocalDate fIncorporacion) {
		this.fIncorporacion = fIncorporacion;
	}

	public Socio getNext() {
		return next;
	}

	public void setNext(Socio next) {
		this.next = next;
	}
	
	public Socio getPrevious() {
		return previous;
	}

	public void setPrevious(Socio previous) {
		this.previous = previous;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clubName, nombre, primerApellido, segundoApellido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Socio other = (Socio) obj;
		return Objects.equals(clubName, other.clubName) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(primerApellido, other.primerApellido)
				&& Objects.equals(segundoApellido, other.segundoApellido);
	}

	@Override
	public String toString() {
		String toString = "Socio [nombre= " + this.nombre + ", primer apellido= " + this.primerApellido
				+ ", segundo apellido= " + this.segundoApellido 
				+ ", fecha de incorporación= " + this.fIncorporacion ;
		if(this.getNext() == null) toString += ", next= null" + ", clubName=" + this.clubName + "]";
		else toString += ", next= " + next.getNombre() + ", clubName=" + this.clubName + "]";
		return toString;
	}
	
}
