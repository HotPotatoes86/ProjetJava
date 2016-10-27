package item;

public enum TypeDrink {
	VODKA(15),
	BIERE(5),
	WHISKY(15);
	
	private final int alcoholLevel;

    private TypeDrink(int value) {
        alcoholLevel = value;
    }
}