package map;
import java.util.HashMap;
import java.util.List;

import item.Item;

public class House {

	private String houseName;
	private HashMap<String, Exit> exits;
	private List<Item> items;
	private boolean containsHero=false;

	public void go() {
		// TODO - implement Place.go
		throw new UnsupportedOperationException();
	}

	public House(String name) {
		this.houseName = name;
		// TODO - implement Place.Place
		throw new UnsupportedOperationException();
	}

}