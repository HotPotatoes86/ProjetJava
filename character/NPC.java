package character;

import java.util.ArrayList;

import item.Item;
import util.Choice;
import util.Name;

public abstract class NPC {

	//----------------------Attributes----------------------//
	// Attributs en protected pour y avoir acces dans les classes filles
	protected int HP = 100;
	protected String name = "Villageois";
	protected boolean status = true; //V : En vie - F : Mort
	protected int attack;
	protected ArrayList<Item> items; // Les objets sur le pnj

	//----------------------Getters----------------------//
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
		return this.attack;
	}
	
	//----------------------Setters----------------------//
	public void setHP(int hp){
		this.HP+=hp;
	}
	
	//----------------------Methods----------------------//
	public abstract void talk();
	
	/**
	 * generate the name randomly the name of the NPC
	 * @param houseName the name of the House
	 * @return the name of the NPC
	 */
	public void chooseName(String houseName){
		if (Choice.randomChoice()){
			this.name = houseName;
		}else if (Choice.randomChoice()){
			this.name = Name.generateName("donnees/Noms.txt",31);
		}
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