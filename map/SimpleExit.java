package map;
public class SimpleExit extends Exit {

	public SimpleExit(Street st, StreetPart sp, House h) {
		this.street = st;
		this.streetPart = sp;
		this.house = h;
	}

	public void use() {
		// TODO - implement SimpleExit.use
		throw new UnsupportedOperationException();
	}

}