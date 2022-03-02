package clasesYObjetos2;

public class Directivo extends Empleado{
	
	public Directivo() {
		super();
	}
	
	public Directivo(String nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return "Directivo: " + getNombre();
	}
}
