package item;

import character.Hero;
import map.LockedExit;

public class Key implements Item{

	private LockedExit exit;
	private int id;
	private String name;
	
	public Key(int id){
		this.id = id;
		this.name = "key" + id;
	}
	
	public LockedExit getLockedExit(){
		return this.exit;
	}
		
	public void setLockedExit(LockedExit e){
		this.exit = e;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void use(Object obj){
		System.out.println("Vous devez utiliser la cle sur une porte");
	}
	
	@Override
	public void use(Object obj1, Object obj2){
		if(obj1 instanceof LockedExit && obj2 instanceof Hero && this instanceof Key){
			if(this.exit == ((LockedExit)obj1)){
				System.out.println("Vous ouvrez la porte");
			}else{
				System.out.println("Cette cle ne fonctionne pas sur cette porte");
			}
		}
	}
	
	@Override
	public String toString() {
		return name ;
	}	
	
}
