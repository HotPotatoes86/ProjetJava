package map;

import java.util.ArrayList;
import java.util.HashMap;

import item.Key;
import util.Choice;
import util.Name;

public class StreetPart extends Place{

	//----------------------Attributes----------------------//
	/**
	 * the houses in the StreetPart
	 */
	private House[] houses;
	
	private ArrayList<Exit> simpleExits = new ArrayList<>();
	
	private ArrayList<Key> keys = new ArrayList<>();

	
	//----------------------Constructors----------------------//
	/**
	 * initialize the houses of the StreetPart and the exits between them
	 * @param name number of the StreetPart
	 * @param test = 0 if no restriction, 1 need a simple exit, 2 need a locked exit
	 */
	public StreetPart(Street s, String name, int test) {
		this.name = name;
		this.houses = new House[2];
		for (int i=0; i<2; i++){
			//1/4 chance
			if (Choice.randomChoice() && Choice.randomChoice()){
				this.houses[i] = new House("Inconnu");
			}
			else{		
				this.houses[i] = new House(Name.generateName("donnees/Noms.txt",31));
			}
			//We need this to avoid a map with doors all blocked
			if (test==1 && i==0){
				this.addExit("house"+(i+1),this.houses[i]);
			}else if (test==2 && i==0){
				//Locked Exit (with a key)
				Key k = new Key(Map.nbKeys);
				Map.nbKeys++;
				Exit e = new LockedExit(k,this.houses[i]);
				k.setLockedExit((LockedExit)e);
				this.exits.put("house"+(i+1), e);
				keys.add(k);
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
					keys.add(k);
				}
			}
			this.houses[i].addExit("street",this);
		}
		this.generateListSimpleExit();
	}
	
	//----------------------Methods----------------------//
	/**
	 * describe the 2 houses of the StreetPart
	 */
	public void describe(){
		System.out.print("House 1 : Maison de " + this.houses[0].getName());
		System.out.print("House 2 : Maison de " + this.houses[1].getName());
	}
	
	public void generateListSimpleExit(){
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (!(e.getValue() instanceof LockedExit)){
				this.simpleExits.add(e.getValue());
			}
		}
	}
	
	public House[] getHouses(){
		return this.houses;
	}
	
	public ArrayList<Exit> getSimpleExit(){
		return this.simpleExits;
	}
	
	public ArrayList<Key> getKeys(){
		return this.keys;
	}

}