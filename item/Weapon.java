package item;

import character.Hero;

public class Weapon implements Item {
	
	private TypeWeapon weapon;
	private Hero heros;
	
	public void unequip(){
		this.heros.setWeapon(-this.weapon.getAtackWeapon()); //on retire les degat de l'arme déséquipé
	}
	
	public void use(){ //equiper arme
		if (this.heros.getWeapon() != null){ //on desequipe
			this.unequip();
		}
		this.heros.setWeapon(this.weapon.getAtackWeapon());;
	}
}