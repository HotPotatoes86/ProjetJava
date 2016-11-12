package map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import character.Enemy;
import character.NPC;
import character.Neutral;
import item.Drink;
import item.Food;
import item.Item;
import item.Weapon;
import util.Choice;

public class House extends Place{

	private NPC npc=null; // = la personne qui est dans la maison
	private List<Item> items;
	
	public House(String name) {
		this.name = name;
		this.items = this.ItemGenerator();
		if (Choice.randomChoice()){
			if (Choice.randomChoice()){
				this.npc = new Enemy();
			}else{
				this.npc = new Neutral();
			}
		}
	}

	public void describe(){
		System.out.println("Maison de " + this.name);
	}
	
	@Override
	public boolean testdirection(String direction){
		boolean test = false;
		if (this.npc == null || this.npc instanceof Neutral){
			for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
				if (e.getKey().equals(direction)){
					test = true;
				}
			}
		}else{
			System.out.println("Un PNJ vous bloque le passage");
		}
		return test;
	}
	
	public NPC getNPC(){
		return this.npc;
	}
	
	public void displayItems(){
		for (Item i : this.items){
			System.out.println(i);
		}
	}
	
	public List<Item> ItemGenerator(){
		List<Item> items = new ArrayList<>();
		// nombre d'items, de 0 a 4
		int nbItem = Choice.randomChoice(0, 4);
		for(int i=0; i<nbItem; i++){
			// De 1 a 3 = type de l'objet
			int typeItem = Choice.randomChoice(1, 3);
			if (typeItem == 1){
				items.add(Drink.createDrink("vodka"));
			}else if (typeItem == 2){
				items.add(Food.createFood("chips"));
			}else if (typeItem == 3){
				items.add(Weapon.createWrink("knife"));
			}
		}
		return items;
	}

}