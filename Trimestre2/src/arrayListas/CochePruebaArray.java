package arrayListas;
import java.util.ArrayList;

public class CochePruebaArray {
	
	public static void main(String[] args) {
		ArrayList<Coche> coches = new ArrayList<Coche>();
		Coche coche1 = new Coche();
		Coche coche2 = new Coche();
		Coche coche3 = new Coche("Rojo", 4);
		Coche coche4 = new Coche("Rojo", 4);
		
		coches.add(coche1);
		coches.add(coche2);
		coches.add(coche3);
		coches.add(coche4);
		
		for(Coche coche:coches) {
			if(coche.getColor().equalsIgnoreCase("Rojo") && coche.getPuertas() == 4) {
				System.out.println(coche.toString() + "\n-------------------------------------------\n\n");
			}
		}
	}
}
