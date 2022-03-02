package interfaces;

public interface Vehiculo {
	/*
	 * Pre: ---
	 * Post: Disminuye la velocidad en la cantidad indicada si es posible
	 */
	public String frenar(int cuanto);
	/*
	 * Pre:---
	 * Post: aumenta la velocidad en la cantidad indicada si es posible
	 */
	public String acelerar(int cuanto);
}
