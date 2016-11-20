package item;

public enum TypeWeapon {
	STICK(1),
	ROPE(2),
	STONE(2),
	WHIP(4),
	SLINGSHOT(5),
	SPEARS(5),
	KNIFE(6),
	BATTLESPEARS(10);
	
	private int attack;

	private TypeWeapon(int attack){
		this.attack = attack;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
	
}