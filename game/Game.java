package game;
import java.util.Scanner;

import character.Hero;
import map.*;

public class Game {

	// Nombre de tours
	private static int counter = 20;
	
	public void start() {
			
		//Scanner
		Scanner scanner = new Scanner(System.in);	
		
		Hero hero;
		
		//Choix de la taille de la carte
		System.out.println("\nVeuillez selectionner la taille de la carte :");
		System.out.println("1- Petite : 1 rue");
		System.out.println("2- Moyenne : 3 rues");
		
		//Taille de la carte par défaut
		int taille = 2;
		String[] choix = {"petite","moyenne"};
		boolean test=false;
		//Rentrer une valeur valide
		while (!test){
			taille = scanner.nextInt();
			if (taille > 0 && taille <=2){
				test = true;
				System.out.println("Vous avez choisi une carte " + choix[taille-1]);
			}
			else{
				System.out.println("Valeur incorrecte, reessayez");
			}
		}
		
		//On initialise la map en fonction de sa taille
		Map map;
		switch (taille){
			case 1: map = new Map(1); break;
			case 2: map = new Map(3); break;
			default: map = new Map(3);break;	
		}
		
		//Instanciation du heros
		Place p = map.getStreets()[0];	// = première rue
		//Place p2 = ((Street)p).getParts()[0];	// = première streetpart
		hero = new Hero(p);
		System.out.println("Vous pouvez aller ici :");
		p.displayExit();
		/* Le jeu commence !!
		 * Le joueur effectue une action
		 */
		Command command;
		
		do{
			System.out.println("\nVeuillez saisir une action :");
			//
			// IMPOSSIBLE DE METTRE AUTRE CHOSE QU'UNE COMMANDE ! A REGLER
			//
			command = Command.valueOf(scanner.next().toUpperCase());
			System.out.println(""); //Juste esthetique
			//On effectue l'action lie a la commande
			switch (command){
		    	case HELP:
			    	System.out.println("Commandes possibles :");
			   		for (Command c : Command.values()){
			   			System.out.println(c + c.getDescription());
		    		}
		    		break;
		    	case GO:
		    		String direction = scanner.nextLine(); 
		    		if (direction.length()>0){
		    			//On enleve l'espace devant la direction
		    			hero.go(direction.substring(1,direction.length()));
		    			//Le tour passe
		    			counter--;
		    		}else{
		    			System.out.println("Direction impossible");
		    		}
		    		break;
		    	case LOOK:
		    		String argument = scanner.nextLine(); 
		    		if (argument.length()>0){
		    			//On enleve l'espace devant l'argument
		    			hero.look(argument.substring(1,argument.length()));
		    		}else{
		    			hero.look();
		    		}
		    	default: break;
	    	}

		}while(this.testjeu(command));
		
		System.out.println("\nFIN DU JEU !");
		//Fermeture du scanner
		scanner.close();
	}

	public boolean testjeu(Command command) {
		if (counter != 0 && command.toString() != "quit"){	
		//Si le jeu dure moins de 20 tours et que le joueur ne veut pas quitter
			return true;
		}
		else{
			return false;
		}
	}	

}