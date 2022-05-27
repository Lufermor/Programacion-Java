package practicaMiPrimerVideojuego;

public class Evento {
	private int id;
	private String pregunta;
	private String respuesta1;
	private String respuesta2;
	private String consecuencia1;
	private String consecuencia2;
	private int efecto1;
	private int efecto2;
	
	public Evento(int id, String pregunta, String respuesta1, String respuesta2, String consecuencia1,
			String consecuencia2, int efecto1, int efecto2) {
		super();
		this.id = id;
		this.pregunta = pregunta;
		this.respuesta1 = respuesta1;
		this.respuesta2 = respuesta2;
		this.consecuencia1 = consecuencia1;
		this.consecuencia2 = consecuencia2;
		this.efecto1 = efecto1;
		this.efecto2 = efecto2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta1() {
		return respuesta1;
	}

	public void setRespuesta1(String respuesta1) {
		this.respuesta1 = respuesta1;
	}

	public String getRespuesta2() {
		return respuesta2;
	}

	public void setRespuesta2(String respuesta2) {
		this.respuesta2 = respuesta2;
	}

	public String getConsecuencia1() {
		return consecuencia1;
	}

	public void setConsecuencia1(String consecuencia1) {
		this.consecuencia1 = consecuencia1;
	}

	public String getConsecuencia2() {
		return consecuencia2;
	}

	public void setConsecuencia2(String consecuencia2) {
		this.consecuencia2 = consecuencia2;
	}

	public int getEfecto1() {
		return efecto1;
	}

	public void setEfecto1(int efecto1) {
		this.efecto1 = efecto1;
	}

	public int getEfecto2() {
		return efecto2;
	}

	public void setEfecto2(int efecto2) {
		this.efecto2 = efecto2;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", pregunta=" + pregunta + ", respuesta1=" + respuesta1 + ", respuesta2="
				+ respuesta2 + ", consecuencia1=" + consecuencia1 + ", consecuencia2=" + consecuencia2 + ", efecto1="
				+ efecto1 + ", efecto2=" + efecto2 + "]";
	}
	
}
