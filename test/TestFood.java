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

public class TestFood {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	/*
	 //private Food food;
	private Hero hero;
		
	@Before
	protected void setUp() throws Exception{
		super.setUp();
		//food = new Food("apple");
		hero = new Hero(new House("maison"));
	}
		
	protected void tearDown() throws Exception{
		super.tearDown();
		//food = null;
	}	
		
	public void testCreateFood() throws Exception{
		
		assertNotNull(Food.createFood());
	}
	
	public void testUse1(){
		hero.use("apple");
		assertTrue(hero.getHp()==100);
	}
	
	public void testUse2(){
		hero.setHp(98);
		hero.use("apple");
		assertTrue(hero.getHp()==100);
	}
	public void testUse3(){
		hero.setHp(90);
		hero.use("apple");
		assertTrue(hero.getHp()==93);
	}
	
	public void testUseFusion1(){			
		for(int i=0; i<hero.getInventory().size(); i++){
			if(hero.getInventory().toString().equals("applepie")){
				assertTrue(hero.getInventory().get(i).toString().equals("applepie"));
			}			
		}		
	} 
	 */

}
