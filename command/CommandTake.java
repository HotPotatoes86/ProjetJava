package command;

import java.util.List;

import character.Hero;
import item.Item;

public class CommandTake {
	//pour prendre un objet il faut qu'il y en ait un
	//il faut ensuite tester si l'objet existe comme pour l'utilisation d'un item
	//ensuite on l'ajoute a l'inventaire du héros par l'appel de la fonction pickupItem
	public static void use(Hero hero, List<Item> chest, String item){
		
		hero.pickUpItem(item, chest);
	}
	

}
