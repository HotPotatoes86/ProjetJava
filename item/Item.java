package item;

import character.Hero;

public interface Item {
	
		
	public int testItem();
	public static boolean testItem(String item) {
		return false;
	}
	
	public void use(Hero hero);
	public void use(Item item, Hero hero);
	
	public String getName();
}
