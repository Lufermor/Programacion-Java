package clasesYObjetos1;

public class Lavadora extends Electrodomestico{
private double carga;
	
	public Lavadora() {
		super();
		this.carga = 5;
		precioFinal();
	}
	
	public Lavadora(double precio, double peso) {
		super(precio, peso);
		this.carga = 5;
		precioFinal();
	}
	
	public Lavadora(double precioBase, String color, 
			String consumo, double peso, double carga) {
		super(precioBase, peso, color, consumo);
		comprobarCarga(carga);
		precioFinal();
	}

	public double getCarga() {
		return carga;
	}
	
	public void setCarga(double carga) {
		comprobarCarga(carga);
		precioFinal();
	}
	
	/*
	 * Pre: ---
	 * Post: este metodo comprueba que la carga del articulo es correcta,
	 * de lo contrario introduce el valor por defecto en la variable local.
	 */
	public void comprobarCarga(double carga) {
		if(carga>0 && carga <50) {
			this.carga=carga;
		}else {
			this.carga=5;
		}
	}

	@Override
	public void precioFinal() {
		super.precioFinal();
		if(carga > 30) {
			this.precioFinal += 50;
		}
	}
	
	@Override
	public String toString() {
		return "Lavadora -> " + super.toString() + 
				", carga = " + carga + "]";
	}
}
