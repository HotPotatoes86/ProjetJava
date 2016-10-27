package Character;
public class Neutral extends NPC {

	// Nom = Villageois
	public Neutral() {
		
	}
	
	public Neutral(String name){
		this.NPCname = name;
	}
	
	public void talk(){
		System.out.println("Bonjour je suis un PNJ méchant");
	}

}