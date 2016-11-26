package item;

import character.Hero;
import map.LockedExit;

public class Key{

	private LockedExit exit;
	private int id;
	
	public Key(int id){
		this.id = id;
	}
	
	public int testItem(){
		int i = 0;
		return i;
	}

		
	public void setLockedExit(LockedExit e){
		this.exit = e;
	}
	
	public void use(LockedExit e){
		if (this.exit == e){
			//remove key
			this.exit.unlock();
			System.out.println("Vous ouvrez la porte");
		}else{
			System.out.println("Cette cle ne fonctionne pas sur cette porte");
		}
	}
	
	public int getId() {
		return id;
	}

	public void use(Hero hero){
		System.out.println("Vous devez utiliser la cl� sur une porte");
	}
	
	public void use(){
		System.out.println("Vous devez utiliser la cle sur une porte");
	}
	
	public void use(Item item, Hero hero){
		
	}
}
