package practicaMiPrimerVideojuego;

public class Arma {
	private int id;
	private String nombre;
	private int ataque;
	
	public Arma(int idArma, String nombre, int ataque) {
		this.id = idArma;
		this.nombre = nombre;
		this.ataque = ataque;
	}

	public int getIdArma() {
		return id;
	}

	public void setIdArma(int idArma) {
		this.id = idArma;
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

	@Override
	public String toString() {
		return "Arma [idArma=" + id + ", nombre=" + nombre + ", ataque=" + ataque + "]";
	}
	
}
