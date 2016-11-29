package item;

import character.Hero;
import util.Choice;

public class Drink implements Item {
	
	//----------------------Attributes----------------------//
	private TypeDrink tDrink;
	private String name;
	
	//----------------------Constructors----------------------//
	/**
	 * constructor of the class Drink
	 * @param drink is an element of enum TypeDrink
	 */
	public Drink(TypeDrink drink){
		this.tDrink = drink;
		this.name=drink.toString().toLowerCase();
	}	
	
	/**
	 * constructor of the class Drink
	 * @param name is the name of the drink
	 */
	public Drink(String name){
		TypeDrink[] tabDrink = TypeDrink.values();
		boolean correctDrink = false;
		for(int i=0; i<tabDrink.length; i++){
			if(name.equals(tabDrink[i].toString().toLowerCase())){
				correctDrink = true;
				this.tDrink = tabDrink[i];
			}
		}
		if (correctDrink){
			this.name = name;
		}else{
			System.out.println("Cet objet n'existe pas");
		}
	}
	
	//----------------------Getters----------------------//
	@Override
	public String getName(){
		return this.name;
	}
	
	/**
	 * @return alcohol level given by the drink
	 */
	public int getLevel(){
		return this.tDrink.getAlcoholLevel();
	}
	
	//----------------------Methods----------------------//
	/**
	 * Create a new Drink with a random TypeDrink value 
	 * @return drink
	 */
	public static Drink createDrink(){
		TypeDrink[] tabDrink = TypeDrink.values();
		TypeDrink randomDrink = tabDrink[Choice.randomChoice(0, tabDrink.length-1)];
		Drink res = new Drink(randomDrink);
		return res;		
	}
		
	/**
	 * convert the parameter item to a drink
	 * @param item which we want to convert as a drink
	 * @return drink 
	 */
	public Drink convertToDrink(Item item){
		Drink d = null;
		TypeDrink[] tabDrink = TypeDrink.values();
		for(int i=0; i<tabDrink.length; i++){
			if(item.toString().equals(tabDrink[i].toString().toLowerCase())){
				d = new Drink(tabDrink[i]);
			}
		}
		return d;
	}
	
	/**
	 * use drink on hero to increase his alcohol level
	 */
	@Override
	public void use(Object obj){
		if(obj instanceof Hero){	
			((Hero)obj).setAlcoholLevel(convertToDrink(this).tDrink.getAlcoholLevel());
			System.out.println("Vous utilisez " +this.name);
			System.out.println("Votre alcoolemie augmente de " + convertToDrink(this).tDrink.getAlcoholLevel());
			((Hero)obj).getInventory().remove(this);
		}
	}
	
	/**
	 * combine 2 drink as another
	 */
	@Override
	public void use(Object obj1, Object obj2){ //obj1 = item & obj2 = hero
		if(obj1 instanceof Item && obj2 instanceof Hero){
			if(this.toString().equals("energydrink") && ((Item)obj1).toString().equals("jagermeister")  || this.toString().equals("jagermeister") && ((Item)obj1).toString().equals("energydrink")){
				((Hero)obj2).getInventory().remove(this);
				((Hero)obj2).getInventory().remove((Item)obj1);
				((Hero)obj2).getInventory().add(new Drink("jagerbomb"));
				System.out.println("Vous recevez jagerbomb");
			}else if(this.toString().equals("energydrink") && ((Item)obj1).toString().equals("vodka")  || this.toString().equals("vodka") && ((Item)obj1).toString().equals("energydrink")){
				((Hero)obj2).getInventory().remove(this);
				((Hero)obj2).getInventory().remove(((Item)obj1));
				((Hero)obj2).getInventory().add(new Drink("vodkaenergy"));
				System.out.println("Vous recevez vodkaenergy");
			}else if(!this.toString().equals("energydrink") && !((Item)obj1).toString().equals("energydrink")){
				((Hero)obj2).getInventory().remove(this);
				((Hero)obj2).getInventory().remove(((Item)obj1));
				((Hero)obj2).getInventory().add(new Drink("gnole"));
				System.out.println("Vous recevez gnole");
			}else{
				System.out.println("energydrink ne peut etre combiner uniquement avec vodka et jagermeister");
			}					
		}else{
			System.out.println("Vous n'avez pas saisi 2 boissons");
		}
	}

	@Override
	public String toString() {
		return "" +name;
	}	
	
}