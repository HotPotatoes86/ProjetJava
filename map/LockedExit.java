package map;

import character.Hero;
import item.Key;

public class LockedExit extends Exit {

	//----------------------Attributes----------------------//
	private Key key;
	private boolean status=true; //Locked or Unlocked

	//----------------------Constructors----------------------//
	public LockedExit(Key k, Place p) {
		this.key = k;
		this.place = p;
	}
	
	//----------------------Getters----------------------//
	public Key getKey(){
		return this.key;
	}
	
	//----------------------Methods----------------------//
	@Override
	public boolean use(Hero hero) {
		if (!status){
			return super.use(hero);
		}
		else{
			if (hero.getInventory().contains(this.key)){
				hero.getInventory().remove(this.key);
				System.out.println("Vous deverrouillez la porte");
				this.status=false;
				return super.use(hero);
			}else{
				System.out.println("La porte est verrouillee, il faut trouver la cle");
				return false;
			}
		}
	}

}