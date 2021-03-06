package clasesYObjetos1;

/**
 * Los objetos de esta clase gestionan informacion sobre titulares de cuentas y 
 * las cantidades en estas.
 */

public class Cuenta {
	/*
	 * Atributos de la clase
	 */
	private String titular;
	private double cantidad;
	/*
	 * Pre: ---
	 * Post: Metodo constructor que solo necesita el nombre del titular de la cuenta
	 */
	public Cuenta(String titular) {
		this.titular = titular;
		this.cantidad = 0;
	}
	/*
	 * Pre: ---
	 * Post: Metodo constructor que requiere del nombre del titular y la cantidad en su cuenta
	 */
	public Cuenta(String titular, double cantidad) {
		this.titular = titular;
		this.cantidad = cantidad;
	}
	/*
	 * Pre: ---
	 * Post: Devuelve el nombre del titular de la cuenta
	 */
	public String getTitular() {
		return titular;
	}
	/*
	 * Pre: ---
	 * Post: Devuelve la cantidad en la cuenta
	 */
	public double getCantidad() {
		return cantidad;
	}
	/*
	 * Pre: ---
	 * Post: Cambia el nombre del titular
	 */
	public void setTitular(String titular) {
		this.titular = titular;
	}
	/*
	 * Pre: --- 
	 * Post: Cambia la cantidad en la cuenta
	 */
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	/*
	 * Pre: cantidad>0
	 * Post: Se aumenta la cantidad en la cuenta, lo ingresado debe ser mayor que cero
	 */
	public void ingresar(double cantidad) {
		if(cantidad>0) {
			this.cantidad += cantidad;
		}
	}
	/*
	 * Pre: ---
	 * Post: resta una cantidad a la cantidad en cuenta, la cantidad en cuenta no puede ser 
	 * 		 menor que cero
	 */
	public void retirar(double cantidad) {
		if(this.cantidad-cantidad<0) {
			this.cantidad = 0;
		}else {
			this.cantidad -= cantidad;
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo imprime por pantalla el titular y la cantidad en cuenta
	 */
	@Override
	public String toString() {
		return "Titular = " + titular + "\nCantidad = " + cantidad;
	}
}
