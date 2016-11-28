package character;

import item.Drink;
import item.Food;
import item.Item;
import item.Weapon;
import util.Choice;
import util.ConsoleInput;
import util.Name;

public abstract class NPC {

	//----------------------Attributes----------------------//
	// protected attributes to have access in the class enemy and neutral
	protected int HP = 100;
	protected String name = "Villageois";
	protected boolean status = true; //true = alive / false = dead (or absent)
	protected int attack;
	protected Item item = itemGenerator();	// NPC can only have 0 or 1 item

	//----------------------Getters----------------------//
	public String getName(){
		return this.name;
	}
	
	/**
	 * if the npc is still alive
	 * @return the current status of the npc
	 */
	public boolean getStatus(){
		return this.status;
	}
	
	public Item getItem() {
		return item;
	}
	
	public int getAttack(){
		return this.attack;
	}
	
	//----------------------Setters----------------------//
	public void setHP(int hp){
		this.HP+=hp;
	}
	
	//----------------------Methods----------------------//
	public abstract void talk(Hero hero);
	
	public abstract void describe();
	
	/**
	 * generate the name randomly the name of the NPC
	 * @param houseName the name of the House
	 * @return the name of the NPC
	 */
	public void chooseName(String houseName){
		if (Choice.randomChoice()){
			this.name = houseName;
		}else if (Choice.randomChoice()){
			this.name = Name.generateName("donnees/Noms.txt",31);
		}
	}
	
	/**
	 * npc take damage when hero attacks him
	 * @param dmg the life he looses
	 */
	public void takeDmg(int dmg){
		this.HP = this.HP - dmg;
		System.out.println(this.name + " perd " + dmg + "HP");
		if (this.HP<=0){
			this.status = false;
			System.out.print("[" + this.name + "]" + " : ");
			ConsoleInput.displayString("AAAAHHH je meurs !");
		}else{
			System.out.println("Il lui reste " + this.HP + "HP");
		}
	}
	
	public Item itemGenerator(){
		Item item = null;
		if(Choice.randomChoice()){
			int typeItem = Choice.randomChoice(1, 3);
			if(typeItem == 1){
				item = Food.createFood();
			}else if(typeItem == 2){
				item = Drink.createDrink();
			}else{
				item = Weapon.createWeapon();
			}
		}
		return item;
	}
}