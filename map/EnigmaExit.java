package map;

import java.util.Scanner;

import util.Choice;

public class EnigmaExit extends Exit{

	private boolean status=true; //Locked or Unlocked

	public EnigmaExit(Place p) {
		this.place = p;
	}
	
	public Place getPlace(){
		return this.place;
	}
	
	public void unlock(int val){
		Scanner sc = new Scanner(System.in);
		int res = sc.nextInt();
		while(res != val){
			System.out.println("Incorrect");
			System.out.println("Veuillez saisir une autre réponse");
			res = sc.nextInt();
		}
		System.out.println("TADAAAM réponse correcte !");
		this.status = false;
		sc.close();
	}
	
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
