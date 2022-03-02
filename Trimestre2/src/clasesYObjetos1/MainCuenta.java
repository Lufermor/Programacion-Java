package clasesYObjetos1;
/*
 * Esta clase hace una prueba sobre la clase cuenta
 */
public class MainCuenta {
	/*
	 * Este metodo crea dos cuentas de clientes y realiza ingresos y retiros
	 */
	public static void main(String[] args) {
		Cuenta cliente1 = new Cuenta("Alvaro", 20000);
		cliente1.ingresar(15000);
		System.out.println(cliente1.toString());
		cliente1.setTitular("Steven");
		System.out.println(cliente1.toString());
		cliente1.retirar(5000);
		System.out.println(cliente1.toString());
		cliente1.retirar(50000);
		System.out.println(cliente1.toString());
		
		Cuenta cliente2 = new Cuenta("Alberto");
		System.out.println(cliente2.toString());
	}
}
