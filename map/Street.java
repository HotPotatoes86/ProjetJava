package map;
public class Street {

	private int nbStreetPart;
	private String name;
	private StreetPart[] parts;
	private static int streetPartHero=0;
	private boolean containsHero=false;

	public Street(String name, int nb) {
		this.nbStreetPart = nb;
		this.name = name;
		this.parts = new StreetPart[nb];
		for (int i=0; i<nb; i++){
			this.parts[i] = new StreetPart(this);
		}
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setFirstStreet(){
		this.parts[streetPartHero].setFirst();
	}
	
	public void moveHero(String direction){
		switch (direction){
			case "forward":
				this.parts[streetPartHero].moveHero();
				streetPartHero++;
				this.parts[streetPartHero].moveHero();
				if (this.endStreet()){
					System.out.println("Vous arrivez au bout de la rue " + this.name);
				}
				break;
			case "backward":
				this.parts[streetPartHero].moveHero();
				streetPartHero--;
				this.parts[streetPartHero].moveHero();
				if (this.endStreet()){
					System.out.println("Vous arrivez au bout de la rue " + this.name);
				}
				break;
			case "left":
			case "right":
				this.parts[this.streetPartHero].moveHero(direction);
				break;
			default: break;
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
		if (streetPartHero == nbStreetPart-1){
			return true;
		}
		else{
			return false;
		}
	}

}