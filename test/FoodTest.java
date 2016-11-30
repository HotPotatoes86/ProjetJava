package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import character.Hero;
import item.Food;
import map.House;

public class FoodTest {
	
	private Hero hero;
	
	public FoodTest(){
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		hero = new Hero(new House("maison"));
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test	
	public void testCreateFood(){
		assertNotNull(Food.createFood());
	}
	
	@Test
	public void testUse1(){
		hero.pickUpItem(new Food("apple"));
		hero.use("apple");
		assertTrue(hero.getHp()==100);
	}
	
	@Test
	public void testUse2(){
		hero.pickUpItem(new Food("apple"));
		hero.setHp(98);
		hero.use("apple");
		assertTrue(hero.getHp()==100);
	}
	
	@Test
	public void testUse3(){
		hero.pickUpItem(new Food("apple"));
		hero.setHp(90);
		hero.use("apple");
		assertTrue(hero.getHp()==93);
	}
	
	@Test
	public void testUseFusion1(){		
		hero.pickUpItem(new Food("apple"));
		hero.pickUpItem(new Food("apple"));
		hero.use("apple","apple");
		for(int i=0; i<hero.getInventory().size(); i++){
			if(hero.getInventory().toString().equals("applepie")){
				assertTrue(hero.getInventory().get(i).toString().equals("applepie"));
			}			
		}		
	} 

	

}
