package character;

import util.ConsoleInput;

public class Neutral extends NPC {
	
	public Neutral(String name){
		this.chooseName(name);
	}
	
	public void describe(){
		if (this.status){
			System.out.print("[" + this.name + "]" + " : ");
			ConsoleInput.displayString("Bonjour je suis un PNJ gentil");
		}else{
			ConsoleInput.displayString("Il n'y a personne...");
		}
	}
	
	public void talk(Hero hero){
		if (this.item != null){
			ConsoleInput scanner = new ConsoleInput();
			System.out.print("[" + this.name + "]" + " : ");
			ConsoleInput.displayString("Voulez-vous " + this.item.toString() + " ?");
			String choice = scanner.stringScan();
			if (choice.equals("yes") || choice.equals("oui")){
				System.out.print("[" + this.name + "]" + " : ");
				ConsoleInput.displayString("Tres bien ! Le voici !");
				hero.pickUpItem(this.item);
			}else{
				System.out.print("[" + this.name + "]" + " : ");
				ConsoleInput.displayString("Ok tres bien, pas de soucis !");
			}
		}
		System.out.print("[" + this.name + "]" + " : ");
		ConsoleInput.displayString("Bon j'ai rendez-vous je m'en vais, amusez vous bien chez moi !");
		this.status = false;
	}
	
	public void setHP(int hp){
		this.HP+=hp;
	}

}