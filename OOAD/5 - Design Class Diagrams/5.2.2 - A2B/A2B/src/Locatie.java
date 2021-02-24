public class Locatie {

	private double lengtegraad;

	private double breedtegraad;

	public Locatie(double lg, double bg) {
		this.lengtegraad = lg;
		this.breedtegraad = bg;
	}
	
	public String toString() {
		return "(" + lengtegraad + "," + breedtegraad + ")";
	}
}
