package item;

import character.Hero;
import util.Choice;

public class Weapon implements Item {
	private TypeWeapon tWeapon;
	private String name;
	
	public Weapon(TypeWeapon weapon){
		this.tWeapon = weapon;
		this.name=weapon.toString().toLowerCase();
	}	
	
	public Weapon(String name){
		TypeWeapon[] tabWeapon = TypeWeapon.values();
		boolean correctWeapon = false;
		for(int i=0; i<tabWeapon.length; i++){
			if(name.equals(tabWeapon[i].toString().toLowerCase())){
				correctWeapon = true;
			}
		}
		if (correctWeapon){
			this.name = name;
		}else{
			System.out.println("Cet objet n'existe pas");
		}
	}
	
	public static Weapon createWeapon(){
		TypeWeapon[] tabWeapon = TypeWeapon.values();
		TypeWeapon randomWeapon = tabWeapon[Choice.randomChoice(0, tabWeapon.length-1)];
		Weapon res = new Weapon(randomWeapon);		
		return res;		
	}
	
	public int testItem(){ //pour tester si l'item est un drink
		TypeWeapon[] tabWeapon = TypeWeapon.values();
		int res = 0;
		for(int i=0; i<tabWeapon.length; i++){
			if (this.toString().equals(tabWeapon[i].toString().toLowerCase())){
				res = 3;
			}
		}
		return res;
	}
	
	/*public static boolean testItem(String item){
		boolean test = false;
		TypeWeapon[] tabWeapon = TypeWeapon.values();
		for(int i=0; i<tabWeapon.length;i++){
			if(item.toString().equals(tabWeapon[i].toString().toLowerCase())){
				test = true;
			}
		}
		return test;
	}*/
	
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
		
	public void use(Hero hero){
		if(this.testItem()==3){			
			if(hero.getWeapon() != null){
				hero.unequip();
			}
			hero.setAttack(convertToWeapon(this).tWeapon.getAttack());
			hero.setWeapon(this);
			hero.getInventory().remove(this);
		}
	}
	
	public void use(Item item, Hero hero){
		if(this.testItem()==3 && item.testItem()==3){
			if(this.toString().equals("stick") && item.toString().equals("rope")  || this.toString().equals("rope") && item.toString().equals("stick")){
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(new Weapon("whip"));
			}else if(this.toString().equals("stick") && item.toString().equals("stone")  || this.toString().equals("stone") && item.toString().equals("stick")){
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(new Weapon("spears"));
			}else if(this.toString().equals("rope") && item.toString().equals("stone")  || this.toString().equals("stone") && item.toString().equals("rope")){
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(new Weapon("slingshot"));
			}else if(this.toString().equals("stick") && item.toString().equals("knife")  || this.toString().equals("knife") && item.toString().equals("stick")){
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(new Weapon("battlespears"));
			}else{
				System.out.println("Vous ne pouvez pas combiner ces 2 armes");
			}
		}
	}
	
	public int addAttack(){	//pour utiliser objet
		int att = 0;
		TypeWeapon[] tabWeapon = TypeWeapon.values();
		for(int i=0; i<tabWeapon.length; i++){
			if(this.toString().equals(tabWeapon[i].toString().toLowerCase())){
				att = tabWeapon[i].getAttack();
			}
		}
		
		return att;
	}

	public String getName() {
		return name;
	}	
	
	@Override
	public String toString() {
		return "" + name;
	}

	
}