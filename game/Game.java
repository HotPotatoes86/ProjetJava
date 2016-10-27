package game;
import java.util.Scanner;

import map.Map;

public class Game {

	public void start() {
		
		// Nombre de tours
		int counter = 20;
		
		// Scanner
		Scanner scanner = new Scanner(System.in);	
		
		// Choix de la difficulté
		System.out.println("\nVeuillez sélectionner la difficulté du jeu :");
		System.out.println("1- Facile    (20 tours)");
		System.out.println("2- Moyen     (15 tours)");
		System.out.println("3- Difficile (10 tours)\n");
		
		// Choix de la taille de la carte
		System.out.println("\nVeuillez sélectionner la difficulté du jeu :");
		System.out.println("1- Petite");
		System.out.println("2- Moyenne");
		System.out.println("3- Grande\n");
		
		int taille = 2;
		boolean test=false;
		// Rentrer une valeur valide
		while (!test){
			taille = scanner.nextInt();
			if (taille > 0 && taille <=3){
				test = true;
				System.out.println("Taille : " + taille);
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
			default: map = new Map(5);		
		}
		
		// Le jeu commence !!
		Command command;
		
		System.out.println("Veuillez saisir une action :");
		command = Command.valueOf(scanner.next().toUpperCase());
		
		if (command.toString()=="help"){
			System.out.println("Commandes possibles :\n");
			for (Command c : Command.values()){
				System.out.println(c);
			}
		}
		
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