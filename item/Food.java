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
	
	/*public static boolean testItem(String item){
		boolean test = false;
		TypeFood[] tabFood = TypeFood.values();
		for(int i=0; i<tabFood.length;i++){
			if(item.toString().equals(tabFood[i].toString().toLowerCase())){
				test = true;
			}
		}
		return test;
	}*/
	
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
			if(hero.getHp()==100){
				System.out.println("Vous n'avez pas besoin de manger, votre vie est au maximum");
			}else if (hero.getHp()<100){
				if(hero.getHp() + convertToFood(this).tFood.getHp() > 100){
					hero.setHp(100);
				}else{
					hero.setHp(hero.getHp() + convertToFood(this).tFood.getHp());					
				}
				hero.getInventory().remove(this);
			}
		}
	}
	
	public void use(Item item, Hero hero){
		if(this.testItem()==1 && item.testItem()==1){
			if(this.toString().equals("chocolate") && item.toString().equals("banana")  || item.toString().equals("banana") && this.toString().equals("chocolate")){
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(new Food("chocolatebanana"));
			}else if(this.toString().equals("apple") && item.toString().equals("apple")  || item.toString().equals("apple") && this.toString().equals("apple")){
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(new Food("applepie"));
			}else if(this.toString().equals("spice") && item.toString().equals("chips")  || item.toString().equals("chips") && this.toString().equals("spice")){
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(new Food("spicychips"));
			}else if(this.toString().equals("spice") && item.toString().equals("chicken")  || item.toString().equals("chicken") && this.toString().equals("spice")){
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(new Food("spicychicken"));
			}else{
				System.out.println("Vous ne pouvez pas combiner ces 2 aliments");
			}
		}			
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "" + name ;
	}	
	
}