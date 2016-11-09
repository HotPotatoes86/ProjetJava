package map;

import java.util.HashMap;

public abstract class Place{
	protected String name;
	protected HashMap<String,Exit> exits;
	
	public abstract void describe();
	
	public String getName(){
		return this.name;
	}
	
	public boolean testdirection(String direction){
		boolean test = false;
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getKey() == direction){
				test = true;
			}
		}
		return test;
	}
	
	public void go(String direction){
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getKey() == direction){
				e.getValue().use();
			}
		}
	}
	
	public Place getNextPlace(String direction){
		Place p = null;
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getKey() == direction){
				p = e.getValue().getPlace();
			}
		}
		return p;
	}
}