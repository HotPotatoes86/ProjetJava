package command;

import character.Hero;

public final class CommandInventory {

	public static void use(Hero hero){
		hero.printInventory();
	}
}
