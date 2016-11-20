package item;

public enum TypeDrink {
	GNOLE(35,20),
	VODKAENERGY(17,11),
	VODKA(15,10),
	WHISKEY(15,10),
	RUM(15,10),
	JAGERBOMB(12,9),
	JAGERMEISTER(10,8),
	BEER(5,4),
	ENERGYDRINK(0,1);
	
	
	private int alcoholLevel;
	private int attack;

	private TypeDrink(int alcoholLevel, int attack){
		this.alcoholLevel = alcoholLevel;
		this.attack = attack;
	}	

	public int getAlcoholLevel() {
		return alcoholLevel;
	}

	public void setAlcoholLevel(int alcoholLevel) {
		this.alcoholLevel = alcoholLevel;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

}