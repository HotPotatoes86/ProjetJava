package character;
public class Neutral extends NPC {
	
	public Neutral(String name){
		this.chooseName(name);
	}
	
	public void talk(){
		System.out.println(this.name + " : Bonjour je suis un PNJ gentil");
	}
	
	public void setHP(int hp){
		this.HP+=hp;
	}

}