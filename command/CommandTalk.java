package command;

import character.Hero;

public final class CommandTalk {

	public static void use(Hero hero){
		hero.talk();
	}
}
