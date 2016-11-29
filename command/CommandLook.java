package command;

import character.Hero;

public final class CommandLook {

	public static void use(Hero hero, String direction){
		if (direction != null && direction.length()>0){
			hero.look(direction);
    	}else{
    		hero.look("");
    	}
	}
}
