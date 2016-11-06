package item;

public enum TypeDrink {
	VODKA(15,10),
	BIERE(5,4),
	WHISKY(15,10),
	RHUM(8,6);
	
	private final int alcoholLevel;
	private final int attack;

    private TypeDrink(int value, int dmg) {
        this.alcoholLevel = value;
        this.attack = dmg;
    }
    
    public int getAlcoholLevel(){
    	return this.alcoholLevel;
    }
    
    public int getAttack(){
    	return this.attack;
    }
}