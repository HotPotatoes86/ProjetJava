package map;

import util.Choice;
import util.ConsoleInput;

public class EnigmaExit extends Exit{

	/**
	 * if the exit is locked (true) or not (false)
	 */
	private boolean status=true;

	public EnigmaExit(Place p) {
		this.place = p;
	}
	
	public Place getPlace(){
		return this.place;
	}
	
	/**
	 * unlock the exit if the user find the correct answer
	 * @param val answer of the enigma
	 */
	public void unlock(int val){
		ConsoleInput scanner = new ConsoleInput();
		int res = scanner.intScan();
		while(res != val){
			System.out.println("Incorrect");
			System.out.println("Veuillez saisir une autre réponse");
			res = scanner.intScan();
		}
		System.out.println("TADAAAM réponse correcte !");
		this.status = false;
	}
	
	/**
	 * if the status is true, the user need to answer to an enigma
	 * else the exit is like a simple exit
	 */
	public void use() {
		if (!status){
			super.use();
		}
		else{
			System.out.println("Vous devez résoudre une enigme");
			int x = Choice.randomChoice(0, 20);
			int y = Choice.randomChoice(0, 50);
			System.out.println(x + "*" + y + " = ?");
			this.unlock(x*y);
		}
	}
}
