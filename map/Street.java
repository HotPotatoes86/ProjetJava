package map;
public class Street {

	private int nbHouse;
	private String name;
	private StreetPart[] parts;
	private StreetPart streetPartHero;
	private boolean containsHero=false;

	public Street(String name, int nb) {
		this.nbHouse = nb;
		this.name = name;
		this.parts = new StreetPart[nb];
		for (StreetPart s : this.parts){
			s = new StreetPart();
		}
		this.streetPartHero = parts[0];
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