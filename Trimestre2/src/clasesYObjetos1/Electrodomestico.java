package clasesYObjetos1;

public class Electrodomestico {
	protected double precioBase;
	protected String color;
	protected String consumoEnergetico;
	protected double peso;
	protected String[] colores = "blanco, negro, rojo, azul, gris".split(", ");
	protected String[] eficiencias = "A,B,C,D,E,F".split(",");
	
	protected double precioFinal;
	
	public Electrodomestico() {
		precioBase = 100;
		color = "Blanco";
		consumoEnergetico = "F";
		peso = 5;
		precioFinal();
	}
	
	public Electrodomestico(double precioBase, double peso) {
		comprobarPrecioBase(precioBase);
		comprobarPeso(peso);
		color = "Blanco";
		consumoEnergetico = "F";
		precioFinal();
	}
	
	public Electrodomestico(double precioBase, double peso, String color, String consumoEnergetico) {
		comprobarPrecioBase(precioBase);
		comprobarPeso(peso);
		comprobarColor(color);
		comprobarConsumoEnergetico(consumoEnergetico);
		precioFinal();
	}
	
	public double getPrecioBase() {
		return precioBase;
	}
	
	public void setPrecioBase(double precioBase) {
		comprobarPrecioBase(precioBase);
		precioFinal();
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		comprobarColor(color);
	}
	
	public String getConsumoEnergetico() {
		return consumoEnergetico;
	}
	
	public void setConsumoEnergetico(String consumoEnergetico) {
		comprobarConsumoEnergetico(consumoEnergetico);
		precioFinal();
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		comprobarPeso(peso);
		precioFinal();
	}
	
	public String[] getColores() {
		return colores;
	}
	
	public void setColores(String[] colores) {
		this.colores = colores;
	}
	
	public String[] getEficiencias() {
		return eficiencias;
	}
	
	public void setEficiencias(String[] eficiencias) {
		this.eficiencias = eficiencias;
	}
	
	public double getPrecioFinal() {
		return precioFinal;
	}
	//No se implementa el setter de precioFinal ya que es una variable que se calcula a partir de otros datos.
	
	/*
	 * Pre: ---
	 * Post: Este metodo comprueba si la cadena intruducida color se corresponde
	 * con alguno de los permitidos, en caso contrario
	 * introduce en la variable local el color por defecto.
	 */
	public void comprobarColor(String color) {
		this.color = "Blanco";
		for(int i = 0; i < colores.length; i++) {
			if(colores[i].equalsIgnoreCase(color)) {
				this.color = color;
				break;
			}	
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo comprueba si la cadena introducida como consumo
	 * se corresponde con alguno de los permitidos, en caso
	 * contrario, introduce en la variable local el consumo por defecto.
	 */
	public void comprobarConsumoEnergetico(String consumo) {
		this.consumoEnergetico = "F";
		for(int i = 0; i < eficiencias.length; i++) {
			if(eficiencias[i].equalsIgnoreCase(consumo)) {
				this.consumoEnergetico = consumo;
				break;
			}	
		}
	}
	/*
	 * Pre: ---
	 * Post: este metodo comprueba que el precio base del articulo es correcto,
	 * de lo contrario introduce el valor por defecto en la variable local.
	 */
	public void comprobarPrecioBase(double precio) {
		if(precio>0) {
			this.precioBase=precio;
		}else {
			this.precioBase=100;
		}
	}
	/*
	 * Pre: ---
	 * Post: este metodo comprueba que el peso del articulo es correcto,
	 * de lo contrario introduce el valor por defecto en la variable local.
	 */
	public void comprobarPeso(double peso) {
		if(peso>0) {
			this.peso=peso;
		}else {
			this.peso=5;
		}
	}
	/*
	 * Pre: ---
	 * Post: Se calcula el precio final del producto en base a los otros atributos
	 */
	public void precioFinal() {
		precioFinal = precioBase;
		
		switch(consumoEnergetico) {
		case "A":
			precioFinal += 100;
			break;
		case "B":
			precioFinal += 80;
			break;
		case "C":
			precioFinal += 60;
			break;
		case "D":
			precioFinal += 50;
			break;
		case "E":
			precioFinal += 30;
			break;
		case "F":
			precioFinal += 10;
			break;
		default: 
			precioFinal += 10;
		}
		if(0<=peso && peso<=19) {
			precioFinal += 10;
		}else if(20<=peso && peso<=49) {
			precioFinal += 50;
		}else if(50<=peso && peso<=79) {
			precioFinal += 80;
		}else if(80<=peso) {
			precioFinal += 100;
		}
		
	}
	@Override
	public String toString() {
		return "Electrodomestico -> [color = " + color + 
				", consumo = " + consumoEnergetico + ", peso = " + peso + 
				", precioBase = " + precioBase + ", precioFinal = " + 
				precioFinal + "]";
	}
}
