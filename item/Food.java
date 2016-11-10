package item;

import character.Hero;

public class Food implements Item {
	
	private TypeFood food;
	private String name;
	private Hero hero;
	
	public static Food createFood(String value){
		Food f=null;
		try{
			f= new Food(TypeFood.valueOf(value.toUpperCase()));
		}
		catch(Exception e){
			System.out.println("erreur");
		}
		return f;
	}
	
	public Food(TypeFood food){		
		this.food=food;
		this.name=food.toString().toLowerCase();
	}
	
	public void use(){
		this.hero.setHp(food.getHp());
	}

	@Override
	public String toString() {
		return "" + name ;
	}
	
	
	
}