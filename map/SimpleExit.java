package map;
public class SimpleExit extends Exit {

	public SimpleExit(Place p) {
		this.place = p;
	}

	public void use() {
		
	}
	
	public Place getPlace(){
		return this.place;
	}

}