import java.util.Random;

public class Map {

	private int nbStreet;
	private Street[] street;
	
	public Map(int nbStreet) {
		this.nbStreet = nbStreet;
		this.street = new Street[nbStreet];
		for (Street s : this.street){
			Random rand = new Random();
			int taille = rand.nextInt(4)+3;
			// Lire dans les données
			s = new Street("nom",taille);
		}
	}

}