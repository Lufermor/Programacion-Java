package repaso1;

public class Tupla {
	private String nacionalidad;
	private int drivers;
	
	public Tupla(String nacionalidad, int drivers) {
		super();
		this.nacionalidad = nacionalidad;
		this.drivers = drivers;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getDrivers() {
		return drivers;
	}

	public void setDrivers(int drivers) {
		this.drivers = drivers;
	}

	@Override
	public String toString() {
		return "TuplaDrivers [nacionalidad=" + nacionalidad + ", drivers=" + drivers + "]";
	}
	
	
}
