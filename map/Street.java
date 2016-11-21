package map;

import util.Choice;

public class Street extends Place{

	//----------------------Attributes----------------------//
	private int nbStreetPart;
	private Place[] parts;

	//----------------------Constructors----------------------//
	public Street(String name, int nb) {
		this.nbStreetPart = nb;
		this.name = name;
		this.parts = new StreetPart[this.nbStreetPart];
		//We need this to avoid a map with doors all blocked
		int partLockedExit = Choice.randomChoice(1, this.nbStreetPart);
		int partSimpleExit = Choice.randomChoice(0, partLockedExit-1);
		for (int i=0; i<this.nbStreetPart; i++){
			if (i == partLockedExit){
				this.parts[i] = new StreetPart(("s"+i),2);	// need a locked exit
			}else if (i == partSimpleExit){
				this.parts[i] = new StreetPart(("s"+i),1);	// need a simple exit
			}else{
				this.parts[i] = new StreetPart(("s"+i),0);
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
	
	//----------------------Methods----------------------//
	public void describe(){
		System.out.println("Vous etes sur la rue " + this.name);
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

}