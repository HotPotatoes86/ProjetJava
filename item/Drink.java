package item;

import character.Hero;
import util.Choice;

public class Drink implements Item {
	
	private TypeDrink tDrink;
	private String name;
	
	public Drink(TypeDrink drink){
		this.tDrink = drink;
		this.name=drink.toString().toLowerCase();
	}	
	
	public Drink(String name){
		TypeDrink[] tabDrink = TypeDrink.values();
		boolean correctDrink = false;
		for(int i=0; i<tabDrink.length; i++){
			if(name.equals(tabDrink[i].toString().toLowerCase())){
				correctDrink = true;
			}
		}
		if (correctDrink){
			this.name = name;
		}else{
			System.out.println("Cet objet n'existe pas");
		}
	}
	
	public static Drink createDrink(){
		TypeDrink[] tabDrink = TypeDrink.values();
		TypeDrink randomDrink = tabDrink[Choice.randomChoice(0, tabDrink.length-1)];
		Drink res = new Drink(randomDrink);
		return res;		
	}
	
	public int testItem(){ //pour tester si l'item est un drink
		TypeDrink[] tabDrink = TypeDrink.values();
		int res = 0;
		for(int i=0; i<tabDrink.length; i++){
			if (this.toString().equals(tabDrink[i].toString().toLowerCase())){
				res = 2;
			}
		}
		return res;
	}	
	
	/*public static boolean testItem(String item){
		boolean test = false;
		TypeDrink[] tabDrink = TypeDrink.values();
		for(int i=0; i<tabDrink.length;i++){
			if(item.toString().equals(tabDrink[i].toString().toLowerCase())){
				test = true;
			}
		}
		return test;
	}*/
	
	
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
	
	public void use(Object obj){
		if(this.testItem()==2 && obj instanceof Hero){	
			((Hero)obj).setAlcoholLevel(convertToDrink(this).tDrink.getAlcoholLevel());
			((Hero)obj).getInventory().remove(this);
		}
	}
	
	public void use(Object obj1, Object obj2){ //obj1 = item & obj2 = hero
		if(obj1 instanceof Item && obj2 instanceof Hero){
			if(this.testItem()==2 && ((Item)obj1).testItem()==2){
				if(this.toString().equals("energydrink") && ((Item)obj1).toString().equals("jagermeister")  || this.toString().equals("jagermeister") && ((Item)obj1).toString().equals("energydrink")){
					((Hero)obj2).getInventory().remove(this);
					((Hero)obj2).getInventory().remove((Item)obj1);
					((Hero)obj2).getInventory().add(new Drink("jagerbomb"));
				}else if(this.toString().equals("energydrink") && ((Item)obj1).toString().equals("vodka")  || this.toString().equals("vodka") && ((Item)obj1).toString().equals("energydrink")){
					((Hero)obj2).getInventory().remove(this);
					((Hero)obj2).getInventory().remove(((Item)obj1));
					((Hero)obj2).getInventory().add(new Drink("vodkaenergy"));
				}else if(!this.toString().equals("energydrink") && !((Item)obj1).toString().equals("energydrink")){
					((Hero)obj2).getInventory().remove(this);
					((Hero)obj2).getInventory().remove(((Item)obj1));
					((Hero)obj2).getInventory().add(new Drink("gnole"));
				}else{
					System.out.println("energydrink ne peut etre combiner uniquement avec vodka et jagermeister");
				}					
			}
		}
	}

	public String getName(){
		return this.name;
	}
	
	@Override
	public String toString() {
		return "" +name;
	}
	
	
}