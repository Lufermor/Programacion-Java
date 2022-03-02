package clasesYObjetos2;

public class Oficial extends Operario{
	
	public Oficial() {
		super();
	}
	
	public Oficial(String nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return "Operario : " + getNombre();
	}
}
