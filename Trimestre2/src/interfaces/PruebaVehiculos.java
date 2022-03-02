package interfaces;

import java.util.ArrayList;

public class PruebaVehiculos {
	/*
	 * Pre: ---
	 * Post: Este metodo main hace una prueba sobre las clases coche y moto, y la interfaz vehiculo
	 */
	public static void main(String[] args) {
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		Moto m1 = new Moto("Negro");
		System.out.println(m1.acelerar(80));
		System.out.println(m1.frenar(10));
		vehiculos.add(m1);
		Moto m2 = new Moto("Rojo");
		System.out.println(m2.acelerar(120));
		System.out.println(m2.frenar(20));
		vehiculos.add(m2);
		Coche c1 = new Coche(5, "Blanco");
		System.out.println(c1.acelerar(160));
		System.out.println(c1.frenar(10));
		vehiculos.add(c1);
		System.out.println(c1.frenar(10));
		Coche c2 = new Coche(5, "Azul");
		System.out.println(c2.acelerar(130));
		System.out.println(c2.frenar(20));
		vehiculos.add(c2);
		Coche c3 = new Coche(5, "Gris");
		System.out.println(c3.acelerar(160));
		System.out.println(c3.frenar(10));
		System.out.println(c3.acelerar(60));
		vehiculos.add(c3);
		for(Vehiculo trasto:vehiculos) System.out.println(trasto.toString());
	}
}
