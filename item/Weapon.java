package item;

import java.util.Random;

import character.Hero;

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
		Random rand = new Random();
		TypeWeapon randomWeapon = tabWeapon[rand.nextInt(tabWeapon.length)];
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
			hero.setAttack(hero.getAttack() + convertToWeapon(this).tWeapon.getAttack());
			hero.setWeapon(convertToWeapon(this));
			hero.getInventory().remove(this);
		}
	}
	
	public void use(Item item, Hero hero){
		if(this.testItem()==3 && item.testItem()==3){
			Weapon weapon1 = convertToWeapon(this);
			Weapon weapon2 = convertToWeapon(item);
			if(weapon1.toString().equals("stick") && weapon2.toString().equals("rope")  || weapon1.toString().equals("rope") && weapon2.toString().equals("stick")){
				Weapon weapon3 = new Weapon("whip");
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(weapon3);
			}else if(weapon1.toString().equals("stick") && weapon2.toString().equals("stone")  || weapon1.toString().equals("stone") && weapon2.toString().equals("stick")){
				Weapon weapon3 = new Weapon("spears");
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(weapon3);
			}else if(weapon1.toString().equals("rope") && weapon2.toString().equals("stone")  || weapon1.toString().equals("stone") && weapon2.toString().equals("rope")){
				Weapon weapon3 = new Weapon("slingshot");
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(weapon3);
			}else if(weapon1.toString().equals("stick") && weapon2.toString().equals("knife")  || weapon1.toString().equals("knife") && weapon2.toString().equals("stick")){
				Weapon weapon3 = new Weapon("battlespears");
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(weapon3);
			}else{
				System.out.println("Vous ne pouvez pas combiner ces 2 armes");
			}
		}
	}
	
	public int addAttack(){	//pour utiliser objet
		return this.tWeapon.getAttack();
	}

	@Override
	public String toString() {
		return "" + name;
	}	
	
}