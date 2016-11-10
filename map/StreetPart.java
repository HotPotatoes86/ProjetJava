package map;

import java.util.Random;

import character.NPC;
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
			Random rand = new Random();
			// Une chance sur 2 (1 ou 2)
			int rdm = rand.nextInt(2)+1;
			if (rdm==1){
				this.houses[i] = new House();
			}
			else{
				// Lire dans les donnees pour donner un nom a la rue
				Name n = new Name();
				
				this.houses[i] = new House(n.generateName("donnees/Noms.txt"));
			}
			this.houses[i].addExit("street",this);
			this.addExit("house"+(i+1),this.houses[i]);
		}
	}
	
	public void describe(){
		System.out.println("House 1 : ");
		this.houses[0].describe();
		System.out.println("House 2 : ");
		this.houses[1].describe();
	}

}
