package command;

import character.Hero;

public class CommandDelete {
	
	public static void use(Hero hero, String item){
		boolean test = false;
		for(int i=0; i<hero.getInventory().size() && !test;i++){
			if(hero.getInventory().get(i).toString().equals(item)){
				hero.deleteItem(hero.getInventory().get(i));
				test = true;
			}
		}
		if(!test){
			System.out.println("Vous ne pouvez pas detruire un objet que vous ne posseder pas");
		}
	}
}
