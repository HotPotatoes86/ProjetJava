package Map;
public class Street {

	private int nbHouse;
	private String streetName;
	private House[][] house;

	/**
	 * 
	 * @param name
	 * @param nb
	 */
	public Street(String name, int nb) {
		this.nbHouse = nb;
		this.streetName = name;
		this.house = new House[nb][2];
	}

}