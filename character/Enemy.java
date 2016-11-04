package character;

import java.util.Random;

public class Enemy extends NPC {

	private int attack;
	
	// Nom = villageois
	public Enemy() {
		
	}
	
	public Enemy(String name) {
		Random rand = new Random();
		// Une attaque entre 10 et 25
		this.attack = rand.nextInt(16)+10;
	}
	
	public void talk(){
		System.out.println(this.NPCname + " : Bonjour je suis un PNJ mechant");
	}
	
	public void setHP(int hp){
		this.HP+=hp;
	}
	
	public void attack(Hero hero){
		hero.setHp(-this.Attack);
	}

}