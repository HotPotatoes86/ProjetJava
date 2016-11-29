package util;

import java.util.Scanner;

public class ConsoleInput implements UserInput{
	
	//----------------------Attributes----------------------//
	private Scanner scanner;
	
	//----------------------Constructors----------------------//
	public ConsoleInput(){
		this.scanner = new Scanner(System.in);
	}
	
	//----------------------Methods----------------------//
	/**
	 * return a String given by the user
	 */
	public String stringScan(){
		String res;
		res = this.scanner.nextLine();
		return res;
	}
	
	/**
	 * return a int given by the user
	 */
	public int intScan(){
		int res;
		res = this.scanner.nextInt();
		return res;
	}
	
	/**
	 * display a string with a delay between all characters
	 * @param s
	 */
	public static void displayString(String s){
		try{
			for (int i=0; i<s.length(); i++){
				System.out.print(s.charAt(i));
				Thread.sleep(50);
			}
			System.out.println();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}

}