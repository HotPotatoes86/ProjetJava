package item;

public interface Item {
	

	/**
	 * use an object on hero
	 * @param obj is the object you use
	 */
	public void use(Object obj); 
	
	/**
	 * use an object on a second
	 * @param obj1 can be drink, food, weapon or locketExit
	 * @param obj2 can be Hero
	 */
	public void use(Object obj1, Object obj2); 
	
	public String getName();
}
