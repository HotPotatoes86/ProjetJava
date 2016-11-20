package character;
public class Neutral extends NPC {

	// Nom = Villageois
	public Neutral() {
		this.attack =0;
	}
	
	public Neutral(String name){
		this.name = name;
	}
	
	public void talk(){
		System.out.println(this.name + " : Bonjour je suis un PNJ gentil");
	}
	
	public void setHP(int hp){
		this.HP+=hp;
	}

}