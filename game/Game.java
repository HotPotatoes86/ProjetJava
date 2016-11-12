package game;
import java.util.Scanner;

import character.Hero;
import map.*;
import util.Choice;

public class Game {

	//Nombre de tours
	private static int counter = 20;
	
	public void start() {
			
		//Scanner pour lire les entrees
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
			try{
				taille = scanner.nextInt();
				if (taille > 0 && taille <=2){
					test = true;
					System.out.println("Vous avez choisi une carte " + choix[taille-1]);
				}
				else{
					System.out.println("Valeur incorrecte, reessayez");
				}
			}
			catch(Exception e){
				System.out.println("Erreur : veuillez saisir une taille correcte");
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
		hero = new Hero(p);
		//Street du Hero
		Street sh = ((Street)map.getStreets()[Choice.randomChoice(0, taille-1)]);
		//StreetPart du Hero
		StreetPart sth = ((StreetPart)sh.getParts()[Choice.randomChoice(0, 3)]);
		//House du Hero
		House hh = sth.getHouses()[Choice.randomChoice(0, 1)];
		hero.setHouse(hh);
		
		System.out.println("");
		p.describe();
		System.out.println("");
		
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
			// test commande, si fail -> commande help
			//
			try{
				command = Command.valueOf(scanner.next().toUpperCase());
				//Nettoie la console
				System.out.print("\033[H\033[2J");  
			    System.out.flush(); 
				//On effectue l'action lie a la commande
				switch (command){
					case ATTACK:
						if (hero.getPlace() instanceof House){
							hero.attack(((House)hero.getPlace()).getNPC());
						}else{
							System.out.println("Vous tentez d'attaquer un ennemi invisible");
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
			    			System.out.println("Erreur : veuillez saisir une direction");
			    			System.out.println("\nDirections possibles : ");
			    			hero.getPlace().displayExit();
			    		}
			    		break;
			    	case HELP:
				    	System.out.println("Commandes possibles :");
				   		for (Command c : Command.values()){
				   			System.out.println(c + c.getDescription());
			    		}
				   		break;
			    	case INVENTORY:
			    		hero.printInventory();
			    		break;
			    	case LOOK:
			    		String argument = scanner.nextLine(); 
			    		if (argument.length()>0){
			    			//On enleve l'espace devant l'argument
			    			hero.look(argument.substring(1,argument.length()));
			    		}else{
			    			hero.look();
			    		}
			    		break;
			    	case QUIT:
			    		System.out.println("Vous quittez la partie...");
			    		Thread.sleep(2000);
			    		System.exit(0);
			    		break;
			    	case STATUS:
			    		System.out.println("Caracteristiques du Hero : ");
			    		System.out.println("HP : " + hero.getHp());
			    		System.out.println("Alcoolemie : " + hero.getAlcoholLevel());
			    		System.out.println("Arme : " + hero.getWeapon());
			    		break;
			    	case TAKE:
			    		break;
			    	case TALK:
			    		hero.talk();
			    		break;
			    	case USE:
			    		break;
			    	default: break;
		    	}
			}
			catch(Exception e){
				System.out.println("\nErreur : Commande invalide");
				System.out.println("Utilisez la commande help pour afficher les commandes possibles");
			} 
		}while(counter>0 && !hero.testHouse());
		
		System.out.println("\nFIN DU JEU !");
		
		if (hero.testHouse()){
			System.out.println("VICTOIRE : Vous avez reussi a rentrer a temps");
		}else{
			System.out.println("DEFAITE : Vous n'avez pas reussi a rentrer a temps");
		}
		
		//Fermeture du scanner
		scanner.close();
	}

}