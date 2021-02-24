import java.util.ArrayList;

public class Verbindingsstuk {

	private int normaleReistijd;
	private Locatie van;
	private Locatie naar;

	private ArrayList<Vertraging> vertragingen = new ArrayList<Vertraging>();
	
	public Verbindingsstuk(Locatie l1, Locatie l2, int tijd) {
		van = l1;
		naar = l2;
		normaleReistijd = tijd;
	}
	
	public Locatie getStart() {
		return van;
	}
	
	public Locatie getEinde() {
		return naar;
	}
	
	public void voegVertragingToe(Vertraging v) {
		vertragingen.add(v);
	}

	public int berekenReistijd() {
        // TO DO implement
		return 0;
	}

}
