package character;

import util.Choice;

public class Enemy extends NPC {
	
	/**
	 * Enemy has an attack from 10 to 25
	 * @param name name of the enemy
	 */
	public Enemy(String name) {
		this.chooseName(name);
		//attack between 10 and 25
		this.attack = Choice.randomChoice(3, 10);
		//this.item = randomitem;
	}
	
	/**
	 * display a simple string
	 */
	public void describe(){
		System.out.println(this.name + " : Bonjour je suis un PNJ mechant");
	}
	
	public void talk(Hero hero){
		System.out.println("Le pnj refuse de vous parler.");
	}
	
	/**
	 * hero loses hp (-attack of the enemy)
	 * @param hero your hero
	 */
	public void attack(Hero hero){
		hero.setHp(-this.attack);
	}

}