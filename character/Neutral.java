package character;

import util.ConsoleInput;

public class Neutral extends NPC {
	
	public Neutral(String name){
		this.chooseName(name);
	}
	
	public void describe(){
		System.out.println(this.name + " : Bonjour je suis un PNJ gentil");
		
	}
	
	public void talk(Hero hero){
		if (this.item != null){
			ConsoleInput scanner = new ConsoleInput();
			System.out.println(this.name + " : Voulez-vous " + this.item.toString() + " ?");
			String choice = scanner.stringScan();
			if (choice.equals("yes") || choice.equals("oui")){
				System.out.println("Tres bien ! Le voici !");
				hero.pickUpItem(this.item);
			}else{
				System.out.println("Ok pas de soucis !");
			}
		}
		System.out.println("Bon j'ai rendez-vous je m'en vais, amusez vous bien chez moi !");
		this.status = false;
	}
	
	public void setHP(int hp){
		this.HP+=hp;
	}

}