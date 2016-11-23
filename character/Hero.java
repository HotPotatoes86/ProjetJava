package character;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import item.Food;
import item.Item;
import item.Weapon;
import map.House;
import map.Place;

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
		this.inventory.add(new Food("apple"));
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
		this.hp += hpSup;
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
		if (actualPlace.testdirection(direction)){
			if (this.actualPlace instanceof House){
				if (!((House)this.actualPlace).testdirection(direction)) return ;
			}
			//hero moves to the direction
			if (this.actualPlace.go(direction)){
				this.actualPlace = this.actualPlace.getNextPlace(direction);
				/*if (this.actualPlace instanceof House){
					
				}*/
			}
			
			//alcohol level goes down
			if (this.alcoholLevel>0) this.alcoholLevel--;
			
			//we display the new possible exits
			System.out.println("\nVous pouvez aller ici :");
			this.actualPlace.displayExit();
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
	 * Describe the actual place of the Hero
	 */
	public void look(){
		System.out.println("Vous regardez autour de vous");
		this.actualPlace.describe();
	}
	
	/**
	 * describe the position s
	 * @param s direction the hero looks
	 */
	public void look(String s){
		//Description Place
		Place p = null;
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
			//On calcule l'attack du hero en fonction de son attack et de son alcoolemie
			npc.takeDmg(this.attack+this.alcoholLevel);
			if (!npc.getStatus()){
				//NPC mort, on ramasse les items
				try{
					for (Item i : npc.getItems()){
						//choose items to pick up
						this.pickUpItem(i, npc.getItems());
					}
				}
				catch (Exception e){
					System.out.println("Pas d'objets :(");
				}
			}
			System.out.println(npc.getName() + " riposte, vous perdez " + npc.getAttack() + "HP");
			this.hp -= npc.getAttack();
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
				((House)this.actualPlace).getNPC().talk();
			}else{
				System.out.println("Vous parlez tout seul");
			}
		}else{
			System.out.println("Vous parlez a un poteau");
		}
	}
	
	/**
	 * add item to the hero's inventory
	 * @param item item which add to the inventory
	 */
	public void pickUpItem(Item item, List<Item> chest){ //on ramasse l'objet
		if(this.inventory.size()<INVENTORYSIZE){
			this.inventory.add(item);
			chest.remove(item);
		}else{
			System.out.println("Votre inventaire est plein, veuillez jeter un objet avant dans ramasser un nouveau");
		}
	}
	
	public void deleteItem(Item item){
		if(this.inventory.size() > 0){
			this.inventory.remove(item);
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
	
	public boolean isFull(){
		boolean full = false;
		if(this.inventory.size() == INVENTORYSIZE){
			full = true;
		}
		return full;
	}
	
	public void unequip(){
		this.attack -= this.weapon.addAttack();
		if(this.isFull()){
			deleteItem(this.weapon);
		}else{
			this.inventory.add(this.weapon);
		}
		this.weapon = null;
	}
	
	/**
	 * use an item (drink, food, weapon)
	 * @param item item you want to use
	 */
	public void use(Item item){
		//if the hero have the item
		item.use(this);
	}
	
	public void use(Item item1, Item item2){
		item1.use(item2, this);
	}

}