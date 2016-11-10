package item;

import character.Hero;

public class Drink implements Item {
	
	private TypeDrink drink;
	private Hero hero;
	
	public void use(){
		this.hero.setAlcoholLevel(drink.getAlcoholLevel());
		this.hero.setAttack(drink.getAttack());
	}

	@Override
	public String toString() {
		return "" +drink;
	}
	
	
}