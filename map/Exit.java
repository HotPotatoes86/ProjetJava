package map;

import character.Hero;

public abstract class Exit {

	protected Place place;
	
	/**
	 * use the exit, display a simple string for the user
	 * @param hero hero of the game
	 * @return true if you use the exit
	 */
	public boolean use(Hero hero) {
		if (this.place instanceof StreetPart){
			System.out.println("Vous avancez dans la rue...");
		}else if(this.place instanceof House){
			System.out.println("Vous rentrez dans la maison de " + this.place.getName());
			if (((House)this.place).getNPC() != null){
				System.out.println("\nVous rencontrez " + ((House)this.place).getNPC().getName() + "\n");
				((House)this.place).getNPC().describe();
			}else{
				System.out.println("Il n'y a personne...");
			}
		}else{
			System.out.println("Vous avancez sur la  " + this.place.getName());
		}
		return true;
	}
	
	public Place getPlace(){
		return this.place;
	}
		
}