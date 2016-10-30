package map;

import java.util.Random;

import character.NPC;

public class StreetPart {

	private House[] houses;
	private NPC npc=null; // = une personne que l'on croise dans la rue
	private boolean containsHero=false;

	public StreetPart() {
		this.houses = new House[2];
		for (House h : this.houses){
			//TODO Facteur random pour maison avec/sans nom
			//Nom = NPC
			Random rand = new Random();
			// Une chance sur 2 (1 ou 2)
			int rdm = rand.nextInt(1)+1;
			if (rdm==1){
				h = new House();
			}
			else{
				h = new House("nom");
			}
		}
	}
	
	public void moveHero(String direction){
		switch (direction){
			case "left": 
				this.houses[0].moveHero();
				break;
			case "right":
				this.houses[1].moveHero();
				break;
		}	
	}
	
	public void moveHero(){
		if (this.containsHero){
			this.containsHero=false;
		}
		else{
			System.out.println("Vous arrivez devant des maisons ...");
			this.containsHero=true;
		}
	}
	
}
