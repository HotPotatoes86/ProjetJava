package command;

import character.Hero;

public final class CommandGo{

	public static void use(Hero hero, String direction){
		if (direction != null && direction.length()>0){
			hero.go(direction);
		}else{
			System.out.println("Erreur : veuillez saisir une direction");
			System.out.println("\nDirections possibles : ");
			hero.getPlace().displayExit();
		}
	}
}
