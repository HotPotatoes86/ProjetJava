package item;

import character.Hero;

public class Drink implements Item {
	
	private TypeDrink drink;
	private String name;
	private Hero hero;
	
	public static Drink createDrink(String value){
		Drink d=null;
		try{
			d= new Drink(TypeDrink.valueOf(value.toUpperCase()));
		}
		catch(Exception e){
			System.out.println("erreur");
		}
		return d;
	}	
	
	public Drink(TypeDrink drink){
		this.drink = drink;
		this.name = drink.toString().toLowerCase();
	}

	public void use(){
		this.hero.setAlcoholLevel(drink.getAlcoholLevel());
		this.hero.setAttack(drink.getAttack());
	}

	@Override
	public String toString() {
		return "" +name;
	}
	
	
}