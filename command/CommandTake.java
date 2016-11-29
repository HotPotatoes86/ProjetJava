package command;

import character.Hero;
import map.House;

public class CommandTake {
	
	/**
	 * use the command take (hero adds an item to his inventory if there are enough place)
	 * @param hero the hero of the game
	 * @param item item hero wants to pick
	 */
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
