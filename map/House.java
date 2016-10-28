package map;
import java.util.HashMap;
import java.util.List;

import character.NPC;
import item.Item;

public class House {

	private String name;
	private HashMap<String, Exit> exits;
	private NPC npc=null; // = la personne qui est dans la maison
	private List<Item> items;
	private boolean containsHero=false; // Optionnel ?
	
	public House(){
		this.name = "Inconnu";
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
			System.out.println("Vous rentrez dans la maison de " + this.name);
			this.containsHero=true;
		}
	}

}