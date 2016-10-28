package map;
public class Street {

	private int nbStreetPart;
	private String name;
	private StreetPart[] parts;
	private int streetPartHero;
	private boolean containsHero=false;

	public Street(String name, int nb) {
		this.nbStreetPart = nb;
		this.name = name;
		this.parts = new StreetPart[nb];
		for (StreetPart s : this.parts){
			s = new StreetPart();
		}
		this.streetPartHero = 0;
	}
	
	public void moveHero(String direction){
		switch (direction){
			case "forward":
				this.parts[this.streetPartHero].moveHero();
				this.streetPartHero++;
				this.parts[this.streetPartHero].moveHero();
				break;
			case "backward":
				this.parts[this.streetPartHero].moveHero();
				this.streetPartHero++;
				this.parts[this.streetPartHero].moveHero();
				break;
			case "left":
			case "right":
				this.parts[this.streetPartHero].moveHero(direction);
				break;
		}
	}
	
	public void moveHero(){
		if (this.containsHero){
			this.containsHero=false;
		}
		else{
			System.out.println("Vous arrivez sur la rue " + this.name);
			this.containsHero=true;
		}
	}
	
	public boolean endStreet(){
		if (this.streetPartHero == nbStreetPart-1){
			return true;
		}
		else{
			return false;
		}
	}

}