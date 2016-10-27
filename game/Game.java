package game;
import java.util.Scanner;

import character.Hero;
import map.Map;

public class Game {

	// Nombre de tours
	private static int counter = 20;
	
	public void start() {
			
		// Scanner
		Scanner scanner = new Scanner(System.in);	
		
		// Choix de la taille de la carte
		System.out.println("\nVeuillez selectionner la taille de la carte :");
		System.out.println("1- Petite");
		System.out.println("2- Moyenne");
		System.out.println("3- Grande\n");
		
		// Taille de la carte par défaut
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
		
		// Instanciation du heros
		Hero hero = new Hero();
		
		/* Le jeu commence !!
		 * Le joueur effectue une action
		 */
		Command command;
		
		do{
			System.out.println("\nVeuillez saisir une action :");
			command = Command.valueOf(scanner.next().toUpperCase());
			// On effectue l'action lie a la commande
			command.action();
			// On laisse un peu de temps entre chaque action
			try{
				Thread.sleep(2000); 
			}
			catch (Exception e){
				System.out.println(e.toString());
			}
			// Le tour ne passe pas si on regarde l'aide
			if (command.toString() != "help"){
				counter--;
			}
		}while(this.testjeu(command));
		
		// Fermeture du scanner
		scanner.close();
	}

	public boolean testjeu(Command command) {
		if (counter != 0 && command.toString() != "quit"){	
		// Si le jeu dure moins de 20 tours et que le joueur ne veut pas quitter
			return true;
		}
		else{
			return false;
		}
	}	

}