package repaso1;
/*
 * Escribe un programa Java que dado un String, elimine de este los
caracteres “b” y “ac”.
 */

public class Repaso1Ejercicio4b {
	public static void main(String[] args) {
		String MyString = "Hello World"; 
        System.out.println("The string before removing character: " + MyString); 
        MyString = MyString.replace(" ", ""); 
        System.out.println("The string after removing character: " + MyString); 
	}
}
