package command;

public final class CommandHelp{

	public static void use(){
		System.out.println("Commandes possibles :");
   		for (Command c : Command.values()){
   			System.out.println(c + c.getDescription());
		}
	}
}
