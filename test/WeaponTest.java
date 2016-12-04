package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import character.Hero;
import item.Weapon;
import map.House;

public class WeaponTest {

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
	public void testCreateWeapon() {
		assertNotNull(Weapon.createWeapon());
	}
	
	@Test
	public void testUse(){
		Weapon weapon = new Weapon("knife");
		hero.pickUpItem(weapon);
		assertTrue(hero.getInventory().contains(weapon));		
		hero.use("knife");		
		assertTrue(hero.getWeapon()==weapon);
		assertTrue(!hero.getInventory().contains(weapon));
	}
	
	@Test
	public void testFusion(){
		Weapon weapon1 = new Weapon("knife");
		Weapon weapon2 = new Weapon("stick");
		hero.pickUpItem(weapon1);
		hero.pickUpItem(weapon2);
		assertTrue(hero.getInventory().contains(weapon2));
		assertTrue(hero.getInventory().contains(weapon1));
		hero.use("stick","knife");
		assertTrue(!hero.getInventory().contains(weapon1));
		assertTrue(!hero.getInventory().contains(weapon2));
		for(int i=0; i<hero.getInventory().size(); i++){
			if(hero.getInventory().toString().equals("battlespears")){
				assertTrue(hero.getInventory().get(i).toString().equals("battlespears"));
			}			
		}			
	}
}
