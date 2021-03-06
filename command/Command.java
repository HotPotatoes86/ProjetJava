package command;

public enum Command {
	ATTACK(" : attaque le pnj face a vous"),	
	DELETE(" : supprime l'objet de l'inventaire"),
	GO(" : se rend dans une direction"),		
	HELP(" : donne la liste des commandes"),	
	INVENTORY(" : affiche votre inventaire"),
	LOOK(" : observe un lieu, un objet"),
	QUIT(" : quitte le jeu"),
	STATUS(" : affiche vos statistiques actuelles"),
	TAKE(" : prend l'objet"),	
	TALK(" : parle au pnj"),
	UNEQUIP(" : range l'arme dans l'inventaire s'il y a de la place"),
	USE(" : utilise un objet, permet les fusions");
	
	
	private final String description; 

	private Command(String value) { 
		description = value; 
	} 
	
	public String getDescription(){
		return this.description;
	}
}