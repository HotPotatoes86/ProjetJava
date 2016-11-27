package command;

import character.Hero;

public final class CommandUse {

	public static void useItem(Hero hero, String item){
		/*if(hero.getInventory().contains((Item)obj)){
		//if(obj instanceof Item){
			hero.use(((Item)obj));
		}else{
			System.out.println("erreur");
		}*/
		
		boolean test = false;
		for(int i=0; i<hero.getInventory().size() && !test; i++){
			if(hero.getInventory().get(i).toString().equals(item)){
				hero.use(hero.getInventory().get(i));
				test = true;
			}
		}
		if(!test){
			System.out.println("Vous ne possedez pas cet objet");
		}
		
	}
	
	/*Ajout d'une méthode testant si les parametres sont 2 item au quel cas on utilise combineItem
	 * et sinon, on utile une methode ouvrant une porte
	 * 
	*/
	
	/*public static void useItem(Hero hero, String obj1, String obj2){
		if(testItem(obj1) && testItem(obj2)){
			combineItem(hero, obj1, obj2);
		}else if(testItem(obj1) && testLocketExit(obj2){
			useKey(hero, obj1, obj2);
		}
	}*/
	
	public static void combineItem(Hero hero, String item1, String item2){
		boolean test1 = false;
		boolean test2 = false;
		int i = 0;
		int j = 0;

		for(i=0; i<hero.getInventory().size() && !test1; i++){
			if(hero.getInventory().get(i).toString().equals(item1)){
				test1 = true;
			}
		}
		for(j=0; j<hero.getInventory().size() && !test2; j++){
			if(hero.getInventory().get(j).toString().equals(item2) && j!=i-1){
				test2 = true;
			}
		}
		if(test1 && test2){
			if(i-1 != j-1){
				hero.use(hero.getInventory().get(i-1), hero.getInventory().get(j-1));
			}else{
				System.out.println("Vous ne pouvez pas combiner l'objet avec lui même");
			}
		}else{
			System.out.println("Vous ne possedez pas ces 2 objets");
		}
	}
	
	/*public static void useKey(Hero hero, String item, String House){
		System.out.println("key");
	}*/
}
