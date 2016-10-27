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
}
