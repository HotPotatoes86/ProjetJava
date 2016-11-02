package map;
public abstract class Exit {

	protected Street street;
	protected StreetPart streetPart;
	protected House house;
	
	public abstract void use();
}