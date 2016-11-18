package command;

public class CommandQuit {

	public static void use(){
		try{
			System.out.println("Vous quittez la partie...");
			Thread.sleep(1000);
			System.exit(0);
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
