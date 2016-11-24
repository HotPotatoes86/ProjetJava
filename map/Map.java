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
		//first street
		int lineName = Choice.randomChoice(1, 8);
		int streetSize = Choice.randomChoice(3, 6);
		String streetName = Name.generateName("donnees/Lieux.txt",lineName);
		this.streets[0] = new Street(streetName,streetSize);
		
		if (this.nbStreet==3){
			//second street
			lineName = Choice.randomChoice(lineName+1, 11);
			streetSize = Choice.randomChoice(3, 6);
			streetName = Name.generateName("donnees/Lieux.txt",lineName);
			this.streets[1] = new Street(streetName,streetSize);
			
			//third street
			lineName = Choice.randomChoice(lineName+1, 14);
			streetSize = Choice.randomChoice(3, 6);
			streetName = Name.generateName("donnees/Lieux.txt",lineName);
			this.streets[2] = new Street(streetName,streetSize);

			//add exits
			
			//end of the street 0 to the enter of the street 1/2
			((Street)this.streets[0]).addExit1(this.streets[1].getName(), this.streets[1]);
			((Street)this.streets[0]).addExit1(this.streets[2].getName(), this.streets[2]);
			
			//enter of the street 1 to the end of the street 0
			this.streets[1].addExit(this.streets[0].getName(), ((Street)this.streets[0]).getParts()[((Street)this.streets[0]).getNbStreetPart()-1]);
			//enter of the street 1 to the enter of street 2  
			this.streets[1].addExit(this.streets[2].getName(), ((Street)this.streets[2]).getParts()[0]);
			
			//enter of the street 2 to the end of the street 0
			this.streets[2].addExit(this.streets[0].getName(), ((Street)this.streets[0]).getParts()[((Street)this.streets[0]).getNbStreetPart()-1]);
			//enter of the street 2 to the enter of street 1 
			this.streets[2].addExit(this.streets[1].getName(), ((Street)this.streets[1]).getParts()[0]);
		}
	}
	
	//----------------------Getters----------------------//
	public Place[] getStreets() {
		return this.streets;
	}
	
	public int getNbStreet(){
		return this.nbStreet;
	}

	//----------------------Setters----------------------//
	public void setStreets(Place[] streets) {
		this.streets = streets;
	}
}