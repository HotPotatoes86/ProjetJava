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
		this.attack = Choice.randomChoice(10, 25);
	}
	
	/**
	 * display a simple string
	 */
	public void talk(){
		System.out.println(this.name + " : Bonjour je suis un PNJ mechant");
	}
	
	/**
	 * hero loses hp (-attack of the enemy)
	 * @param hero your hero
	 */
	public void attack(Hero hero){
		hero.setHp(-this.attack);
	}

}