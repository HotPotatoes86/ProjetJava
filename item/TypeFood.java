package item;

public enum TypeFood {
	CHIPS(2);
	
	private final int hp;
	
	private TypeFood(int hp){
		this.hp = hp;
	}
	
	public int getHp(){
		return this.hp;
	}
}