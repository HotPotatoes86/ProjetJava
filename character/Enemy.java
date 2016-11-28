package character;

import util.Choice;
import util.ConsoleInput;

public class Enemy extends NPC {
	
	/**
	 * Enemy has an attack from 10 to 25
	 * @param name name of the enemy
	 */
	public Enemy(String name) {
		this.chooseName(name);
		//attack between 10 and 25
		this.attack = Choice.randomChoice(8, 15);
	}
	
	/**
	 * display a simple string
	 */
	public void describe(){
		if (this.status){
			System.out.print("[" + this.name + "]" + " : ");
			ConsoleInput.displayString("Bonjour je suis un PNJ mechant");
		}else{
			ConsoleInput.displayString("Il n'y a personne...");
		}
	}
	
	public void talk(Hero hero){
		if (this.status){
			System.out.println("Le pnj refuse de vous parler.");
			this.attack(hero);
		}
	}
	
	/**
	 * hero loses hp (-attack of the enemy)
	 * @param hero your hero
	 */
	public void attack(Hero hero){
		if (this.status){
			System.out.println(this.name + " attaque, vous perdez " + this.getAttack() + "HP");
			hero.setHp(hero.getHp()-this.attack);
		}
	}

}