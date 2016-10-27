package map;

public class StreetPart {

	private House[] houses;
	private House houseHero = null;
	private boolean containsHero=false;

	public StreetPart() {
		this.houses = new House[2];
		for (House h : this.houses){
			h = new House();
		}
	}
	
	public void moveHero(String direction){
		if (this.containsHero){
			this.containsHero=false;
		}
		else{
			this.containsHero=true;
		}
	}
	
}
