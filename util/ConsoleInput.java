package util;

import java.util.Scanner;

public class ConsoleInput implements UserInput{
	public String scan(){
		String res;
		Scanner scanner = new Scanner(System.in);
		res = scanner.next();
		scanner.close();
		return res;
	}
}