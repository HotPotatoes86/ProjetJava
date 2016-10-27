package game;
import java.util.Scanner;

import map.Map;

public class Game {

	public void start() {
		
		// Nombre de tours
		int counter = 20;
		
		// Scanner
		Scanner scanner = new Scanner(System.in);	
		
		// Choix de la taille de la carte
		System.out.println("\nVeuillez selectionner la taille de la carte :");
		System.out.println("1- Petite");
		System.out.println("2- Moyenne");
		System.out.println("3- Grande\n");
		
		int taille = 2;
		String[] choix = {"petite","moyenne","grande"};
		boolean test=false;
		// Rentrer une valeur valide
		while (!test){
			taille = scanner.nextInt();
			if (taille > 0 && taille <=3){
				test = true;
				System.out.println("Vous avez choisi une carte " + choix[taille-1]);
			}
			else{
				System.out.println("Valeur incorrecte");
			}
		}
		
		// On initialise la map en fonction de sa taille
		Map map;
		switch (taille){
			case 1: map = new Map(2); break;
			case 2: map = new Map(5); break;
			case 3: map = new Map(8); break;
			default: map = new Map(5);break;	
		}
		
		/* Le jeu commence !!
		 * Le joueur effectue une action
		 */
		Command command;
		System.out.println("\nVeuillez saisir une action :");
		command = Command.valueOf(scanner.next().toUpperCase());
		command.action();
		
		// Fermeture du scanner
		scanner.close();
	}

	public boolean testjeu(int counter, Command command) {
		if (counter < 20 && command.toString() != "quit"){	
		// Si le jeu dure moins de 20 tours et que le joueur ne veut pas quitter
			return true;
		}
		else{
			return false;
		}
	}	

}