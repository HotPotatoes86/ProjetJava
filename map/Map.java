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
		
		for (Street s : this.streets){
			Random rand = new Random();
			// Une rue a entre 3 et 8 maisons
			int taille = rand.nextInt(4)+3;
			
			// Lire dans les donnees pour donner un nom a la rue
			String nom = "";
			int i = rand.nextInt(10)+1; // 1 à 12
			String fichier ="donnees/Lieux.txt";
			
			try{
				InputStream ips=new FileInputStream(fichier); 
				InputStreamReader ipsr=new InputStreamReader(ips);
				BufferedReader br=new BufferedReader(ipsr);
				String ligne;
				while (i!=0 && (ligne=br.readLine())!=null){
					nom = ligne;
					i--;
				}
				br.close(); 
			}		
			catch (Exception e){
				System.out.println(e.toString());
			}
			
			// Instanciation de la rue
			s = new Street(nom,taille);
		}
		
		// Le hero se trouve sur la premiere rue
		this.streetHero = 0;
		
		// Fonction qui dit a la street qu'elle contient Hero
	}
	
	public void moveHero(String direction){
		// Test si hero au bord de la rue
		if (this.streets[this.streetHero].endStreet()){
			switch (direction){
				case "left":
					if (this.streetHero == 0 || this.streetHero == 3){
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
					}break;
				//TODO Un peu lourd... Faire une fonction ?
				case "right":
					if (this.streetHero == 0 || this.streetHero == 3){
						this.streets[this.streetHero].moveHero();
						this.streetHero+=2;
						this.streets[this.streetHero].moveHero();
					}break;
				case "forward":
					if (this.streetHero == 0){
						this.streets[this.streetHero].moveHero();
						this.streetHero+=3;
						this.streets[this.streetHero].moveHero();
					}break;
				case "backward":
					if (this.streetHero == 3){
						this.streets[this.streetHero].moveHero();
						this.streetHero-=3;
						this.streets[this.streetHero].moveHero();
					}break;
			}
		}
		// Sinon le hero avance dans la rue
		else{
			this.streets[this.streetHero].moveHero(direction);
		}	
	}
	
}