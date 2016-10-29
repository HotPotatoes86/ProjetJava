package item;

import character.Hero;

public class Food implements Item {
	
	private TypeFood food;
	private Hero heros;
	
	public void use(){
		this.heros.setHp(food.getHp());
	}
	
}