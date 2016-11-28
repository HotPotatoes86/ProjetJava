package item;

public interface Item {
	
	/**
	 * test if item is a drink, food, weapon or key	
	 * @return integer with different values for different type of item
	 */
	public int testItem();

	/**
	 * use an object on hero
	 * @param obj is the object you use
	 */
	public void use(Object obj); 
	
	/**
	 * use an object on a second
	 * @param obj1 can be drink, food, weapon or key
	 * @param obj2 can be Hero or locketExit
	 */
	public void use(Object obj1, Object obj2); 
	
	public String getName();
}
