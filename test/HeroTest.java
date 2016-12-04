package test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import character.Enemy;
import character.Hero;
import character.Neutral;
import item.Food;
import item.Item;
import item.Weapon;
import map.House;
import map.Place;

public class HeroTest {

	private static Hero hero;
	private static House house;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		house = new House("maison");
		house.setNPC(new Neutral("pnj"));
		hero = new Hero(house);	}

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
	public void testGo1() {
		house.removeNPC();
		house.setNPC(new Enemy("pnj"));
		assertTrue(!house.testdirection("street"));
		
	}
	
	@Test
	public void testGo2(){
		if(hero.getPlace().go(hero, "direction")){
			Place p = hero.getPlace().getNextPlace("direction");
			assertTrue(hero.getPlace() == p);
		}
	}

	@Test 
	public void testHouse(){
		hero.setPlace(hero.getHouse());
		assertTrue(hero.getPlace() == hero.getHouse());
	}
	
	
	@Test
	public void testPickUpItem(){
		Item food = new Food("apple");
		house.addItem(food);
		hero.pickUpItem(food,house.getInventory());
		assertTrue(hero.getInventory().contains(food));
		assertTrue(!house.getInventory().contains(food));
	}
	
	@Test
	public void testDelete(){
		Item food = new Food("apple");
		hero.pickUpItem(food);
		assertTrue(hero.getInventory().contains(food));
		hero.deleteItem(food);
		assertTrue(!hero.getInventory().contains(food));
	}
	
	@Test
	public void testUnequip1(){
		Weapon weapon = new Weapon("knife");
		hero.getInventory().add(weapon);
		hero.use("knife");
		assertTrue(hero.getWeapon()==weapon);
		hero.unequip();
		assertTrue(hero.getWeapon()==null);
		assertTrue(hero.getInventory().contains(weapon));
		assertTrue(hero.getAttack()==10);
	}
	
	@Test
	public void testUnequip2(){
		Weapon weapon = new Weapon("knife");
		hero.getInventory().add(weapon);
		hero.use("knife");
		assertTrue(!hero.getInventory().contains(weapon));
		for(int i=0; i<15; i++){
			hero.getInventory().add(new Food("apple"));
		}
		hero.unequip();
		for(int i=0; i<hero.getInventory().size();i++){
			assertTrue(!hero.getInventory().get(i).equals("knife"));
		}
		assertTrue(hero.getWeapon()==null);
	}
	
	@Test
	public void testUse1(){
		hero.getInventory().add(new Food("apple"));
		hero.use("apple");
		for(int i=0; i<hero.getInventory().size();i++){
			assertTrue(!hero.getInventory().get(i).equals("apple"));
		}
	}
	
	@Test 
	public void testUse2(){
		hero.getInventory().add(new Food("chocolate"));
		hero.getInventory().add(new Food("banana"));
		hero.use("chocolate", "banana");
		for(int i=0; i<hero.getInventory().size();i++){
			assertTrue(!hero.getInventory().get(i).equals("banana"));
			assertTrue(!hero.getInventory().get(i).equals("chocolate"));
			if(hero.getInventory().get(i).equals("chocolatebanana")){
				assertTrue(hero.getInventory().get(i).equals("chocolatebanana"));
			}
		}
	}
	
}
