import java.util.*;
public class Bisiesto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner lectura = new Scanner(System.in);
		Scanner seguir = new Scanner(System.in);
		int year;
		String otro="s"; 
		
		do {
			System.out.println("Comprobador de años bisisestos\nIntroduce año:");
			
			year = lectura.nextInt();
			
			if(esBisiesto(year))
				System.out.println("Este año es bisieto.");
			else
				System.out.println("Este año no es bisiesto.");
			
			System.out.println("¿Desea comprobar otro año (s/n)?");
			otro = seguir.nextLine();
			
		} while (otro.equals("s"));
		
	}
	
	public static boolean esBisiesto(int a) {
		if(a%4==0 && a%100!=0 || a%400==0)
			return true;
		else
			return false;
	}
}
