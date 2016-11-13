package map;

import java.util.HashMap;

import util.Choice;

public class LockedExit extends Exit {

	private int keyType;
	private boolean status=true; //Locked or Unlocked
	private static HashMap<Integer, Boolean> keys = new HashMap<>();

	public LockedExit(int type, Place p) {
		while (keys.containsKey(type)){
			// Une chance sur 10 = 10 types de clés
			type = Choice.randomChoice(1, 10);
		}
		this.keyType = type;
		keys.put(type, true);
		this.place = p;
	}
	
	public Place getPlace(){
		return this.place;
	}
	
	public void unlock(int key){
		if (key==this.keyType){
			this.status = false;
		}
	}
	
	@Override
	public void use() {
		if (!status){
			super.use();
		}
		else{
			//unlock?
		}
	}

}