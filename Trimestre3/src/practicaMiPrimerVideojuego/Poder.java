package practicaMiPrimerVideojuego;

public class Poder {
	private int id;
	private String nombre;
	private int ataque;
	private int tipo;
	private String descripcion;
	
	public Poder(int idPoder, String nombre, int ataque, int tipo, String descripcion) {
		super();
		this.id = idPoder;
		this.nombre = nombre;
		this.ataque = ataque;
		setTipo(tipo);
		this.descripcion = descripcion;
	}

	public int getIdPoder() {
		return id;
	}

	public void setIdPoder(int idPoder) {
		this.id = idPoder;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		if(tipo==1 || tipo == 2) this.tipo = tipo;
		else this.tipo = 1;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Poder [idPoder=" + id + ", nombre=" + nombre + ", ataque=" + ataque + ", tipo=" + tipo
				+ ", descripcion=" + descripcion + "]";
	}
	
}
