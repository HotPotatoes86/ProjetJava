package map;

public class StreetPart {

	private House[] houses;
	private House houseHero;
	private boolean containsHero=false;

	public StreetPart() {
		this.houses = new House[2];
		for (House h : this.houses){
			h = new House();
		}
	}
	
}
