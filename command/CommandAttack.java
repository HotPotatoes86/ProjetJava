package command;

import character.Hero;
import map.House;

public final class CommandAttack {

	public static void use(Hero hero){
		if (hero.getPlace() instanceof House){
			hero.attack(((House)hero.getPlace()).getNPC());
		}else{
			System.out.println("Vous tentez d'attaquer un ennemi invisible");
		}
	}
}
