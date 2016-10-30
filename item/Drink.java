package item;

import character.Hero;

public class Drink implements Item {
	
	private TypeDrink drink;
	private Hero heros;
	
	public void use(){
		this.heros.setAlcoholLevel(drink.getAlcoholLevel());
		this.heros.setAttack(drink.getAttack());
	}
	
}