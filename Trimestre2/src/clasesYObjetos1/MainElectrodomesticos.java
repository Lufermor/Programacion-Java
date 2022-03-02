package clasesYObjetos1;

public class MainElectrodomesticos {
	public static void main(String[] args) {
		Electrodomestico e = new Electrodomestico();
		System.out.println(e.toString());
		
		Lavadora l = new Lavadora();
		System.out.println(l.toString());
		l.setCarga(40);
		System.out.println(l.toString());
		
		Television t = new Television();
		System.out.println(t.toString());
		t.setTdt(true);
		t.setResolucion(80);
		System.out.println(t.toString());
	}
}
