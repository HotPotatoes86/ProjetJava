package map;

import java.util.ArrayList;

import item.Key;
import util.Choice;
import util.Name;

public class StreetPart extends Place{

	//----------------------Attributes----------------------//
	/**
	 * the houses in the StreetPart
	 */
	private House[] houses;
	
	private ArrayList<Exit> simpleExits;

	
	//----------------------Constructors----------------------//
	/**
	 * initialize the houses of the StreetPart and the exits between them
	 * @param name number of the StreetPart
	 * @param test = 0 if no restriction, 1 need a simple exit, 2 need a locked exit
	 */
	public StreetPart(Street s, String name, int test) {
		this.name = name;
		this.houses = new House[2];
		this.simpleExits = new ArrayList<>();
		for (int i=0; i<2; i++){
			//1/2 chance
			if (Choice.randomChoice()){
				this.houses[i] = new House("Inconnu");
			}
			else{		
				this.houses[i] = new House(Name.generateName("donnees/Noms.txt",31));
			}
			//We need this to avoid a map with doors all blocked
			if (test==1 && i==0){
				this.addExit("house"+(i+1),this.houses[i]);
			}else if (test==2 && i==0){
<<<<<<< HEAD
				this.exits.put("house"+(i+1), 
						new LockedExit(new Key((LockedExit)this.exits.get("house"+(i+1)),
								this.houses[i].getName()),this.houses[i]));
				//parcourir la liste des maisons exeptees la maison dont on vient de creer la cle, et generer 
				//la cle de cette maison dans la liste precedente. il faut s'assurer que le jeu n'est pas 
				//bloque en mettant au moins une cle dans une maison a simple porte ou a enigme
=======
				//Locked Exit (with a key)
				Key k = new Key(Map.nbKeys);
				Map.nbKeys++;
				Exit e = new LockedExit(k,this.houses[i]);
				k.setLockedExit((LockedExit)e);
				this.exits.put("house"+(i+1), e);
>>>>>>> origin/master
			}else{
				//here the type of exit is choosed randomly
				int alea = Choice.randomChoice(0, 2);
				if (alea==0){
					this.addExit("house"+(i+1),this.houses[i]);
				}else if (alea==1){
					this.exits.put("house"+(i+1), new EnigmaExit(this.houses[i]));
				}else{
					//Locked Exit (with a key)
					Key k = new Key(Map.nbKeys);
					Map.nbKeys++;
					Exit e = new LockedExit(k,this.houses[i]);
					k.setLockedExit((LockedExit)e);
					this.exits.put("house"+(i+1), e);
					s.generatePlaceKey(k);
				}
			}
			this.houses[i].addExit("street",this);
		}
	}
	
	//----------------------Methods----------------------//
	/**
	 * describe the 2 houses of the StreetPart
	 */
	public void describe(){
		System.out.print("House 1 : Maison de " + this.houses[0].getName());
		System.out.print("House 2 : Maison de " + this.houses[1].getName());
	}
	
	public House[] getHouses(){
		return this.houses;
	}
	
	public ArrayList<Exit> getSimpleExit(){
		return this.simpleExits;
	}

}