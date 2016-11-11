package character;

import util.Choice;

public class Enemy extends NPC {

	private int attack;
	
	// Nom = villageois
	public Enemy() {
		// Une attaque entre 10 et 25
		Choice.randomChoice(10, 25);
	}
	
	public Enemy(String name) {
		this.name = name;
		// Une attaque entre 10 et 25
		Choice.randomChoice(10, 25);
	}
	
	public void talk(){
		System.out.println(this.name + " : Bonjour je suis un PNJ mechant");
	}
	
	public int getAtk(){
		return this.attack;
	}
	
	public void setHP(int hp){
		this.HP+=hp;
	}
	
	public void attack(Hero hero){
		hero.setHp(-this.Attack);
	}

}