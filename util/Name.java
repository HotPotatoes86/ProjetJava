package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class Name {

	public String generateName(String link){
		// Lire dans les donnees pour donner un nom a la rue
		Random rand = new Random();
		String name = "";
		int cpt = rand.nextInt(12)+1; // 1 Ã  12
		String fichier =link;
					
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while (cpt!=0 && (ligne=br.readLine())!=null){
				name = ligne;
				cpt--;
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		return name;
	}
	
	
}
