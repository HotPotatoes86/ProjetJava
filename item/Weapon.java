package item;

import character.Hero;

public class Weapon implements Item {
	
	private TypeWeapon weapon;
	private Hero hero;
	
	public void unequip(){
		this.hero.setWeapon(-this.weapon.getAtackWeapon()); //on retire les degat de l'arme d�s�quip�
	}
	
	public void use(){ //equiper arme
		if (this.hero.getWeapon() != null){ //on desequipe
			this.unequip();
		}
		this.hero.setWeapon(this.weapon.getAtackWeapon());;
	}
}