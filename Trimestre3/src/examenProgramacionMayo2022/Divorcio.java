package examenProgramacionMayo2022;

public class Divorcio {
	private String provincia;
	private String separacion;
	private int year;
	private int divorcios;
	
	public Divorcio(String provincia, String separacion, int year, int divorcios) {
		super();
		this.provincia = provincia;
		this.separacion = separacion;
		this.year = year;
		this.divorcios = divorcios;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getSeparacion() {
		return separacion;
	}

	public void setSeparacion(String separacion) {
		this.separacion = separacion;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDivorcios() {
		return divorcios;
	}

	public void setDivorcios(int divorcios) {
		this.divorcios = divorcios;
	}

	@Override
	public String toString() {
		return "Divorcio [provincia=" + provincia + ", separacion=" + separacion + ", year=" + year + ", divorcios="
				+ divorcios + "]";
	}
	
}
