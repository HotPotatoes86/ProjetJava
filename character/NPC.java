package character;

import java.util.ArrayList;

import item.Item;

public abstract class NPC {

	// Attributs en protected pour y avoir acces dans les classes filles
	protected int HP = 100;
	protected String NPCname = "Villageois";
	protected boolean status = true; //V : En vie - F : Mort
	protected int Attack = 0;
	protected ArrayList<Item> items; // Les objets sur le pnj

	public abstract void talk();
	
	public void takeDmg(int dmg){
		this.HP = this.HP - dmg;
		if (this.HP<0){
			this.status = false;
		}
	}
	
	public boolean getStatus(){
		return this.status;
	}

	public ArrayList<Item> getItems() {
		return items;
	}
}