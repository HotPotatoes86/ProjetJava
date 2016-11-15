package character;

import util.Choice;

public class Enemy extends NPC {

	private int attack;
	
	/**
	 * the name of the Enemy is "Villageois"
	 * he has an attack from 10 to 25
	 */
	public Enemy() {
		// Une attaque entre 10 et 25
		Choice.randomChoice(10, 25);
	}
	
	/**
	 * Enemy has an attack from 10 to 25
	 * @param name name of the enemy
	 */
	public Enemy(String name) {
		this.name = name;
		// Une attaque entre 10 et 25
		Choice.randomChoice(10, 25);
	}
	
	/**
	 * display a simple string
	 */
	public void talk(){
		System.out.println(this.name + " : Bonjour je suis un PNJ mechant");
	}
	
	public int getAtk(){
		return this.attack;
	}
	
	public void setHP(int hp){
		this.HP+=hp;
	}
	
	/**
	 * hero loses hp (-attack of the enemy)
	 * @param hero your hero
	 */
	public void attack(Hero hero){
		hero.setHp(-this.Attack);
	}

}