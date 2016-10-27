package map;
public class Street {

	private int nbStreetPart;
	private String name;
	private StreetPart[] parts;
	private StreetPart streetPartHero;
	private boolean containsHero=false;

	public Street(String name, int nb) {
		this.nbStreetPart = nb;
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
	
	public void moveHero(){
		if (this.containsHero){
			this.containsHero=false;
		}
		else{
			this.containsHero=true;
		}
	}
	
	public boolean endStreet(){
		if (this.streetPartHero == this.parts[nbStreetPart-1]){
			return true;
		}
		else{
			return false;
		}
	}

}