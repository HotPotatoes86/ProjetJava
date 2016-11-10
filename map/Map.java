package map;

import character.Hero;
import util.Name;

public class Map {

	private Hero hero;
	private int nbStreet;
	private Place[] streets;
	
	public Map(int nbStreet) {
		this.nbStreet = nbStreet;
		this.streets = new Street[this.nbStreet];
		Name n = new Name();
		//Random rand = new Random();
		//pour faire un fichier temporaire : 
		//FILE temp = File.createTempFile("tmpAdr",".txt");
		//pour le supprimer a la fin du programme
		//tempFile.deleteOnExit();
		//mais aprï¿½s pour copier les adresses dans le temp ca a l'air plutot complexe ...
		//et pour supprimer une ligne en gros faut refaire un tmp sans la ligne voulu ...
		//du coup je cherche une autre mï¿½thode moins gourmande ...
			//Instanciation de la rue (4 maisons dans une rue)
			this.streets[0] = new Street(n.generateName("donnees/Lieux.txt"),4);
			this.streets[0].addExit("forward",((Street)this.streets[0]).getParts[0]);
			if (this.nbStreet==3){
				this.streets[1] = new Street(n.generateName("donnees/Lieux.txt"),4);
				this.streets[2] = new Street(n.generateName("donnees/Lieux.txt"),4);
					
				((Street)this.streets[0]).addExit("street1", this.streets[1]);
				((Street)this.streets[0]).addExit("street2", this.streets[2]);
				((Street)this.streets[1]).addExit("street0", this.streets[0]);
				((Street)this.streets[1]).addExit("street2", this.streets[2]);
				((Street)this.streets[2]).addExit("street0", this.streets[0]);
				((Street)this.streets[2]).addExit("street1", this.streets[1]);
			}
	}
	
	public Place[] getStreets() {
		return streets;
	}

	public void setStreets(Place[] streets) {
		this.streets = streets;
	}

	public void go(String direction){
		this.hero.go(direction);
	}
}