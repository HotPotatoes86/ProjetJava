package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Name {

	public static String generateName(String link, int nbLines){
		// Lire dans les donnees pour donner un nom a la rue
		String name = "";
		int cpt = Choice.randomChoice(1, nbLines-1);
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