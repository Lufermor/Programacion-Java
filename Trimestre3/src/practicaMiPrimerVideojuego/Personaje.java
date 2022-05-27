package practicaMiPrimerVideojuego;

public class Personaje {
	private int id;
	private String nombre;
	private int vida;
	private String habilidad;
	private String descripcionHabilidad;
	private int efectoHabilidad;
	private int tipoHabilidad;
	
	public Personaje(int id, String nombre, int vida, String habilidad, String descripcionHabilidad,
			int efectoHabilidad, int tipoHabilidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.vida = vida;
		this.habilidad = habilidad;
		this.descripcionHabilidad = descripcionHabilidad;
		this.efectoHabilidad = efectoHabilidad;
		setTipoHabilidad(tipoHabilidad);
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

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

	public String getDescripcionHabilidad() {
		return descripcionHabilidad;
	}

	public void setDescripcionHabilidad(String descripcionHabilidad) {
		this.descripcionHabilidad = descripcionHabilidad;
	}

	public int getEfectoHabilidad() {
		return efectoHabilidad;
	}

	public void setEfectoHabilidad(int efectoHabilidad) {
		this.efectoHabilidad = efectoHabilidad;
	}

	public int getTipoHabilidad() {
		return tipoHabilidad;
	}

	public void setTipoHabilidad(int tipoHabilidad) {
		if(tipoHabilidad==1 || tipoHabilidad==2) {
			this.tipoHabilidad = tipoHabilidad;
		}else this.tipoHabilidad =1;
	}

}
