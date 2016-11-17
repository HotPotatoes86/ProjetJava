package game;
import character.Hero;
import map.House;
import map.Map;
import map.Place;
import map.Street;
import map.StreetPart;
import util.Choice;
import util.ConsoleInput;

public class Game {

	//Number of turns
	private static int counter = 20;
	
	public void start() {
			
		//Scanner to read the entries
		ConsoleInput scanner = new ConsoleInput();
		
		Hero hero;
		
		//Choice of the map's size
		System.out.println("\nVeuillez selectionner la taille de la carte :");
		System.out.println("1- Petite : 1 rue");
		System.out.println("2- Moyenne : 3 rues");
		
		//Size of the map by default
		int taille = 2;
		String[] choix = {"petite","moyenne"};
		boolean test=false;
		//Enter a valid value
		while (!test){
			try{
				taille = scanner.intScan();
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
		//The map is initialized depending on the size
		Map map;
		switch (taille){
			case 1: map = new Map(1); break;
			case 2: map = new Map(3); break;
			default: map = new Map(3);break;	
		}
		
		//Instantiation of Hero
		Place p = map.getStreets()[0];	// = première rue
		hero = new Hero(p);
		//Street of Hero
		Street sh = ((Street)map.getStreets()[Choice.randomChoice(0, taille-1)]);
		//StreetPart of Hero
		StreetPart sth = ((StreetPart)sh.getParts()[Choice.randomChoice(0, 3)]);
		//House of Hero
		House hh = sth.getHouses()[Choice.randomChoice(0, 1)];
		hero.setHouse(hh);
		
		System.out.println("");
		p.describe();
		System.out.println("");
		
		System.out.println("Vous pouvez aller ici :");
		p.displayExit();
		
		/* The game is started
		 * The player does an action
		 */
		Command command;

		do{
			System.out.println("\nVeuillez saisir une action :");
			try{
				String cmd = scanner.stringScan();
				String[] parts = cmd.split(" ");
				System.out.println(parts[0]);
				command = Command.valueOf(parts[0].toUpperCase());
				System.out.println(command);
				//Nettoie la console
				/*System.out.print("\033[H\033[2J");  
			    System.out.flush(); */
				System.out.println("\n\n\n\n\n");
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
			    		String direction = parts[1];
			    		System.out.println(direction);
			    		System.out.println(direction.substring(1,direction.length()));
			    		if (direction.length()>0){
			    			//On enleve l'espace devant la direction
			    			hero.go(direction);
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
			    		String argument = parts[1];
			    		if (argument.length()>0){
			    			//On enleve l'espace devant l'argument
			    			hero.look(argument);
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
		
	}

}