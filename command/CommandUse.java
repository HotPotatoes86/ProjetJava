package command;

import character.Hero;
import item.Drink;
import item.Food;
import item.Item;
import item.Weapon;

public final class CommandUse {

	public static void useItem(Hero hero, String item){
		Item it = null;
		if(Drink.testItem(item)){
			it = new Drink(item);
		}else if (Food.testItem(item)){
			it = new Food(item);
		}else if (Weapon.testItem(item)){
			it = new Weapon(item);
		}		
		hero.use(it);
	}
	
	public static void combineItem(Hero hero, String item1, String item2){
		Item it1 = null;
		Item it2 = null;
		if(Drink.testItem(item1)){
			it1 = new Drink(item1);
		}else if (Food.testItem(item1)){
			it1 = new Food(item1);
		}else if (Weapon.testItem(item1)){
			it1 = new Weapon(item1);
		}
		if(Drink.testItem(item2)){
			it2 = new Drink(item2);
		}else if (Food.testItem(item2)){
			it2 = new Food(item2);
		}else if (Weapon.testItem(item2)){
			it2 = new Weapon(item2);
		}		
		hero.use(it1,it2);
	}
}
