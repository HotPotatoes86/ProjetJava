package item;

import character.Hero;

public class Food implements Item {
	
	private TypeFood food;
	private Hero hero;
	
	public void use(){
		this.hero.setHp(food.getHp());
	}
	
}