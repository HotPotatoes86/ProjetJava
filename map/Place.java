package map;

import java.util.HashMap;

public abstract class Place{
	
	//----------------------Attributes----------------------//
	protected String name;
	protected HashMap<String,Exit> exits = new HashMap<>();
	
	//----------------------Getters----------------------//
	/**
	 * getter of exit
	 * @param s key of the exit we want
	 * @return the exit which have the key "s"
	 */
	public Exit getExit(String s){
		Exit exit = null;
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getKey().equalsIgnoreCase(s)){
				exit = e.getValue();
			}
		}
		return exit;
	}
	
	public String getName(){
		return this.name;
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
	
	//----------------------Methods----------------------//
	public abstract void describe();
	
	/**
	 * create an exit from the place to another place
	 * @param cmd direction given by the user
	 * @param p direction of the exit
	 */
	public void addExit(String cmd,Place p){
		this.exits.put(cmd, new SimpleExit(p));
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
	 * use the exit which have the same key (difference with testdirection : we test if we can use the exit)
	 * @param direction direction you want to go (example : forward)
	 * @return true if the hero can go to the direction
	 */
	public boolean go(String direction){
		boolean test = false;
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getKey().equals(direction)){
				test = e.getValue().use();
			}
		}
		return test;
	}
}