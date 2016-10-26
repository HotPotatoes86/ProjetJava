import java.util.Scanner;

public class Game {

	public void start() {
		int counter = 0;
		//Hero hero = new Hero("nom"); 
		//Map map = new Map(4);	// Difficulté = 4
		
		Command command;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Veuillez saisir une action :");
		command = Command.valueOf(scanner.next().toUpperCase());
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