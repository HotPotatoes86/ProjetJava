package item;

import character.Hero;
import util.Choice;

public class Food implements Item {
	
	private TypeFood tFood;
	private String name;
	
	public Food(TypeFood food){		
		this.tFood=food;
		this.name=food.toString().toLowerCase();
	}
	
	public Food(String name){
		TypeFood[] tabFood = TypeFood.values();
		boolean correctFood= false;
		for(int i=0; i<tabFood.length; i++){
			if(name.equals(tabFood[i].toString().toLowerCase())){
				correctFood = true;
			}
		}
		if (correctFood){
			this.name = name;
		}else{
			System.out.println("Cet objet n'existe pas");
		}
	}
	
	public static Food createFood(){
		TypeFood[] tabFood = TypeFood.values();
		TypeFood randomFood = tabFood[Choice.randomChoice(0, tabFood.length-1)];
		Food res = new Food(randomFood);		
		return res;		
	}
	
	public int testItem(){ //pour tester si l'item est une food
		TypeFood[] tabFood = TypeFood.values();
		int res = 0;
		for(int i=0; i<tabFood.length; i++){
			if (this.toString().equals(tabFood[i].toString().toLowerCase())){
				res = 1;
			}
		}
		return res;
	}
	
	public Food convertToFood(Item item){
		Food f = null;
		TypeFood[] tabFood = TypeFood.values();
		for(int i=0; i<tabFood.length; i++){
			if(item.toString().equals(tabFood[i].toString().toLowerCase())){
				f = new Food(tabFood[i]);
			}
		}
		return f;
	}
	
	public void use(Hero hero){
		if(this.testItem()==1){			
			hero.setHp(hero.getHp() + convertToFood(this).tFood.getHp());
			hero.getInventory().remove(this);
		}
	}
	
	public void use(Item item, Hero hero){
		if(this.testItem()==1 && item.testItem()==1){
			Food food1 = convertToFood(this);
			Food food2 = convertToFood(item);
			if(food1.toString().equals("chocolate") && food2.toString().equals("banana")  || food1.toString().equals("banana") && food2.toString().equals("chocolate")){
				Food food3 = new Food("chocolatebanana");
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(food3);
			}else if(food1.toString().equals("apple") && food2.toString().equals("apple")  || food1.toString().equals("apple") && food2.toString().equals("apple")){
				Food food3 = new Food("applepie");
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(food3);
			}else if(food1.toString().equals("spice") && food2.toString().equals("chips")  || food1.toString().equals("chips") && food2.toString().equals("spice")){
				Food food3 = new Food("spicychips");
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(food3);
			}else if(food1.toString().equals("spice") && food2.toString().equals("chicken")  || food1.toString().equals("chicken") && food2.toString().equals("spice")){
				Food food3 = new Food("spicychicken");
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(food3);
			}else{
				System.out.println("Vous ne pouvez pas combiner ces 2 aliments");
			}
		}			
	}

	@Override
	public String toString() {
		return "" + name ;
	}	
	
}