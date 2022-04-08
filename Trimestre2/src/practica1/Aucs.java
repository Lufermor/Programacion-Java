package practica1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


public class Aucs {
	public static void main(String args[]) {
		/*String[] nombres = {"Antonio",	"Manuel",	"Jose",	"Francisco",	"David",	"Juan",	"Javier",	"Jose Antonio",	"Daniel",	"Jose Luis",	"Francisco Javier",	"Carlos",	"Jesus",	"Alejandro",	"Miguel",	"Jose Manuel",	"Rafael",	"Miguel Angel",	"Pablo",	"Pedro",	"Angel",	"Sergio",	"Jose Maria",	"Fernando",	"Jorge",	"Luis",	"Alberto",	"Alvaro",	"Juan Carlos",	"Adrian",	"Diego",	"Juan Jose",	"Raul",	"Ivan",	"Juan Antonio",	"Ruben",	"Enrique",	"Oscar",	"Ramon",	"Andres",	"Vicente",	"Juan Manuel",	"Santiago",	"Joaquin",	"Victor",	"Mario",	"Eduardo",	"Roberto",	"Jaime",	"Francisco Jose",	"Marcos",	"Ignacio",	"Hugo",	"Alfonso",	"Jordi",	"Ricardo",	"Salvador",	"Guillermo",	"Gabriel",	"Marc",	"Emilio",	"Mohamed",	"Gonzalo",	"Julio",	"Julian",	"Martin",	"Jose Miguel",	"Tomas",	"Agustin",	"Nicolas",	"Jose Ramon",	"Samuel",	"Ismael",	"Joan",	"Cristian",	"Felix",	"Lucas",	"Aitor",	"Hector",	"Juan Francisco",	"Iker",	"Alex",	"Jose Carlos",	"Josep",	"Sebastian",	"Mariano",	"Cesar",	"Alfredo",	"Domingo",	"Jose Angel",	"Felipe",	"Victor Manuel",	"Rodrigo",	"Jose Ignacio",	"Mateo",	"Luis Miguel",	"Jose Francisco",	"Juan Luis",	"Xavier",	"Albert",	"Gregorio",	"Pau",	"Lorenzo",	"Antonio Jose",	"Aaron",	"Borja",	"Esteban",	"Cristobal",	"Arturo",	"Eric",	"Izan",	"Mohammed",	"Jose Javier",	"Isaac",	"Joel",	"Juan Miguel",	"Antonio Jesus",	"Eugenio",	"Asier",	"Francisco Manuel",	"Jesus Maria",	"Jaume",	"Dario",	"German",	"Abel",	"Bruno",	"Jonathan",	"Unai",	"Pedro Jose",	"Ahmed",	"Jose Vicente",	"Mikel",	"Valentin",	"Marco",	"Sergi",	"Moises",	"Christian",	"Leo",	"Juan Ramon",	"Omar",	"Iñigo",	"Pol",	"Juan Pedro",	"Gerard",	"Jon",	"Manuel Jesus",	"Adolfo",	"Arnau",	"Ernesto",	"Israel",	"Miquel",	"Oriol",	"Isidro",	"Antonio Manuel",	"Adam",	"Benito",	"Bernardo",	"Gerardo",	"Jonatan",	"Eloy",	"Carmelo",	"Federico",	"Francesc",	"Jose Alberto",	"Jesus Manuel",	"Pascual",	"Luis Alberto",	"Oliver",	"Juan Jesus",	"Adria",	"Alonso",	"Roger",	"Saul",	"Kevin",	"Youssef",	"Elias",	"Iñaki",	"Matias",	"Josep Maria",	"Juan Pablo",	"Bartolome",	"Marti",	"Benjamin",	"Carles",	"Erik",	"Pere",	"Alexander",	"Guillem",	"Ander",	"Pedro Antonio",	"Carlos Alberto",	"Fermin",	"Marco Antonio",	"Marcelino",	"Lluis",	"Jose Enrique",	"Antoni",	"Angel Luis",	"Juan Ignacio",	"Abraham",	"Aurelio",	"Said",	"Julen",	"Francisco Jesus",	"Enzo",	"Aleix",	"Xabier",	"Gorka",	"Jeronimo",	"Ferran",	"Roman",	"Gustavo",	"Luis Fernando",	"Jacinto",	"Rachid",	"Leonardo",	"Manuel Angel",	"Jose Juan",	"Eusebio",	"Luis Manuel",	"Damian",	"Yeray",	"Carlos Javier",	"Jan",	"Victoriano",	"Jose David",	"Pedro Luis",	"Enric",	"Ali",	"Isidoro",	"Armando",	"Juan Bautista",	"Blas",	"Teodoro",	"Jose Joaquin",	"Dionisio",	"Eduard",	"Ian",	"Gines",	"Santos",	"Jairo",	"Eneko",	"Candido",	"Justo",	"Juan Maria",	"Julio Cesar",	"Florencio",	"Mustapha",	"Edgar",	"Francisco Antonio",	"Biel",	"Emiliano",	"Emilio Jose",	"Jose Andres",	"Nil",	"Luis Antonio",	"Simon",	"Jesus Angel",	"Luis Angel",	"Maximo",	"Serafin",	"Luis Maria",	"Faustino",	"Luca",	"Jacobo",	"Alexis",	"Igor",	"Fidel",	"Ramiro",	"Ezequiel",	"Dylan",	"Claudio",	"Hassan",	"Alexandre",	"Amador",	"Gael",	"Manuel Antonio",	"Yago",	"Francisco Miguel",	"Pedro Manuel",	"Juan Diego",	"Andreu",	"Muhammad",	"Rogelio",	"Ion",	"Jorge Luis",	"Jose Daniel",	"Jose Fernando",	"Luciano",	"Ibai",	"Mauro",	"Juan Dios",	"Joaquim",	"Carlos Manuel",	"Juan Andres",	"Juan Vicente",	"Ildefonso",	"Manuel Jose",	"Rayan",	"Iago",	"Thiago",	"Antonio Javier",	"Leandro",	"Aritz",	"Modesto",	"Cayetano",	"Antonio Miguel",	"Aimar",	"Khalid",	"Josue",	"Hamza",	"Ayoub",	"Florentino",	"Luis Javier",	"Antonio Luis",	"Luis Carlos",	"Fabian",	"Pedro Jesus",	"Paulino",	"Pedro Maria",	"Constantino",	"Abdellah",	"Nestor",	"Manel",	"Bilal",	"Eladio",	"Alan",	"Avelino",	"Celestino",	"Francesc Xavier",	"Juan Angel",	"Robert",	"Angel Manuel",	"Hicham",	"Markel",	"Saturnino",	"Fabio",	"Imanol",	"Vasile",	"Gheorghe",	"Marcelo",	"Oier",	"Rufino",	"Abdelkader",	"Ricard",	"Gaspar",	"Brais",	"Andoni",	"Luis Enrique",	"Brahim",	"Juan Alberto",	"Josu",	"Bernat",	"Clemente",	"Fernando Jose",	"Jesus Antonio",	"Basilio",	"Ibrahim",	"Raimundo",	"Roberto Carlos",	"Didac",	"Noel",	"Ioan",	"Angel Maria",	"Feliciano",	"Marcel",	"Joseba",	"Anas",	"Hilario",	"Yassine",	"Abdelaziz",	"Juan David",	"Anton",	"Evaristo",	"Pedro Pablo",	"Marcial",	"Eliseo",	"Patricio",	"Antonio Francisco",	"Abderrahim",	"Laureano",	"Mauricio",	"Adan",	"Narciso",	"Karim",	"Francisco Luis",	"Manuel Alejandro",	"Michael",	"Benigno",	"Hamid",	"Cecilio",	"Pedro Javier",	"Bernardino",	"Axel",	"Brian",	"Constantin",	"Camilo",	"Leopoldo",	"Segundo",	"Alain",	"Carlos Jose",	"Max",	"Pelayo",	"Roque",	"Marian",	"Valeriano",	"Pedro Miguel",	"Demetrio",	"Jose Gabriel",	"Francisco Borja",	"Cesareo",	"Ismail",	"Rodolfo",	"Mamadou",	"Octavio",	"Francisco Asis",	"Noah",	"Jose Felix",	"Denis",	"Zakaria",	"Jesus Miguel",	"Jose Rafael",	"Paul",	"Jamal",	"Eloi",	"Lluc",	"Jose Pedro",	"Florin",	"Luis Francisco",	"Bernabe",	"Abdeslam",	"Lazaro",	"Bienvenido",	"Manuel Francisco",	"Cipriano",	"Nicolae",	"Driss",	"Lucio",	"Anastasio",	"Jose Alejandro",	"Baltasar",	"Alberto Jose",	"Anselmo",	"Aziz",	"Amir",	"Beñat",	"Ignasi",	"Juan Enrique",	"Amadeo",	"Moussa",	"Liam",	"Teo",	"Jose Domingo",	"Jesus Javier",	"Alessandro",	"Carlos Enrique",	"Placido",	"Pablo Jose",	"Samir",	"Celso",	"Anibal",	"Gustavo Adolfo",	"Eulogio",	"Jorge Juan",	"Victor Jose",	"Fulgencio",	"Orlando",	"Ayman",	"Vicent",	"Casimiro",	"Noe",	"Juan Gabriel",	"Nabil",	"Luis Alfonso",	"Teofilo",	"Marcos Antonio",	"Ibon",	"Juan Fernando",	"Vicente Jose",	"Unax",	"Alexandru",	"Adil",	"Luis Eduardo",	"Baldomero",	"Iban",	"Yassin",	"Alejandro Jose",	"Herminio",	"Jose Pablo",	"Kilian",	"Maximino",	"Eduardo Jose",	"Norberto",	"Younes",	"Carlos Antonio",	"Gaizka",	"Aday",	"Jose Tomas",	"Jose Jesus",	"Antonio Maria"};
		System.out.println(nombres.length + "\n------");
		for(int i = 0; i<5; i++) {
			System.out.println((int)(Math.random()*(nombres.length - 1)));
		}*/
		
		/*
		String[][] tab = new String[5][5];
		tab[2][1] = tab[2][2] = tab[2][3] = "*";
		for(int i= 0; i<tab.length; i++) {
			for(int j = 0; j < tab[i].length; j++) {
				if(tab[i][j] == null) tab[i][j]= "·";
			}
		}
		for(int i= 0; i<tab.length; i++) {
			for(int j = 0; j < tab[i].length; j++) {
				int contador = 0;
				for(int h = i-1; h<=i+1; h++) {
					for(int k = j-1; k<=j+1; k++) {
						if(!((0<=h && h<tab.length)&&(0<=k && k<tab[i].length))) continue; /*Con esta linea nos aseguramos de 
																no intentar comprobar valores por fuera de los limites de la tabla*/
						/*if(h==i && k == j) continue;//Con esta linea nos aseguramos de no contar la celda actual
						//System.out.println("h = " + h + ", k = " + k);
						if(tab[h][k].equalsIgnoreCase("*")) {
							contador++;
						}
					}
				}
				System.out.println("Posicion: [" + i +"][" + j + "]: " + contador + " celulas vivas");
			}
		}*/
	
//		String codes = "{1,2,3,4,5,6,7,8,9,0}";
//		String[] codigos = codes.substring(1,codes.length()-1).split(",");
//		for(String s:codigos) System.out.println(s);
	}
}
