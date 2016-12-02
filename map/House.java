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
	private List<Item> inventory;
	
	//----------------------Constructors----------------------//
	/**
	 * constructor of the class house
	 * add randomly a npc (enemy or neutral)
	 * add randomly items in the house
	 * @param name name of the inhabitant of the house
	 */
	public House(String name) {
		this.name = name;
		//this.inventory = this.ItemGenerator();
		this.inventory = new ArrayList<Item>(this.itemGenerator());
		if (Choice.randomChoice()){
			if (Choice.randomChoice()){
				this.npc = new Enemy(this.name);
			}else{
				this.npc = new Neutral(this.name);
			}
		}
	}
	
	//----------------------Getters----------------------//
	public Item getItem(Item i){
		Item res = null;
		if (this.inventory.contains(i)){
			for (Item it : this.inventory){
				if (it == i){
					res = i;
				}
			}
		}
		return res;
	}
		
	public List<Item> getInventory() {
		return inventory;
	}

	public NPC getNPC(){
		return this.npc;
	}
	
	public void setNPC(NPC npc){
		this.npc = npc;
	}

	//----------------------Methods----------------------//
	/**
	 * remove npc from house (for the hero's house)
	 */
	public void removeNPC(){
		this.npc = null;
	}
	
	/**
	 * add an item in the list of items
	 * @param i item which will add to the list
	 */
	public void addItem(Item i){
		this.inventory.add(i);
	}
	
	/**
	 * delete an item of the list if the list contains its item
	 * @param i the item we want to delete
	 */
	public void deleteItem(Item i){
		if (this.inventory.contains(i)){
			this.inventory.remove(i);
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
		if (!this.inventory.isEmpty()){
			System.out.println("\nObjets dans la maison : ");
			for(Item i : this.inventory){
				System.out.println(i);
			}
		}else{
			System.out.println("\nLa maison ne contient pas d'objet");
		}
	}
	
	/**
	 * generate items in the house
	 * choose randomly the number and the type of items in the house
	 * @return the list of items in the house
	 */
	public List<Item> itemGenerator(){
		List<Item> items = new ArrayList<>();
		//number of items, 0 to 4
		int nbItem = Choice.randomChoice(0,4);
		for(int i=0; i<nbItem; i++){
			//1 to 3 = item's type
			int typeItem = Choice.randomChoice(1,3);
			if (typeItem == 1){
				items.add(Food.createFood());
			}else if(typeItem == 2){
				items.add(Drink.createDrink());
			}else{
				items.add(Weapon.createWeapon());
			}
		}
		return items;
	}
}