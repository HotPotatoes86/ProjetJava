package item;

import character.Hero;
import util.Choice;

public class Weapon implements Item {
	
	//----------------------Attributes----------------------//
	private TypeWeapon tWeapon;
	private String name;
	
	//----------------------Constructors----------------------//
	/**
	 * constructor of the class Weapon
	 * @param weapon in an element of enum TypeDrink
	 */
	public Weapon(TypeWeapon weapon){
		this.tWeapon = weapon;
		this.name=weapon.toString().toLowerCase();
	}	
	
	/**
	 * constructor of the class Weapon
	 * @param name is the name of the weapon
	 */
	public Weapon(String name){
		TypeWeapon[] tabWeapon = TypeWeapon.values();
		boolean correctWeapon = false;
		for(int i=0; i<tabWeapon.length; i++){
			if(name.equals(tabWeapon[i].toString().toLowerCase())){
				correctWeapon = true;
				this.tWeapon = tabWeapon[i];
			}
		}
		if (correctWeapon){
			this.name = name;
		}else{
			System.out.println("Cet objet n'existe pas");
		}
	}
	
	//----------------------Getters----------------------//
	@Override
	public String getName() {
		return name;
	}	
	
	//----------------------Methods----------------------//	
	/**
	 * describe the value of the item
	 */
	public void describe(){
		System.out.println(this.name + " : " + "+" + this.tWeapon.getAttack() + " attack");
	}
	
	/**
	 * create a new Weapon with a random TypeWeapon value
	 * @return weapon
	 */
	public static Weapon createWeapon(){
		TypeWeapon[] tabWeapon = TypeWeapon.values();
		TypeWeapon randomWeapon = tabWeapon[Choice.randomChoice(0, tabWeapon.length-1)];
		Weapon res = new Weapon(randomWeapon);		
		return res;		
	}
	

	/**
	 * convert the parameter item to a Weapon
	 * @param item which we want to convert as a weapon
	 * @return weapon
	 */
	public Weapon convertToWeapon(Item item){
		Weapon w = null;
		TypeWeapon[] tabWeapon = TypeWeapon.values();
		for(int i=0; i<tabWeapon.length; i++){
			if(item.toString().equals(tabWeapon[i].toString().toLowerCase())){
				w = new Weapon(tabWeapon[i]);
			}
		}
		return w;
	}	
		
	/**
	 * use a weapon on hero to equip him and increase his attack
	 * we have to test if he have a weapon before equip new
	 */
	@Override
	public void use(Object obj){
		if(obj instanceof Hero){	
			if(((Hero)obj).getWeapon() != null){
				((Hero)obj).unequip();
			}
			((Hero)obj).setAttack(convertToWeapon(this).tWeapon.getAttack());
			((Hero)obj).setWeapon(this);
			System.out.println("Vous vous equipez de " +this.name);
			System.out.println("Vous gagnez " + convertToWeapon(this).tWeapon.getAttack() +" point d'attaque");
			((Hero)obj).getInventory().remove(this);
		}
	}
	
	/**
	 * combine 2 weapon as another
	 */
	@Override
	public void use(Object obj1, Object obj2){ //obj1 = item & obj2 = hero
		if(obj1 instanceof Item && obj2 instanceof Hero){
			if(this.toString().equals("stick") && ((Item)obj1).toString().equals("rope")  || this.toString().equals("rope") && ((Item)obj1).toString().equals("stick")){
				((Hero)obj2).getInventory().remove(this);
				((Hero)obj2).getInventory().remove(((Item)obj1));
				((Hero)obj2).getInventory().add(new Weapon("whip"));
				System.out.println("Vous recevez whip");
			}else if(this.toString().equals("stick") && ((Item)obj1).toString().equals("stone")  || this.toString().equals("stone") && ((Item)obj1).toString().equals("stick")){
				((Hero)obj2).getInventory().remove(this);
				((Hero)obj2).getInventory().remove(((Item)obj1));
				((Hero)obj2).getInventory().add(new Weapon("spears"));
				System.out.println("Vous recevez spears");
			}else if(this.toString().equals("rope") && ((Item)obj1).toString().equals("stone")  || this.toString().equals("stone") && ((Item)obj1).toString().equals("rope")){
				((Hero)obj2).getInventory().remove(this);
				((Hero)obj2).getInventory().remove(((Item)obj1));
				((Hero)obj2).getInventory().add(new Weapon("slingshot"));
				System.out.println("Vous recevez slingshot");
			}else if(this.toString().equals("stick") && ((Item)obj1).toString().equals("knife")  || this.toString().equals("knife") && ((Item)obj1).toString().equals("stick")){
				((Hero)obj2).getInventory().remove(this);
				((Hero)obj2).getInventory().remove(((Item)obj1));
				((Hero)obj2).getInventory().add(new Weapon("battlespears"));
				System.out.println("Vous recevez battlespears");
			}else{
				System.out.println("Vous ne pouvez pas combiner ces 2 armes");
			}
		}else{
			System.out.println("Vous n'avez pas saisi 2 armes");
		}
	}
	
	/**
	 * enable to return weapon attack value to unequip weapon
	 * @return weapon attack value
	 */
	public int addAttack(){	//pour utiliser objet
		int atk = 0;
		TypeWeapon[] tabWeapon = TypeWeapon.values();
		for(int i=0; i<tabWeapon.length; i++){
			if(this.toString().equals(tabWeapon[i].toString().toLowerCase())){
				atk = tabWeapon[i].getAttack();
			}
		}
		
		return atk;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}