package map;

import character.Hero;
import util.ConsoleInput;

public abstract class Exit {

	//----------------------Attributes----------------------//
	protected Place place;
	
	//----------------------Getters----------------------//
	
	public Place getPlace(){
		return this.place;
	}
	
	//----------------------Methods----------------------//
	/**
	 * use the exit, display a simple string for the user
	 * @param hero hero of the game
	 * @return true if you use the exit
	 */
	public boolean use(Hero hero) {
		if (this.place instanceof StreetPart){
			ConsoleInput.displayString("Vous avancez dans la rue...");
		}else if(this.place instanceof House){
			ConsoleInput.displayString("Vous rentrez dans la maison de " + this.place.getName());
			if (((House)this.place).getNPC() != null && ((House)this.place).getNPC().getStatus()){
				ConsoleInput.displayString("Vous rencontrez " + ((House)this.place).getNPC().getName() + "\n");
				((House)this.place).getNPC().describe();
			}else{
				ConsoleInput.displayString("Il n'y a personne...");
			}
		}else{
			ConsoleInput.displayString("Vous avancez sur la  " + this.place.getName());
		}
		return true;
	}
		
}