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
	private Place[] streets;
	
	public Map(Hero hero, int nbStreet) {
		this.nbStreet = nbStreet;
		this.streets = new Street[nbStreet];
		
		//pour faire un fichier temporaire : 
		//FILE temp = File.createTempFile("tmpAdr",".txt");
		//pour le supprimer a la fin du programme
		//tempFile.deleteOnExit();
		//mais aprï¿½s pour copier les adresses dans le temp ca a l'air plutot complexe ...
		//et pour supprimer une ligne en gros faut refaire un tmp sans la ligne voulu ...
		//du coup je cherche une autre mï¿½thode moins gourmande ...
		for (int i=0; i<nbStreet; i++){
			Random rand = new Random();
			// Une rue a entre 3 et 8 maisons
			int taille = rand.nextInt(6)+3;
			
			// Lire dans les donnees pour donner un nom a la rue
			String nom = "";
			int compteur = rand.nextInt(12)+1; // 1 Ã  12
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
	}
	
	public void go(String direction){
		this.hero.go(direction);
	}
}