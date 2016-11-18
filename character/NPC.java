package character;

import java.util.ArrayList;

import item.Item;

public abstract class NPC {

	// Attributs en protected pour y avoir acces dans les classes filles
	protected int HP = 100;
	protected String name = "Villageois";
	protected boolean status = true; //V : En vie - F : Mort
	protected int Attack = 0;
	protected ArrayList<Item> items; // Les objets sur le pnj

	public abstract void talk();
	
	public String getName(){
		return this.name;
	}
	
	/**
	 * if the npc is still alive
	 * @return the current status of the npc
	 */
	public boolean getStatus(){
		return this.status;
	}

	public ArrayList<Item> getItems() {
		return items;
	}
	
	public int getAttack(){
		return this.Attack;
	}
	
	/**
	 * npc take damage when hero attacks him
	 * @param dmg the life he looses
	 */
	public void takeDmg(int dmg){
		this.HP = this.HP - dmg;
		System.out.println(this.name + " perd " + dmg + "HP");
		if (this.HP<=0){
			this.status = false;
			System.out.println(this.name + " : AAAAHHH je meurs !");
		}else{
			System.out.println("Il lui reste " + this.HP + "HP");
		}
	}
}