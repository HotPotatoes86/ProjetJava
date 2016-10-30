package character;
public class Neutral extends NPC {

	// Nom = Villageois
	public Neutral() {
		
	}
	
	public Neutral(String name){
		this.NPCname = name;
	}
	
	public void talk(){
		System.out.println(this.NPCname + " : Bonjour je suis un PNJ gentil");
	}
	
	public void setHP(int hp){
		this.HP+=hp;
	}

}