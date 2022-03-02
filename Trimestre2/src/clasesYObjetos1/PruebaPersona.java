package clasesYObjetos1;

public class PruebaPersona {
	public static void main(String[] args) {
		Persona p = new Persona();
		System.out.println(p.toString());
		p.setNombre("Alvaro");
		p.setEdad(20);
		p.setSexo("H");
		System.out.println(p.toString());
		p.setAltura(1.80);
		p.setPeso(80.3);
		System.out.println(p.toString());
		System.out.println(p.calcularIMC());
	}
}
