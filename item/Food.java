package item;

import character.Hero;
import util.Choice;

public class Food implements Item {
	
	//----------------------Attributes----------------------//
	private TypeFood tFood;
	private String name;
	
	//----------------------Constructors----------------------//
	/**
	 * Constructor of the class Food
	 * @param food is an element on the enum TypeFood
	 */
	public Food(TypeFood food){		
		this.tFood=food;
		this.name=food.toString().toLowerCase();
	}
	
	/**
	 * Constructor of the class Food
	 * @param name is the name of the food
	 */
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
	
	//----------------------Getters----------------------//
	@Override
	public String getName() {
		return name;
	}
	
	//----------------------Methods----------------------//
	/**
	 * create a new food with a random TypeFood value
	 * @return food
	 */
	public static Food createFood(){
		TypeFood[] tabFood = TypeFood.values();
		TypeFood randomFood = tabFood[Choice.randomChoice(0, tabFood.length-1)];
		Food res = new Food(randomFood);		
		return res;		
	}
		
	/**
	 * convert the parameter item in a food
	 * @param item which we want to convert as a food
	 * @return weapon 
	 */
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
	
	/**
	 * use a food on hero to increase his HP
	 */
	@Override
	public void use(Object obj){
		if(obj instanceof Hero){	
			if(((Hero)obj).getHp()==100){
				System.out.println("Vous n'avez pas besoin de manger, votre vie est au maximum");
			}else if (((Hero)obj).getHp()<100){
				if(((Hero)obj).getHp() + convertToFood(this).tFood.getHp() > 100){
					((Hero)obj).setHp(100);
					System.out.println("Vous utilisez " + this.name);
					System.out.println("Votre vie monte a 100");
				}else{
					((Hero)obj).setHp(((Hero)obj).getHp() + convertToFood(this).tFood.getHp());
					System.out.println("Vous utilisez " +this.name);
					System.out.println("Vous gagnez " + convertToFood(this).tFood.getHp() + " point de vie");
				}
				((Hero)obj).getInventory().remove(this);
			}
		}
	}
	
	/**
	 * combine 2 food as another 
	 */
	@Override
	public void use(Object obj1, Object obj2){ //obj1 = item & obj2 = hero
		if(obj1 instanceof Item && obj2 instanceof Hero){
			if(this.toString().equals("chocolate") && ((Item)obj1).toString().equals("banana")  || ((Item)obj1).toString().equals("banana") && this.toString().equals("chocolate")){
				((Hero)obj2).getInventory().remove(this);
				((Hero)obj2).getInventory().remove(((Item)obj1));
				((Hero)obj2).getInventory().add(new Food("chocolatebanana"));
				System.out.println("Vous recevez chocolatebanana");
			}else if(this.toString().equals("apple") && ((Item)obj1).toString().equals("apple")  || ((Item)obj1).toString().equals("apple") && this.toString().equals("apple")){
				((Hero)obj2).getInventory().remove(this);
				((Hero)obj2).getInventory().remove(((Item)obj1));
				((Hero)obj2).getInventory().add(new Food("applepie"));
				System.out.println("Vous recevez applepie");
			}else if(this.toString().equals("spice") && ((Item)obj1).toString().equals("chips")  || ((Item)obj1).toString().equals("chips") && this.toString().equals("spice")){
				((Hero)obj2).getInventory().remove(this);
				((Hero)obj2).getInventory().remove(((Item)obj1));
				((Hero)obj2).getInventory().add(new Food("spicychips"));
				System.out.println("Vous recevez spicychips");
			}else if(this.toString().equals("spice") && ((Item)obj1).toString().equals("chicken")  || ((Item)obj1).toString().equals("chicken") && this.toString().equals("spice")){
				((Hero)obj2).getInventory().remove(this);
				((Hero)obj2).getInventory().remove(((Item)obj1));
				((Hero)obj2).getInventory().add(new Food("spicychicken"));
				System.out.println("Vous recevez spicychicken");
			}else{
				System.out.println("Vous ne pouvez pas combiner ces 2 aliments");
			}
		}else{
			System.out.println("Vous n'avez pas saisi 2 aliments");
		}
	}

	@Override
	public String toString() {
		return "" + name ;
	}	
	
}