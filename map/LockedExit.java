package map;

import java.util.HashMap;

import item.Key;
import util.Choice;

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
	public Place getPlace(){
		return this.place;
	}
	
	public Key getKey(){
		return this.key;
	}
	
	//----------------------Methods----------------------//
	public void unlock(){
		this.status = false;
		System.out.println("La porte est dévérouillée !");
	}
	
	@Override
	public boolean use() {
		if (!status){
			return super.use();
		}
		else{
			System.out.println("La porte est vérouillée, il faut trouver la clé");
			return false;
		}
	}

}