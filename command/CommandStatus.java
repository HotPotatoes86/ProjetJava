package command;

import character.Hero;

public final class CommandStatus {

	public static void use(Hero hero){
		System.out.println("Caracteristiques du Hero : ");
		System.out.println("HP : " + hero.getHp());
		System.out.println("Alcoolemie : " + hero.getAlcoholLevel());
		System.out.println("Attaque : " + hero.getAttack());
		System.out.println("Arme : " + hero.getWeapon());
	}
}
