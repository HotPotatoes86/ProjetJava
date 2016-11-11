package map;

import character.NPC;
import util.Choice;
import util.Name;

public class StreetPart extends Place{

	private House[] houses;
	private NPC npc=null; // = une personne que l'on croise dans la rue

	public StreetPart(String name) {
		this.name = name;
		this.houses = new House[2];
		for (int i=0; i<2; i++){
			//TODO Facteur random pour maison avec/sans nom
			//Nom = NPC
			// Une chance sur 2
			if (Choice.randomChoice()){
				this.houses[i] = new House("Inconnu");
			}
			else{
				// Lire dans les donnees pour donner un nom a la rue		
				this.houses[i] = new House(Name.generateName("donnees/Noms.txt"));
			}
			this.houses[i].addExit("street",this);
			this.addExit("house"+(i+1),this.houses[i]);
		}
	}
	
	public void describe(){
		System.out.print("House 1 : ");
		this.houses[0].describe();
		System.out.print("House 2 : ");
		this.houses[1].describe();
	}

}
