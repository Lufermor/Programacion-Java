package clasesYObjetos2;

public class Operario extends Empleado{
	
	public Operario() {
		super();
	}
	
	public Operario(String nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return "Operario : " + getNombre();
	}
}
