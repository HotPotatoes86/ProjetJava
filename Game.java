public class Game {

	private int counter = 0;
	private Hero hero;
	private Map map;
	private Command command;

	public void main() {
		this.hero = new Hero("nom");
		this.map = new Map(4); //Difficulté = 4
		while (this.testjeu()){
			this.start();
		}
		throw new UnsupportedOperationException();
	}

	public void start() {
		
		throw new UnsupportedOperationException();
	}

	public boolean testjeu() {
		if (this.counter < 20 && this.command.getDescription() != "quit"){	
			// Si le jeu dure moins de 20 tours et que le joueur ne veut pas quitter
			return true;
		}
		else{
			return false;
		}
	}

}
