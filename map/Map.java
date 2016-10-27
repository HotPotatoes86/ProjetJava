package map;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class Map {

	private int nbStreet;
	private Street[] street;
	
	public Map(int nbStreet) {
		this.nbStreet = nbStreet;
		this.street = new Street[nbStreet];
		
		for (Street s : this.street){
			Random rand = new Random();
			// Une rue a entre 3 et 8 maisons
			int taille = rand.nextInt(4)+3;
			
			// Lire dans les données pour donner un nom a la rue
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
	}

}