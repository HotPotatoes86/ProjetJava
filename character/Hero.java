package character;

import java.util.ArrayList;
import java.util.List;

import item.Drink;
import item.Item;

public class Hero {

	private int hp = 100;
	private int attack = 10;
	private int alcoholLevel = 15;
	private List<Item> items;

	public Hero() {
		this.items = new ArrayList<>();
	}

	public void use(Item item){
		// Si le hero possede l'objet
		if (this.items.contains(item)){
			if (item instanceof Drink){
				//TODO
			}
		}
		else{
			System.out.println("Vous ne possedez pas cet objet");
		}
	}

}