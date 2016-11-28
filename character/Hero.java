package character;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import item.Drink;
import item.Food;
import item.Item;
import item.Weapon;
import map.House;
import map.Place;
import util.ConsoleInput;

public class Hero {

	//----------------------Attributes----------------------//
	private int hp = 100; //si on mange on regagne des hp
	private int attack = 10; //si on boit on fait plus de degat
	private int alcoholLevel = 15; //si on boit, le niveau d'alcool monte, si on atteint 100 = coma
	private List<Item> inventory;
	private Weapon weapon = null;
	private House house = null;
	private Place actualPlace;
	private static final int INVENTORYSIZE = 10;

	//----------------------Constructors----------------------//
	/**
	 * Constructor of Class Hero
	 * @param p initial place of the hero
	 */
	public Hero(Place p) {
		this.actualPlace = p;
		this.inventory = new ArrayList<>(INVENTORYSIZE);
		this.inventory.add(new Food("apple"));
		this.inventory.add(new Weapon("knife"));
		this.inventory.add(new Food("apple"));
		this.inventory.add(new Drink("beer"));
		this.inventory.add(new Drink("vodka"));
		this.inventory.add(new Weapon("stick"));
	}
	
	//----------------------Getters----------------------//
	
	public int getHp(){
		return this.hp;
	}
	
	public Place getPlace(){
		return this.actualPlace;
	}
	
	public int getAlcoholLevel(){
		return this.alcoholLevel;
	}
	
	public Weapon getWeapon(){
		return this.weapon;
	}
	
	public List<Item> getInventory() {
		return inventory;
	}
	
	public int getAttack() {
		return attack;
	}
	
	//----------------------Setters----------------------//
	
	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}	

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public void setHp(int hpSup){
		this.hp = hpSup;
	}

	public void setAlcoholLevel(int alcoholSup){
		this.alcoholLevel += alcoholSup;
	}

	public void setAttack(int attackSup){
		this.attack += attackSup;
	}
	
	public void setWeapon(int attackWeapon){
		this.attack += attackWeapon;
	}
	
	public void setHouse(House h){
		this.house = h;
	}
	
	//----------------------Methods----------------------//
	/**
	 * Move the Hero to the direction if it's possible
	 * @param direction direction you want to go to
	 */
	public void go(String direction){
		//if hero can go to the direction
		if (this.actualPlace.testdirection(direction)){
			if (this.actualPlace instanceof House){
				if (!((House)this.actualPlace).testdirection(direction)) return ;
			}
			//hero moves to the direction
			if (this.actualPlace.go(this,direction)){
				this.actualPlace = this.actualPlace.getNextPlace(direction);
			}
			
			//alcohol level goes down
			if (this.alcoholLevel>0) this.alcoholLevel--;
			
		}else if (this.actualPlace == this.house){
			return;
			
		}else{
				System.out.println("Direction impossible");
				System.out.println("\nDirections possibles : ");
				this.actualPlace.displayExit();
		}
	}
	
	/**
	 * Function for the winning condition
	 * @return true if the Hero is in his house
	 */
	public boolean testHouse(){
		//if the hero is in his home
		if (this.actualPlace.equals(this.house)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * method used to display items if the hero is in a house with no npc
	 * call the method displayItems from the class house
	 */
	public void displayHouseItems(){
		//display items in the house if there're no npc
		if (this.actualPlace instanceof House){
			if (((House)this.actualPlace).getNPC() != null){
				if (!((House)this.actualPlace).getNPC().getStatus()){
					((House)this.actualPlace).displayItems();
				}
			}else{
				((House)this.actualPlace).displayItems();
			}
		}
	}
	
	/**
	 * Describe the actual place of the Hero
	 */
	public void look(){
		System.out.println("Vous regardez autour de vous");
		this.actualPlace.describe();
		// display items of the house
		if (this.actualPlace instanceof House){
			((House)this.actualPlace).displayItems();
		}
	}
	
	/**
	 * describe the position s
	 * @param s direction the hero looks
	 */
	public void look(String s){
		//Description Place
		Place p = null;
		System.out.println(s);
		p = this.actualPlace.getNextPlace(s);
		if (p != null){
			switch (s){
				case "forward": System.out.println("Vous regardez devant vous"); break;
				case "backward":System.out.println("Vous regardez derriere vous"); break;
				case "house1":System.out.println("Vous regardez la maison a gauche"); break;
				case "house2":System.out.println("Vous regardez la maison a droite"); break;
				default: System.out.println("Vous regardez " + p.getName()); break;
			}
			p.describe();
		}else{
			System.out.println("Argument incorrect");
		}
	}
	
	/**
	 * attack the npc and if he's dead, he picks up his items
	 * @param npc npc you want attack
	 */
	public void attack(NPC npc){
		if (npc != null){
			//attack is calculated with attack AND alcohol level of the hero
			npc.takeDmg(this.attack+this.alcoholLevel);
			if (!npc.getStatus()){
				//npc is dead, hero pick up his items
				try{
					if (npc.item != null){
						ConsoleInput scanner = new ConsoleInput();
						System.out.println("Voulez-vous " + npc.item.toString() + " ?");
						String choice = scanner.stringScan();
						if (choice.equals("yes") || choice.equals("oui")){
							this.pickUpItem(npc.getItem());
						}
					}
				}
				catch (Exception e){
					System.out.println("Le PNJ ne possedait pas d'objets :(");
				}
			}
			//if npc is still alive, he attacks
			if (npc instanceof Enemy){
				((Enemy)npc).attack(this);
			}
			if (this.hp<=0){
				try{
					System.out.println("DEFAITE : Vous etes mort !");
					Thread.sleep(1000);
					System.exit(0);
				}
				catch (Exception e){
					System.out.println(e);
				}
			}
		}else{
			System.out.println("Vous tentez d'attaquer un ennemi invisible");
		}
	}
	
	/**
	 * talk to the NPC if Hero is in a house
	 */
	public void talk(){
		if (this.actualPlace instanceof House){
			if (((House)this.actualPlace).getNPC() != null){
				((House)this.actualPlace).getNPC().talk(this);
			}else{
				System.out.println("Vous parlez tout seul");
			}
		}else{
			System.out.println("Vous parlez a un poteau");
		}
	}
	
	/**
	 * add item from the list "chest" to the hero's inventory
	 * @param item item which add to the inventory
	 */
	public void pickUpItem(Item item, List<Item> chest){ //on ramasse l'objet
		if(this.inventory.size()<INVENTORYSIZE){
			this.inventory.add(item);
			System.out.println("Vous ramassez " +item.getName());
			chest.remove(item);
		}else{
			System.out.println("Votre inventaire est plein, veuillez jeter un objet avant dans ramasser un nouveau");
		}
	}
	
	/**
	 * add item (of PNJ) to the hero's inventory
	 * @param item item which add to the inventory
	 */
	public void pickUpItem(Item item){
		if(this.inventory.size()<INVENTORYSIZE){
			this.inventory.add(item);
			System.out.println("Vous recevez " +item.getName());
		}else{
			System.out.println("Votre inventaire est plein, l'object est detruit");
		}
	}
	
	/**
	 * remove item to the hero's inventory
	 * @param item item which remove to the inventory
	 */
	public void deleteItem(Item item){
		if(this.inventory.size() > 0){
			this.inventory.remove(item);
			System.out.println("Vous supprimez " +item.getName());
		}
	}
	
	/**
	 * display the inventory of the hero
	 */
	public void printInventory(){
		if(this.inventory.isEmpty()){
			System.out.println("inventaire vide");
		}else{
			Iterator<Item> it = this.inventory.iterator();
			int i=1;
			while(it.hasNext()){
				System.out.println("objet "+i +": " + it.next());
				i++;
			}
		}
	}
	
	/**
	 * test if hero's inventory is full
	 * @return true if hero's inventory is full
	 */
	public boolean isFull(){
		boolean full = false;
		if(this.inventory.size() == INVENTORYSIZE){
			full = true;
		}
		return full;
	}
	
	/**
	 * unequip hero's weapon
	 */
	public void unequip(){
		//System.out.println("blblb");
		this.attack -= this.weapon.addAttack();
		if(this.isFull()){
			System.out.println("Votre inventaire est plein, vous detruisez donc " +this.weapon.getName());
			deleteItem(this.weapon);
		}else{
			System.out.println("Vous remettez " + this.weapon.getName() + " dans votre inventaire");
			this.inventory.add(this.weapon);
		}
		this.weapon = null;
	}
	
	/**
	 * use an item (drink, food, weapon)
	 * @param item item you want to use
	 */
	public void use(String item){
		boolean test = false;
		for(int i=0; i<this.inventory.size() && !test; i++){
			if(this.inventory.get(i).toString().equals(item)){
				this.inventory.get(i).use(this);
				test = true;
			}
		}
		if(!test){
			System.out.println("Vous ne possedez pas cet objet");
		}
		//item.use(this);
	}
	
	/**
	 * combine 2 items with the same type
	 * @param item1 (drink, food, weapon)
	 * @param item2 (drink, food, weapon)
	 */
	public void use(String item1, String item2){
		boolean test1 = false;
		boolean test2 = false;
		int i = 0;
		int j = 0;

		for(i=0; i<this.inventory.size() && !test1; i++){
			if(this.inventory.get(i).toString().equals(item1)){
				test1 = true;
			}
		}
		for(j=0; j<this.inventory.size() && !test2; j++){
			if(this.inventory.get(j).toString().equals(item2) && j!=i-1){
				test2 = true;
			}
		}
		if(test1 && test2){
			if(i-1 != j-1){
				this.inventory.get(i-1).use(this.inventory.get(j-1), this);
			}else{
				System.out.println("Vous ne pouvez pas combiner l'objet avec lui même");
			}
			/*if(i-1 != j-1){
				hero.use(hero.getInventory().get(i-1), hero.getInventory().get(j-1));
			}else{
				System.out.println("Vous ne pouvez pas combiner l'objet avec lui même");
			}*/
		}else{
			System.out.println("Vous ne possedez pas ces 2 objets");
		}
		//item1.use(item2,this);	
	}
		
}