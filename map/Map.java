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
		for (int i=0; i<this.nbStreet; i++){
			//Instanciation de la rue (4 maisons dans une rue)
			System.out.println(i);
			this.streets[i] = new Street(n.generateName("donnees/Lieux.txt"),4);
		}
		System.out.println("Generate");
		this.generateExit();
	}
	
	public void generateExit(){
		if (this.nbStreet>1){
			System.out.println("0");
			((Street)this.streets[0]).addExit(1,this.streets[1]);
			((Street)this.streets[0]).addExit(1,this.streets[2]);
			System.out.println("1");
			((Street)this.streets[1]).addExit(0,this.streets[0]);
			((Street)this.streets[1]).addExit(0,this.streets[2]);
			System.out.println("2");
			((Street)this.streets[2]).addExit(0,this.streets[0]);
			((Street)this.streets[2]).addExit(0,this.streets[1]);
			/*if (this.nbStreet>3){
				((Street)this.streets[0]).addExit(1,this.streets[3]);
				((Street)this.streets[1]).addExit(0,this.streets[3]);
				((Street)this.streets[2]).addExit(0,this.streets[3]);
				
				((Street)this.streets[3]).addExit(0,this.streets[0]);
				((Street)this.streets[3]).addExit(0,this.streets[1]);
				((Street)this.streets[3]).addExit(0,this.streets[2]);
				((Street)this.streets[3]).addExit(1,this.streets[4]);
				((Street)this.streets[3]).addExit(1,this.streets[5]);
				
				((Street)this.streets[4]).addExit(0,this.streets[3]);
				((Street)this.streets[4]).addExit(0,this.streets[5]);
				((Street)this.streets[5]).addExit(0,this.streets[3]);
				((Street)this.streets[5]).addExit(0,this.streets[4]);
			}*/
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