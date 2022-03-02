package practica3;

public class UsoBizi {
	//IDUsuario;RetiroDT;RetiroEstacion;AnclajeDT;AnclajeEstacion
	private String idUsuario;
	private String retiroDT;
	private String retiroEstacion;
	private String anclajeDT;
	private String anclajeEstacion;
	
	public UsoBizi() {
		this.idUsuario = "";
		this.retiroDT = "";
		this.retiroEstacion = "";
		this.anclajeDT = "";
		this.anclajeEstacion = "";
	}
	
	public UsoBizi(String idUsuario, String retiroDT, String retiroEstacion, String anclajeDT, String anclajeEstacion) {
		this.idUsuario = idUsuario;
		this.retiroDT = retiroDT;
		this.retiroEstacion = retiroEstacion;
		this.anclajeDT = anclajeDT;
		this.anclajeEstacion = anclajeEstacion;
	}
	
	public void setidUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getidUsuario() {
		return this.idUsuario;
	}
	
	public void setRetiroDT(String retiroDT) {
		this.retiroDT = retiroDT;
	}
	
	public String getRetiroDT() {
		return this.retiroDT;
	}
	
	public void setRetiroEstacion(String retiroEstacion) {
		this.retiroEstacion = retiroEstacion;
	}
	
	public String getRetiroEstacion() {
		return this.retiroEstacion;
	}
	
	public void setAnclajeDT(String anclajeDT) {
		this.anclajeDT = anclajeDT;
	}
	
	public String getAnclajeDT() {
		return this.anclajeDT;
	}
	
	public void setAnclajeEstacion(String anclajeEstacion) {
		this.anclajeEstacion = anclajeEstacion;
	}
	
	public String getAnclajeEstacion() {
		return this.anclajeEstacion;
	}
	
	@Override
	public String toString() {
		return "[IDUsuario: " + this.idUsuario + 
				", RetiroDT: " + this.retiroDT + 
				", RetiroEstacion: " + this.retiroEstacion + 
				", AnclajeDT: " + this.anclajeDT +
				", AnclajeEstacion: " + this.anclajeEstacion +"]";
		
	}
}
