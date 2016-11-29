package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Name {

	//----------------------Methods----------------------//
	/**
	 * generate randomly a name from a file of data
	 * @param link the path to the file
	 * @param nbLines the number of lines of the file
	 * @return a randomly name of the file
	 */
	public static String generateName(String link, int line){
		// read the file in link with a number of lines (line)
		String name = "";
		int cpt = Choice.randomChoice(1, line);
		String fichier =link;
					
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			// search the line we want 
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