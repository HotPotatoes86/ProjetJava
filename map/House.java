package map;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		this.exits = new HashMap<>();
		// TODO Items en Random
	}
	
	public void addExit(Street st, StreetPart sp){
		Random rand = new Random();
		// Une chance sur deux que la porte soit verrouillee
		int rdm = rand.nextInt(2)+1;
		if (rdm==1){
			this.exits.put(st.getName(), new SimpleExit(st,sp,this));
		}
		else{
			// Une chance sur 10 = 10 types de clés
			rdm = rand.nextInt(10)+1;
			// Cree une cle qui correspond
			// Pour les portes verrouillees faire hashmap pour le type de cle ?
			this.exits.put(st.getName(), new LockedExit(rdm,st,sp,this));
		}
	}
	
	public String getName(){
		return this.name;
	}
	
	public void moveHero() {
		if (this.containsHero){
			this.containsHero=false;
		}
		else{
			// Une seule entrée pour une maison
			// Rajouter des portes secrètes ? Maison en maison?
			for (Map.Entry<String,Exit> e : this.exits.entrySet()){
				if (e instanceof SimpleExit){
					System.out.println("Vous rentrez dans la maison de " + this.name);
					this.containsHero=true;
				}
			}
		}
	}

}