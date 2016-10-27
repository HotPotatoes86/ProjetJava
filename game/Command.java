package game;
public enum Command {
	GO("go"),
	USE("use"),
	HELP("help"),
	TAKE("take"),
	QUIT("quit"),
	LOOK("look");
	
	private final String description;

    private Command(String value) {
        description = value;
    }

    @Override
    public String toString() {
        return description;
    }
    
    public void action(){
    	switch (this.description){
	    	case "help": 
	    		System.out.println("Commandes possibles :");
	    		for (Command c : Command.values()){
	    			System.out.println(c);
	    		}
	    		break;
	    	case "go":
	    		break;
	    	default: break;
    	}
    }
}
