package game;

public enum Command {
	GO(" : se rend dans une direction"),		
	USE(" : utilise un objet, permet les fusions"),	
	ATTACK(" : attaque le pnj face au hero"),	
	HELP(" : donne la liste des commandes"),	
	TAKE(" : prend l'objet"),					
	QUIT(" : quitte le jeu"),					
	LOOK(" : observe un lieu, un objet");
	
	private final String description; 

	private Command(String value) { 
		description = value; 
	} 
	
	public String getDescription(){
		return this.description;
	}
}
