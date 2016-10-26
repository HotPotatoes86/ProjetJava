public class Game {

	private int counter = 0;
	private Hero hero;
	private Map map;
	private Command command;

	public void main() {
		this.hero = new Hero("nom");
		this.map = new Map();
		while (this.testjeu()){
			this.start();
		}
		throw new UnsupportedOperationException();
	}

	public void start() {
		
		throw new UnsupportedOperationException();
	}

	public boolean testjeu() {
		if (this.counter < 20 && this.command != QUIT){	// Si le jeu dure moins de 20 tours
			return true;
		}
		else{
			return false;
		}
		throw new UnsupportedOperationException();
	}

}
