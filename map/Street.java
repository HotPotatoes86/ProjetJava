package map;

import java.util.HashMap;

public class Street extends Place{

	private int nbStreetPart;
	private Place[] parts;

	public Street(String name, int nb) {
		this.nbStreetPart = nb;
		this.name = name;
		this.parts = new StreetPart[this.nbStreetPart];
		this.parts[0] = new StreetPart("s"+0);
		this.parts[1] = new StreetPart("s"+1);
		this.parts[2] = new StreetPart("s"+2);
		this.parts[3] = new StreetPart("s"+3);
		this.parts[0].addExit("backward", this);
		for (int j=0; j<this.nbStreetPart; j++){
			// On ajoute une exit vers les streetparts voisines 
			if (j>0){
				this.parts[j].addExit("backward",this.parts[j-1]);
			}
			if (j<(this.nbStreetPart-1)){
				this.parts[j].addExit("forward",this.parts[j+1]);
			}
		}
		System.out.println("Avant : ");
		this.displayExit();
		((Place)this).addExit("forward",this.parts[0]);
		System.out.println("Après : ");
		this.displayExit();
		System.out.println("/////////");
	}
	
	public void describe(){
		System.out.println("Vous arrivez sur la rue " + this.name);
	}
	
	@Override
	public void addExit(String cmd, Place p){
		this.parts[this.nbStreetPart-1].addExit("forward", p);
	}

	public Place[] getParts() {
		return parts;
	}
}