import java.util.ArrayList;

public class Route {

	private Locatie van, naar;

	private ArrayList<Verbindingsstuk> verbindingsstukken = new ArrayList<Verbindingsstuk>();
	
	public Route (Locatie l1, Locatie l2) {
		van = l1;
		naar = l2;
	}

	public int berekenReistijd() {
		// TO DO: implementeer deze methode

		int reistijd = 0;

		for(Verbindingsstuk v : verbindingsstukken) {
			reistijd += v.berekenReistijd();
		}

		return reistijd;
	}
	
	public void voegToe(Verbindingsstuk v) {
		verbindingsstukken.add(v);
	}

	public String toString() {
		String routeAlsTekst = "" + van;
		for (Verbindingsstuk v: verbindingsstukken) {
			routeAlsTekst += " => " + v.getEinde();
		}
		return routeAlsTekst;
	}
}