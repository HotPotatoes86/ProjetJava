package item;

import character.Hero;
import map.LockedExit;

public class Key implements Item{

	private LockedExit exit;
	private String name;
	
	public Key(LockedExit e, String n){
		this.exit = e;
		this.name = n;
	}
	
	public int testItem(){
		int i = 0;
	
		return i;
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
	
	
	public String getName() {
		return name;
	}

	public void use(Hero hero){
		System.out.println("Vous devez utiliser la clé sur une porte");
	}
	
	public void use(Item item, Hero hero){
		
	}
}
