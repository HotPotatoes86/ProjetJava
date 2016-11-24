package game;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import character.Hero;
import map.Map;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		
		String fichier ="donnees/Histoire.txt";
		
		/* Affichage de l'histoire (dans fichier txt)
		 * Gestion des exceptions
		 */
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				System.out.println(ligne);
				Thread.sleep(2000); // Temps d'attente entre chaque ligne
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		Map map = game.initMap();
		Hero hero = game.initHero(map);
		game.start(map, hero);
	}
}