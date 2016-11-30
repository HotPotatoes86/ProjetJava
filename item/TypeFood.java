package item;

public enum TypeFood {
	SPICE(-1),
	CHIPS(2),
	CHOCOLATE(3),
	APPLE(3),
	BANANA(4),
	SPICYCHIPS(5),
	CHICKEN(6),
	APPLEPIE(7),
	CHOCOLATEBANANA(8),
	SPICYCHIKEN(10);
	
	private int hp;
	
	private TypeFood(int hp){
		this.hp = hp;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
}