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
	}
	
	public void moveHero(){
		if (this.containsHero){
			this.containsHero=false;
		}
		else{
			this.containsHero=true;
		}
	}

}