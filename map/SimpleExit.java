package map;
public class SimpleExit extends Exit {

	public SimpleExit(Place p) {
		this.place = p;
	}

	public void use() {
		System.out.println("Vous allez à " + this.place.getName());
	}
	
	public Place getPlace(){
		return this.place;
	}

}