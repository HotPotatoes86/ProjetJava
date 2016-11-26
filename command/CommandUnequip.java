package command;

import character.Hero;

public class CommandUnequip {

	public static void use(Hero hero){
		if(hero.getWeapon() != null){
			hero.unequip();
		}else{
			System.out.println("vous n'avez pas d'arme");
		}
	}
	
}
