package map;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import character.NPC;

public class StreetPart {

	private House[] houses;
	private NPC npc=null; // = une personne que l'on croise dans la rue
	private boolean containsHero=false;

	public StreetPart(Street st) {
		this.houses = new House[2];
		for (int i=0; i<2; i++){
			//TODO Facteur random pour maison avec/sans nom
			//Nom = NPC
			Random rand = new Random();
			// Une chance sur 2 (1 ou 2)
			int rdm = rand.nextInt(2)+1;
			if (rdm==1){
				this.houses[i] = new House();
			}
			else{
				// Lire dans les donnees pour donner un nom a la rue
				String nom = "";
				int compteur = rand.nextInt(29)+1; // 1 à 31
				String fichier ="donnees/Noms.txt";
							
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
				this.houses[i] = new House(nom);
				this.houses[i].addExit(st, this);
			}
		}
	}
	
	public void moveHero(String direction){
		switch (direction){
			case "left": 
				this.houses[0].moveHero();
				break;
			case "right":
				this.houses[1].moveHero();
				break;
		}	
	}
	
	public void setFirst(){
		this.containsHero=true;
	}
	
	public void moveHero(){
		if (this.containsHero){
			this.containsHero=false;
		}
		else{
			System.out.println("<- " + this.houses[0].getName());
			System.out.println("-> " + this.houses[1].getName());
			this.containsHero=true;
		}
	}
	
}
