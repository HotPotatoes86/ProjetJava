package item;

public interface Item {
	
		
	public int testItem();

	public void use(Object obj); //pour utiliser un objet sur le heros
	public void use(Object obj1, Object obj2); //pour fusionner 2 objets ou utiliser cl� sur porte
	
	public String getName();
}
