package map;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import character.Hero;

public class Map {

	private Hero hero;
	private int nbStreet;
	private int streetHero;
	private Street[] streets;
	
	public Map(Hero hero, int nbStreet) {
		this.hero = hero;
		this.nbStreet = nbStreet;
		this.streets = new Street[nbStreet];
		
		//pour faire un fichier temporaire : 
		//FILE temp = File.createTempFile("tmpAdr",".txt");
		//pour le supprimer a la fin du programme
		//tempFile.deleteOnExit();
		//mais apr�s pour copier les adresses dans le temp ca a l'air plutot complexe ...
		//et pour supprimer une ligne en gros faut refaire un tmp sans la ligne voulu ...
		//du coup je cherche une autre m�thode moins gourmande ...
		for (int i=0; i<nbStreet; i++){
			Random rand = new Random();
			// Une rue a entre 3 et 8 maisons
			int taille = rand.nextInt(4)+3;
			
			// Lire dans les donnees pour donner un nom a la rue
			String nom = "";
			int compteur = rand.nextInt(10)+1; // 1 à 12
			String fichier ="donnees/Lieux.txt";
			
			try{
				InputStream ips=new FileInputStream(fichier); 
				InputStreamReader ipsr=new InputStreamReader(ips);
				BufferedReader br=new BufferedReader(ipsr);
				String ligne;
				while (compteur!=0 && (ligne=br.readLine())!=null){
					nom = ligne;
					compteur--;
				}
				br.close(); 
			}		
			catch (Exception e){
				System.out.println(e.toString());
			}
			
			// Instanciation de la rue
			this.streets[i] = new Street(nom,taille);
		}
		
		// Le hero se trouve sur la premiere rue
		this.streetHero = 0;
		this.streets[this.streetHero].setFirstStreet();
		this.streets[this.streetHero].moveHero();
		
		// Fonction qui dit a la street qu'elle contient Hero
	}
	
	// A ameliorer, un peu long
	public void moveHero(String direction){
		// Test si hero au bord de la rue
		if (this.streets[this.streetHero].endStreet()){
			switch (direction){
				case "left":
					if ((this.streetHero == 0 || this.streetHero == 3) && this.nbStreet != 1){
						this.streets[this.streetHero].moveHero();
						this.streetHero++;
						this.streets[this.streetHero].moveHero();
					}
					else if (this.streetHero == 1){
						this.streets[this.streetHero].moveHero();
						this.streetHero+=2;
						this.streets[this.streetHero].moveHero();
					}
					else if (this.streetHero == 2 || this.streetHero == 5){
						this.streets[this.streetHero].moveHero();
						this.streetHero-=2;
						this.streets[this.streetHero].moveHero();
					}
					else{
						System.out.println("Direction impossible");
					}
					break;
				//TODO Un peu lourd... Faire une fonction ?
				case "right":
					if ((this.streetHero == 0 || this.streetHero == 3) && this.nbStreet != 1){
						this.streets[this.streetHero].moveHero();
						this.streetHero+=2;
						this.streets[this.streetHero].moveHero();
					}
					else{
						System.out.println("Direction impossible");
					}
					break;
				case "forward":
					if (this.streetHero == 0 && this.nbStreet == 6){
						this.streets[this.streetHero].moveHero();
						this.streetHero+=3;
						this.streets[this.streetHero].moveHero();
					}
					else{
						System.out.println("Direction impossible");
					}
					break;
				case "backward":
					if (this.streetHero == 3){
						this.streets[this.streetHero].moveHero();
						this.streetHero-=3;
						this.streets[this.streetHero].moveHero();
					}
					else{
						System.out.println("Direction impossible");
					}
					break;
			}
		}
		// Sinon le hero avance dans la rue
		else{
			this.streets[this.streetHero].moveHero(direction);
		}	
	}
	
}