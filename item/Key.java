package item;

import map.LockedExit;

public class Key implements Item{

	//----------------------Attributes----------------------//
	private LockedExit exit;
	private int id;
	private String name;
	
	//----------------------Constructors----------------------//
	public Key(int id){
		this.id = id;
		this.name = "key" + id;
	}
	
	//----------------------Getters----------------------//
	public LockedExit getLockedExit(){
		return this.exit;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String getName() {
		return name;
	}
	

	//----------------------Setters----------------------//
	public void setLockedExit(LockedExit e){
		this.exit = e;
	}
	
	//----------------------Methods----------------------//
	/**
	 * describe the value of the item
	 */
	public void describe(){
		System.out.println("C'est une cle d'une maison");
	}
	

	@Override
	public void use(Object obj){
		System.out.println("Vous devez utiliser la cle sur une porte");
	}
	
	@Override
	public void use(Object obj1, Object obj2){
		System.out.println("Pour utiliser une cle, avancer vers la maison correspondante, elle se deverouillera toute seule !");
	}
	
	@Override
	public String toString() {
		return name ;
	}	
	
}
