package map;
public abstract class Exit {

	protected Place place;
	
	/**
	 * use the exit, display a simple string for the user
	 */
	public boolean use() {
		if (this.place instanceof StreetPart){
			System.out.println("Vous avancez dans la rue...");
		}else if(this.place instanceof House){
			System.out.println("Vous rentrez dans la maison de " + this.place.getName());
			if (((House)this.place).getNPC() != null){
				System.out.println("Vous rencontrez " + ((House)this.place).getNPC().getName());
			}
		}else{
			System.out.println("Vous avancez sur la  " + this.place.getName());
		}
		return true;
	}
	
	public abstract Place getPlace();
		
}