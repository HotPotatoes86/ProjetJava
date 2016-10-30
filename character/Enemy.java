package character;
public class Enemy extends NPC {

	private int Attack;
	
	// Nom = villageois
	public Enemy() {
		
	}
	
	public Enemy(String name) {
		
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