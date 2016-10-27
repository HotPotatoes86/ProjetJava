package map;
public class Street {

	private int nbHouse;
	private String streetName;
	private House[][] house;
	private boolean containsHero=false;

	public Street(String name, int nb) {
		this.nbHouse = nb;
		this.streetName = name;
		this.house = new House[nb][2];
		for (House[] h : this.house){
			h[0] = new House("nom");
			h[1] = new House("nom");
		}
	}
	
	public void moveHeroStreet(){
		if (this.containsHero){
			this.containsHero=false;
		}
		else{
			this.containsHero=true;
		}
	}
	
	public void moveHeroHouse(){
		if (this.containsHero){
			//TODO
		}
	}

}