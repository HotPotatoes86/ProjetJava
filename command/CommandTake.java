package command;

import character.Hero;
import map.House;

public class CommandTake {
	
	public static void use(Hero hero, String item){
		if(hero.getPlace() instanceof House){
			House h = ((House)hero.getPlace());
			for(int i=0; i<h.getInventory().size();i++){
				if(h.getInventory().get(i).toString().equals(item)){
					hero.pickUpItem(h.getInventory().get(i), h.getInventory());
				}
			}
		}
	}
	
	

}
