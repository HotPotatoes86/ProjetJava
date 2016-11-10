package map;

import java.util.HashMap;

public class Street extends Place{

	private int nbStreetPart;
	private Place[] parts;

	public Street(String name, int nb) {
		this.nbStreetPart = nb;
		this.name = name;
		this.parts = new StreetPart[this.nbStreetPart];
		for (int i=0; i<this.nbStreetPart; i++){
			this.parts[i] = new StreetPart("s"+i);
		}
		System.out.println("addexit");
		for (int j=0; j<this.nbStreetPart; j++){
			System.out.println(j);
			// On ajoute une exit vers les streetparts voisines 
			if (j>0){
				this.parts[j].addExit(this.parts[j-1]);
			}
			if (j<(this.nbStreetPart-1)){
				this.parts[j].addExit(this.parts[j+1]);
			}
		}
		System.out.println("fin rue");
	}
	
	public void addExit(int type, Place p){ // type = debut (0) ou fin de rue (1)
		if (type == 0){
			this.parts[0].addExit(p);
		}
		else{
			this.parts[this.nbStreetPart-1].addExit(p);
		}
	}
	
	public void describe(){
		System.out.println("Vous arrivez sur la rue " + this.name);
	}
	
	public boolean testdirection(String direction){
		boolean test = false;
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getKey() == direction){
				test = true;
			}
		}
		return test;
	}
	
	public void go(String direction){
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getKey() == direction){
				e.getValue().use();
			}
		}
	}
	
	public Place getNextPlace(String direction){
		Place p = null;
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getKey() == direction){
				p = e.getValue().getPlace();
			}
		}
		return p;
	}

	public Place[] getParts() {
		return parts;
	}
}