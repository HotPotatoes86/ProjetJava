package item;

import map.LockedExit;

public class Key implements Item{

	private LockedExit exit;
	private String name;
	
	public Key(LockedExit e, String n){
		this.exit = e;
		this.name = n;
	}
	
	public void use(LockedExit e){
		if (this.exit == e){
			//remove key
			this.exit.unlock();
		}
	}
	
	public void use(){
		System.out.println("Vous devez utiliser la clé sur une porte");
	}
}
