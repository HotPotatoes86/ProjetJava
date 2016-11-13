package map;
public class SimpleExit extends Exit {

	public SimpleExit(Place p) {
		this.place = p;
	}
	
	public Place getPlace(){
		return this.place;
	}

}