package map;

import util.Choice;
import util.Name;

public class Map {

	//----------------------Attributes----------------------//
	private int nbStreet;
	private Place[] streets;
	
	//----------------------Constructors----------------------//
	public Map(int nbStreet) {
		this.nbStreet = nbStreet;
		this.streets = new Street[this.nbStreet];
		//the streets have always differents names
		int lineName = Choice.randomChoice(1, 8);
		this.streets[0] = new Street(Name.generateName("donnees/Lieux.txt",lineName),Choice.randomChoice(3,6));
		
		if (this.nbStreet==3){
			lineName = Choice.randomChoice(lineName+1, 11);
			this.streets[1] = new Street(Name.generateName("donnees/Lieux.txt",lineName),Choice.randomChoice(3,6));
			
			lineName = Choice.randomChoice(lineName+1, 14);
			this.streets[2] = new Street(Name.generateName("donnees/Lieux.txt",lineName),Choice.randomChoice(3,6));

			//add exits
			((Street)this.streets[0]).addExit1(this.streets[1].getName(), this.streets[1]);
			((Street)this.streets[0]).addExit1(this.streets[2].getName(), this.streets[2]);
			this.streets[1].addExit(this.streets[0].getName(), ((Street)this.streets[0]).getParts()[3]);
			this.streets[1].addExit(this.streets[2].getName(), ((Street)this.streets[2]).getParts()[0]);
			this.streets[2].addExit(this.streets[0].getName(), ((Street)this.streets[0]).getParts()[3]);
			this.streets[2].addExit(this.streets[1].getName(), ((Street)this.streets[1]).getParts()[0]);
		}
	}
	
	//----------------------Getters----------------------//
	public Place[] getStreets() {
		return streets;
	}

	//----------------------Setters----------------------//
	public void setStreets(Place[] streets) {
		this.streets = streets;
	}
}