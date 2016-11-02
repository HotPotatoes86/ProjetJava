package map;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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
	
	public String getName(){
		return this.name;
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