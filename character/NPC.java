package character;

import java.util.ArrayList;

import item.Item;

public abstract class NPC {

	// Attributs en protected pour y avoir acces dans les classes filles
	protected int HP = 100;
	protected String NPCname = "Villageois";
	protected int Attack = 0;
	protected ArrayList<Item> items; // Les objets sur le pnj

	public abstract void talk();
	public abstract void setHP(int hp);
}