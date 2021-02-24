public class Plaats extends Locatie {

	private String plaatsnaam;
	
	public Plaats(String naam, double lg, double bg) {
		super(lg,bg);
		this.plaatsnaam = naam;
	}
	
	public String toString() {
		return plaatsnaam + super.toString();
	}
	
}
