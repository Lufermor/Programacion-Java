package interfases1;

public class EstadoMoto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*En este punto definimos los valores de los métodos de nuestro vehiculo, que fueron definidos en el interface*/  
        Moto miMoto = new Moto(); 
        miMoto.cambiaMarcha(4); 
        miMoto.acelera(5); 
        miMoto.frena(2); 
          
        System.out.println("Ahora mismo la situación de la motocicleta es :"); 
        miMoto.printStates(); 
	}

}
