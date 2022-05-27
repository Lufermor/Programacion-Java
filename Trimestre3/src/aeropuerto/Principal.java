package aeropuerto;

public class Principal {
	/*
	 * Pre: ---
	 * Post: Simula el comportamiento de un aeropuerto compuesto de una cola de tamaño 2,
	 * una pila de tamaño 3 y una lista simple enlazada de aviones
	 */
	public static void main(String[] args) {
		Aeropuerto barajas = new Aeropuerto();
		barajas.getAviones().add(new Avion(123, null));
		barajas.getAviones().add(new Avion(23, null));
		System.out.println(barajas);
		barajas.getAviones().show();
		barajas.pasajeroCheckIn(new Pasajero("Luis", "123123123-H", null, 123));
		barajas.pasajeroCheckIn(new Pasajero("Elena", "321321321-D", null, 23));
		barajas.pasajeroCheckIn(new Pasajero("Carmen", "17799874-X", null, 123));
		barajas.pasajeroCheckIn(new Pasajero("Manuel", "22669988-D", null, 123));
		barajas.pasajeroBoarding();
		barajas.pasajeroBoarding();
//		System.out.println(barajas);
//		barajas.getAviones().show();
		barajas.showAvion(123);
		barajas.pasajeroBoarding();
		barajas.imprimir();
	}
}
