package map;

import java.util.ArrayList;
import java.util.List;

import item.Key;
import util.Choice;

public class Street extends Place{

	//----------------------Attributes----------------------//
	private int nbStreetPart;
	private Place[] parts;
	// test if there're a key in a simple exit (to don't block the player)
	private static boolean testSimpleExit = false;

	//----------------------Constructors----------------------//
	public Street(String name, int nb) {
		this.nbStreetPart = nb;
		this.name = name;
		this.parts = new StreetPart[this.nbStreetPart];
		//We need this to avoid a map with doors all blocked
		int partLockedExit = Choice.randomChoice(1, this.nbStreetPart-1);
		int partSimpleExit = Choice.randomChoice(0, partLockedExit-1);
		for (int i=0; i<this.nbStreetPart; i++){
			if (i == partLockedExit){
				this.parts[i] = new StreetPart(this,("s"+i),2);	// need a locked exit
			}else if (i == partSimpleExit){
				this.parts[i] = new StreetPart(this,("s"+i),1);	// need a simple exit
			}else{
				this.parts[i] = new StreetPart(this,("s"+i),0);	// need nothing
			}
		}
		this.parts[0].addExit("backward", this);
		for (int j=0; j<this.nbStreetPart; j++){
			// add exit to the near streetparts
			if (j>0){
				this.parts[j].addExit("backward",this.parts[j-1]);
			}
			if (j<(this.nbStreetPart-1)){
				this.parts[j].addExit("forward",this.parts[j+1]);
			}
		}
		this.exits.put("forward", new SimpleExit(this.parts[0]));
	}
	
	//----------------------Getters----------------------//
	@Override
	public String getName(){
		return "rue " + this.name;
	}
	
	/**
	 * @return the streetparts of the street
	 */
	public Place[] getParts() {
		return parts;
	}
	
	public int getNbStreetPart(){
		return this.nbStreetPart;
	}
	
	//----------------------Methods----------------------//
	public void describe(){
		System.out.println("Vous etes au bout de la rue " + this.name);
	}
	
	/**
	 * add an exit to the end of the street p
	 * @param cmd the command to move to the place p
	 * @param p the place you want to move to
	 */
	//StreetPart -> Street
	public void addExit1(String cmd, Place p){
		this.parts[this.nbStreetPart-1].addExit(cmd, p);
	}
	
	/**
	 * generate the key in a random house with no locked exit
	 * @param k the key we want put in a random house
	 */
	public void generatePlaceKey(Key k){
		Exit res = null;
		// we add all exit in the street in a list and we choice a random exit in this list
		// next we add the key in the house linked with the exit
		List<Exit> l = new ArrayList<>();
		for (int i=0; i<this.nbStreetPart; i++){
			// if list is not empty
			if (!this.testSimpleExit){
				if (!((StreetPart)this.parts[i]).getSimpleExit().isEmpty()){
					// we add all simple exit of the streetpart
					for (Exit e : ((StreetPart)this.parts[i]).getSimpleExit()){
						l.add(e);
					}
				}
			}else{
				// test if the key is the key of the exit 
				// we don't put the key in the house that is locked with this key
				if (!((LockedExit)((StreetPart)this.parts[i]).getExit("house1")).equals(k.getLockedExit())){
					l.add(((StreetPart)this.parts[i]).getExit("house1"));
				}
				if (!((LockedExit)((StreetPart)this.parts[i]).getExit("house2")).equals(k.getLockedExit())){
					l.add(((StreetPart)this.parts[i]).getExit("house2"));
				}			
			}
		}
		// it's okay, a key is in a simple exit
		if (!this.testSimpleExit) this.testSimpleExit = true;
		// we choose a random exit in the list with a counter
		int cpt = Choice.randomChoice(0, l.size()-1);
		for (Exit e : l){
			if (cpt==0){
				res = e;
				break;
			}else{
				cpt--;
			}
		}
		((House)res.getPlace()).addItem(k);
	}

	
	
}