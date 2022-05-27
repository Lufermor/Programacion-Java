package practicaMiPrimerVideojuego;

public class Rank {
	private int id;
	private String nombre;
	private int puntos;
	
	public Rank(int id, String nombre, int puntos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.puntos = puntos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "Rank [id=" + id + ", nombre=" + nombre + ", puntos=" + puntos + "]";
	}
	
}
