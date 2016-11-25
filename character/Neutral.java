package character;
public class Neutral extends NPC {
	
	public Neutral(String name){
		this.chooseName(name);
	}
	
	public void talk(){
		System.out.println(this.name + " : Bonjour je suis un PNJ gentil");
		/*if (!this.items.isEmpty()){
			System.out.println("Voulez-vous " + this.items.toString());
		}
		System.out.println("Bon j'ai rendez-vous je m'en vais, amusez vous bien chez moi !");
		this.status = false;*/
	}
	
	public void setHP(int hp){
		this.HP+=hp;
	}

}