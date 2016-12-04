package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import character.Hero;
import item.Drink;
import map.House;

public class DrinkTest {
	
	private static Hero hero;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hero = new Hero(new House("maison"));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		hero.getInventory().removeAll(hero.getInventory());
	}

	@Test
	public void testCreateDrink() {
		assertNotNull(Drink.createDrink());		
	}
	
	@Test
	public void testUse(){
		Drink drink = new Drink("vodka");
		hero.pickUpItem(drink);
		hero.use("vodka");
		assertTrue(hero.getAlcoholLevel()==30);
		assertTrue(!hero.getInventory().contains(drink));
	}
	
	@Test
	public void testFusion(){
		Drink drink1 = new Drink("vodka");
		Drink drink2 = new Drink("energydrink");
		hero.pickUpItem(drink1);
		hero.pickUpItem(drink2);
		assertTrue(hero.getInventory().contains(drink1));
		assertTrue(hero.getInventory().contains(drink2));
		hero.use("vodka", "energydrink");
		assertTrue(!hero.getInventory().contains(drink1));
		assertTrue(!hero.getInventory().contains(drink2));
		for(int i=0; i<hero.getInventory().size(); i++){
			if(hero.getInventory().toString().equals("vodkaenergy")){
				assertTrue(hero.getInventory().get(i).toString().equals("vodkaenergy"));
			}			
		}			
	}
	
	

}
