package game;
import character.Hero;
import command.Command;
import command.CommandAttack;
import command.CommandGo;
import command.CommandHelp;
import command.CommandInventory;
import command.CommandLook;
import command.CommandQuit;
import command.CommandStatus;
import command.CommandTalk;
import command.CommandUse;
import map.House;
import map.LockedExit;
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
		Place p = map.getStreets()[0];	// = first street
		hero = new Hero(p);
		boolean testexit = false; //we search a house with a locked exit
		while (!testexit){
			//Street of Hero
			Street sh = ((Street)map.getStreets()[Choice.randomChoice(0, taille-1)]);
			//StreetPart of Hero
			StreetPart sth = ((StreetPart)sh.getParts()[Choice.randomChoice(0, 3)]);
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
		
		System.out.println("");
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e);
		}
		p.describe();
		System.out.println("");
		
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e);
		}
		
		System.out.println("Vous pouvez aller ici :");
		p.displayExit();
		
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e);
		}
		
		/* The game is started
		 * The player does an action
		 */
		Command command;
		do{
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
			    		break;
			    	default: break;
		    	}
			}
			catch(Exception e){
				System.out.println("\nErreur : Commande invalide");
				//e.printStackTrace();
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