package item;

import character.Hero;

public class Weapon implements Item {
	
	private TypeWeapon weapon;
	private String name;
	private Hero hero;
	
	public static Weapon createWrink(String value){
		Weapon w=null;
		try{
			w= new Weapon(TypeWeapon.valueOf(value.toUpperCase()));
		}
		catch(Exception e){
			System.out.println("erreur");
		}
		return w;
	}	
	
	public Weapon(TypeWeapon weapon){
		this.weapon = weapon;
		this.name = weapon.toString().toLowerCase();
	}
	
	public void unequip(){
		this.hero.setWeapon(-this.weapon.getAttackWeapon()); //on retire les degat de l'arme d�s�quip�
	}
	
	public void use(){ //equiper arme
		if (this.hero.getWeapon() != null){ //on desequipe
			this.unequip();
		}
		this.hero.setWeapon(this.weapon.getAttackWeapon());;
	}

	@Override
	public String toString() {
		return "" + name;
	}
	
	
}