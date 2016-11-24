package item;

import map.LockedExit;

public class Key{

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
			System.out.println("Vous ouvrez la porte");
		}else{
			System.out.println("Cette clé ne fonctionne pas sur cette porte");
		}
	}
	
	
	public void use(){
		System.out.println("Vous devez utiliser la clé sur une porte");
	}
}
