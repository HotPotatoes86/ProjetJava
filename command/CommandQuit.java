package command;

public class CommandQuit {

	public static void use(){
		try{
			System.out.print("\nVous quittez la partie");
			Thread t = new Thread(){
				public void run() {
					for (int i=0; i<3; i++){
						try{
							Thread.sleep(400);
						}
						catch(Exception e){
							System.out.println(e);
						}
						System.out.print(".");
					}
				}
			};
			t.start();
			Thread.sleep(2000);
			System.out.print("\n");
			System.exit(0);
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
