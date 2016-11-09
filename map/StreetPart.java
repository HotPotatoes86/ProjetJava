package map;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import character.NPC;

public class StreetPart extends Place{

	private House[] houses;
	private NPC npc=null; // = une personne que l'on croise dans la rue

	public StreetPart(String name) {
		this.name = name;
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
				int compteur = rand.nextInt(31)+1; // 1 à 31
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
				//Ajout de Exit de StreetPart vers House (en fonction du type Exit aléatoire)
				((House)this.houses[i]).addExit(this);
			}
		}
	}
	
	public void describe(){
		this.houses[0].describe();
		this.houses[1].describe();
	}
	
	public void addLockedExit(int rdm, Place p){
		this.exits.put(p.getName(), new LockedExit(rdm,p));
	}

}
