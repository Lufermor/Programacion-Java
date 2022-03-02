package clasesYObjetos2;

public class Tecnico extends Operario{
	
	public Tecnico() {
		super();
	}
	
	public Tecnico(String nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return "Operario : " + getNombre();
	}
}
