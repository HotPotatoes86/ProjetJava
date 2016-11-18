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

	//----------------------Attributes----------------------//
	private NPC npc=null; // = la personne qui est dans la maison
	private List<Item> items;
	
	//----------------------Constructors----------------------//
	/**
	 * constructor of the class house
	 * add randomly a npc (enemy or neutral)
	 * add randomly items in the house
	 * @param name name of the inhabitant of the house
	 */
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
	
	//----------------------Getters----------------------//
	public Item getItem(Item i){
		Item res = null;
		if (this.items.contains(i)){
			for (Item it : this.items){
				if (it == i){
					res = i;
				}
			}
		}
		return res;
	}
	
	public NPC getNPC(){
		return this.npc;
	}
	
	//----------------------Methods----------------------//
	/**
	 * add an item in the list of items
	 * @param i item which will add to the list
	 */
	public void addItem(Item i){
		this.items.add(i);
	}
	
	/**
	 * delete an item of the list if the list contains its item
	 * @param i the item we want to delete
	 */
	public void deleteItem(Item i){
		if (this.items.contains(i)){
			this.items.remove(i);
		}
	}

	public void describe(){
		System.out.println("Maison de " + this.name);
	}
	

	@Override
	public boolean testdirection(String direction){
		boolean test = false;
		if (this.npc == null || this.npc instanceof Neutral || !this.npc.getStatus()){
			for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
				if (e.getKey().equals(direction)){
					test = true;
				}
			}
		}else{
			System.out.println("Un PNJ vous bloque le passage, vous devez le vaincre !");
		}
		return test;
	}
	
	/**
	 * display the elements (items) of the house's list
	 */
	public void displayItems(){
		for (Item i : this.items){
			System.out.println(i);
		}
	}
	
	/**
	 * generate items in the house
	 * choose randomly the number and the type of items in the house
	 * @return the list of items in the house
	 */
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