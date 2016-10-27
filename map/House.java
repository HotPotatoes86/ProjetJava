package map;
import java.util.HashMap;
import java.util.List;

import item.Item;

public class House {

	private String name;
	private HashMap<String, Exit> exits;
	private List<Item> items;
	private boolean containsHero=false;
	
	public House(){
		this.name = "Sans Nom";
	}

	public House(String name) {
		this.name = name;
		// TODO Exits, Items en Random
	}
	
	public void moveHero() {
		if (this.containsHero){
			this.containsHero=false;
		}
		else{
			this.containsHero=true;
		}
	}

}