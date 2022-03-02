package clasesYObjetos1;

public class Television extends Electrodomestico{
	private double resolucion;
	private boolean tdt;
	
	public Television() {
		super();
		this.resolucion = 20;
		this.tdt = false;
		precioFinal();
	}
	
	public Television(double precio, double peso) {
		super(precio, peso);
		this.resolucion = 20;
		this.tdt = false;
		precioFinal();
	}
	
	public Television(double precioBase, String color, 
			String consumo, double peso, double resolucion, boolean tdt) {
		super(precioBase, peso, color, consumo);
		comprobarResolucion(resolucion);
		this.tdt = tdt;
		precioFinal();
	}
	
	public double getResolucion() {
		return resolucion;
	}
	
	public void setResolucion(double resolucion) {
		comprobarResolucion(resolucion);
		precioFinal();
	}
	
	public boolean getTdt() {
		return tdt;
	}
	
	public void setTdt(boolean tdt) {
		this.tdt = tdt;
		precioFinal();
	}
	
	/*
	 * Pre: ---
	 * Post: este metodo comprueba que la resolución del articulo es correcta,
	 * de lo contrario introduce el valor por defecto en la variable local.
	 */
	public void comprobarResolucion(double resolucion) {
		if(resolucion>=10 && resolucion <=85) {
			this.resolucion=resolucion;
		}else {
			this.resolucion=20;
		}
	}
	
	@Override
	public void precioFinal() {
		super.precioFinal();
		if(this.resolucion > 40) this.precioFinal = 1.3*precioFinal;
		if(tdt) this.precioFinal += 50;
	}
	
	@Override
	public String toString() {
		return "Televisor -> " + super.toString() + 
				", resolucion = " + resolucion + ", TDT =" + tdt + "]";		
	}
}
