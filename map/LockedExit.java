package map;

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
	public void unlock(){
		this.status = false;
		System.out.println("La porte est deverrouillee !");
	}
	
	@Override
	public boolean use() {
		if (!status){
			return super.use();
		}
		else{
			System.out.println("La porte est verrouillee, il faut trouver la cle");
			return false;
		}
	}

}