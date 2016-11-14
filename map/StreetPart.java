package map;

import util.*;

public class StreetPart extends Place{

	private House[] houses;

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
				this.houses[i] = new House(Name.generateName("donnees/Noms.txt",31));
			}
			this.houses[i].addExit("street",this);
			//if (Choice.randomChoice()){
				this.addExit("house"+(i+1),this.houses[i]);
			/*}else{
				this.exits.put("house"+(i+1), new EnigmaExit(this.houses[i]));
			}*/
		}
	}
	
	public void describe(){
		System.out.print("House 1 : ");
		this.houses[0].describe();
		System.out.print("House 2 : ");
		this.houses[1].describe();
	}
	
	public House[] getHouses(){
		return this.houses;
	}

}