package util;

import java.util.Scanner;

public class ConsoleInput implements UserInput{
	
	Scanner scanner;
	
	public ConsoleInput(){
		this.scanner = new Scanner(System.in);
	}
	
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

}