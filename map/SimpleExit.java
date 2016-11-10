package map;
public class SimpleExit extends Exit {

	public SimpleExit(Place p) {
		this.place = p;
	}

	public void use() {
		if (this.place instanceof StreetPart){
			System.out.println("Vous avancez dans la rue...");
		}else if(this.place instanceof House){
			System.out.println("Vous rentrez dans la maison de " + this.place.getName());
		}else{
			System.out.println("Vous avancez sur la  " + this.place.getName());
		}
	}
	
	public Place getPlace(){
		return this.place;
	}

}