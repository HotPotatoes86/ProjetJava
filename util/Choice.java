package util;

import java.util.Random;

public class Choice {

	/**
	 * give randomly a boolean
	 * @return true or false
	 */
	public static boolean randomChoice(){
		int rdm = randomChoice(0,1);
		if (rdm == 1){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * give a randomly number between min and max
	 * @param min lower bound
	 * @param max upper bound
	 * @return a randomly number between min and max
	 */
	public static int randomChoice(int min, int max){
		Random rand = new Random();
		int rdm = rand.nextInt(max - min + 1) + min;
		return rdm;
	}
}