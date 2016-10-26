public class Map {

	private int nbStreet;
	private Street[] street;
	
	public Map(int nbStreet) {
		this.nbStreet = nbStreet;
		this.street = new Street[nbStreet];
	}

}