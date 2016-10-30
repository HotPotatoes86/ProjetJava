package item;

public enum TypeWeapon {
	Baton(2);
	
	private final int attack;
	
	private TypeWeapon(int dmg){
		this.attack = dmg;
	}
	
	public int getAtackWeapon(){
		return this.attack;
	}
	
}