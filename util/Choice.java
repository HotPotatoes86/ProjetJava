package util;

import java.util.Random;

public class Choice {

	//retourne true ou false en random
	public static boolean randomChoice(){
		int rdm = randomChoice(0,1);
		if (rdm == 1){
			return true;
		}else{
			return false;
		}
	}
	
	public static int randomChoice(int min, int max){
		Random rand = new Random();
		int rdm = 0;
		try{
			rdm = rand.nextInt(max-min+1);
		}
		catch (Exception e){
			System.out.println("Erreur : min>max");
		}
		return rdm;
	}
}