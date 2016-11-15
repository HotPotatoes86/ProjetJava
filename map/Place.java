package map;

import java.util.HashMap;

public abstract class Place{
	protected String name;
	protected HashMap<String,Exit> exits = new HashMap<>();
	
	public abstract void describe();
	
	/**
	 * create an exit from the place to another place
	 * @param cmd direction given by the user
	 * @param p direction of the exit
	 */
	public void addExit(String cmd,Place p){
		this.exits.put(cmd, new SimpleExit(p));
	}
	
	public String getName(){
		return this.name;
	}
	
	/**
	 * display all the exit of the place
	 */
	public void displayExit(){
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			System.out.println(e.getKey());
		}
	}
	
	/**
	 * says if the direction is in the list of exits of the place
	 * @param direction direction you want to test in the list
	 * @return true if the direction is in the list
	 */
	public boolean testdirection(String direction){
		boolean test = false;
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getKey().equals(direction)){
				test = true;
			}
		}
		return test;
	}
	
	/**
	 * use the exit which have the same key
	 * @param direction direction you want to go (example : forward)
	 */
	public void go(String direction){
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getKey().equals(direction)){
				e.getValue().use();
			}
		}
	}
	
	/**
	 * return the place in the direction by searching in the list of exit of the place
	 * @param direction direction of the place
	 * @return the place in the direction
	 */
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