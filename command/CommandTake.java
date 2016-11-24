package command;

import java.util.List;

import character.Hero;
import item.Item;

public class CommandTake {
	//a tester ... il faut peut etre mettre l'inventaire d'une maison a la place de chest ...
	public static void use(Hero hero, List<Item> chest, String item){
		for(int i=0; i<chest.size(); i++){
			if(chest.get(i).toString().equals(item)){
				hero.pickUpItem(chest.get(i), chest);
			}
		}		
	}
	
	

}
