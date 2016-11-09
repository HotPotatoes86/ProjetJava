package map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import character.NPC;
import item.Drink;
import item.Food;
import item.Item;
import item.Weapon;

public class House extends Place{

	private NPC npc=null; // = la personne qui est dans la maison
	private List<Item> items;
	
	public House(){
		this.name = "Inconnu";
	}

	public House(String name) {
		this.name = name;
		this.exits = new HashMap<>();
		this.items = this.ItemGenerator();
	}
	
	public void describe(){
		System.out.println("Maison de " + this.name);
	}
	
	public List<Item> ItemGenerator(){
		List<Item> items = new ArrayList<>();
		Random rand = new Random();
		// nombre d'items, de 0 a 4
		int nbItem = rand.nextInt(4);
		for(int i=0; i<nbItem; i++){
			// De 1 a 3 = type de l'objet
			int typeItem = rand.nextInt(3)+1;
			if (typeItem == 1){
				items.add(new Drink());
			}else if (typeItem == 2){
				items.add(new Food());
			}else if (typeItem == 3){
				items.add(new Weapon());
			}
		}
		return items;
	}
	
	public void addExit(Place p){
		Random rand = new Random();
		// Une chance sur deux que la porte soit verrouillee
		int rdm = rand.nextInt(2)+1;
		if (rdm==1){
			this.exits.put(p.getName(), new SimpleExit(p));
		}
		else{
			// Une chance sur 10 = 10 types de clés
			rdm = rand.nextInt(10)+1;
			// Cree une cle qui correspond
			// Pour les portes verrouillees faire hashmap pour le type de cle ?
			this.exits.put(p.getName(), new LockedExit(rdm,p));
		}
	}

}