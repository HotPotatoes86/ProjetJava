package item;

public enum TypeDrink {
	GNOLE(35),
	VODKAENERGY(17),
	VODKA(15),
	WHISKEY(15),
	RUM(15),
	JAGERBOMB(12),
	JAGERMEISTER(10),
	BEER(5),
	ENERGYDRINK(0);
		
	private int alcoholLevel;

	private TypeDrink(int alcoholLevel){
		this.alcoholLevel = alcoholLevel;
	}	

	public int getAlcoholLevel() {
		return alcoholLevel;
	}

	public void setAlcoholLevel(int alcoholLevel) {
		this.alcoholLevel = alcoholLevel;
	}

}