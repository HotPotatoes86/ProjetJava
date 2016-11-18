package map;

import util.Choice;
import util.ConsoleInput;

public class EnigmaExit extends Exit{

	//----------------------Attributes----------------------//
	/**
	 * if the exit is locked (true) or not (false)
	 */
	private boolean status=true;

	//----------------------Constructors----------------------//
	public EnigmaExit(Place p) {
		this.place = p;
	}
	
	//----------------------Getters----------------------//
	public Place getPlace(){
		return this.place;
	}
	
	//----------------------Methods----------------------//
	/**
	 * unlock the exit if the user find the correct answer
	 * @param val answer of the enigma
	 */
	public void unlock(int val){
		ConsoleInput scanner = new ConsoleInput();
		int res;
		try{
			res = scanner.intScan();
			while(res != 00 && res != val){
				System.out.println("Incorrect");
				System.out.println("Veuillez saisir une autre réponse");
				res = scanner.intScan();
			}
			if (res==val){
				System.out.println("TADAAAM réponse correcte !");
				this.status = false;
			}
		}
		catch (Exception e){
			System.out.println("Veuillez saisir un entier");
		}
	}
	
	/**
	 * if the status is true, the user need to answer to an enigma
	 * else the exit is like a simple exit
	 */
	public boolean use() {
		if (!status){
			return super.use();
		}
		else{
			System.out.println("Vous devez résoudre une enigme (0 pour abandonner)");
			int x = Choice.randomChoice(0, 10);
			int y = Choice.randomChoice(0, 15);
			System.out.println(x + "*" + y + " = ?");
			this.unlock(x*y);
			if (!status){
				return super.use();
			}
			else{
				return false;
			}
		}
	}
}
