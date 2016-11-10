package map;

import java.util.HashMap;

public abstract class Place{
	protected String name;
	protected HashMap<String,Exit> exits = new HashMap<>();
	
	public abstract void describe();
	
	public void addExit(String cmd,Place p){
		this.exits.put(cmd, new SimpleExit(p));
	}
	
	public String getName(){
		return this.name;
	}
	
	public void displayExit(){
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getValue().getPlace() instanceof House){
				System.out.println(e.getKey() + " -> " + e.getValue().getPlace().getName());
			}else{
				System.out.println(e.getKey());
			}
		}
	}
	
	public boolean testdirection(String direction){
		boolean test = false;
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getKey().equals(direction)){
				test = true;
			}
		}
		return test;
	}
	
	public void go(String direction){
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getKey().equals(direction)){
				e.getValue().use();
			}
		}
	}
	
	public Place getNextPlace(String direction){
		Place p = null;
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getKey().equals(direction)){
				p = e.getValue().getPlace();
			}
		}
		return p;
	}
}