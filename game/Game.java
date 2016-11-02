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
		
		// Instanciation du heros
		Hero hero = new Hero();
		
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
			case 1: map = new Map(hero,1); break;
			case 2: map = new Map(hero,3); break;
			case 3: map = new Map(hero,6); break;
			default: map = new Map(hero,3);break;	
		}
		
		/* Le jeu commence !!
		 * Le joueur effectue une action
		 */
		Command command;
		
		do{
			System.out.println("\nVeuillez saisir une action :");
			command = Command.valueOf(scanner.next().toUpperCase());
			// On effectue l'action lie a la commande
			switch (command.toString()){
		    	case "help": 
		    		System.out.println("Commandes possibles :");
		    		for (Command c : Command.values()){
		    			System.out.println(c);
		    		}
		    		break;
		    	case "go":
		    		String direction = scanner.nextLine();
		    		if (!direction.equalsIgnoreCase(" forward") && !direction.equalsIgnoreCase(" backward") &&
		    			!direction.equalsIgnoreCase(" left") && !direction.equalsIgnoreCase(" right")){;
		    			System.out.println("Direction incorrecte");
		    		}
		    		else{
		    			// On enleve l'espace devant la direction
		    			map.moveHero(direction.substring(1,direction.length()));
		    		}
		    		break;
		    	default: break;
	    	}
			// On laisse un peu de temps entre chaque action
			try{
				Thread.sleep(2000); 
			}
			catch (Exception e){
				System.out.println(e.toString());
			}
			// Le tour passe seulement si le joueur se deplace
			if (command.toString() == "go"){
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