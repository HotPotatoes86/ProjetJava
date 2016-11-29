package test;

import item.Food;
import item.Item;
import junit.framework.TestCase;

public class FoodTest extends TestCase {
		
	private Food food;
	private Item item;
		
	
	protected void setUp() throws Exception{
		super.setUp();
		food = new Food("apple");
	}
		
	protected void tearDown() throws Exception{
		super.tearDown();
		food = null;
	}	
		
	public void testCreateFood() throws Exception{
		
		assertNotNull(Food.createFood());
	}
	
	public void testUse() throws Exception{
		
		
	}
}
