package game;
import character.Hero;
import command.*;
import map.*;
import util.*;

public class Game {

	//Number of turns
	private static int counter = 20;
	
	/**
	 * initialize the map of the game
	 * @return the map of the game
	 */
	public Map initMap(){
		//Scanner to read the entries
		ConsoleInput scanner = new ConsoleInput();
				
		//Choice of the map's size
		System.out.println("\nVeuillez selectionner la taille de la carte :");
		System.out.println("1- Petite (1 rue)");
		System.out.println("2- Moyenne : (3 rues)");
				
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
					System.out.println("Vous avez choisi une carte " + choix[taille-1] + "\n");
				}	
				else{
					System.out.println("Valeur incorrecte, reessayez");
				}
			}
			catch(Exception e){
				System.out.println("Erreur : veuillez saisir une taille correcte");
			}
		}
		Map map;
		//The map is initialized depending on the size
		switch (taille){
			case 1: map = new Map(1); break;
			case 2: map = new Map(3); break;
			default: map = new Map(3);break;	
		}
		return map;
	}
	
	/**
	 * initialize the hero of the game
	 * @param map map of the game (where the hero is)
	 * @return the hero of the game
	 */
	public Hero initHero(Map map){

		//Instantiation of Hero
		Place p = map.getStreets()[0];	// = first street
		Hero hero = new Hero(p);
		boolean testexit = false; //we search a house with a locked exit
		while (!testexit){
			//Street of Hero
			Street sh = ((Street)map.getStreets()[Choice.randomChoice(0, map.getNbStreet()-1)]);
			//StreetPart of Hero
			StreetPart sth = ((StreetPart)sh.getParts()[Choice.randomChoice(0, sh.getNbStreetPart()-1)]);
			//House of Hero
			House hh;
			if (sth.getExit("house1") instanceof LockedExit){
				hh = sth.getHouses()[0];
				hero.setHouse(hh);
				testexit = true;
			}else if (sth.getExit("house2") instanceof LockedExit){
				hh = sth.getHouses()[1];
				hero.setHouse(hh);
				testexit = true;
			}
		}
		return hero;
	}
	
	/**
	 * launch the game
	 * @param map map of the game
	 * @param hero hero of the game
	 */ 
	public void start(Map map, Hero hero){
		
		//Scanner to read the entries
		ConsoleInput scanner = new ConsoleInput();
		
		//thread.sleep is used to have a better rendering on the console
		try{
			Thread.sleep(500);
		}catch(Exception e){
			System.out.println(e);
		}
		
		//describe the actual condition of the player
		hero.getPlace().describe();
		
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e);
		}
		
		//display all possible exit (only forward for the beginning) to help the player
		System.out.println("\nVous pouvez aller ici :");
		hero.getPlace().displayExit();
		
		/* The game is started
		 * The player does an action
		 */
		Command command;
		do{
			//display items if the hero is in a house with no npc
			hero.displayHouseItems();
			
			System.out.println("\nVeuillez saisir une action :");
			try{
				String cmd = scanner.stringScan();
				String[] parts = cmd.split(" ");
				//argument for the command
				String arg;
				if (parts.length>1){
					arg = parts[1];
					for (int i=2; i<parts.length; i++){
						arg+=" " + parts[i];
					}
				}else{
					arg=null;
				}
				command = Command.valueOf(parts[0].toUpperCase());
				
				//cleans the console
				System.out.print("\n\n\n");
			    
				//does the action related to the command
				switch (command){
					case ATTACK:
						CommandAttack.use(hero);
						break;
					case DELETE:
			    		CommandDelete.use(hero, parts[1]);
			    		break;
					case GO:
						CommandGo.use(hero, arg);
			    		break;
			    	case HELP:
				    	CommandHelp.use();
				   		break;
			    	case INVENTORY:
			    		CommandInventory.use(hero);
			    		break;
			    	case LOOK:
						CommandLook.use(hero, arg);
			    		break;
			    	case QUIT:
			    		CommandQuit.use();
			    		break;
			    	case STATUS:
			    		CommandStatus.use(hero);
			    		break;
			    	case TAKE:
			    		CommandTake.use(hero, parts[1]);
			    		break;
			    	case TALK:
			    		CommandTalk.use(hero);
			    		break;
			    	case USE:
			    		if(parts.length == 2){
			    			CommandUse.useItem(hero, parts[1]);
			    		}else if(parts.length == 3){
			    			CommandUse.combineItem(hero, parts[1], parts[2]);
			    		}
			    		break;
			    	case UNEQUIP:
			    		CommandUnequip.use(hero);
			    		break;
			    	default: break;
		    	}
			}
			catch(Exception e){
				System.out.println("\nErreur : Commande invalide");
				System.out.println("Utilisez la commande help pour afficher les commandes possibles");
			} 
		}while(counter>0 && !hero.testHouse() && hero.getAlcoholLevel() < 100);
		
		System.out.println("\nFIN DU JEU !");
		
		if (hero.testHouse()){
			System.out.println("VICTOIRE : Vous avez reussi a rentrer a temps");
		}else if(counter == 0){
			System.out.println("DEFAITE : Vous n'avez pas reussi a rentrer a temps");
		}else{
			System.out.println("DEFAITE : Vous faites un coma ethylique");
		}
		
	}

}