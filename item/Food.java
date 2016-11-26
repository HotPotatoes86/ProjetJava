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
	
	public void use(Object obj){
		if(this.testItem()==1 && obj instanceof Hero){	
			if(((Hero)obj).getHp()==100){
				System.out.println("Vous n'avez pas besoin de manger, votre vie est au maximum");
			}else if (((Hero)obj).getHp()<100){
				if(((Hero)obj).getHp() + convertToFood(this).tFood.getHp() > 100){
					((Hero)obj).setHp(100);
				}else{
					((Hero)obj).setHp(((Hero)obj).getHp() + convertToFood(this).tFood.getHp());					
				}
				((Hero)obj).getInventory().remove(this);
			}
		}
	}
	
	public void use(Object obj1, Object obj2){ //obj1 = item & obj2 = hero
		if(obj1 instanceof Item && obj2 instanceof Hero){
			if(this.testItem()==1 && ((Item)obj1).testItem()==1){
				if(this.toString().equals("chocolate") && ((Item)obj1).toString().equals("banana")  || ((Item)obj1).toString().equals("banana") && this.toString().equals("chocolate")){
					((Hero)obj2).getInventory().remove(this);
					((Hero)obj2).getInventory().remove(((Item)obj1));
					((Hero)obj2).getInventory().add(new Food("chocolatebanana"));
				}else if(this.toString().equals("apple") && ((Item)obj1).toString().equals("apple")  || ((Item)obj1).toString().equals("apple") && this.toString().equals("apple")){
					((Hero)obj2).getInventory().remove(this);
					((Hero)obj2).getInventory().remove(((Item)obj1));
					((Hero)obj2).getInventory().add(new Food("applepie"));
				}else if(this.toString().equals("spice") && ((Item)obj1).toString().equals("chips")  || ((Item)obj1).toString().equals("chips") && this.toString().equals("spice")){
					((Hero)obj2).getInventory().remove(this);
					((Hero)obj2).getInventory().remove(((Item)obj1));
					((Hero)obj2).getInventory().add(new Food("spicychips"));
				}else if(this.toString().equals("spice") && ((Item)obj1).toString().equals("chicken")  || ((Item)obj1).toString().equals("chicken") && this.toString().equals("spice")){
					((Hero)obj2).getInventory().remove(this);
					((Hero)obj2).getInventory().remove(((Item)obj1));
					((Hero)obj2).getInventory().add(new Food("spicychicken"));
				}else{
					System.out.println("Vous ne pouvez pas combiner ces 2 aliments");
				}
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