package map;
public class SimpleExit extends Exit {

	//----------------------Constructors----------------------//
	public SimpleExit(Place p) {
		this.place = p;
	}
	
	//----------------------Getters----------------------//
	public Place getPlace(){
		return this.place;
	}

}