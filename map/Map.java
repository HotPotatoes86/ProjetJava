package map;

import util.Name;

public class Map {

	private int nbStreet;
	private Place[] streets;
	
	public Map(int nbStreet) {
		this.nbStreet = nbStreet;
		this.streets = new Street[this.nbStreet];
		//Random rand = new Random();
		//pour faire un fichier temporaire : 
		//FILE temp = File.createTempFile("tmpAdr",".txt");
		//pour le supprimer a la fin du programme
		//tempFile.deleteOnExit();
		//mais aprï¿½s pour copier les adresses dans le temp ca a l'air plutot complexe ...
		//et pour supprimer une ligne en gros faut refaire un tmp sans la ligne voulu ...
		//du coup je cherche une autre mï¿½thode moins gourmande ...
			//Instanciation de la rue (4 maisons dans une rue)
			this.streets[0] = new Street(Name.generateName("donnees/Lieux.txt",12),4);
			if (this.nbStreet==3){
				this.streets[1] = new Street(Name.generateName("donnees/Lieux.txt",12),4);
				this.streets[2] = new Street(Name.generateName("donnees/Lieux.txt",12),4);
				
				((Street)this.streets[0]).addExit1(this.streets[1].getName(), this.streets[1]);
				((Street)this.streets[0]).addExit1(this.streets[2].getName(), this.streets[2]);
				this.streets[1].addExit(this.streets[0].getName(), ((Street)this.streets[0]).getParts()[3]);
				this.streets[1].addExit(this.streets[2].getName(), ((Street)this.streets[2]).getParts()[0]);
				this.streets[2].addExit(this.streets[0].getName(), ((Street)this.streets[0]).getParts()[3]);
				this.streets[2].addExit(this.streets[1].getName(), ((Street)this.streets[1]).getParts()[0]);
			}
	}
	
	public Place[] getStreets() {
		return streets;
	}

	public void setStreets(Place[] streets) {
		this.streets = streets;
	}
}