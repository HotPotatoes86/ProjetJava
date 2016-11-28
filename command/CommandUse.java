package command;

import character.Hero;

public final class CommandUse {

	public static void useItem(Hero hero, String item){
		hero.use(item);		
	}
		
	public static void combineItem(Hero hero, String item1, String item2){
		hero.use(item1, item2);
	}
}
