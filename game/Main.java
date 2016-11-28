package game;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import character.Hero;
import map.Map;
import util.ConsoleInput;

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
			String line;
			while ((line=br.readLine())!=null){
				ConsoleInput.displayString(line);
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