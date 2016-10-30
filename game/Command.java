package game;

public enum Command {
	GO("go"),		// Se rend dans une direction (par defaut tout droit)
	USE("use"),		// Utilise un objet, utilise objet sur objet
	HELP("help"),	// Donne les commandes
	TAKE("take"),	// Prend l'objet
	QUIT("quit"),	// Quitte le jeu
	LOOK("look");	// Donne la position ou les caracteristiques de l'objet
	
	private final String description;

    private Command(String value) {
        description = value;
    }

    @Override
    public String toString() {
        return description;
    }
 
}
