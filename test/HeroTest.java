package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import character.Enemy;
import character.Hero;
import map.House;

public class HeroTest {

	private Hero hero;
	private House house;
	
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
	public void testGo1() {
		house = new House("maison");
		hero = new Hero(house);
		house.removeNPC();
		house.setNPC(new Enemy("pnj"));
		assertTrue(!house.testdirection("street"));
	}
	
	public void testGo2(){
		
	}

}
